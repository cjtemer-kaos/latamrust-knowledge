# Launcher v5.0 completo - fusionado PC1+PC2, features, bugs, backups

LAUNCHER v5.0 COMPLETO - Fusionado PC1 + PC2

UBICACION: D:\ias\proyectos\cobbleverse-launcher-v2\
- launcher_v5.py (368 lineas) - Codigo fuente principal
- main_v5.py - Entry point para PyInstaller
- dist/LatamRust_Cobbleverso.exe (24MB) - Exe compilado
- Share: \\PC2-NEXUS\share\launcher-cobbleverse\

FEATURES:
1. Google Drive download via gdown (~65MB/s, ~30s)
2. Java 21 auto-install si no existe en el sistema
3. Skins sync EN AMBOS MOMENTOS:
   - En INSTALAR: descarga skins del server a cliente
   - En JUGAR: sincroniza skins ANTES de lanzar el juego
4. Update button: verifica GitHub para skins nuevas
5. installed() solo verifica %APPDATA%/LatamRust/mods/ (NO Modrinth profiles)
6. portablemc.exe copiado automaticamente al game dir
7. Nombre: LatamRust_Cobbleverso.exe

BUGS CORREGIDOS:
- gdown quiet=False causaba NoneType write en PyInstaller -> quiet=True
- urllib.request.Session no existe -> usar gdown con id= parameter
- installed() detectaba Modrinth profile como instalado -> solo verificar LatamRust
- installed() requeria versions/ que no esta en profile Modrinth -> solo verificar mods + fabric-api
- _refresh() no se ejecutaba despues de install -> usar root.after(100, _refresh)
- portablemc no encontrado -> copiar de BASE_DIR a GAME_DIR
- Java no encontrado -> auto-download Java 21

SKINS SYNC:
- Server: D:\SERVIDOR\servers\LATAMRUST COBBLEMON\config\easy_npc\skin\
- GitHub: release skins-v1 (325 skins, 106KB)
- Client: %APPDATA%\LatamRust\config\easy_npc\skin\
- Scripts: generate_skins.py, generate_pokemon_skins.py, sync_skins.py

BACKUPS EN SHARE:
- LatamRust_Cobbleverso_BACKUP.exe (v4.2)
- LatamRust_Cobbleverso_v4.2.exe (v4.2)
- launcher_v4_BACKUP.py
- launcher_pc2_BACKUP.py
