# Direct: minecraft-server-1.21.1-region-files-anvil

Category: Minecraft
Tags: minecraft, 1.21.1, region, mca, anvil, chunk
Created: 2026-08-20T13:40:09.299920

---

Region files .mca (formato Anvil) en 1.21.1: cada archivo r.<x>.<z>.mca almacena 1024 chunks (cuadricula 32x32). Estructura binaria: cabecera de 8KB = tabla de ubicaciones (4096 bytes: 1024 entradas de 4 bytes, 3 bytes = offset en sectores de 4KB, 1 byte = numero de sectores usados) + tabla de timestamps (4096 bytes, 1024 entradas de 4 bytes). Luego los datos: por chunk, 4 bytes de longitud big-endian + 1 byte de tipo de compresion (1=Gzip, 2=Zlib, 3=none, 4=LZ4) + NBT. Si el chunk excede ~1MB se guarda externo como .mcc y el .mca referencia offset externo. Cada dimension tiene su propia carpeta region/. Fuente: minecraft.wiki/w/Region_file_format + Anvil_file_format + mcworldlib (verificado).
