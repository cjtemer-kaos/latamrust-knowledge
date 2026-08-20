# Bloqueos pendientes Latamrust Cobbleverse (backend PC2, launcher, LuckPerms, rate_limiters)

BLOQUEOS PENDIENTESsesion supernexus):

1. BACKEND LATAMRUST EN PC2: ModuleNotFoundError 'No module named src'. Fix: sys.path.insert(0, r'D:\ias\proyectos\latamrust-nexus') en start_server.py. Todos los __init__.py ya creados.

2. LAUNCHER LATAMRUST COBBLEVERSE: NO INICIADO. Requisitos: fork Helios Launcher (Zeventy v2.2.1), distribution.json con MC 1.21.1 jars + Fabric 0.18.4 Loader + Cobblemon 1.7.3 + 164 mods cliente. Target: PC2 (192.168.1.16:55555). Auto-update via GitHub Releases + electron-builder.

3. LUCKPERMS: Solo grupo default &a[JUGADOR]. KAOS__MCS es OP sin rango LP. Comandos /lp no funcionan por RCON. Fix: desde chat in-game como OP: /lp user KAOS__MCS permission set luckperms.* true, luego colorear grupos.

4. RATE_LIMITERS: rate_limiters.py en PC2 intenta importar RateLimiter de gemas_core pero no existe. Fix: agregar implementacion simple o reemplazar importacion.

NOTA: La sesion original (20260711_135528_51accb) tiene 877+ acciones documentadas en los compaction summaries. El contexto completo esta almacenado en la nota del brain 'Latamrust Cobbleverse - Contexto completo sesion supernexus'.
