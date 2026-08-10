# LATAMRUST COBBLEMON - Server Knowledge Base

Complete documentation for the LATAMRUST COBBLEMON server (Fabric 1.21.1).

## ⛔ START HERE

**Before making ANY changes, read `docs/CRITICAL-RULES.md`** — it contains mandatory rules to prevent breaking the server.

## 📋 Table of Contents

- [Quick Status](#quick-status)
- [Server Overview](#server-overview)
- [Critical Rules](#critical-rules)
- [Performance Mods](#performance-mods)
- [World Configuration](#world-configuration)
- [Mods List](#mods-list)
- [Staff Panel](#staff-panel)
- [Chunky World Generation](#chunky-world-generation)
- [ClaimBlocks System](#claimblocks-system)
- [RCON Access](#rcon-access)
- [Tailscale Network](#tailscale-network)
- [Commands Reference](#commands-reference)
- [Cómo crear mods](docs/MOD-DEVELOPMENT.md) 🛠️
- [Orden de carga de mods (LP Loader)](docs/LP-LOADER.md) 🔧
- [Ejemplos de mods funcionales](mod-examples/latamrust-core/) 📦

## 🎮 Quick Status

| Property | Value |
|----------|-------|
| **Status** | ✅ ONLINE |
| **Fabric Loader** | 0.19.3 (build 26.2) |
| **Sponge-Mixin** | 0.17.3 |
| **Total Mods** | 325 |
| **RAM** | 10G-20G (G1GC) |
| **MCSS** | Configured correctly |
| **Last Updated** | 2026-08-07 |

## 🎮 Server Overview

| Property | Value |
|----------|-------|
| **Server Name** | LATAMRUST COBBLEMON |
| **Platform** | Fabric 1.21.1 |
| **Loader Version** | 0.19.3 |
| **Total Mods** | 325 |
| **Game Port** | 55555 |
| **RCON Port** | 25575 |
| **RCON Password** | See server config |
| **BlueMap Port** | 8101 |
| **RAM Allocation** | 20GB (`-Xms10G -Xmx20G`) |
| **Manager** | MCSS |

## ⛔ Critical Rules

**Read `docs/CRITICAL-RULES.md` for the full list.**

### Summary of Prohibitions

1. **NEVER** run the Fabric Installer
2. **NEVER** overwrite `fabric-server-launch.jar` (must be 639B, not 616B)
3. **NEVER** delete `sponge-mixin/0.17.3+mixin.0.8.7/`
4. **NEVER** edit `fabric-installer.json` inside the loader jar
5. **NEVER** modify mod `.jar` files
6. **NEVER** downgrade to Fabric Loader 0.18.4
7. **NEVER** hardcode absolute paths
8. **NEVER** touch `launcher.py`

### Why These Rules Exist

The Fabric Installer 1.0.1 creates a different `fabric-server-launch.jar` (616B) that **does NOT include** `intermediary-1.21.1.jar`. This causes 68 mods with `intermediary` accessWideners to crash with:

```
ClassTweakerFormatException: Namespace (intermediary) does not match current runtime namespace (official)
```

The ORIGINAL launcher (639B) includes intermediary and works correctly. **NEVER overwrite it.**

## ⚡ Performance Mods

Mods de rendimiento instalados y configurados:

| Mod | Versión | Config |
|-----|---------|--------|
| ThreadTweak | 0.1.5 | Main priority = 5 (normal) |
| ServerCore | 1.5.19 | activation-range: true, spawn-interval: 4 |
| PacketFixer | 3.3.1 | allSizesUnlimited: false |
| ModernFix | 5.25.1 | Custom overrides |
| Lithium | 0.15.4 | Default (bien) |
| FerriteCore | 7.0.3 | Default (bien) |

⚠️ **IMPORTANTE**: Estos mods REQUIEREN configuración manual. Los defaults causan lag severo. Ver `docs/PERFORMANCE-MODS.md`.

## 🌍 World Configuration

### World Borders

| Dimension | Size | Center | Radius |
|-----------|------|--------|--------|
| Overworld | 60,000 | 0, 0 | ±30,000 |
| Nether | 7,500 | 0, 0 | ±3,750 |
| End | 30,000 | -150, 6 | ±15,000 |
| Distortion | 5,000 | -11, -4 | ±2,500 |
| Nightmare | 5,000 | 0, 0 | ±2,500 |

### Day/Night Cycle

- **Day**: 50 minutes
- **Night**: 10 minutes
- **Weather**: No rain (datapack)

## 📦 Mods List

See `docs/DATAPACKS-MODS.md` for the complete list.

### Critical Dependencies

| Mod | Requires | Purpose |
|-----|----------|---------|
| staff-panel | Fabric Loader ≥0.19.3 | Admin panel GUI |
| yawp | Fabric Loader ≥0.19.2 | World protection |
| accessories | Fabric API | Accessory system |
| architectury | Fabric API | Core library |

## 👥 Staff Panel

See `docs/STAFF-PANEL.md` for complete documentation.

### Quick Reference

```bash
# Open staff panel
/staff

# Jail commands
/jail jail1 <player> [time]
/jail unjail1 <player>

# Other commands
/ban <player> [reason]
/unban <player>
/mute <player>
/kick <player> [reason]
/tp <player> <target>
/gm <player> <mode>
/invsee <player>
```

## 🗺️ Chunky World Generation

See `docs/CHUNKY-GUIDE.md` for complete guide.

### Quick Reference

```bash
# Check progress
mcrcon -H 127.0.0.1 -P 25575 -p <password> "chunky progress"

# Start task
mcrcon -H 127.0.0.1 -P 25575 -p <password> "chunky start"

# Auto-switch runs every 5 minutes
# Script: D:/share/scripts/chunky-auto-switch.sh
```

## 🛡️ ClaimBlocks System

See `docs/CLAIMBLOCKS-DECISION.md` for analysis.

### Current Status

- **Decision pending**: ClaimBlocks vs FTB Chunks
- **FTB Chunks** currently active
- **ClaimBlocks** prototype ready (`ClaimBlocks-1.0.jar`)

## 🔌 RCON Access

See `docs/RCON-ACCESS.md` for complete guide.

### Quick Reference

```bash
# Test connection
mcrcon -H 127.0.0.1 -P 25575 -p <password> "list"

# From Tailscale
mcrcon -H 100.83.148.88 -P 25575 -p <password> "list"
```

## 🌐 Tailscale Network

See `docs/TAILSCALE.md` for complete guide.

### Network Map

| Machine | Tailscale IP | LAN IP | Role |
|---------|-------------|--------|------|
| PC2 (NEXUS) | 100.83.148.88 | 192.168.1.16 | Server |
| PC1 | 100.94.236.93 | — | Client/Agent |

## 📚 Additional Documentation

- `docs/ANTICHEAT.md` - Anticheat system
- `docs/LUCKPERMS.md` - LuckPerms permissions
- `docs/TROUBLESHOOTING.md` - Common issues & fixes

## 🔧 Getting Help

1. Check `docs/CRITICAL-RULES.md` first
2. Check `docs/TROUBLESHOOTING.md`
3. Check server logs: `logs/latest.log`
4. Ask in Discord

---

**Last Updated**: August 7, 2026
**Maintained by**: KAOS_MCS (admin)

## 🤖 PC1 Knowledge (Hermes Agent)

Desde 2026-08-07, este repo unifica el conocimiento de **PC1 (agente Hermes)** y **PC2 (server)**.

- `pc1-knowledge/PC1-KNOWLEDGE.md` — Launcher v5, Discord bot, configs, reglas
- `pc1-knowledge/launcher/` — Código fuente del launcher v5.0
- `pc1-knowledge/discord/` — Código del bot Discord (directo a Hermes)

**Regla de oro**: La comunicación PC1 ↔ PC2 NUNCA se corta. Todo se documenta aquí.
