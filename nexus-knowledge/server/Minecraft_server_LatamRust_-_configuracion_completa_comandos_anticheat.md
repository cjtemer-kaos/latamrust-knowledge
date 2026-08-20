# Minecraft server LatamRust - configuracion completa, comandos, anticheat

MINECRAFT SERVER LATAMRUST - Configuracion completa

PC2 (192.168.1.16):
- MCSS: Puerto 8080 (web interface)
- MC Server: Puerto 55555 (online-mode=false)
- RCON: Puerto 25575, pw: cobbleverse2026
- Backend LatamRust: Puerto 9001
- SuperNEXUS: Puerto 9000

MODPACK:
- CobbleVerse Pokemon Adventure v4.0.1
- Fabric 1.21.1 + 186 mods + 6 datapacks
- Server: D:\SERVIDOR\servers\LATAMRUST COBBLEMON\
- Game dir: %APPDATA%\LatamRust\

ANTICHEAT:
- Config: D:\SERVIDOR\servers\LATAMRUST COBBLEMON\config\latamrust-core.config
- allowed_mods: 483 mods (leer de .config, NO .json)
- exempt_groups: player,admin,staff+,staff,builder
- Importante: el mod lee de .config, no de .json

EASY NPC SKINS:
- Server: D:\SERVIDOR\servers\LATAMRUST COBBLEMON\config\easy_npc\skin\
- Client: %APPDATA%\LatamRust\config\easy_npc\skin\
- GitHub: release skins-v1 (325 skins)

COMANDOS UTILES:
- RCON: mcrcon -H 127.0.0.1 -P 25575 -p cobbleverse2026 "comando"
- List: mcrcon ... "list"
- Stop: mcrcon ... "stop"
- Gamerule: mcrcon ... "gamerule sendCommandFeedback false"
