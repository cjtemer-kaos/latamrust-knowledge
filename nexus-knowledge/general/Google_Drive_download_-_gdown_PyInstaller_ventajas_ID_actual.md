# Google Drive download - gdown, PyInstaller, ventajas, ID actual

GOOGLE DRIVE DOWNLOAD - Metodo recomendado

LIBRERIA: gdown (pip install gdown)

METODO 1: Por ID de archivo
import gdown
gdown.download(id='FILE_ID', output='dest.zip', quiet=True)

METODO 2: Por URL
import gdown
gdown.download(url='https://drive.google.com/uc?id=FILE_ID', output='dest.zip')

IMPORTANTE:
- NO usar fuzzy=True (no soportado en gdown 6.x)
- NO usar quiet=False en PyInstaller (causa NoneType write)
- USAR quiet=True para evitar problemas de output
- USAR id= parameter en vez de url= para mayor compatibilidad

PYINSTALLER:
- Incluir gdown: --hidden-import gdown
- gdown se incluye automaticamente si se importa en el codigo

VENTAJAS vs GitHub Releases:
- ~65MB/s vs ~5MB/s (GitHub throttling)
- Sin limite de tamaño para archivos grandes
- Google CDN global

ARCHIVO ACTUAL:
- Google Drive ID: 1h0ohkqZrSO2XX-ZIXYx7Ru0lAKqj9--n
- Contenido: cobbleverse-v401.zip (1.8GB, 8795 archivos)
