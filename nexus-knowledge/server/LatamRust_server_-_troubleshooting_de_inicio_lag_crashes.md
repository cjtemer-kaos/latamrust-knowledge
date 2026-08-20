# LatamRust server - troubleshooting de inicio, lag, crashes

LATAMRUST SERVER - Troubleshooting de inicio

PROBLEMA: Server no arranca despues de restart
1. Verificar MCSS: tasklist | findstr mcss
2. Verificar Java: tasklist | findstr java
3. Verificar puertos: netstat -ano | findstr 55555
4. Revisar logs: Get-Content logs/latest.log | Select-Object -Last 20
5. Si MCSS no restarta: reiniciar MCSS manualmente
6. Si nada funciona: reiniciar PC2

PROBLEMA: Server arranca pero cierra inmediatamente
1. Verificar logs: buscar 'ERROR' o 'Exception'
2. Verificar espacio en disco: dir D:\SERVIDOR\
3. Verificar memoria: tasklist | findstr java (RAM usage)
4. Verificar que no haya otro proceso en puerto 55555

PROBLEMA: Server arranca pero no acepta conexiones
1. Verificar online-mode=false en server.properties
2. Verificar firewall: puertos 55555 y 25575 abiertos
3. Verificar que los jugadores tengan la version correcta
4. Verificar anticheat: latamrust-core.config

PROBLEMA: Server lento (lag)
1. Verificar RAM: tasklist | findstr java
2. Verificar CPU: tasklist /V | findstr java
3. Reducir view-distance en server.properties
4. Verificar mods con spark: /spark profiler
5. Verificar red: ping 192.168.1.16

PROBLEMA: Server crashea frecuentemente
1. Revisar crash-reports/ en el directorio del server
2. Verificar logs antes del crash
3. Verificar memoria: aumentar Xmx si es necesario
4. Verificar mods problemáticos
