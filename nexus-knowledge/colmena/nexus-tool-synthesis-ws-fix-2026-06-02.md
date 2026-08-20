# nexus-tool-synthesis-ws-fix-2026-06-02

# Tool result synthesis fix en `src/api/server.py:handle_chat_ws`. Antes, cuando una tool como `web_se

Tool result synthesis fix en `src/api/server.py:handle_chat_ws`. Antes, cuando una tool como `web_search`/`web_fetch`/`code_search`/`find_files`/`glob_files`/`grep_content`/`lsp_*` se ejecutaba, el server streameaba el JSON crudo envuelto en `\`\`\`tool_result` markdown fence. Ahora, server.py:1581-

## Temas


## Codigo

