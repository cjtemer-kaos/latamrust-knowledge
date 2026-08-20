# Resumen completo trabajo LatamRust 2026-08-09: chat, tablist, LP, auth, YAWP

RESUMEN COMPLETO DE TRABAJO - 2026-08-09

## CHAT (RESUELTO)
- Problema: Paradigm sobreescribe Styled Chat con enableCustomChatFormat=true
- Fix: Cambiar enableCustomChatFormat=false en D:/SERVIDOR/servers/LATAMRUST COBBLEMON/config/paradigm/chat.json
- Reload: `paradigm reload chat` por RCON (NO 'paradigm reload' ni dashboard reload)
- Resultado: Admin=rojo+arcoíris (Styled Chat), Trainer=cian (Styled Chat)
- PARADIGM REESCRIBE EL JSON AL RELOAD - solo el dashboard web persiste cambios directos

## TABLIST (RESUELTO)
- Problema: Doble rango en tab (%player:displayname% muestra prefix de LP + display name)
- Fix: Cambiar %player:displayname% a %player:name% en config/styledplayerlist/config.json
- Admin=rojo, Trainer=aqua

## LUCKPERMS (RESUELTO)
- Backup importado desde luckperms-2026-08-09-10-45.json.gz
- OPs normalizados: todos iguales a KAOS__MCS (grupo admin + 8 nodos)
- Trainer tiene essential_commands.home.max.4
- Trainer tiene minecraft.command.trigger

## AUTH MOD (PENDIENTE HABILITAR)
- auth-dp.zip creado en world/datapacks/
- Necesita /datapack enable desde el juego
- mr_auth es datapack puro, tag minecraft:tick estaba vacío

## YAWP - PROTECCION DE ZONAS (RESUELTO)
- Problema: trainers podían romper bloques en spawn (989, 72, 1071) a pesar de flags Denied
- Investigación: wiki oficial + código fuente de YAWP en GitHub
- Causa raíz: op_bypass_flags=true en yawp-common.toml
- Fix: op_bypass_flags=false + admins como owners de spawn (kaos__mcs, robben_, leftor_)
- Flags en spawn: break-blocks, place-blocks, explosions-blocks, explosions-entities, fire-tick, invincible, item-pickup, melee-animals - todos Denied
- Spawn cubre: X:181-1508, Y:-64-320, Z:435-1653
- Grupo YAWP: 'jhonsai', 'aryys', 'jonymcs' no encontrados como jugadores - pendiente agregar como owners cuando entren

## COMANDOS CLAVE
- paradigm reload chat (RCON) - recarga SOLO chat
- /yawp flag local <dim> <region> <flag> state Denied|Allowed|Disabled
- /yawp local <dim> <region> add player owners <player>
- /yawp local <dim> <region> list flag

## LECCIONES
- Paradigm es quien controla chat/tablist, dashboard web es fuente de verdad
- YAWP: internet PRIMERO antes de probar comandos al azar
- Si usuario corrige sintaxis, USAR SU sintaxis exacta
- No reiniciar server MC sin permiso explícito
