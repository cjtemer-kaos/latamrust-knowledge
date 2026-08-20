# Sesion 2026-08-04: Launcher CobbleVerse v4.1 completo - Google Drive, skins, fix bugs

RESUMEN SESION 2026-08-04: Launcher CobbleVerse v4.1 completado. 

ARCHIVOS EN SHARE (//PC2-NEXUS/share/):
- CobbleVerse_Launcher_v4.exe (24MB) - launcher final funcional
- cobbleverse-pack-v4.0.1.zip (1787MB) - juego completo Modrinth profile
- launcher-v2/ - codigo fuente Python
- helios-launcher/ - fork Helios (pendiente)

FUNCIONAMIENTO DEL LAUNCHER v4.1:
1. Descarga modpack desde Google Drive via gdown (File ID: 1h0ohkqZrSO2XX-ZIXYx7Ru0lAKqj9--n) ~65MB/s
2. Extrae a %APPDATA%/LatamRust
3. Descarga Easy NPC skins desde GitHub (release skins-v1, 325 skins, 29 Pokemon)
4. Sincroniza skins a config/easy_npc/skin/
5. Boton JUGAR lanza via portablemc

BUGS CORREGIDOS:
- gdown quiet=False causaba NoneType write error en PyInstaller -> fix: quiet=True
- urllib.request.Session no existe -> fix: usar gdown con id= parameter
- installed() requeria directorio versions/ que no esta en profile Modrinth -> fix: verificar mods + config
- curl throttling en GitHub -> fix: migrar a Google Drive

GITHUB REPOS:
- cjtemer-kaos/cobbleverse-pack: releases v4.0.1 (modpack ZIP) + skins-v1 (325 skins)
- cjtemer-kaos/cobbleverse-launcher-v2: fuente del launcher

EASY NPC SKINS:
- Script generate_skins.py: genera 271 skins para 38 tipos de NPC
- Script generate_pokemon_skins.py: genera 29 skins Pokemon tematicas
- Script sync_skins.py: sincroniza skins del server a GitHub release
- Total: 325 skins en release skins-v1

PENDIENTE:
- Firma digital del exe (Smart App Control bloquea exe sin firmar)
- Helios launcher (Electron) como alternativa
- Mas skins descargadas de The Skincraft/Planet Minecraft
