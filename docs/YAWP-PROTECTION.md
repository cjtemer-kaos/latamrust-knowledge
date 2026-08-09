# YAWP - Yet Another World Protector

## Visión General
YAWP es un mod de protección de servidores que permite proteger zonas usando regiones y flags. Inspirado en WorldGuard.

- **Modrinth**: https://modrinth.com/mod/yawp
- **Wiki**: https://z0rdak.github.io/yawp-docs/ (parcialmente incompleta)
- **GitHub**: https://github.com/Z0rdak/Yet-Another-World-Protector
- **Versión instalada**: yawp-1.21.1-fabric-0.6.3-beta3.jar

## Configuración (PC2)
```
D:/SERVIDOR/servers/LATAMRUST COBBLEMON/config/yawp-common.toml
D:/SERVIDOR/servers/LATAMRUST COBBLEMON/config/yawp-flags.toml
D:/SERVIDOR/servers/LATAMRUST COBBLEMON/config/yawp-region-defaults.toml
D:/SERVIDOR/servers/LATAMRUST COBBLEMON/config/yawp-features.toml
```

## ⚠️ FIX CRÍTICO: op_bypass_flags

### Problema
Flags set a Denied pero jugadores ROMPEN bloques igual.

### Causa Raíz
`op_bypass_flags = true` en `yawp-common.toml` permite que cualquier jugador con "config permission" (OPs, UUIDs en `players_with_permission`) BYPASE TODOS los flags.

### Solución
1. Cambiar `op_bypass_flags = false` en `yawp-common.toml`
2. Agregar admins como `owners` de las regiones protegidas

### Fix via SSH
```bash
ssh cjtr@192.168.1.16 "python -c \"f='D:/SERVIDOR/servers/LATAMRUST COBBLEMON/config/yawp-common.toml';c=open(f).read();open(f,'w').write(c.replace('op_bypass_flags = true','op_bypass_flags = false'));print('done')\""
```

## Comandos YAWP

### Gestión de Regiones
```bash
# Crear región (con markers)
/yawp marker create <nombre> <pos1> <pos2>

# Info de región
/yawp local <dim> <region> info

# Eliminar región
/yawp local <dim> <region> delete -y

# Listar regiones
/yawp local <dim> list
```

### Gestión de Players
```bash
# Agregar owner (admin puede bypass flags)
/yawp local <dim> <region> add player owners <player>

# Agregar member (bypass flags)
/yawp local <dim> <region> add player members <player>

# Quitar player
/yawp local <dim> <region> remove player owners <player>
/yawp local <dim> <region> remove player members <player>
```

### Gestión de Flags
```bash
# Set flag
/yawp flag local <dim> <region> <flag> state Denied|Allowed|Disabled

# Listar flags de región
/yawp local <dim> <region> list flag

# Info de flag específico
/yawp flag local <dim> <region> <flag>

# Agregar flag a región
/yawp local <dim> <region> add flag <flag>
```

### Estados de Flags
- `[+]` = Allowed (permitido)
- `[x]` = Denied (denegado)
- `[-]` = Disabled (deshabilitado)

### Grupos YAWP
Solo existen DOS grupos (en PLURAL, NO son grupos de LuckPerms):
- **`owners`**: Pueden administrar la región + bypass flags
- **`members`**: Solo bypass flags

### Flags Comunes
- `break-blocks` - Romper bloques
- `place-blocks` - Colocar bloques
- `explosions-blocks` - Explosiones a bloques
- `explosions-entities` - Explosiones a entidades
- `fire-tick` - Fuego se propaga
- `invincible` - Jugador invencible
- `item-pickup` - Recoger items
- `melee-animals` - Daño melee a animales

## Config yawp-common.toml
```toml
# OP level para comandos (0=todos, 4=default, 5=nadie)
command_op_level = 4

# OPs bypass flags (DEBE SER false para protección real)
op_bypass_flags = false

# UUIDs con permiso de mod
players_with_permission = ["uuid1", "uuid2"]

# Jerarquía de ownership
hierarchy_ownership = true

# Permitir TP dentro/fuera de regiones
allow_region_tp = true
```

## Región Spawn Actual
- **Dimension**: minecraft:overworld
- **Área**: Cuboid X:181-1508, Y:-64-320, Z:435-1653
- **Flags Denied**: break-blocks, place-blocks, explosions-blocks, explosions-entities, fire-tick, invincible, item-pickup, melee-animals
- **Owners**: kaos__mcs, robben_, leftor_ (jhonsai, aryys, jonymcs pendientes)

## Lecciones Aprendidas
1. **SIEMPRE buscar docs del desarrollador** antes de probar comandos al azar
2. Los comandos `add player owner` NO existen — es `add player owners` (PLURAL)
3. `yawp flag local <dim> <region> <flag>` sin args es para gestionar, NO para consultar
4. Para listar flags usar: `yawp local <dim> <region> list flag`
5. El config se lee al iniciar el server — cambios requieren restart
6. Los .dat de regiones se guardan en `world/data/yawp/`
