# LatamRust server - mantenimiento, backups, limpieza

LATAMRUST SERVER - Mantenimiento y backups

BACKUPS:
- MCSS crea backups automaticos en D:\SERVIDOR\backups\
- Backup manual: mcrcon ... "save-off" && copiar world/ && mcrcon ... "save-on"

ACTUALIZACIONES:
- Mods: copiar JARs a mods/, reiniciar server
- Datapacks: copiar ZIPs a datapacks/, reiniciar server
- Resource packs: copiar ZIPs a resourcepacks/, reiniciar server
- Config: editar archivos en config/, reiniciar server

MONITOREO:
- CPU/RAM: tasklist | findstr java
- Puertos: netstat -ano | findstr 55555
- Logs: Get-Content logs/latest.log | Select-String 'ERROR'
- Jugadores: mcrcon ... "list"

LIMPIEZA:
- Borrar logs viejos: del logs\*.log.gz
- Borrar backups viejos: del backups\*.zip (mantener ultimos 5)
- Borrar crash reports: del crash-reports\*.txt

IMPORTANTE:
- NUNCA reiniciar MC sin confirmar con usuario
- SIEMPRE guardar antes de restart (mcrcon ... "save-off")
- Verificar que MCSS este corriendo despues de restart
