# Conocimiento PC2 GitHub: ClaimBlocks, staff panel, LuckPerms, RCON, Tailscale, server config

CONOCIMIENTO PC2 (GitHub latamrust-knowledge) - Parte 2: CLAIMBLOCKS, STAFF PANEL, LUCKPERMS, RCON, TAILSCALE

CLAIMBLOCKS vs FTB: Decisión pendiente. FTB Chunks (activo) para protección de chunks, FTB Teams (activo) para equipos. ClaimBlocks prototipo listo (ClaimBlocks-1.0.jar). Stone templates: small 10x10, medium 30x30, large 50x50, XL 100x100, XXL 150x150. Flags: block_break, block_place, explosions, fire, mob_spawning, pvp, item_pickup, redstone, hopper, fluid_flow, mob_griefing. Comandos: /cb menu, /cb claim, /cb unclaim, /cb add <player>, /cb remove, /cb info, /cb list. Config: config/ClaimBlocks/claims.json. RECOMENDACION: mantener ambos por ahora.

STAFF PANEL: mod Fabric propio (staff-panel-src/). Comandos: /staff (panel GUI), /jail jail1 <player> [time], /jail unjail1 <player>, /ban, /unban, /mute, /kick, /tp, /gm <player> <mode>, /invsee. Requiere Fabric Loader >=0.19.3. Gradle: build.gradle en staff-panel-src/.

LUCKPERMS: grupos player (default), admin, staff+, staff, builder. Editar con web editor (localhost:8080) NO por RCON. Commands: /lp editor, /lp group <g> parent, /lp user <u> group.

RCON: puerto 25575, mcrcon.exe en D:/SERVIDOR/mcrcon/. Conectar local: mcrcon -H 127.0.0.1 -P 25575 -p <pw> "list". Via Tailscale: -H 100.83.148.88.

TAILSCALE: PC2 (NEXUS) IP Tailscale 100.83.148.88, LAN 192.168.1.16, rol server. PC1 IP Tailscale 100.94.236.93, rol cliente/agente.

STAFF PANEL src: main mod entry StaffPanelMod.java, commands/StaffCommands.java, menu/JailSystem.java (jail con tiempo + persistencia), menu/StaffActions.java.

SERVER-CONFIG: server.properties - server-port=55555, max-players=30, view-distance=12, simulation-distance=12, enable-rcon=true, rcon.port=25575, online-mode=false, enable-command-block=true, spawn-protection=0, gamemode=survival, difficulty=normal, pvp=true.
