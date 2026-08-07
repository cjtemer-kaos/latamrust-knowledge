# Performance Mods Configuration

> **Servidor**: LATAMRUST COBBLEMON | Fabric 1.21.1 | 325 mods
> **Última actualización**: 2026-08-07

## Mods de rendimiento instalados

| Mod | Versión | Estado |
|-----|---------|--------|
| ModernFix | 5.25.1+mc1.21.1 | ✅ Configurado |
| Lithium | 0.15.4+mc1.21.1 | ✅ Default (bien) |
| FerriteCore | 7.0.3 | ✅ Default (bien) |
| ServerCore | 1.5.19+1.21.1 | ✅ **Configurado manualmente** |
| ThreadTweak | 0.1.5+mc1.21.1 | ✅ **Configurado manualmente** |
| LetMeDespawn | 1.5.0 | ✅ Default (bien) |
| PacketFixer | 3.3.1 | ✅ **Configurado manualmente** |
| EnhancedBlockEntities | 0.10.2+1.21 | ✅ Default (bien) |

## ⚠️ Configs que REQUIEREN ajuste manual

### ThreadTweak (`config/threadtweak.json`)

**PROBLEMA DEFAULT**: Main thread priority = 1 (el más bajo posible). Le da prioridad MÍNIMA al Server thread, causando lag severo.

```json
{
  "threadCount": {
    "bootstrap": 1,
    "main": 5
  },
  "threadPriority": {
    "game": 5,
    "bootstrap": 1,
    "main": 5,
    "io": 1,
    "integratedServer": 5
  }
}
```

**Regla**: `main` y `game` deben ser **5** (normal). Nunca 1.

### ServerCore (`config/servercore/config.yml`)

**PROBLEMAS DEFAULT**:
1. `activation-range: enabled: false` — TODOS los mobs se tickean sin importar distancia
2. Monster spawn-interval = 1 (intenta spawneear **cada tick**)

**Configs correctas**:

```yaml
activation-range:
  enabled: true  # Solo tickea mobs cerca de jugadores

mob-spawning:
  categories:
    - category: 'MONSTER'
      mobcap: 70
      spawn-interval: 4  # Cada 4 ticks, no cada tick
      despawn-distance: 128
```

### PacketFixer (`config/packetfixer.properties`)

**PROBLEMA DEFAULT**: `allSizesUnlimited=true` — sin límites de packets.

```properties
allSizesUnlimited=false  # Usar límites normales de Minecraft
```

## Configs que NO necesitan cambio

| Mod | Config | Notas |
|-----|--------|-------|
| Lithium | Default | Optimizado por defecto |
| FerriteCore | Default | Optimizado por defecto |
| LetMeDespawn | Default | Solo limpia corpses |
| EnhancedBlockEntities | Default | Rendering optimizado |

## ModernFix (`config/modernfix-mixins.properties`)

User overrides actuales:

```properties
mixin.bugfix.missing_block_entities=true
mixin.bugfix.packet_leak=true
mixin.perf.clear_fabric_mapping_tables=true
mixin.perf.clear_mixin_classinfo=true
mixin.perf.deduplicate_climate_parameters=true
mixin.perf.deduplicate_location=true
mixin.perf.dynamic_entity_renderers=true
mixin.perf.dynamic_resources=true
mixin.perf.faster_item_rendering=true
mixin.perf.ingredient_item_deduplication=true
```

## Diagnóstico de lag

### Checklist rápido

1. **¿`Can't keep up` aparece?** → Ver thread priority en threadtweak
2. **¿Muchos mobs lejanos tickeando?** → Ver activation-range en servercore
3. **¿sparks timeout?** → Puede ser I/O de disco o chunks grandes
4. **¿RAM creciendo sin parar?** → Memory leak (raro con estos mods)

### Comandos de diagnóstico (NO ejecutar con server vivo)

```bash
# Thread dump (ver qué hace el Server thread)
jstack <PID> | grep -A10 '"Server thread"'

# Memory (ver heap)
jstat -gc <PID>

# CPU del server thread
jstack <PID> | grep -A1 '"Server thread"' | grep "cpu="
```

## Reglas

1. **NUNCA** deshabilitar estos mods — solo ajustar configs
2. **SIEMPRE** verificar configs después de instalar mods nuevos
3. **NUNCA** asumir que los defaults son correctos
4. Si el lag empeora, verificar: thread priority → activation range → spawn interval
