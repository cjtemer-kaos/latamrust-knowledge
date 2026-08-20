# nexus-ide-plan-mayo-2026

# NEXUS IDE — Plan de Implementacion

NEXUS no es plugin para VS Code — NEXUS ES el IDE. Como Cursor pero soberano y multi-modelo.

## Temas
- Git: aider/aider/repo.py (~500 LOC)
- LSP Autocomplete: marimo/lsp.py + hermes/lsp/ (~930 LOC)
- Codebase indexing: codegraph/ + aider/repomap.py (~1500 LOC)
- Visual diff: hermes/display.py + aider/diffs.py (~400 LOC)
- Plan-approve: ohmo/nano_tool.py (~300 LOC)
- Monaco + FileTree + Tabs + Store (base del IDE)
- Terminal embebida (xterm.js)
- Chat->Editor (boton Aplicar codigo)

## Codigo

