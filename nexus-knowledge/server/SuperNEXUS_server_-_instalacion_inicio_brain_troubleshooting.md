# SuperNEXUS server - instalacion, inicio, brain, troubleshooting

SUPERNEXUS SERVER - Configuracion y inicio

INSTALACION:
- Repo: D:\ias\proyectos\supernexus-v2
- Python: .venv-py313 (Python 3.13)
- Dependencias: pip install -r requirements.txt

INICIO:
- Comando: .venv-py313\Scripts\python.exe src\api\server.py 9000
- Puerto: 9000
- URL: http://localhost:9000

IMPORTANTE:
- NUNCA usar el python de hermes venv para SuperNEXUS
- Usar SIEMPRE .venv-py313\Scripts\python.exe
- Si falla con pydantic, es contamination de hermes venv
- Fix: unset PYTHONPATH o ruta completa al python

COMPONENTES:
- API Server: puerto 9000
- MCP Bridge: 100+ herramientas
- Brain: memoria persistente ilimitada
- Director: orquestador de agentes
- SelfLearningLoop: aprendizaje automatico

BRAIN:
- Directorio: D:\ias\proyectos\supernexus-v2\brain
- Mensajes: 5335+
- Conocimientos: 2259+
- Memorias: 3436+
- Canales: general, tasks, analysis, commands, ui

AUTO-START:
- El server NO auto-starta al reiniciar PC
- Usar script start_all.bat para iniciar todo
- SuperNEXUS debe iniciar ANTES de Hermes
