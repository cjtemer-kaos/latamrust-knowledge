# Direct: PLAN mini-mod FTB teams nametag

Category: Integracion
Tags: ftb-teams, scoreboard, nametag, mini-mod, conflictos
Created: 2026-08-19T19:43:58.295235

---

PLAN mini-mod 'FTB Teams -> Scoreboard vanilla' (2026-08-19). OBJETIVO: mostrar el equipo FTB en el nametag del jugador (nombree+color) 100% server-side. INVESTIGACION CONFLICTOS COMPLETADA: NINGUNO de los 176 mods del server crea Scoreboard Teams vanilla. Verificado: styledplayerlist solo hace sendScoreboard (no crea teams), styled-chat 0 refs, Paradigm 0 refs, ftb-teams 0 refs (confirma que FTB Teams no toca el vanilla). Por eso el mini-mod puede escribir teams vanilla sin colisionar (seria el unico). API FTB: FTBTeamsAPI.api().getManager()().getPlayerTeamForPlayerID(uuid)->Optional<Team> con getColoredName()/getName()/getTeamId(); eventos FTBTeamsEvents (fabric): PLAYER_JOINED_PARTY_TEAM, TEAM_PLAYER_LOGGED_IN, TEAM_PROPERTIES_CHANGED, TEAM_DELETED, TEAM_CREATED. Mecanica: en cadoevento usar server.getScoreboard().addPlayerTeam(nombre) o getPlayerTeam, setDisplayName/getColoredName, setColor, addPlayer(uuid). Beneficio extra: activaria el team tambien en styledplayerlist/vanillaDisplayName. Mod propio de la fusión latamrust (cuidar no romper server estable).
