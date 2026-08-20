# LatamRust server - referencia completa de comandos RCON

LATAMRUST SERVER - Referencia de comandos RCON

BASICOS:
- list: ver jugadores online
- stop: apagar server
- say <msg>: enviar mensaje a todos
- tell <player> <msg>: enviar mensaje privado

ADMIN:
- gamemode <survival|creative|adventure|spectator> <player>
- tp <player> <target>
- give <player> <item> [amount]
- effect <player> <effect> [duration] [level]
- clear <player>
- kick <player> [reason]
- ban <player> [reason]
- pardon <player>

MUNDO:
- time <set|add> <value>
- weather <clear|rain|thunder>
- gamerule <rule> <value>
- difficulty <peaceful|easy|normal|hard>
- save-all
- save-off / save-on

INFORMACION:
- seed: ver semilla del mundo
- whitelist list: ver whitelist
- op list: ver jugadores OP
- debug: informacion de debug

GAMERULES UTILES:
- sendCommandFeedback false: ocultar respuestas de comandos
- doDaylightCycle false: congelar tiempo
- doMobSpawning false: deshabilitar spawns
- keepInventory true: conservar items al morir
- doFireTick false: deshabilitar propagacion de fuego
