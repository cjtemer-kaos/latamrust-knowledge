# Direct: minecraft/fabric/1.21.1/ftb-teams

Category: Config
Tags: cobblemon, fabric, 1.21.1, ftb-teams, server, equipos
Created: 2026-08-20T13:35:25.370156

---

FTB Teams (Fabric 1.21.1) config real para Cobblemon servers: build para MC 1.21.1 = 2101.1.x (verificado en GitHub FTBTeam/FTB-Teams releases). Uso basico: /ftbteams create Nombre, /ftbteams settings <key> <value> (tab para ciclar opciones), /ftbteams party para gestion de equipo, /ftbteams info, /ftbteams force-disband (requiere OP). Los datos de equipos NO estan en un config file universal: se guardan por mundo en world/data/ftbteams (players, teams y parties como datos del mundo). Para modpacks donde los jugadores no deben crear equipos, la API expone FTBTeamsAPI#setPartyCreationFromAPIOnly(true) (reemplaza a CustomPartyCreationHandler, deprecado). Es el bloque base de FTB Chunks y FTB Quests; requiere Fabric API.
