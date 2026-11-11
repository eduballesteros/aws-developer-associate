# Validación del repositorio
Fecha: 11/11/2026.
- Java 21: compilación y empaquetado Maven completados (BUILD SUCCESS).
- JUnit: 4 pruebas de validación de entradas; 0 fallos y 0 errores.
- Enlaces internos Markdown, eventos JSON y pom.xml: comprobados.
- Script de autenticación PowerShell: sintaxis comprobada; no se ha autenticado contra AWS.
- No se ha desplegado en AWS: authorizer, aislamiento real, infraestructura SAM y pruebas de integración
  quedan por verificar siguiendo proyecto/README.md. No se presenta la base como validada en producción.
- Maven se ejecutó desde una carpeta temporal, sin instalación global. Instala Maven para usar mvn en tu equipo.
- El empaquetado produjo avisos de recursos META-INF superpuestos entre dependencias; completó correctamente.

## Actualización de la guía semanal
Se han reorganizado las 12 semanas en tareas y entregas, con asignación de 240 minutos por semana.
Las marcas de tiempo se limitan a las publicadas; los demás intervalos son presupuestos de estudio.
El código Java no cambia en esta actualización. Las pruebas de nube siguen pendientes.
