# LatamRust server - backup y restore, procedimientos

LATAMRUST SERVER - Procedimientos de backup y restore

BACKUP AUTOMATICO:
- MCSS crea backups en D:\SERVIDOR\backups\
- Frecuencia: configurable en MCSS
- Contenido: mundo, config, mods

BACKUP MANUAL:
1. mcrcon ... "save-off" (detener guardado)
2. Copiar D:\SERVIDOR\servers\LATAMRUST COBBLEMON\ a ubicacion segura
3. mcrcon ... "save-on" (reanudar guardado)

RESTORE:
1. Detener server: mcrcon ... "stop"
2. Copiar backup a D:\SERVIDOR\servers\LATAMRUST COBBLEMON\
3. Iniciar server desde MCSS

IMPORTANTE:
- SIEMPRE save-off antes de backup manual
- SIEMPRE save-on despues de backup
- No copiar mientras el server esta corriendo (puede corromperse)
- Mantener ultimos 5 backups, borrar los viejos

BACKUPS IMPORTANTES:
-/world/: datos del mundo (lo mas importante)
- /config/: configuraciones
- /mods/: mods instalados
- /logs/: historial de logs
