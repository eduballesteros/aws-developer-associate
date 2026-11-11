# Desarrollo · notas de decisión
- SDK: reutilizar clientes fuera del handler; credenciales por cadena del SDK; no claves incrustadas.
- Síncrono: respuesta inmediata y dependencia de latencia. Asíncrono: desacoplar con entrega, reintentos e idempotencia.
- Lambda: memoria/CPU, timeout, concurrencia reservada frente a aprovisionada, cold start y conexiones reutilizadas.
- Eventos: API Gateway tiene respuesta HTTP; SQS usa polling por mapeo y requiere tratar fallos parciales.
- DynamoDB: Query necesita clave de partición; Scan recorre la tabla. Índices dependen del patrón de acceso.
  GSI tiene consistencia eventual. Escritura condicional evita sobrescribir; transacciones coordinan varias operaciones.
- S3 almacena objetos; RDS aporta SQL/relaciones/transacciones; DynamoDB acceso por claves y escalado gestionado.
- Caché: CloudFront para contenido en el borde; DAX para patrones DynamoDB compatibles; ElastiCache para caché de aplicación.
- Streaming: estudia particiones, orden, consumidores, retención y checkpoints; contrasta Kinesis y cola de trabajo.
- SQS Standard puede duplicar y desordenar; FIFO tiene grupos/orden y deduplicación con límites: consumidor idempotente.
- SNS distribuye a suscriptores; EventBridge enruta por reglas; Step Functions coordina estados y errores.
- Backoff con jitter evita reintentos sincronizados; no reintentar indiscriminadamente errores de validación.
- IA: el asistente propone; pruebas y revisión comprueban. Mock de servicio gestionado permite practicar sin consumo.
Autoevaluación: dibuja una solicitud que falla después de escribir datos y antes de confirmar el mensaje. ¿Cómo se recupera?
