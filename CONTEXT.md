# LATAMRUST Knowledge — Context

## Qué es
Repositorio de documentación y conocimiento del servidor LATAMRUST COBBLEMON. Fuente de verdad para configuración, troubleshooting y arquitectura.

## Repositorio
- **GitHub**: `github.com/cjtemer-kaos/latamrust-knowledge`
- **Propósito**: Documentar todo sobre el servidor para que cualquier sesión/agente pueda entender el estado

## Estructura
```
docs/
├── ANTICHEAT.md         # Sistema anticheat (latamrust-core)
├── CHUNKY-GUIDE.md      # Generación de mundos con Chunky
├── CLAIMBLOCKS-DECISION.md  # Análisis ClaimBlocks vs FTB
├── DATAPACKS-MODS.md    # Mods y datapacks custom
├── LUCKPERMS.md         # Permisos LuckPerms
├── RCON-ACCESS.md       # Acceso RCON remoto
├── SERVER-CONFIG.md     # Configuración del servidor
├── STAFF-PANEL.md       # Documentación del staff panel
├── TAILSCALE.md         # Red Tailscale
└── TROUBLESHOOTING.md   # Guía de problemas comunes

staff-panel-src/         # Source code del staff panel mod
claimblocks-analysis/    # Análisis de ClaimBlocks
```

## Reglas
1. **SIEMPRE** actualizar este repo cuando hay cambios grandes en el servidor
2. Mantener `STRUCTURE.md` actualizado
3. Cada archivo en `docs/` debe ser autocontenido
4. NO incluir credenciales (RCON passwords, API keys)
