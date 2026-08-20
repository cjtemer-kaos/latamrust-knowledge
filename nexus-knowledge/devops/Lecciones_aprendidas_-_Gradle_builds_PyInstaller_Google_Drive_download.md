# Lecciones aprendidas - Gradle builds, PyInstaller, Google Drive download

LECCIONES APRENDIDAS - Gradle builds y PyInstaller

GRADLE BUILD (BOs-Easy-NPC):
- Estructura: core/Common -> core/Fabric -> config-ui -> bundle/Fabric
- Java 21 requerido en rama 1.21.1 (no 17)
- Dependencias circulares: bundle/Fabric necesita config-ui que necesita core
- Solucion: construir en orden correcto o usar Modrinth JAR original
- Common module SII compila (easy_npc-common-1.21.1-7.5.0.jar)
- Fabric module falla por dependencia config-ui (modRuntimeOnly)

PYINSTALLER:
- Usar Python del sistema (NO hermes venv): C:/Users/cjtr/AppData/Local/Programs/Python/Python313/python.exe
- PYTHONPATH= para evitar contamination del hermes venv
- --hidden-import gdown para incluir gdown en el exe
- --add-data assets;assets para incluir imagenes
- gdown quiet=False causa NoneType write en PyInstaller -> usar quiet=True
- urllib.request.Session no existe -> usar gdown con id= parameter

GOOGLE DRIVE DOWNLOAD:
- gdown.download(id=FILE_ID, output=dest, quiet=True) funciona
- gdown.download(url=URL) tambien funciona
- No usar fuzzy=True (no soportado en version 6.x)
- No usar quiet=False (causa error en PyInstaller)
