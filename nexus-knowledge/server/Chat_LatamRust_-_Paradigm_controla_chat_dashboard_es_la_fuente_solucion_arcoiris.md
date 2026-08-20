# Chat LatamRust - Paradigm controla chat, dashboard es la fuente, solucion arcoiris

LECCION CHAT LATAMRUST RESUELTO (2026-08-09):

PROBLEMA: Chat se veía sin colores/rango. Robben_ y KAOS__MCS se veían distinto al escribir.

DIAGNOSTICO FINAL:
1. PARADIGM es el mod que CONTROLA el chat (no Styled Chat). Su customChatFormat gana.
2. Paradigm guarda config en SQLite (config/paradigm/data/paradigm.db) + memoria + espejo JSON. Editar el JSON directo NO sirve - Paradigm lo sobreescribe al recargar. HAY QUE EDITAR POR EL DASHBOARD WEB (http://100.83.148.88:8765 con token) - es la unica fuente que respeta.
3. ROBBEN_ tambien estaba editando el dashboard en paralelo y CANCELABA mis cambios (por eso el archivo 'volvia' a aqua+blanco). Coordinar quien edita.
4. Styled Chat perdía contra Paradigm.

SOLUCION APLICADA:
- Formato chat en Paradigm (dashboard CHAT editor): {prefix}<rainbow>{player_name}</rainbow> <color:dark_gray>»</color> <color:white>{message}</color>
- = prefix rojo de LP + nombre arcoíris + mensaje blanco
- LuckPerms restaurado al backup 10:45 del mismo dia
- Prefix grupo admin limpiado: &c[ADMIN]&r (rojo)
- Todos los OP en grupo admin con 8 nodos: ftbchunks.max_claimed, luckperms.group.*, luckperms.*, essentialcommands.command.rules, essentialcommands.command.spawn, gamemode.creative, minecraft.command.gamemode
- Eliminado test.perm y prefixes duplicados.

BACKUPS: config/paradigm/chat.json.bak-20260809 y .bak2-20260809. LP backups en mods/luckperms/*.json.gz (ultimo bueno: luckperms-2026-08-09-10-45.json.gz).

IMPORTANTE: Para cambiar chat en este server SIEMPRE usar dashboard Paradigm, nunca editar JSON directo.
