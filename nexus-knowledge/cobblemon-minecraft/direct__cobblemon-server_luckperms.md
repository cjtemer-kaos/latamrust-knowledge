# Direct: cobblemon-server/luckperms

Category: Cobblemon-minecraft
Tags: luckperms, permisos, fabric, 1.21.1, config.yml, grupos, herencia
Created: 2026-08-20T13:42:51.813541

---

LuckPerms para Fabric 1.21.1 (jar LuckPerms-Fabric-5.x.jar, instalar en mods/, SOLO server, clientes no lo necesitan). Config generada en config/LuckPerms/config.yml (en Fabric va a config/ y NO a plugins/; ojo: por bug/convencion la base H2 luckperms-h2-v2.mv.db, libs/ y contexts.json se generan en mods/luckperms). Al primer arranque crea grupo 'default' y el grupo es opcional cambiar con default-group. Storage: storage-method (h2 por defecto; sqlite/yaml/json/mysql). En redes multi-server poner mysql y rellenar la seccion data: (address, database, username, password). Comandos: /lp editor, /lp group <g> permission set <nodo>, /lp group <g> parent add <padre> para herencia, /lp user <u> parent add <g>. CRITICO en Fabric: Fabric NO aplica checks de permisos a los comandos vanilla, asi que LuckPerms por si solo NO controla /gamemode o /tp; solo los mods que implementen Fabric Permissions API (fabric-permissions-api) respetan los nodos. Fuentes: https://luckperms.net/wiki/Installation, https://luckperms.net/wiki/Configuration, GitHub issue #3760 (config path en fabric).
