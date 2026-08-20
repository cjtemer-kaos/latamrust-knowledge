# Chat LatamRust solucion: paradigm reload chat + styled chat per-group

SOLUCION CHAT LATAMRUST (2026-08-09):

PROBLEMA: Chat mostraba rainbow para todos (admin y trainer). Styled Chat no tomaba control.

CAUSA: Paradigm customChatFormat estaba activo (enableCustomChatFormat=true) y usaba <rainbow> para todos.

SOLUCION:
1. Editar JSON directo: config/paradigm/chat.json -> enableCustomChatFormat=false
2. Ejecutar `paradigm reload chat` por RCON (NO paradigm reload, NO paradigm dashboard reload)
3. Dashboard web NO persiste cambios (WebSocket broken desde browser automation)
4. Para TAB list: Styled Player List usa %player:name% (no %player:displayname%) para evitar doble rango

COMANDOS CLAVE:
- paradigm reload chat (recarga SOLO chat config)
- paradigm dashboard reload (recarga dashboard, NO chat)
- No existe 'paradigm reload' (sin subcomando)

RESULTADO: Styled Chat toma control con colores por grupo:
- admin: <red><bold>ADMIN</bold></red> <rainbow>${player}</rainbow>: ${message}
- trainer: <aqua><bold>TRAINER</bold></aqua> <aqua>${player}</aqua>: ${message}

NOTA: Paradigm reescribe chat.json desde su DB al hacer reload. Si el JSON se edita sin reload, Paradigm lo sobreescribe con el valor de la DB. El edit del JSON + paradigm reload chat funciona porque Paradigm lee el JSON al recargar.
