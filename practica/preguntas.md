# Preguntas originales · 24
No son preguntas reales del examen. Responde antes de desplegar la solución; registra dudas.
Cada dominio tiene seis preguntas; esta distribución NO reproduce la ponderación oficial.

## 1. Dominio 1
Una Lambda escribe en una tabla. ¿Cómo obtiene permisos?

A. Claves root en variables  
B. Rol de ejecución limitado a la tabla  
C. Tabla pública

<details><summary>Respuesta y explicación</summary>

**B**. El rol entrega credenciales temporales. Root es excesivo y una tabla pública no resuelve la autorización.

</details>

## 2. Dominio 1
Necesitas listar tareas de un usuario con PK conocida. ¿Qué operación?

A. Scan y filtro siempre  
B. Query por partición  
C. Exportar toda la tabla

<details><summary>Respuesta y explicación</summary>

**B**. Query usa la clave. Un filtro tras Scan no evita leer el conjunto recorrido; exportar no responde a la consulta interactiva.

</details>

## 3. Dominio 1
Se entrega dos veces un mensaje que genera un cargo. ¿Qué protege?

A. Solo FIFO  
B. Solo más memoria  
C. Idempotencia con identificador persistente

<details><summary>Respuesta y explicación</summary>

**C**. La deduplicación de transporte no garantiza efectos externos únicos. El consumidor debe reconocer la operación ya aplicada.

</details>

## 4. Dominio 1
Dos consumidores fallan y reintentan a la vez. ¿Qué reduce la sincronización?

A. Backoff exponencial con jitter  
B. Reintento inmediato infinito  
C. Suprimir todos los errores

<details><summary>Respuesta y explicación</summary>

**A**. El jitter dispersa reintentos. El bucle inmediato agrava carga; ocultar errores pierde fiabilidad.

</details>

## 5. Dominio 1
Necesitas distribuir un evento a varias colas. ¿Qué patrón?

A. Una cola con consumidores que esperan todos recibirlo  
B. SNS con suscripciones SQS  
C. Guardar el evento solo en logs

<details><summary>Respuesta y explicación</summary>

**B**. SNS hace fan-out a colas; consumidores de una misma cola se reparten trabajo, no reciben todos una copia.

</details>

## 6. Dominio 1
Un asistente genera código y tests que pasan. ¿Qué concluyes?

A. Requisitos y seguridad aún necesitan revisión independiente  
B. El código ya es seguro  
C. No hacen falta casos límite

<details><summary>Respuesta y explicación</summary>

**A**. Código y tests pueden compartir supuestos erróneos. Pasar tests no demuestra seguridad ni cobertura de requisitos.

</details>

## 7. Dominio 2
Allow y Deny explícito aplicables a la misma acción. ¿Resultado?

A. Gana Allow  
B. Se alternan  
C. Gana Deny

<details><summary>Respuesta y explicación</summary>

**C**. Deny explícito aplicable prevalece. Hay que revisar además otras capas de autorización.

</details>

## 8. Dominio 2
El body contiene userId de otro usuario. ¿Qué debe usar la API?

A. Ese campo sin verificar  
B. Identidad del JWT verificado y autorización  
C. Un usuario fijo global

<details><summary>Respuesta y explicación</summary>

**B**. La identidad de cliente no es confiable por sí sola. El token debe validarse y cada acceso limitarse al propietario.

</details>

## 9. Dominio 2
Un tercero necesita descargar un objeto privado durante poco tiempo. ¿Opción?

A. URL prefirmada de operación limitada  
B. Bucket público permanente  
C. Enviar clave del firmante

<details><summary>Respuesta y explicación</summary>

**A**. La URL limita tiempo y operación; no hay que entregar credenciales ni hacer público el bucket.

</details>

## 10. Dominio 2
Leer un secreto cifrado falla pese a permiso del servicio. ¿Qué revisar?

A. Solo nombre del archivo Java  
B. Permisos/política de clave KMS si corresponde  
C. Cambiar a root como solución permanente

<details><summary>Respuesta y explicación</summary>

**B**. El servicio y la clave pueden tener controles distintos. Root no es una corrección de mínimo privilegio.

</details>

## 11. Dominio 2
El modelo solicita ejecutar una operación sensible sin permiso del usuario. ¿Qué haces?

A. Ejecutarla por confianza en el modelo  
B. Dar privilegios administrativos  
C. Validar autorización fuera del modelo y exigir revisión si procede

<details><summary>Respuesta y explicación</summary>

**C**. La salida del modelo no concede derechos. Limitar herramientas y sesiones reduce el impacto de instrucciones maliciosas.

</details>

## 12. Dominio 2
Un log de interacción IA contiene datos personales. ¿Acción adecuada?

