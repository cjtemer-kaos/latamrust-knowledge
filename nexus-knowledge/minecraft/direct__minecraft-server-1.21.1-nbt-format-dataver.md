# Direct: minecraft-server-1.21.1-nbt-format-dataversion

Category: Minecraft
Tags: minecraft, 1.21.1, nbt, snbt, dataversion, datafixerupper
Created: 2026-08-20T13:43:53.489925

---

Formato NBT (Named Binary Tag, spec de Notch) en 1.21.1: base de todo el guardado Java. Tipos: byte(b), short(s), int, long(l), float(f), double(d), byte[] ([B;]), int[] ([I;]), long[] ([L;]), string, list y compound (anidados). SNBT = representacion textual legible usada en comandos/data packs. Archivos tipicos: level.dat y playerdata/*.dat (gzip NBT), chunks dentro de .mca (gzip/zlib), scoreboard.dat, structures .nbt, hotbar.nbt (sin comprimir). DataVersion (1.21.1 = 4189) se guarda en level.dat y en cada chunk: al cargar un mundo con DataVersion menor, DataFixerUpper reescribe TODO el esquema (destructivo, one-way) para adaptarlo a la version nueva. Data generators de vanilla pueden convertir gzip NBT <-> SNBT. Fuente: minecraft.wiki/w/NBT_format + NeoForged NBT docs 1.21.1 (verificado).
