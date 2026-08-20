# Python environment - venv, PyInstaller, PYTHONPATH contamination, Windows quirks

PYTHON ENVIRONMENT - Configuracion y troubleshooting

PYTHONS DISPONIBLES EN PC1:
- Python 3.13: C:/Users/cjtr/AppData/Local/Programs/Python/Python313/python.exe (PARA PYINSTALLER)
- Miniconda 3.10: D:/Miniconda3/python.exe (para SuperNEXUS)
- Hermes venv: C:/Users/cjtr/.hermes/hermes-agent/venv/ (NO usar para PyInstaller)

PROBLEMA COMUN: PYTHONPATH contamination
- El hermes venv agrega sus paths al sys.path
- Esto causa conflictos con otras librerias (pydantic, etc.)
- SOLUCION: usar PYTHONPATH= antes del comando, o ruta completa al python

PYINSTALLER:
- Usar SIEMPRE el Python del sistema, NO el hermes venv
- Ruta: C:/Users/cjtr/AppData/Local/Programs/Python/Python313/python.exe
- Comando: PYTHONPATH= python -m PyInstaller ...
- Si falla con module not found, agregar --hidden-import MODULE_NAME

VENV SUPER:
- D:\ias\proyectos\supernexus-v2\.venv-py313\Scripts\python.exe
- Python 3.13, NO 3.11 (hermes usa 3.11)
- Install: pip install -r requirements.txt

WINDOWS QUIRKS:
- UNC paths (\\server\share) no funcionan con Python open()
- Usar net use o copiar a directorio local primero
- PowerShell backticks rompen bash: usar python scripts en vez de CMD
