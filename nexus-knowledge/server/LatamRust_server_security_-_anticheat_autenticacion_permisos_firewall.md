# LatamRust server security - anticheat, autenticacion, permisos, firewall

LATAMRUST SERVER SECURITY - Configuracion de seguridad

ANTICHEAT:
- latamrust-core: verifica mods de clientes
- allowed_mods: 483 mods en whitelist
- exempt_groups: player, admin, staff+, staff, builder
- Kickea jugadores con mods no autorizados

AUTENTICACION:
- online-mode=false: acepta jugadores sin cuenta Microsoft
- auth-v1.5.1: sistema de autenticacion custom
- Players must have matching username

PERMISOS:
- LuckPerms: gestion de permisos y rangos
- OP nivel 4: permisos completos
- Rangos: player, admin, staff+, staff, builder

FIREWALL:
- Puerto 55555: MC Server (abierto)
- Puerto 25575: RCON (solo local)
- Puerto 8080: MCSS web (solo local)
- Puerto 9001: Backend (solo local)
- Puerto 9000: SuperNEXUS (solo local)

IMPORTANTE:
- RCON password: cobbleverse2026 (NO compartir)
- Nunca exponer RCON al internet
- Usar playit.gg para conexion externa segura
- Verificar logs regularmente por intentos de acceso no autorizados
