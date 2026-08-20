# Configuracion completa Hermes + SuperNEXUS - guia, problemas, PC2

CONFIGURACION HERMES + SUPERNEXUS - Guia completa

REPO: github.com/cjtemer-kaos/supernexus-hermes-config
ARCHIVOS: SUPERNEXUS_HERMES_CONFIG.md, config_template.yaml, start_all.bat

HERMES CONFIG (config.yaml):
- Model: gemma4:latest (local Ollama, 128K context)
- Auxiliary: mimo-v2.5-free via OpenCode Zen
- MCP: supernexus bridge en puerto 9000
- Compression: mimo-v2.5-free con context_length 200000

SUPERNEXUS:
- API: puerto 9000, start: .venv-py313/python.exe src/api/server.py 9000
- Brain: D:\ias\proyectos\supernexus-v2\brain (ilimitado)
- MCP bridge: 100+ herramientas (brain_remember, brain_recall, codebase_context, etc.)

SOLUCIONES PROBLEMAS COMUNES:
- Context length exceeded: auxiliary compression debe usar modelo EXTERNO (no local)
- Memory full (2200 chars): usar SuperNEXUS brain, no memory local
- MCP bridge no conecta: verificar Python en PATH + puerto 9000
- Auxiliary models no funcionan: verificar API key OpenCode Zen

PC2 (192.168.1.16):
- MCSS corriendo, LatamRust Cobblemon + SuperNexus online
- Capturadora USB para ver escritorio: ffmpeg -f dshow -i video="USB Video"
- Share: \\PC2-NEXUS\share\
