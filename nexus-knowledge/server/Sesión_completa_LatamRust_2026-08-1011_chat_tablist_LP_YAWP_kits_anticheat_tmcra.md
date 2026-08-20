# Sesión completa LatamRust 2026-08-10/11: chat, tablist, LP, YAWP, kits, anticheat, tmcraft, comunicación agentes Redis+Discord

SESION COMPLETA 2026-08-10/11 - LatamRust CobbleVerse + Comunicación Agentes

RESUELTOS:
1. CHAT: Paradigm sobreescribe Styled Chat. Fix: enableCustomChatFormat=false + 'paradigm reload chat' por RCON. Admin=rojo+arcoíris, Trainer=cian.
2. TABLIST: Doble rango por %player:displayname%. Fix: cambiar a %player:name% en styledplayerlist/config.json.
3. LUCKPERMS: Backup importado, OPs normalizados (admin+8nodos), trainer tiene home.max.4 + trigger.
4. YAWP: trainers rompian bloques en spawn. Causa: op_bypass_flags=true en yawp-common.toml. Fix: op_bypass_flags=false + admins como owners de spawn. Grupos YAWP: members/owners (NO LuckPerms).
5. KITS VIP/VIPX: Permisos LP configurados (vip:8 homes+TP5s, vipx:10 homes+TP0s). Kits pendientes de crear con /kit add vip 30d.
6. AUTH: auth-dp.zip creado, pendiente /datapack enable.
7. ANTICHEAT: latamrust-core timeout cambiado a 300s.
8. TMCRAFT LAG: 590 recetas rotas parcheadas (jar .new listo, falta reinicio).
9. PARADIGM CHAT: enableCustomChatFormat=false persiste tras reloads.
10. EASYAUTH: 17 cuentas OK, restos de mr_auth en scoreboard.dat.

SISTEMA DE COMUNICACIÓN AGENTES:
- Redis PubSub en nexus:msg:chat (PC1:192.168.1.4:6379, PC2:192.168.1.16:6379)
- Worker redis_agent_worker.py con Ollama local (deepseek-v4-flash)
- Monitor discord_agent_monitor.py envía resultados a Discord automáticamente
- Bot Discord: asistente ia#2568, server KAOS Mcs
- Coordinación demostrada: PC1+PC2 dividieron 6 items del server y crearon INFORME-FINAL conjunto
- Cursor numérico para evitar bugs de comparación string

HARDWARE:
- PC1: 192.168.1.4 (Tailscale 100.94.236.93), mejor hardware
- PC2: 192.168.1.16 (Tailscale 100.83.148.88), server MC + Redis Docker
- Redis: nexus-redis Docker en PC1 (0.0.0.0:6379), Redis Docker en PC2

LECCIONES:
- Paradigm reescribe JSON al reload - SIEMPRE usar dashboard o comandos
- YAWP: buscar docs del desarrollador ANTES de probar comandos
- redis-py necesario en ambas máquinas para comunicación
- hermes -z es lento para tareas complejas - usar Ollama directo
- Cursor numérico necesario para evitar bugs de comparación string
- Ambos agentes deben poder funcionar independientemente cuando uno está apagado
