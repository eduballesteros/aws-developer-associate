# Preparación
## Conocimientos previos
Comprueba: métodos y excepciones Java, colecciones, JSON, HTTP (200/201/400/401/403/409/500),
Git, Maven y pruebas JUnit. Si no puedes crear una API pequeña, añade una semana previa.

## Equipo
- JDK 21 y Maven 3.9 o compatible: comprueba `java -version`, `javac -version`, `mvn -version`.
- Git: `git --version`.
- Para nube: AWS CLI v2 y AWS SAM CLI. Docker es opcional para SAM local.
- Instaladores oficiales en [fuentes](fuentes.md). No instales paquetes desde enlaces desconocidos.
- En proyecto ejecuta `mvn test package`. Descarga dependencias la primera vez.
- No hace falta Spring Boot para este laboratorio; centra tiempo en servicios AWS.

## Cuenta y acceso
1. Lee costes ANTES de crear recursos. Puedes hacer teoría, preguntas y tests Java sin cuenta AWS.
2. Activa MFA en root; reserva root para tareas que lo exigen.
3. Configura acceso temporal mediante una identidad federada/SSO cuando esté disponible.
4. Con AWS CLI, configura el perfil de laboratorio; si usas SSO: `aws configure sso --profile estudio`
   y `aws sso login --profile estudio`. Requiere un centro de identidades previamente configurado.
5. Comprueba `aws sts get-caller-identity --profile estudio`. No publiques su salida.
6. Usa una cuenta de laboratorio y una región; nunca uses recursos de trabajo para estos ejercicios.
7. Guarda credenciales fuera del repositorio. No incluyas claves en código, notas ni capturas.

## Primera sesión (60 min)
15 min leer roadmap y guía · 15 min comprobar herramientas · 15 min cuenta/MFA o teoría sin cuenta ·
15 min crear primera evidencia en seguimiento/progreso.md.
