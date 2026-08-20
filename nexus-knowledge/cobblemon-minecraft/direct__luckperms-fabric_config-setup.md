# Direct: luckperms-fabric/config-setup

Category: Cobblemon-minecraft
Tags: fabric, luckperms, permissions, config, cobblemon
Created: 2026-08-20T13:48:16.202552

---

LuckPerms como mod Fabric 1.21.1: config en config/luckperms/config.yml. Claves clave: storage-method (h2 por defecto; mysql/mariadb/postgresql para redes de servidores), sync-minutes (3 en red, -1 en standalone). Al instalarlo BLOQUEA todo por defecto (deny-by-default): hay que crear grupos y permisos o ningun comando funciona. Setup estandar: /lp creategroup donator; /lp group X parent add default; /lp group X weight set 1000 (prioridad de prefijo); /lp group default permission set <nodo> true. Edicion masiva: /lp editor (web editor), /lp export permissions.yml y /lp import permissions.yml. API bridge para mods: fabric-permissions-api (lucko) permite a mods como Cobblemon Economy / placeholders leer permisos. Fuentes: luckperms.net/wiki/Configuration, github.com/lucko/LuckPerms y lucko/fabric-permissions-api.
