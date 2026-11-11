# AWS Developer Associate · preparación personal
Java intermedio · AWS desde cero · 4 h/semana · español · laboratorios ≤10 € · objetivo orientativo: febrero de 2027.

## Empieza aquí
1. Lee [preparación del equipo](docs/00-inicio.md) y [costes](docs/costes.md).
2. Sigue el [roadmap](docs/roadmap.md) y abre [semana 01](semanas/01.md).
3. Completa [proyecto Java](proyecto/README.md), registra evidencias en seguimiento.
4. Practica con [preguntas originales](practica/preguntas.md) y [tarjetas](practica/tarjetas.tsv).
5. Decide cuándo reservar con [checklist del examen](docs/examen.md).

Para practicar con preguntas de selección, ejecuta desde esta carpeta en PowerShell:
```powershell
.\practica\Practicar.ps1 -Cantidad 6
# Solo seguridad:
.\practica\Practicar.ps1 -Dominio 2 -Cantidad 6
```
También puedes leerlas sin ejecutar nada en practica/preguntas.md.

## Contenido
- 12 guías semanales: teoría, práctica, comprobación y soluciones orientativas.
- Notas por dominio, referencias oficiales y matriz de cobertura.
- Base Java para Lambda, DynamoDB y Cognito, infraestructura SAM y pruebas.
- Retos progresivos de SQS, observabilidad, CI/CD e IA; no están resueltos en la base.
- 24 preguntas explicadas, tarjetas, dos mini-evaluaciones y registro de simulacros.

**DVA-C03**, guía consultada el 11/11/2026. [Fuentes y fechas](docs/fuentes.md).
El repositorio es material original de apoyo, no un curso oficial ni una garantía de aprobar.
48 horas es un primer ciclo: amplía 4–8 semanas si los resultados lo requieren.
No hay examen filtrado ni simulacros oficiales copiados. Los mini-tests no equivalen a un simulacro completo.

No se ha desplegado nada en AWS. Los comandos de despliegue crean recursos facturables.
Repositorio local; no se ha publicado en GitHub.
