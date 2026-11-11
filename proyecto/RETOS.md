# Retos progresivos
La base incluye solución de API, pero se aprende mejor implementando primero una variante sin copiar.
No todos los retos se resuelven en 90 minutos: prioriza el criterio semanal y extiende si hace falta.

## Semana 2 · S3 con SDK
Crea bucket privado, objeto de texto y URL de 60 s. SDK: S3Client, S3Presigner y cadena de credenciales.
Entrega: código sin claves y explicación del alcance de la URL. Alternativa sin nube: interfaz y mock.
Solución orientativa: PutObject → GetObject → presign GetObject; limpiar objeto y bucket.

## Semanas 3–5 · API y datos
Lee Handler.java. Cambia campo titulo por descripción opcional validada y añade tests.
Prueba dos usuarios y 21 tareas para comprobar paginación. El cursor no debe permitir elegir otra partición.
Entrega: evidencia 201/400/401/409, páginas y aislamiento, sin guardar JWT.
Solución: usar sub verificado en PK y cursor solo como SK; no aceptar PK del cliente.

## Semana 6 · Secretos
Diseña una interfaz ConfigProvider. Implementa fake local; documenta variante Parameter Store/Secrets Manager.
No crear secreto real necesario para esta API. Explica caché, rotación y permisos KMS.
Entrega: política mínima de ejemplo con ARNs ficticios y análisis de acceso.

## Semana 7 · SQS
Añade cola principal, DLQ y consumidor separado. En SAM configura fuente SQS y permisos por rol.
Visibilidad debe dar margen al timeout del consumidor; estudia recomendación vigente del servicio.
Simula dos entregas iguales y fallo persistente; usa identificador idempotente persistido con condición.
Si guardas estado y publicas evento en pasos separados, existe riesgo de evento perdido: analiza outbox
o DynamoDB Streams como mejora complementaria. No afirmes atomicidad entre PutItem y SendMessage.
Entrega: repetición sin efecto duplicado y recuperación de un mensaje de DLQ después de corregir causa.
Solución orientativa: estado de procesamiento por ID, reconocimiento solo tras completar; manejar fallos parciales.

## Semana 8 · Automatización
El buildspec empaqueta y ejecuta tests. Diseña tres fases: fuente → build/test → deploy.
Usa un ejemplo oficial de CodePipeline si puedes hacerlo sin superar presupuesto.
Revisa rol de despliegue y artefactos, no AdministratorAccess por comodidad.
Añade alias, versión y estrategia canary en una rama; prueba rollback con pocas solicitudes.
Entrega: prueba fallida bloquea promoción y explicación de reversión. La canalización completa no viene creada.

## Semana 9 · Observabilidad
Añade log JSON de operación sin datos sensibles, métrica de error y alarma con aviso.
Implementa trazas mediante instrumentación compatible vigente; revisa muestreo/coste.
Haz fallar permiso DynamoDB en un entorno desechable; restaura después.
Compara memoria con una muestra pequeña y registra limitaciones de la medición.
Entrega: línea de tiempo, evidencia, causa, corrección y limpieza. Consulta notas/04-diagnostico.md.

## Semana 10 · IA
Define interfaz AiClient y FakeAiClient que clasifica una tarea ficticia.
Prueba timeout, salida malformada y entrada con secreto señuelo; evita registrar contenido.
Usa una herramienta asistida por IA disponible para proponer tests y revisa cada caso.
Variante opcional: cliente de servicio gestionado AWS, solo tras comprobar acceso/precio.
Entrega: contrato de entrada/salida, autorización externa y lista de riesgos.
No necesitas seleccionar modelos, diseñar RAG ni crear un marco de gobierno para el examen.

## Comprobación final
Puedes explicar identidad, permisos, datos, reintentos, despliegue y coste sin mirar código.
Proyecto demostrado no sustituye cubrir todos los servicios y skills de la guía.
