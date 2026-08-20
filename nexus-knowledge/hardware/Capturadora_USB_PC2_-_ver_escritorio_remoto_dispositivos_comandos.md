# Capturadora USB PC2 - ver escritorio remoto, dispositivos, comandos

CAPTURADORA USB PC2 - Ver escritorio remoto

HARDWARE: Capturadora USB conectada a tarjeta de video de PC2
DISPOSITIVOS: 'USB Video' y 'XHLC Camera'

COMANDO PARA VER PC2:
ffmpeg -f dshow -i video="USB Video" -frames:v 1 -update 1 pc2_screen.png

LUEGO: vision_analyze(image_url="pc2_screen.png") para ver que hay en pantalla

LIMITACIONES:
- Solo funciona cuando PC1 esta en la misma red
- La capturadora debe estar conectada fisicamente
- La resolucion depende de la capturadora
- No funciona si PC2 esta apagado o la capturadora desconectada

USO COMUN:
1. Verificar estado de MCSS en PC2
2. Verificar que el server esta corriendo
3. Ver errores en pantalla
4. Monitorear instalaciones
