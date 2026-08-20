# Direct: Sleep 50% jugadores LATAMRUST

Category: Server
Tags: sleep, gamerule, playersSleepingPercentage, server-sleep, 50porciento
Created: 2026-08-19T16:45:47.903150

---

SLEEP 50% LATAMRUST (2026-08-19): para que el 50% de los jugadores durmiendo pase la noche se instalo el mod/datapack 'Server Sleep' (Modrinth serversleep, MIT, server_side). Para 1.21.1 viene como DATAPACK (serversleep-datapack2.jar en world/datapacks/). El datapack solo hace 'gamerule playersSleepingPercentage 50'. NOTA: al agregarlo en caliente dio 'non-pack entry ignoring' (datapacks cargados al arranque), por lo que se aplico la gamerule DIRECTAMENTE con mcss_console: 'gamerule playersSleepingPercentage 50' -> VERIFICADO en log set to 50. Vanilla Minecraft tambien soporta esto via server.properties playersSleepingPercentage=50 (o datapack en arranque). Quedo activo sin reiniciar el server.
