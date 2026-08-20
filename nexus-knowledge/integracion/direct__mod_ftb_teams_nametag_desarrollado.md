# Direct: MOD FTB Teams Nametag desarrollado

Category: Integracion
Tags: ftb-teams, nametag, scoreboard, fabric, mod
Created: 2026-08-19T20:23:44.680547

---

MOD 'FTB Teams Nametag' DESARROLLADO (2026-08-19): muestra el equipo FTB Teams en el nametag/jugador (tag '[Equipo] nombre' con color) 100% server-side. BASE: GitHub Mathew-1991/FTB-Teams-Tags-Addon (MIT, Forge 1.20.1) portado a Fabric 1.21.1. UBICACION proyecto: D:/ias/proyectos/ftb-teams-nametag; jar compilado: build/libs/ftb-teams-nametag-1.0.0.jar. API FTB: FTBTeamsAPI.api().getManager().getTeamForPlayerID(uuid) ->Optional<Team> con getName().getString() (tag) / getId(). Mecanica: por login/reload sincroniza cada FTB team a un Scoreboard Team vanilla (id 'ftb_'+short(nombre 10 hex)), le pone setPrefix(Text.literal('[Equipo] ')) con color, y addScoreHolderToTeam. NOMBRES YARN 1.21.1 build.3 VERIFICADOS contra mappings-base.tiny: Scoreboard getTeam/addTeam/addScoreHolderToTeam; Team setPrefix/setSuffix/setColor(Formatting); Text=net.minecraft.text.Text (NO component.Component que es data-component); Style=net.minecraft.text.Style; Formatting=net.minecraft.util.Formatting; ServerPlayerEntity; MinecraftServer.getPlayerManager().getPlayerList(); player.getNameForScoreboard(); Text.literal().setStyle(). CONFIG editable: config/ftbteams_nametag.json (prefixColor gold, prefixFormat, useTeamColor, bold/italic, enabled nametag/tablist/chat). CONFLICTOS: ninguno de los 176 mods crea Scoreboard Team vanilla (styledplayerlist solo sendScoreboard, styled-chat/Paradigm/ftb-teams 0 refs) => el mod es el unico que escribe => 0 conflicto.
