# LatamRust server config - archivos, configuraciones, LuckPerms

LATAMRUST SERVER CONFIG - Archivos de configuracion

server.properties:
- online-mode=false (acepta jugadores sin cuenta Microsoft)
- server-port=55555
- rcon.port=25575, rcon.password=cobbleverse2026
- max-players=30, view-distance=6, simulation-distance=6
- sendCommandFeedback=false (se resetea al restart)

latamrust-core.config:
- allowed_mods=mod1,mod2,... (483 mods actualmente)
- exempt_groups=player,admin,staff+,staff,builder
- LEER DE AQUI, no del .json

ops.json:
- Jugadores con nivel 4 (OP completo)
- KAOS__MCS, Robben_, Leftor_, JhonSai, JONYmcs

LuckPerms:
- Puerto web: 8080
- Storage: H2 (local)
- Comandos: NO funcionan via RCON en Fabric
- Fix: usar web-editor en localhost:8080 o comandos desde chat in-game

Easy NPC:
- Config: config/easy_npc/
- Skins: config/easy_npc/skin/ (38 tipos, 325 skins)
- El mod lee allowed_mods de latamrust-core.config
