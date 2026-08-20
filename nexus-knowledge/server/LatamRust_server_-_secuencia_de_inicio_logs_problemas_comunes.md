# LatamRust server - secuencia de inicio, logs, problemas comunes

LATAMRUST SERVER - Secuencia de inicio

PASOS AL INICIAR:
1. MCSS detecta que el server debe correr
2. MCSS ejecuta java -Xms4G -Xmx8G -jar fabric-server.jar nogui
3. Fabric Loader carga (0.18.4)
4. Se cargan 186 mods + 6 datapacks
5. LuckPerms se conecta (puerto 8080)
6. LatamRust Core (anticheat) se inicializa
7. Easy NPC se carga
8. SuperNEXUS backend se conecta (puerto 9001)
9. Server listo para jugadores

LOGS:
- D:\SERVIDOR\servers\LATAMRUST COBBLEMON\logs\latest.log
- Errores:[block.10604] son normales (no afectan)
- Missing sounds: son opcionales (no afectan)
- Easy NPC warnings: son normales

TIEMPO DE INICIO:
- ~30-60 segundos desde que MCSS inicia java
- Puede tardar mas si hay muchos mods nuevos

PROBLEMAS COMUNES AL INICIAR:
- 'Could not apply patch' -> error de mixin, no afecta
- 'Registry was empty' -> normal en primer inicio
- 'Online mod data expired' -> normal, se actualiza solo
- 'Fabric is preparing JARs' -> normal en primer inicio
