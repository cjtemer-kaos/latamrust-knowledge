# LatamRust server - gestion del mundo, world edit, proteccion

LATAMRUST SERVER - Gestion del mundo

WORLD EDIT:
- WorldEdit instalado (worldedit-7.3.8-fabric-1.21.1.jar)
- Comandos: //set, //replace, //copy, //paste, //undo
- Permiso: worldedit.* para admins

WORLDBORDER:
- Sin worldborder configurado por defecto
- Para limitar: /worldborder set <size>

SEED:
- Sin seed especificada (aleatoria)
- Para ver: /seed
- Para cambiar: editar server.properties y regenerar mundo

BACKUPS DEL MUNDO:
- MCSS crea backups automaticos
- Directorio: D:\SERVIDOR\backups\
- Manual: mcrcon save-off && copiar world/ && mcrcon save-on

REGENERACION DE CHUNKS:
- /forceload add <x1> <z1> <x2> <z2>: forzar carga de chunks
- /forceload remove <x1> <z1> <x2> <z2>: liberar chunks
- WorldEdit: //chunk <radius>: cargar chunks cercanos

PROTECCION DEL MUNDO:
- FTB Chunks: proteccion de terreno por jugadores
- FTB Teams: equipos de jugadores
- WorldEdit: para builders autorizados
