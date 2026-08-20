# LatamRust server management - MCSS, RCON, comandos, configuracion

LATAMRUST SERVER MANAGEMENT - MCSS, RCON, comandos

MCSS (MC Server Soft):
- Puerto web: 8080
- Admin: localhost:8080
- Auto-restart: configurado
- Servidores: LatamRust Cobblemon (55555), SuperNexus

RCON:
- Puerto: 25575
- Password: cobbleverse2026
- Herramienta: D:\SERVIDOR\mcrcon\mcrcon.exe
- Comando: mcrcon -H 127.0.0.1 -P 25575 -p cobbleverse2026 "comando"

COMANDOS UTILES:
- list: ver jugadores online
- stop: apagar server (MCSS auto-restarta)
- say <msg>: enviar mensaje a todos
- gamemode <mode> <player>: cambiar gamemode
- tp <player> <target>: teletransportar
- gamerule sendCommandFeedback false: ocultar respuestas de comandos

CONFIGURACION SERVER:
- online-mode=false: acepta jugadores sin cuenta Microsoft
- server-port=55555
- rcon.port=25575
- rcon.password=cobbleverse2026
- max-players=30
- view-distance=6
- simulation-distance=6

IMPORTANT: Gamerule sendCommandFeedback se resetea al restart
- Setear via RCON post-restart: mcrcon ... "gamerule sendCommandFeedback false"
- O agregar a server.properties (se resetea igual por MCSS)
