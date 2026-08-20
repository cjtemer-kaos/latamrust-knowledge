# Direct: minecraft-nbt/named-binary-tag

Category: Minecraft
Tags: minecraft, nbt, format, gzip, lz4, zlib, serialization
Created: 2026-08-20T13:35:20.221226

---

LOGICA INTERNA Minecraft - Formato NBT (Named Binary Tag): serializacion usada por level.dat, chunks, playerdata, estructuras (.nbt) y entidades. Tags: 1 Byte, 2 Short, 3 Int, 4 Long, 5 Float, 6 Double, 7 ByteArray, 8 String, 9 List, 10 Compound, 11 IntArray, 12 LongArray, 0 TAG_End. Estructura: un byte de tipo + nombre tagged (unsigned short length + UTF-8) + payload; los compounds se anidan hasta cerrar con TAG_End. Compresion por archivo: level.dat = gzip; chunks .mca usan el compression type de su header (1=GZip, 2=Zlib/deflate, 3=sin uso, 4=LZ4 desde 24w04a/1.20.5, activable via lz4-compression en server.properties). Herramientas: NBTExplorer (level.dat), Amulet (region .mca), mca-json/fidian (convierte .mca y .dat a JSON, soporta 1.21.4+ y data versions 3955/4189/4671). NBT no es editable con editor de texto plano; es el formato guardado universal del juego.
