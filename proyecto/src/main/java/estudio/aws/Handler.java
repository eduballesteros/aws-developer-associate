package estudio.aws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import java.io.*;
import java.util.*;

public class Handler implements RequestStreamHandler {
    private static final ObjectMapper JSON = new ObjectMapper();
    private static final DynamoDbClient DB = DynamoDbClient.create();
    private static final String TABLE = System.getenv("TABLE_NAME");

    @Override public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
        try {
            JsonNode event = JSON.readTree(input);
            // Solo identidad validada por el authorizer JWT de HTTP API, nunca userId del body.
            String user = event.at("/requestContext/authorizer/jwt/claims/sub").asText("");
            if (user.isBlank()) { respond(output, 401, Map.of("error", "no autenticado")); return; }
            String method = event.at("/requestContext/http/method").asText("");
            if ("POST".equals(method)) {
                if (event.path("isBase64Encoded").asBoolean(false)) {
                    respond(output, 400, Map.of("error", "enviar JSON UTF-8 sin base64")); return;
                }
                JsonNode body;
                try { body = JSON.readTree(event.path("body").asText("")); }
                catch (com.fasterxml.jackson.core.JsonProcessingException ex) {
                    respond(output, 400, Map.of("error", "JSON invalido")); return;
                }
                if (body == null || !body.isObject()) throw new IllegalArgumentException("objeto JSON requerido");
                String id = TaskRules.id(body.path("id").asText(null));
                String title = TaskRules.title(body.path("titulo").asText(null));
                DB.putItem(PutItemRequest.builder().tableName(TABLE)
                    .item(Map.of("pk", s(user), "sk", s(id), "titulo", s(title)))
                    .conditionExpression("attribute_not_exists(pk) AND attribute_not_exists(sk)").build());
                respond(output, 201, Map.of("id", id, "titulo", title));
            } else if ("GET".equals(method)) {
                Map<String, AttributeValue> start = null;
                String cursor = event.at("/queryStringParameters/cursor").asText("");
                if (!cursor.isBlank()) start = Map.of("pk", s(user), "sk", s(TaskRules.id(cursor)));
                QueryRequest.Builder query = QueryRequest.builder().tableName(TABLE)
                    .keyConditionExpression("pk = :u").expressionAttributeValues(Map.of(":u", s(user))).limit(20);
                if (start != null) query.exclusiveStartKey(start);
                QueryResponse result = DB.query(query.build());
                List<Map<String,String>> tasks = result.items().stream()
                    .map(item -> Map.of("id", item.get("sk").s(), "titulo", item.get("titulo").s())).toList();
                String next = result.hasLastEvaluatedKey() && !result.lastEvaluatedKey().isEmpty()
                    ? result.lastEvaluatedKey().get("sk").s() : "";
                respond(output, 200, Map.of("tareas", tasks, "siguienteCursor", next));
            } else respond(output, 405, Map.of("error", "metodo no permitido"));
        } catch (ConditionalCheckFailedException ex) {
            respond(output, 409, Map.of("error", "id ya existente para este usuario"));
        } catch (IllegalArgumentException ex) {
            respond(output, 400, Map.of("error", "datos invalidos"));
        } catch (Exception ex) {
            // No registrar cuerpos, JWT, mensajes de excepcion ni datos personales.
            context.getLogger().log(JSON.writeValueAsString(Map.of("event", "request_failed",
                "requestId", context.getAwsRequestId(), "type", ex.getClass().getSimpleName())));
            respond(output, 500, Map.of("error", "fallo interno"));
        }
    }
    private static AttributeValue s(String value) { return AttributeValue.builder().s(value).build(); }
    private static void respond(OutputStream output, int code, Object body) throws IOException {
        JSON.writeValue(output, Map.of("statusCode", code, "headers", Map.of("content-type", "application/json"),
            "body", JSON.writeValueAsString(body)));
    }
}
