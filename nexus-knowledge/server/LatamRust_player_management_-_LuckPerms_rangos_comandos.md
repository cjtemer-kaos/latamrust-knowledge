# LatamRust player management - LuckPerms, rangos, comandos

LATAMRUST PLAYER MANAGEMENT - LuckPerms y rangos

JUGADORES OP (nivel 4):
- KAOS__MCS (2 UUIDs - PC1 y PC2)
- Robben_
- Leftor_
- JhonSai
- JONYmcs

GRUPOS LUCKPERMS:
- player (default) - todos los jugadores
- admin - administradores
- staff+ - staff superior
- staff - staff normal
- builder - constructores

COMANDOS LUCKPERMS:
- NO funcionan via RCON en Fabric (bug conocido)
- Fix: usar web-editor en localhost:8080
- O: ejecutar desde chat in-game como OP

COMANDOS DESDE CHAT (como OP):
/lp group admin create
/lp group admin meta set prefix "&c[ADMIN] " default
/lp group staff create
/lp group staff meta set prefix "&b[STAFF] " default
/lp group vip create
/lp group vip meta set prefix "&6[VIP] " default
/lp user KAOS__MCS parent set admin

EXEMPT GROUPS (anticheat):
- player, admin, staff+, staff, builder
- Estos grupos NO son verificados por el anticheat
