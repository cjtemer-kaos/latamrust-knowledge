# LatamRust server - guia de troubleshooting completa

LATAMRUST SERVER - Guia de troubleshooting

PROBLEMA: Server no arranca
1. Verificar que MCSS este corriendo: tasklist | findstr mcss
2. Verificar puertos: netstat -ano | findstr 55555
3. Revisar logs: Get-Content logs/latest.log | Select-Object -Last 20
4. Reiniciar desde MCSS web interface (localhost:8080)
5. Si nada funciona: reiniciar PC2

PROBLEMA: Jugadores no pueden conectar
1. Verificar server online: mcrcon ... "list"
2. Verificar firewall: puertos 55555 y 25575 abiertos
3. Verificar playit.gg: california-street.gl.joinmc.link activo
4. Verificar anticheat: revisar latamrust-core.config
5. Verificar online-mode=false en server.properties

PROBLEMA: Anticheat kickea jugadores
1. Obtener mods del cliente: Get-Content logs/latest.log | Select-String 'UNAUTHORIZED'
2. Comparar con allowed_mods en latamrust-core.config
3. Agregar mods faltantes
4. Reiniciar server

PROBLEMA: Skins de NPCs no aparecen
1. Verificar que easy_npc este instalado
2. Verificar config/easy_npc/skin/ en cliente
3. Ejecutar sync_skins.py o actualizar via launcher
4. Reiniciar juego del jugador

PROBLEMA: Juego crash al entrar
1. Verificar que el jugador tenga todos los mods
2. Verificar version de Fabric (0.18.4)
3. Verificar Java 21 instalado
4. Revisar logs del cliente: %APPDATA%\LatamRust\logs\
