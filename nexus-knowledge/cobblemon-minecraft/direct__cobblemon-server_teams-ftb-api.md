# Direct: cobblemon-server/teams-ftb-api

Category: Cobblemon-minecraft
Tags: ftb-teams, teams-api, fabric, 1.21.1, config-snbt, permisos
Created: 2026-08-20T13:41:54.318834

---

FTB Teams API (mod ftb-teams-fabric, version 2101.1.10 para MC 1.21.1): libreria de teams/equipos usada por mods FTB (FTB Chunks, FTB Quests) y util en servers Cobblemon para gestion de equipos. Requiere Fabric API + Architectury API + FTB Library (que usa el sistema de config SNBT). Config via SNBT de FTB Library: comun en config/ftb-teams-common.snbt y por-server en world/serverconfig/ftb-teams-server.snbt. Comandos sin OP: /ftbteams list [team-type], /ftbteams party <opciones>, /ftbteams msg <msg>, /ftbteams info [team]. Requieren OP: /ftbteams server <create|delete|settings> (gestiona equipo del servidor, no se puede unir/salir de el: para proteger chunks a nivel servidor) y /ftbteams force-disband <team>. Para RESTRINGIR creacion de teams por jugadores, denegar los nodos de permiso command.ftbteams.party.create / .join / .invite / .leave con un mod de permisos (FTB Ranks o LuckPerms). Fuente: https://docs.feed-the-beast.com/mod-docs/mods/suite/Teams y CurseForge.
