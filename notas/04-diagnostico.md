# Diagnóstico y optimización
1. Reproduce con datos ficticios e identifica cambio reciente.
2. Correlaciona request ID, timestamp y servicio. Logs explican eventos; métricas tendencias; trazas recorrido.
3. AccessDenied: identidad efectiva, región/recurso, política de identidad/recurso, KMS, condiciones y Deny.
4. Timeout: dependencia, red, conexiones, configuración y latencia; subir timeout puede esconder la causa.
5. Throttling: cuota, concurrencia y particiones calientes; retries con backoff, no tormenta de llamadas.
6. Despliegue fallido: eventos CloudFormation y logs de build antes de cambiar código al azar.
7. Compara memoria/CPU con duración y coste; no asumir que la memoria mínima es más barata.
8. Evita datos sensibles en logs; retención y volumen también cuestan.
9. Emite métricas de negocio y alertas accionables; comprueba que se notifican.
10. Las recomendaciones de IA son hipótesis: verifica contra evidencia antes de aplicarlas.

Ejemplo Logs Insights para logs JSON con campo event:
```sql
fields @timestamp, event, requestId
| filter event = "request_failed"
| sort @timestamp desc
| limit 20
```
El handler base registra eventos mínimos, sin cuerpo ni tokens. Añade trazas/alarma como reto, no están activadas.