A. Minimizar/redactar y restringir acceso/retención  
B. Copiarlo a un prompt público  
C. Solo cambiar el nombre de la función

<details><summary>Respuesta y explicación</summary>

**A**. Protege el contenido antes de registrarlo. Renombrar no evita exposición; compartirlo agrava el problema.

</details>

## 13. Dominio 3
Quieres que un alias apunte a una revisión estable de Lambda. ¿Qué usar?

A. Siempre $LATEST mutable  
B. Versión publicada  
C. Solo rama Git sin desplegar

<details><summary>Respuesta y explicación</summary>

**B**. Una versión publicada es una revisión inmutable. Git por sí solo no cambia el destino desplegado.

</details>

## 14. Dominio 3
¿Qué servicio orquesta fases de una canalización?

A. CodePipeline  
B. DynamoDB  
C. Cognito

<details><summary>Respuesta y explicación</summary>

**A**. CodePipeline coordina fases; CodeBuild ejecuta construcción/pruebas. Los otros servicios no son orquestadores CI/CD.

</details>

## 15. Dominio 3
¿Qué debe ocurrir cuando falla una prueba requerida?

A. Desplegar igualmente  
B. Ignorar salida  
C. Bloquear promoción de esa revisión

<details><summary>Respuesta y explicación</summary>

**C**. Una fase de validación debe impedir promover una revisión inválida; ignorarla elimina su utilidad.

</details>

## 16. Dominio 3
Una revisión recibe primero 10% del tráfico para observar errores. ¿Estrategia?

A. Canary  
B. Despliegue total inmediato  
C. Scan

<details><summary>Respuesta y explicación</summary>

**A**. Canary desplaza una fracción antes de completar. Scan es operación de datos, no estrategia de despliegue.

</details>

## 17. Dominio 3
¿Dónde guardas configuración distinta por entorno?

A. Secretos incrustados en imagen  
B. Configuración externa controlada por entorno  
C. En comentarios Java públicos

<details><summary>Respuesta y explicación</summary>

**B**. Separar configuración facilita seguridad y promoción del mismo artefacto. Los secretos no deben estar en imagen/código.

</details>

## 18. Dominio 3
¿Qué diferencia ECR y ECS?

A. Ambos son bases SQL  
B. ECR gestiona JWT  
C. ECR almacena imágenes y ECS orquesta tareas

<details><summary>Respuesta y explicación</summary>

**C**. Son funciones diferentes: registro y orquestación. JWT corresponde a identidad, no al registro de imágenes.

</details>

## 19. Dominio 4
La API devuelve 500 desde el último despliegue. ¿Primer enfoque?

A. Aumentar todos los límites  
B. Correlacionar errores y cambios con logs/métricas  
C. Borrar logs

<details><summary>Respuesta y explicación</summary>

**B**. Busca evidencia y cambios antes de modificar recursos; borrar logs impide investigar.

</details>

## 20. Dominio 4
Una Lambda tarda menos con más memoria. ¿Es siempre más cara?

A. No: comparar duración, recursos y precio  
B. Sí siempre  
C. No tiene coste de cómputo

<details><summary>Respuesta y explicación</summary>

**A**. El coste depende de recursos y duración, entre otros factores. Hay que medir, no inferir solo por memoria.

</details>

## 21. Dominio 4
Suben reintentos y entregas a DLQ. ¿Qué hacer?

A. Redrive inmediato sin corregir  
B. Eliminar DLQ  
C. Investigar causa y validar corrección antes del redrive

<details><summary>Respuesta y explicación</summary>

**C**. Reinyectar sin corregir repite el fallo y puede duplicar efectos. DLQ preserva información para recuperación.

</details>

## 22. Dominio 4
Necesitas seguir una solicitud entre servicios. ¿Qué aporta más contexto?

A. Traza distribuida correlacionada  
B. Solo un contador total  
C. Nombre del bucket

<details><summary>Respuesta y explicación</summary>

**A**. Las trazas muestran recorrido y latencias; una métrica agregada no reconstruye por sí sola la solicitud.

</details>

## 23. Dominio 4
Quieres alerta cuando aumentan errores. ¿Qué combinas?

A. TTL e índice  
B. Métrica, umbral/alarma y canal de notificación  
C. Más comentarios en código

<details><summary>Respuesta y explicación</summary>

**B**. Se necesita condición observable y notificación. TTL e índices no sustituyen alarmas.

</details>

## 24. Dominio 4
La IA sugiere aumentar timeout por un fallo. ¿Cómo actuar?

A. Aplicarlo sin medir  
B. Dar acceso total al asistente  
C. Verificar logs, dependencias y causa antes de cambiar

<details><summary>Respuesta y explicación</summary>

**C**. La recomendación es hipótesis. Verificar evita ocultar problemas de red, permisos o rendimiento.

</details>
