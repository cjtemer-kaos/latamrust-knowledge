# Direct: minecraft/fabric/1.21.1/ftb-teams-ranks-chunks

Category: Config
Tags: cobblemon, fabric, 1.21.1, ftb-teams, ftb-ranks, ftb-chunks, permisos
Created: 2026-08-20T13:35:44.051906

---

FTB Teams + FTB Ranks/FTB Chunks: control de equipos y claims en servidores Cobblemon Fabric 1.21.1 (verificado en FTBTeam issues #838 y #1425). FTB Ranks autogenera nodos de permiso command.ftbteams.* listados en /serverconfig/ftbranks/README.txt, configurados en el ranks.snbt del paquete (no tocar los archivos generados directamente). Ejemplos reales: command.ftbteams.party.create:false bloquea a jugadores crear equipos; command.ftbteams.party.invite:false y command.ftbteams.party.allies.add:false bloquean invitar/aliar. Un nodo false en un rango base con condition always_active debe overridearse con true en rangos superiores (VIP/Admin). Se aplican tambien a la GUI de partidos, no solo a comandos. Propiedades de claims de equipo (con FTB Chunks): /ftbteams server settings <team> ftbchunks:block_edit_mode public y ftbchunks:block_interact_mode public (Forge/NeoForge); en Fabric 1.20.1/1.21.x estan fusionadas en una sola: ftbchunks:block_edit_and_interact_mode public.
