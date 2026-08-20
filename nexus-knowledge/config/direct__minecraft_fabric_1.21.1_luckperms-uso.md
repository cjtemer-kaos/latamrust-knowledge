# Direct: minecraft/fabric/1.21.1/luckperms-uso

Category: Config
Tags: cobblemon, fabric, 1.21.1, luckperms, grupos, comandos
Created: 2026-08-20T13:35:50.734285

---

LuckPerms (mod Fabric 1.21.1) uso practico en servidores Cobblemon (verificado en wiki luckperms.net y guias reales de hosts). Comandos clave: /lp editor abre el editor web (sube/aplica cambios desde navegador); /lp group <grupo> parent set default; /lp user <jugador> group add <grupo> (el jugador debe haberse logeado al menos una vez). Para admin se usa wildcard * en un grupo admin (cubre todos los nodos, incluidos los de mods como Cobblemon). Sinergia comun en Cobblemon: rankear grupos con luckyperms y usar nodos de mods tipo cobblemon.command.givepokedex o los de FTB (command.ftbteams.*). Importante: como es un mod, los nodos de cualquier mod registrado funcionan igual que en Spigot; no hay config de perms en archivos, todo se gestiona por comandos/editor (persistencia en storage-method, por defecto h2 local).
