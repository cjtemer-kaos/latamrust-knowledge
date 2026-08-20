# Anticheat LatamRust - detalles tecnicos, configuracion, troubleshooting

ANTICHEAT LATAMRUST - Detalles tecnicos

MOD: latamrust-core-1.0.0.jar (29KB)
UBICACION: D:\SERVIDOR\servers\LATAMRUST COBBLEMON\mods\

COMO FUNCIONA:
1. Jugador entra al server
2. Server pide lista de mods al cliente via canal de red
3. Cliente envia lista de mod IDs (sin sufijo -fabric)
4. Anticheat compara contra allowed_mods en config
5. Si hay mods NO en whitelist -> WARNING + KICK
6. Si jugador esta en exempt_group -> NO se verifica

ARCHIVO DE CONFIGURACION:
- D:\SERVIDOR\servers\LATAMRUST COBBLEMON\config\latamrust-core.config
- Formato: allowed_mods=mod1,mod2,mod3
- exempt_groups=player,admin,staff+,staff,builder
- IMPORTANTE: el mod lee .config, NO .json

COMO ACTUALIZAR:
1. Obtener lista de mods del cliente desde logs
2. Comparar con allowed_mods actual
3. Agregar mods faltantes al .config
4. Reiniciar server para que recargue

PROBLEMA COMUN:
- Cliente reporta 'accessories' pero whitelist tiene 'accessories-fabric'
- SOLUCION: usar IDs sin sufijo -fabric (como los reporta el cliente)

OBTENER MODS DEL CLIENTE:
- SSH: Get-Content logs/latest.log | Select-String 'UNAUTHORIZED'
- El log muestra todos los mods que NO estan en la whitelist
