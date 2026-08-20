# supernexus-slash-commands

Sistema de slash commands SuperNEXUS v2:
- Backend: src/core/slash_commands.py — SlashRegistry con 9 comandos (help, clear, model, persona, skill, agent, session, plan, doctor)
- API: GET /api/slash (listar), POST /api/slash {raw:"/comando"} → SlashResult {ok, message, data}
- Frontend: ChatView.tsx detecta input que empieza con "/" → envía a /api/slash en vez de WebSocket
- Autocomplete: Dropdown predictivo al escribir "/", filtrado por prefijo, navegación con ↑↓, Tab para completar, Enter para ejecutar, Esc para cerrar
- El textarea es React controlled component — onKeyDown SOLO en el textarea, no en el div padre
- browser_press NO dispara onKeyDown de React — usar solo en Electron real para testing
