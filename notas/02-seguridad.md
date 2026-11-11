# Seguridad · notas de decisión
- Autenticación identifica; autorización decide acciones; auditoría deja evidencia.
- Roles y STS dan sesiones temporales. Trust policy y permisos del rol resuelven problemas distintos.
- Deny explícito aplicable prevalece; falta de Allow también puede impedir una acción.
- En API no confíes en un propietario enviado por cliente. Derívalo del token verificado y limita cada operación.
- URLs prefirmadas: limitan operación/tiempo; no son un mecanismo para hacer público un bucket.
- Cifrado en tránsito (TLS) y en reposo protegen puntos distintos. Cifrado de cliente protege antes de enviar.
- KMS: autorización del servicio y autorización sobre clave pueden ser necesarias; protege claves y datos.
- Secrets Manager: ciclo de secretos/rotación. Parameter Store: configuración y parámetros según tipo y necesidades.
- Certificados: entiende ACM público frente a Private CA; no despliegues CA para una práctica de bajo presupuesto.
- Nunca incluir JWT, contraseñas, secretos ni datos sensibles en logs, prompts o commits.
- IA: valida entrada/salida, minimiza datos, controla herramientas con autorización externa al modelo y aísla sesiones.
  La salida del modelo no otorga privilegios. Revisa opciones de privacidad específicas del servicio.
- Reconoce prompt injection y necesidad de revisión humana en acciones sensibles; no necesitas diseñar RAG.
Autoevaluación: tienes Allow en DynamoDB pero AccessDenied con SSE-KMS. ¿Qué permisos y políticas revisarías?
