# Laboratorios con presupuesto total de 10 €
Materiales: 0 €. Laboratorios: objetivo ≤10 € en todo el ciclo, examen aparte.
No se garantiza ese coste: región, uso, impuestos, cuenta y créditos lo cambian.

## Antes de desplegar
- Revisa plan, saldo y vencimiento en Billing. La capa gratuita no cubre todos los servicios.
- Estima precios de Lambda, API Gateway, DynamoDB, Cognito, logs y almacenamiento de artefactos.
- En Billing → Budgets crea un presupuesto de coste para el periodo de estudio, con importe
  conservador en la moneda de tu cuenta (deja margen respecto a 10 €).
- Alertas al 50%, 80% y 100% por correo. Confirma las suscripciones si el canal lo solicita.
- Revisa filtros: incluye todas las regiones y servicios. Mantén una vista del uso sin descontar créditos.
- No dependas de previsiones en una cuenta sin historial. Mira costes reales cada sesión.
- Registra consumo en seguimiento/costes.md.
AWS Budgets avisa con retraso: **no corta automáticamente el gasto**.
Fuente: [documentación oficial](https://docs.aws.amazon.com/cost-management/latest/userguide/budgets-managing-costs.html).

## Durante
Una región, pocas peticiones, ninguna carga masiva. No usar datos personales reales.
La base tiene DynamoDB bajo demanda y logs con 3 días de retención; ambos pueden costar.
No activa VPC/NAT, RDS, DAX, ElastiCache ni concurrencia aprovisionada.
Esos temas se estudian con escenarios; no los despliegues para completar el plan.
No habilites SMS en Cognito. No compres dominio. No crees claves KMS o Private CA solo por practicar teoría.
Al probar IA usa un mock por defecto; revisa precio y permisos antes de cualquier llamada real.

## Cierre de cada laboratorio
1. Guarda código y evidencias sin secretos.
2. Desde proyecto: `sam delete --stack-name aws-dev-estudio --region eu-west-1 --profile estudio`.
3. Revisa CloudFormation: la pila debe desaparecer; atiende DELETE_FAILED.
4. Comprueba tabla, API, funciones, Cognito, logs, colas y buckets de artefactos.
5. Los buckets con objetos/versiones, repositorios ECR y recursos externos pueden persistir.
   Borra únicamente recursos identificados como tuyos de este laboratorio.
6. Revisa facturación al día siguiente. Si queda gasto, identifica servicio y región antes de recrear.
Eliminar la pila borra datos del laboratorio; exporta solo datos ficticios que quieras conservar.

Si el consumo se aproxima a 8 €: detén despliegues y sigue localmente. No amplíes presupuesto por defecto.
