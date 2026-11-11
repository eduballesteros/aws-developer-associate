# Pruebas y despliegue
- Diferencia unitarias (lógica aislada), integración (servicios reales) y extremo a extremo (flujo completo).
- Una prueba generada por IA puede repetir el mismo error del código: contrasta con requisitos independientes.
- SAM transforma recursos de aplicación en CloudFormation. Lee plan de cambios antes de ejecutarlo.
- Versiones Lambda son publicadas/inmutables; alias apunta a versión y puede repartir tráfico.
- Canary desplaza fracción antes de completar; blue/green alterna entornos; rolling sustituye por grupos.
- Rollback debe contemplar cambios de esquema/configuración y efectos externos, no solo código.
- CodeBuild construye/prueba; CodePipeline orquesta fases; CodeDeploy gestiona despliegues compatibles.
- Artefactos: dependencias, JAR/ZIP, imagen, tags y configuración por entorno. No meter secretos en imagen.
- ECR almacena imágenes; ECS/EKS orquestan; Fargate ejecuta sin administrar hosts de la misma forma que EC2.
- Reconoce definición de tarea ECS, manifiesto EKS, sondas de salud y revisiones sin desplegar un clúster caro.
- El buildspec incluido solo prueba/empaqueta; no es una canalización completa ni realiza despliegue.
Autoevaluación: el código compila, pero el canary falla. ¿Qué métrica, log y rollback comprobarías?
