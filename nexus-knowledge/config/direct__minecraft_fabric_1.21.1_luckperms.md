# Direct: minecraft/fabric/1.21.1/luckperms

Category: Config
Tags: cobblemon, fabric, 1.21.1, luckperms, permisos, server
Created: 2026-08-20T13:35:48.060175

---

LuckPerms (mod Fabric 1.21.1) config real: a diferencia de la version plugin, el jar se instala en /mods (no /plugins) y genera su config en config/luckperms.conf (fuente: repo oficial LuckPerms/LuckPerms fabric/src/main/resources/luckperms.conf). Claves principales: server = "global" (nombre del servidor; "global" lo ignora y se usa para permisos por servidor); storage-method = "h2" por defecto (local). Para BD remota se configura la seccion data { address="host:port" database username password } con MySQL/Postgres/Mongo (puertos por defecto 3306/5432/27017). messaging-service = "auto" para sync en red multi-servidor; seccion split-storage { enabled=false } para separar user/group/uuid/log en distintas BD. Las fuentes de config se resuelven por orden: system properties > env vars (ej. LUCKPERMS_SERVER, LUCKPERMS_STORAGE_METHOD) > luckperms.conf > defaults.
