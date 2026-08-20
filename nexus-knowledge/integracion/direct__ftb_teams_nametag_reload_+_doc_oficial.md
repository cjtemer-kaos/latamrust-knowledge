# Direct: FTB Teams Nametag reload + doc oficial

Category: Integracion
Tags: ftb-teams, nametag, reload, jar, doc-oficial
Created: 2026-08-19T20:53:37.506473

---

FTB Teams Nametag — ESTADO y MEJORA de reload (2026-08-19 noche): El mod (D:/ias/proyectos/ftb-teams-nametag) muestra el FTB team en el nametag solo si es PARTY team (isPartyTeam(): el fix evita mostrar el PlayerTeam individual de solitarios). Server LATAMRUST tiene 3 grupos FTB: admin, JNK, chaskini (ver world/ftbteams/party/*.snbt: JNK owner SrJenko 31ec31ca color #59FFBE; admin owner KAOS__MCS 6721f528; chaskini owner Chasca 776609fc). Los jugadores SI estan en teams, el tag sigue solo nombre porque el server corria el jar VIEJO (sin el reload). MEJORA implementada y compilada (jar build/libs/ftb-teams-nametag-1.0.0.jar 2026-08-19 20:45): al hacer /reload (ServerLifecycleEvents.END_DATA_PACK_RELOAD) recarga config/ftbteams_nametag.json y re-aplica prefixes a los jugadores online, SIN cerrar el server. WEB OFICIAL DEV (github.com/FTBTeam/docs, version 1.21.1): FTB Teams NO tiene nametag propio; doc dice 'override behavior via API' => el enfoque del mod (API FTB -> Scoreboard vanilla) es la via oficial. PENDIENTE: usuario avisa cuando copiar el jar nuevo a mods/ y reiniciar el server (SOLO EL usuario inicia/para el server; nunca tocar sin permiso). Config editable: config/ftbteams_nametag.json (prefixColor gold, prefixFormat, useTeamColor, enabled nametag/tablist/chat).
