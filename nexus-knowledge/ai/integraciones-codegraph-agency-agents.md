# integraciones-codegraph-agency-agents

Integradas 2 mejoras desde repos externos:

1. CodeGraph (colbymchenry/codegraph): MCP server de code intelligence con tree-sitter + SQLite FTS5. Indexa SuperNEXUS (417 archivos, 6989 nodos, 6572 edges). Configurado en .claude/settings.json como MCP server. Reduce 94% tool calls para explorar código. Excluye skills/hub del índice.

2. Agency Agents (msitarzewski/agency-agents): 205 perfiles de agentes especializados importados como skills en src/skills/hub/agency-*. Cubren: engineering, design, marketing, finance, game-dev, academic, QA, product, sales, support. Total skills ahora: 1637.

CodeGraph tools disponibles: codegraph_search, codegraph_context, codegraph_callers, codegraph_callees, codegraph_impact, codegraph_node, codegraph_explore, codegraph_status, codegraph_files.
