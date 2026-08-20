# MCP Bridge SuperNEXUS-Hermes - configuracion, herramientas, troubleshooting

MCP BRIDGE - SuperNEXUS <-> Hermes

CONFIGURACION en ~/.hermes/config.yaml:
mcp_servers:
  supernexus:
    command: python (o ruta completa a python.exe)
    args:
    - D:\ias\proyectos\supernexus-v2\src\bridges\mcp_bridge_server.py
    env:
      NEXUS_BRAIN: D:\ias\proyectos\supernexus-v2\brain
    timeout: 120
    connect_timeout: 30

HERRAMIENTAS MCP DISPONIBLES (100+):
- brain_remember / brain_recall: Memoria persistente ilimitada
- codebase_context: Contexto de codigo comprimido
- execute_remote_task: Tareas en nodos remotos
- deep_research: Investigacion web profunda
- image_generate: Generacion de imagenes
- nexus_status: Estado del sistema
- doctor_diagnose: Auto-diagnostico
- system_resources: CPU, RAM, disco

IMPORTANTE:
- SuperNEXUS API debe estar corriendo en puerto 9000
- Python debe estar en PATH o usar ruta completa en command:
  command: D:\Miniconda3\python.exe (PC1) o python (PC2)
- NEXUS_BRAIN apunta al directorio de memoria
- Timeout: 120s para operaciones largas
