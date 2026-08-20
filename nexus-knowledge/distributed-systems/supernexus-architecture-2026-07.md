# supernexus-architecture-2026-07

SUPERNEXUS UI - Arquitectura completa (sesión 2026-07-26):
- Frontend: React+TypeScript+Tailwind en ui/src/, build con vite via build-safe.sh
- Backend: Py3.13 en src/api/server.py (9398 líneas), port 9000
- Golden bundle: dist_golden/index-CCYbE4zY.js (1.4MB) = fuente de verdad
- Source compilado: ~548KB, 50 archivos en ui/src/
- 13 sidebar items: Chat, Proyectos, Editor, Gemas, Teams, Compare, Gallery, Tareas, Cerebro, Skills, Hive, Conexiones, Sistema
- Right panel: AvatarRenderer + scanner rings + emociones + System Monitor + Activity Log + ESCUCHAR
- Chat: WebSocket streaming, modelo selector, voice (Web Speech API), imágenes pendientes
- Proyectos: CRUD universal, scan por markers, auto-load CONTEXT.md
- Gallery: Vision Chat conectado al Director (no directo a Foocus), configurable host:port
- Teams: Ejecución Paralela con 24 gemas, timeout, sintetizar
- Cerebro: Dashboard/Conocimiento/Conversaciones/Memoria/Salud, brain modules, dream consolidation
- Conexiones: 17 agentes, filter tags, health check, sync
- Hive: Hub con agents list + dispatch task
