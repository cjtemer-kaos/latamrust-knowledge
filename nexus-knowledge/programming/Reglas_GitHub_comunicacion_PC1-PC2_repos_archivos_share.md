# Reglas GitHub, comunicacion PC1-PC2, repos, archivos share

REGLAS GITHUB Y COMUNICACION PC1-PC2

GITHUB HYGIENE:
- NUNCA subir IPs/passwords/usernames internos a repos
- Limpiar con regex a placeholders antes de push
- Repo cobbleverse-launcher PÚBLICO (launcher baja pack de ahí)
- Pack >100MB: git rechaza, usar GitHub Releases
- API keys: usar TU_API_KEY_AQUI en templates

COMUNICACION PC1 <-> PC2:
- Carpeta: \\PC2-NEXUS\share\mensajes
- Scripts: send.py, receive.py, watch.bat, watch-pc2.bat
- Setup: \\PC2-NEXUS\share\mensajes\SETUP-PC1.bat
- Uso PC1: python send.py PC1 PC2 "mensaje"
- Uso PC2: python send.py PC2 PC1 "mensaje"
- Monitoreo: watch.bat (PC1) o watch-pc2.bat (PC2)
- IMPORTANTE: Ambos PCs usan la MISMA carpeta, NO escritorios locales

REPOS GITHUB:
- cjtemer-kaos/cobbleverse-pack: modpack + skins
- cjtemer-kaos/cobbleverse-launcher-v2: launcher fuente
- cjtemer-kaos/supernexus-hermes-config: guia configuracion

ARCHIVOS IMPORTANTES EN SHARE:
- LatamRust_Cobbleverso.exe: launcher para distribuir
- cobbleverse-pack-v4.0.1.zip: juego completo (1.8GB)
- INFORME-LAUNCHER-v4.1.md: documentacion completa
