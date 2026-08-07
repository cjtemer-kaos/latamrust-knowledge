# Server Configuration Guide

## Overview

Complete server configuration for LATAMRUST COBBLEMON.

## Server Properties

**File**: `server.properties`

```properties
# Server
server-name=LATAMRUST COBBLEMON
server-ip=0.0.0.0
server-port=55555
max-players=100
view-distance=12
simulation-distance=12

# RCON
enable-rcon=true
rcon.port=25575
rcon.password=<password>

# World
level-name=world
level-seed=
level-type=minecraft\:normal
generator-settings={}

# Performance
sync-chunk-writes=false
entity-broadcast-range-percentage=100

# Game Mode
gamemode=survival
difficulty=normal
hardcore=false
pvp=true

# Commands
enable-command-block=true
allow-nether=true
spawn-protection=0

# Misc
online-mode=true
white-list=false
spawn-monsters=true
spawn-animals=true
spawn-npcs=true
allow-flight=false
force-gamemode=false
```

## JVM Arguments

**File**: `start.bat`

```bash
@echo off
title LATAMRUST COBBLEMON
java -Xms10G -Xmx20G -XX:+AlwaysPreTouch -jar fabric-server.jar nogui
pause
```

### Argument Explanation

- `-Xms10G` - Minimum heap: 10GB
- `-Xmx20G` - Maximum heap: 20GB
- `-XX:+AlwaysPreTouch` - Pre-touch memory pages
- `-jar fabric-server.jar` - Server jar
- `nogui` - No GUI

## Mods Configuration

### Essential Mods

| Mod | Version | Purpose |
|-----|---------|---------|
| Fabric API | Latest | Core functionality |
| Cobblemon | Latest | Pokemon mod |
| LuckPerms | Latest | Permissions |
| BlueMap | Latest | Web map |
| Chunky | 1.4.23 | World generation |
| FTB Chunks | Latest | Chunk protection |
| FTB Teams | Latest | Team management |

### Performance Mods

| Mod | Purpose |
|-----|---------|
| Lithium | General optimization |
| Phosphor | Lighting engine |
| Sodium | Rendering (client) |
| Starlight | Light engine |
| FerriteCore | Memory optimization |

### Utility Mods

| Mod | Purpose |
|-----|---------|
| JourneyMap | Minimap |
| REI | Recipe viewer |
| AppleSkin | Food info |
| Xaero's Maps | World map |

## World Configuration

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

## Datapacks

### Installed

1. **COBBLEVERSE-DP-v31.zip** - Main datapack
2. **NEWMOON ISLAND** - Custom island
3. **No Ender Dragon** - Removes dragon
4. **No Hunger** - Removes hunger
5. **Custom Loot** - Modified loot tables

### Custom Datapacks

| Datapack | Purpose |
|----------|---------|
| COBBLEVERSE-DP-v31 | Core features |
| NEWMOON ISLAND | Custom content |
| Jail System | Staff commands |

## Monitoring

### Chunky Monitor

**Schedule**: Every 5 minutes
**Location**: `D:/share/scripts/chunky-monitor.sh`
**Logs**: `logs/chunky-alerts.log`

### Ollama AI

**Model**: qwen3.5:2b
**Purpose**: Status analysis
**Frequency**: Every 5 minutes

### BlueMap

**Port**: 8101
**URL**: http://localhost:8101
**Features**: Real-time map, player tracking

## Backup Strategy

### Daily Backups

```bash
# Backup world
mcrcon -H 127.0.0.1 -P 25575 -p <password> "save-all"

# Copy world folder
xcopy /E /I "D:\SERVIDOR\servers\LATAMRUST COBBLEMON\world" "D:\backups\world-%date%"
```

### Weekly Backups

```bash
# Full server backup
tar -czf "D:\backups\server-%date%.tar.gz" "D:\SERVIDOR\servers\LATAMRUST COBBLEMON"
```

## Performance Tuning

### JVM Tuning

```bash
# G1GC (recommended)
-XX:+UseG1GC -XX:+ParallelRefProcEnabled -XX:MaxGCPauseMillis=200

# ZGC (experimental)
-XX:+UseZGC -XX:+ZGenerational
```

### Server Tuning

```properties
# Reduce entity processing
entity-broadcast-range-percentage=50

# Optimize chunks
sync-chunk-writes=false
max-chunk-generators=8

# Reduce network
rate-limit=0
```

## Troubleshooting

### "Out of Memory"

1. Increase `-Xmx` value
2. Check for memory leaks
3. Reduce view-distance
4. Use performance mods

### "Lag spikes"

1. Check TPS: `/tps`
2. Monitor entities
3. Optimize chunks
4. Reduce simulation-distance

### "World corruption"

1. Restore from backup
2. Use MCASelector to fix
3. Regenerate chunks with Chunky

## Security

### Firewall Rules

```bash
# Allow game
netsh advfirewall firewall add rule name="Minecraft" dir=in action=allow protocol=tcp localport=55555

# Allow RCON
netsh advfirewall firewall add rule name="RCON" dir=in action=allow protocol=tcp localport=25575

# Allow BlueMap
netsh advfirewall firewall add rule name="BlueMap" dir=in action=allow protocol=tcp localport=8101
```

### Password Policy

- Use strong, unique passwords
- Change monthly
- Never expose publicly
- Use password manager

## Version History

- **v1.0** - Initial setup
- **v1.1** - Added Cobblemon
- **v1.2** - Added FTB Chunks
- **v1.3** - Added BlueMap
- **v1.4** - Added Chunky
- **v1.5** - Added Staff Panel
- **v1.6** - Optimized performance

---

**Last Updated**: August 7, 2026
