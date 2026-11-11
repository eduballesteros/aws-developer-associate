# Roadmap de acciones · 12 semanas / 48 horas
Perfil: Java intermedio, AWS desde cero, español, 4 h/semana y laboratorios hasta 10 € en total.
Objetivo orientativo: febrero de 2027; no reservar por calendario si falta preparación.
Si comienzas después, desplaza semanas sin comprimir repasos.

**Cada enlace de semana abre las cuatro sesiones y la entrega concreta.**
Vídeos: [selección, marcas de tiempo y límites](youtube.md). Alcance del examen: [fuentes oficiales](fuentes.md).

| Semana | Objetivo | Temas | Práctica | Recursos | Horas | Criterio de avance |
|---|---|---|---|---|---:|---|
| [01](../semanas/01.md) | Cuenta segura y fundamentos | Regiones, IAM, MFA y presupuesto | Preparar equipo, cuenta y alertas | [V1](youtube.md) + guía de semana | 4 | Explicas región/AZ y rol frente a usuario; sabes qué cuenta y región usarás y cómo te enterarás del gasto. |
| [02](../semanas/02.md) | SDK Java y S3 | SDK, credenciales, objetos y URLs firmadas | Ejemplo S3 o mock etiquetado | [V1](youtube.md) + guía de semana | 4 | No hay claves en el repositorio y distingues identidad, permiso del objeto y expiración de la URL. |
| [03](../semanas/03.md) | Primera ejecución del proyecto y flujo HTTP | Eventos, HTTP y validación | Compilar Java y añadir un caso de prueba | [V2](youtube.md) + guía de semana | 4 | Puedes localizar la validación, justificar errores y distinguir pruebas locales de pruebas de integración. |
| [04](../semanas/04.md) | DynamoDB y protección frente a duplicados | Claves, Query, consistencia, índices y TTL | Modelar 21 tareas y preparar casos | [V2](youtube.md) + guía de semana | 4 | Justificas el patrón de acceso y por qué el cursor no debe permitir cambiar el usuario de la consulta. |
| [05](../semanas/05.md) | Autenticación y prueba de dos usuarios | Cognito, JWT y autorización | Probar sin token y con usuarios A/B | [V4](youtube.md) + guía de semana | 4 | Demuestras aislamiento entre usuarios y sabes dónde se valida el JWT y dónde se aplica autorización sobre datos. |
| [06](../semanas/06.md) | Cifrado, secretos y permisos | TLS, KMS, secretos y datos sensibles | Revisar logs y política ficticia | [V4](youtube.md) + guía de semana | 4 | Distingues permiso del servicio y de clave, y puedes justificar cómo proteger configuración y logs. |
| [07](../semanas/07.md) | Colas, reintentos e idempotencia | SQS/SNS/EventBridge, reintentos y DLQ | Simular entregas repetidas y fallos | Documentación oficial + guía de semana | 4 | Puedes explicar la recuperación y demostrar que el identificador repetido no duplica efectos en tu simulación. |
| [08](../semanas/08.md) | SAM, tests y automatización | IaC, artefactos, canalizaciones y rollback | Romper/restaurar un test y diseñar fases | [V5](youtube.md) + guía de semana | 4 | Distingues build, pruebas, promoción y despliegue; puedes explicar canary/blue-green/rolling y rollback. |
| [09](../semanas/09.md) | Diagnosticar con logs y métricas | Logs, métricas, alarmas y rendimiento | Investigar un incidente y proponer alarma | [V2](youtube.md) + guía de semana | 4 | Usas evidencias para distinguir permiso, latencia y límites; no guardas datos sensibles en logs. |
| [10](../semanas/10.md) | IA segura y revisión del alcance | Asistencia de IA, privacidad, contenedores y cobertura | Fake IA, casos límite y matriz de lagunas | Documentación oficial + guía de semana | 4 | Puedes revisar salida de IA y limitar datos/acciones; sabes qué contenidos del alcance sigues sin dominar. |
| [11](../semanas/11.md) | Diagnóstico de preparación | Simulacro y errores por dominio | 130 min evaluación, 80 corrección, 30 plan | Fuente legítima nueva; alternativa formativa si no hay acceso | 4 | Errores explicados y refuerzo definido |
| [12](../semanas/12.md) | Decidir siguiente paso | Segunda evaluación y demostración | 130 min evaluación, 60 revisión, 50 explicación/checklist | Otro simulacro nuevo + proyecto | 4 | Resultados consistentes y conceptos aplicados, o ampliación |

## Sesiones y presupuesto de tiempo
Semanas 1–10: sesión 1=60 min teoría; sesión 2=60 min práctica; sesión 3=30 práctica+30 preguntas;
sesión 4=15 corrección+45 repaso/registro. Total semanal exacto: 240 min.
Reparte parte del repaso al día siguiente (+1) y recupera conceptos de +7/+21 días sin añadir horas.

**Mínimo y ampliaciones:** mínimo es la entrega semanal. SQS real, canalización completa, canary,
alarmas/trazas reales y comparación de memoria son ampliaciones si no caben. Las habilidades que
solo hayas simulado se marcan como tales; usa cobertura para decidir refuerzo.
El laboratorio integrado se despliega y prueba en semana 5, con presupuesto preparado;
antes se estudian y prueban componentes localmente. Eliminar y recrear, no dejar recursos entre semanas.

Si una configuración consume el tiempo de práctica, termina la sesión, registra el bloqueo y
amplía esa semana. No sustituyas práctica por ver más vídeos.

## Evaluación y recursos de pago
No se garantiza un simulacro completo gratuito en español. Los mini-tests locales no sustituyen dos
muestras nuevas. Semanas 11–12 incluyen una alternativa formativa y dejan visible esa limitación.
No se compra ni se despliega nada automáticamente. [Criterios de reserva](examen.md).
