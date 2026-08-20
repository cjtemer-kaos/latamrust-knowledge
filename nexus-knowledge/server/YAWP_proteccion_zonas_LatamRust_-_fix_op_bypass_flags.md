# YAWP proteccion zonas LatamRust - fix op_bypass_flags

YAWP (Yet Another World Protector) - Config de protección de zonas en LatamRust.

PROBLEMA COMÚN: Flags set a Denied pero jugadores ROMPEN bloques igual.
CAUSA RAÍZ: op_bypass_flags = true en yawp-common.toml permite que cualquier jugador con 'config permission' (OPs, UUIDs en players_with_permission) BYPASE TODOS los flags.
FIX: op_bypass_flags = false + agregar admins como 'owners' de las regiones protegidas.

Config path PC2: D:/SERVIDOR/servers/LATAMRUST COBBLEMON/config/yawp-common.toml

COMANDOS YAWP:
- Agregar owner: /yawp local <dim> <region> add player owners <player>
- Agregar member: /yawp local <dim> <region> add player members <player>
- Quitar player: /yawp local <dim> <region> remove player owners <player>
- Set flag: /yawp flag local <dim> <region> <flag> state Denied|Allowed|Disabled
- Listar flags: /yawp local <dim> <region> list flag
- Info flag: /yawp flag local <dim> <region> <flag>
- Eliminar región: /yawp local <dim> <region> delete -y

GRUPOS YAWP: Solo 'members' y 'owners' (PLURAL). NO son grupos de LuckPerms.
- owners: administran región + bypass flags
- members: solo bypass flags

ESTADOS DE FLAGS: [+] = Allowed, [x] = Denied, [-] = Disabled

FLAGS COMUNES: break-blocks, place-blocks, explosions-blocks, explosions-entities, fire-tick, invincible, item-pickup, melee-animals

IMPORTANTE: Siempre buscar docs del desarrollador ANTES de probar comandos al azar.
Wiki: https://z0rdak.github.io/yawp-docs/ (incompleta)
Modrinth: https://modrinth.com/mod/yawp
GitHub: https://github.com/Z0rdak/Yet-Another-World-Protector
