# Direct: Aprendizaje mods nametag y plan v3

Category: Server
Tags: mod, nametag, ftb, aprendizaje, plan
Created: 2026-08-20T11:24:20.400408

---

APRENDIZAJE mods nametag/tags LATAMRUST (2026-08-20): analice 4 mods de Modrinth para portar su logica al mod del tag de equipos. (1) Player Nametags (server-side, Polymer VirtualEntity/ItemDisplayElement con setCustomName, escucha ticks getTicks()%updateRate==0, config /player-nametags reload): la tecnica que NUNCA falla por que no depende del sync del Scoreboard. (2) PrideTags (server-side SCOREBOARD: getOrCreateTeam, setColor(Optional<TeamColor>), setPlayerSuffix; confirma que el enfoque Scoreboard ES valido -> el 'aleatorio' de mi mod no es el enfoque sino el sync al cliente). (3) Simple Player Badges (server-side, chat, config JSON badgenames.json + /badges reload). (4) GradientNametags (client-side, NO usar por regla 100% server-side). INDICE: {equipo} = tag FTB. PLAN v3 MOD FTB TEAMS NAMETAG implementado y compilado: Capa1 Scoreboard+TeamS2CPacket fix sync (sin deps); Capa2 tick inteligente solo getTicks()%20 y solo si el equipo cambio (evita flicker); Capa3 config datapack/reload + prefixColor='team' usa el color REAL del FTB team mapeado a Formatting (founded en colorFromTeam con TextColor->Formatting por nombre o RGB cercano). Jar: ftb-teams-nametag-1.0.0.jar (10729B) compilado, NO instalado (pendiente permiso).
