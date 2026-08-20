# LatamRust server - optimizacion de rendimiento, mods, configuracion

LATAMRUST SERVER - Optimizacion de rendimiento

JAVA OPTIONS:
- Xms4G: memoria minima (4GB)
- Xmx8G: memoria maxima (8GB)
- Ajustar segun RAM disponible en PC2 (32GB total)

MODS DE RENDIMIENTO:
- sodium-fabric: renderizado optimizado
- lithium: optimizaciones de servidor
- ferritecore: reduccion de memoria
- krypton: optimizacion de red
- modernfix: fixes de rendimiento
- entityculling: no renderizar entidades fuera de vista
- ImmediatelyFast: renderizado rapido
- BadOptimizations: optimizaciones variadas

CONFIGURACION SERVER:
- view-distance=6: reducir si hay lag
- simulation-distance=6: reducir si hay lag
- max-players=30: ajustar segun necesidad
- network-compression-threshold=256: optimizar red

MONITOREO:
- spark: mod de profiling (instalado)
- /spark profiler: ver uso de CPU/RAM
- /spark tps: ver TPS del server
- tasklist | findstr java: ver uso de RAM

PROBLEMAS COMUNES:
- Lag con muchos jugadores: reducir view-distance
- Crash por memoria: aumentar Xmx
- TPS bajo: verificar mods problemáticos con spark
