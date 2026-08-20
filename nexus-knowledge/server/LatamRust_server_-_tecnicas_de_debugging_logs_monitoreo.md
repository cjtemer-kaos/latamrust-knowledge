# LatamRust server - tecnicas de debugging, logs, monitoreo

LATAMRUST SERVER - Tecnicas de debugging

VER LOGS EN TIEMPO REAL:
- SSH: ssh cjtr@192.168.1.16
- PowerShell: Get-Content D:\SERVIDOR\servers\LATAMRUST COBBLEMON\logs\latest.log -Wait
- Filtro: Get-Content logs/latest.log | Select-String 'ERROR|WARN'

VER CONEXIONES ACTIVAS:
- netstat -ano | findstr 55555 (MC server)
- netstat -ano | findstr 25575 (RCON)
- netstat -ano | findstr ESTABLISHED (conexiones activas)

VER PROCESOS:
- tasklist | findstr java (proceso MC)
- tasklist | findstr mcss (gestor de server)
- tasklist | findstr python (SuperNEXUS)

VER ERRORES RECIENTES:
- Get-Content logs/latest.log | Select-String 'ERROR' | Select-Object -Last 10
- Get-Content logs/latest.log | Select-String 'Exception' | Select-Object -Last 5

VER JUGADORES:
- mcrcon ... "list"
- Get-Content logs/latest.log | Select-String 'joined|left'

VER MODS CARGADOS:
- Get-Content logs/latest.log | Select-String 'Loading.*mods'
- El log muestra 'Loading N mods:' al inicio

VER ANTICHEAT:
- Get-Content logs/latest.log | Select-String 'UNAUTHORIZED'
- Muestra todos los mods no autorizados del ultimo jugador
