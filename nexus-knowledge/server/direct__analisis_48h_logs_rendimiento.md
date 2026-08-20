# Direct: Analisis 48h logs rendimiento

Category: Server
Tags: logs, rendimiento, lag, autosave, vuelo
Created: 2026-08-20T12:40:19.022780

---

ANALISIS 48h LOGS LATAMRUST (17-20 ago, datos reales): (1) 2070x 'moved too quickly' casi TODOS de jugadores montando pokemon voladores: Charizard(SrJenko 1400x), Kilowattrel(JhonSai 229x), Swellow(eilex 102x), Braviary(JONYmcs 84x), Kilowattrel(NaoriDZN_ 56x) -> I'm Fast (instalado) lo arregla. (2) 72x 'Can't keep up' de server lag de hasta 11154ms(223 ticks): concentrados de MADRUGADA/MANANA (00:17,04:01,06:42,09:21,09:30...) con pocos jugadores -> sospecha AUTOSAVE del mundo de 57GB (autosave=1800s) o picos CPU, NO jugadores. (3) ERROR recurrente: 'Failed to load function minecraft:tick' en cada reinicio, causado por 2 datapacks que sobrescriben minecraft:tick (giratina-respawn->cobbleverse:tick_giratina y legendarystructures->gamerules:tick); funciones existen, es quirk de multi-datapack, no crash. (4) Otros errores benignos (registries empty, jeed requiere JEI/REI/EMI, data fixers). OPTIMIZACION sugerida: ajustar autosave/guardados para reducir lag de madrugada, limpiar datapack tick conflictivo, I'm Fast ya resuelve el vuelo.
