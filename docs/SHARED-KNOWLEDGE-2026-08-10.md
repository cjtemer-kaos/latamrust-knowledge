# Conocimiento Compartido — LatamRust CobbleVerse (2026-08-10/11)
# Este archivo es leído por ambos sistemas: SuperNEXUS (PC1) y LatamRust Nexus (PC2)

## Server Config
- RCON: 25575, pass cobbleverse2026
- MC: 55555, Paradigm: 8765, BlueMap: 8101
- RAM: Xms8G -Xmx20G (start.bat corregido)
- Mods: 175 server
- view-distance: 8, simulation-distance: 8

## Chat/Tablist
- Paradigm controla chat: enableCustomChatFormat=false
- Reload: `paradigm reload chat` por RCON (NO paradigm reload)
- Tablist: %player:name% (evita doble rango)
- Admin: rojo+arcoíris, Trainer: cian
- Dashboard web: http://100.83.148.88:8765

## YAWP Protección
- op_bypass_flags=false en yawp-common.toml
- Grupos: members/owners (PLURAL, NO son LP)
- Comandos: /yawp local <dim> <region> add player owners <player>
- Flags: break-blocks, place-blocks Denied en spawn
- Spawn: X:181-1508, Y:-64-320, Z:435-1653

## Kits VIP/VIPX
- VIP: 8 homes, TP 5s, kits.claim.vip
- VIPX: 10 homes, TP instant, kits.claim.vipx
- Crear con: /kit add vip 30d (cooldown 30 días)
- Admin debe tener items en inventario para crear

## Anticheat
- latamrust-core timeout 300s (parcheado de 120s)
- exempt_groups=admin,staff+,staff,builder
- Backup: latamrust-core-1.0.0.jar.bak

## TMCRAFT Lag
- 590 recetas rotas parcheadas
- Archivo: tmcraft-1.4.18+1.7.3.jar.new (pendiente instalación)
- Requiere reinicio del server

## EasyAuth
- 17 cuentas OK, BCrypt hashes
- Restos de mr_auth en scoreboard.dat (pendiente limpieza)

## Comunicación Agentes
- Redis: nexus:msg:chat (PC1:192.168.1.4:6379, PC2:192.168.1.16:6379)
- Worker: redis_agent_worker.py con Ollama local (deepseek-v4-flash)
- Monitor: discord_agent_monitor.py → Discord automáticamente
- Bot Discord: asistente ia#2568, server KAOS Mcs
- Canal Discord: chat_id 1535036003654439104
- Coordinación demostrada: PC1+PC2 dividieron 6 items + INFORME-FINAL conjunto
- Cursor numérico para evitar bugs de comparación string

## Hardware
- PC1: 192.168.1.4 (mejor hardware, NO mantiene server MC)
- PC2: 192.168.1.16 (server MC + Redis Docker)
- Redis: nexus-redis Docker en PC1 (0.0.0.0:6379)

## Lecciones
- Paradigm reescribe JSON al reload - SIEMPRE usar dashboard o comandos
- YAWP: docs del desarrollador ANTES de probar comandos
- redis-py necesario en ambas máquinas
- hermes -z lento para tareas → usar Ollama directo
- Cursor numérico para evitar bugs de comparación string
- Ambos agentes deben funcionar independientemente cuando uno está apagado
