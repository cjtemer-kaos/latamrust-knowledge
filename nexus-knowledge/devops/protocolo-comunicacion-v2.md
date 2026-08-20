# protocolo-comunicacion-v2

PROTOCOLO NEXUSHIVE v2 (adoptado 2026-05-18):
- Tablero: SOLO handoffs y alerts. Auto-archive >24h.
- Estados de agentes: usar memory_set, NO tablero.
- Tareas completadas: mover a archivo historial automáticamente.
- Aprendizajes/conocimiento: usar brain_remember.
- Logs detallados: archivos locales, no tablero.
- Respaldos en ~/.nexus/brain/archives/ (tablero) y ~/.nexus/brain/memory_history/ (memoria).
