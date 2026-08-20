# Anticheat LatamRust - configuracion, solucion, comunicacion PC1-PC2

ANTICHEAT LATAMRUST CORE - Configuracion y solucion

PROBLEMA: Anticheat kickea jugadores por mods no autorizados
SOLUCION: Actualizar latamrust-core.config con TODOS los mods del cliente

ARCHIVOS IMPORTANTES:
- config/latamrust-core.config (NO el .json) - donde lee el mod
- config/latamrust-core.json (NO lo lee el mod, pero mantener actualizado)

COMO FUNCIONA:
1. Jugador entra al server
2. Server pide lista de mods al cliente
3. Anticheat compara contra allowed_mods en .config
4. Si hay mods NO en la whitelist -> kickea
5. exempt_groups=player,admin,staff+,staff,builder (estos no son kickeados)

SOLUCION: Obtener mods del cliente desde logs, agregar TODOS al .config
IMPORTANTE: El mod lee de .config, NO de .json (aunque ambos tengan los mismos mods)

COMUNICACION PC1 <-> PC2:
- Carpeta: \\PC2-NEXUS\share\mensajes
- Scripts: send.py, receive.py, watch.bat
- Uso: python send.py PC1 PC2 "mensaje"
