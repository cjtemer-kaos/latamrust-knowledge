# LatamRust server - startup, monitoreo, gamerule, troubleshooting

LATAMRUST SERVER - Startup y monitoreo

INICIO:
1. MCSS auto-starta el server al abrir MCSS
2. O manual: mcrcon ... "start" (si MCSS lo soporta)
3. O manual: java -Xms4G -Xmx8G -jar fabric-server.jar nogui

MONITOREO:
- RCON list: mcrcon -H 127.0.0.1 -P 25575 -p cobbleverse2026 "list"
- RCON logs: mcrcon ... "grep <pattern> logs/latest.log" (NO funciona en RCON)
- Server logs: D:\SERVIDOR\servers\LATAMRUST COBBLEMON\logs\latest.log
- SSH: ssh cjtr@192.168.1.16 "powershell -Command Get-Content logs/latest.log | Select-String 'pattern'"

PROBLEMA COMUN: Server no arranca despues de restart
- Causa: MCSS no auto-restarta siempre
- Fix: reiniciar manualmente desde MCSS web interface (localhost:8080)
- O: mcrcon ... "stop" y esperar 60s para que MCSS reinicie

GAMERULE sendCommandFeedback:
- Se resetea al restart del server
- Setear via RCON post-restart: mcrcon ... "gamerule sendCommandFeedback false"
- O agregar a server.properties (se resetea igual por MCSS)
