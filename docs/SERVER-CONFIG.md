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
max-players=30
view-distance=12
simulation-distance=12

# RCON
enable-rcon=true
rcon.port=25575
rcon.password=<REDACTED>

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
online-mode=false
white-list=false
spawn-monsters=true
spawn-animals=true
spawn-npcs=true
allow-flight=false
force-gamemode=false
```

## Fabric Loader Setup (CRITICAL)

### Current Configuration

| Component | Version | Source |
|-----------|---------|--------|
| **Fabric Loader** | 0.19.3 (build 26.2) | Maven |
| **Sponge-Mixin** | 0.17.3 | Maven |
| **Intermediary** | 1.21.1 | Maven |
| **Minecraft** | 1.21.1 | Vanilla |

### Boot Architecture

```
fabric-server-launch.jar (639B, ORIGINAL)
  └── Class-Path →
      ├── asm-9.10.1.jar
      ├── asm-analysis-9.10.1.jar
      ├── asm-commons-9.10.1.jar
      ├── asm-tree-9.10.1.jar
      ├── asm-util-9.10.1.jar
      ├── sponge-mixin-0.17.3+mixin.0.8.7.jar  ← CRÍTICO
      ├── intermediary-1.21.1.jar                ← CRÍTICO
      └── fabric-loader-0.19.3.jar
```

### ⛔ CRITICAL: Do NOT Use Fabric Installer

The Fabric Installer 1.0.1 creates a DIFFERENT `fabric-server-launch.jar` (616B) that **does NOT include** `intermediary-1.21.1.jar`. This causes:

```
ClassTweakerFormatException: Namespace (intermediary) does not match current runtime namespace (official)
```

**68 mods use `intermediary` accessWideners. Without the intermediary jar, ALL of them crash.**

The ORIGINAL launcher (639B) includes intermediary and works correctly. **NEVER overwrite it.**

### Library Paths

```
libraries/
├── net/fabricmc/
│   ├── fabric-loader/0.19.3/fabric-loader-0.19.3.jar
│   ├── sponge-mixin/0.17.3+mixin.0.8.7/sponge-mixin-0.17.3+mixin.0.8.7.jar
│   └── intermediary/1.21.1/intermediary-1.21.1.jar
└── org/ow2/asm/asm/9.10.1/asm-9.10.1.jar
```

### MCSS Configuration

**File**: `mcss_server_config.json`

```json
{
  "startupMethode": "BatFile",
  "startupLine": "java -Xms10G -Xmx20G ... -jar fabric-server-launch.jar nogui",
  "javaPathOverride": "C:\\Program Files\\Eclipse Adoptium\\jdk-21.0.11.10-hotspot\\bin\\java.exe"
}
```

**IMPORTANT**: The `startupLine` must use `fabric-server-launch.jar`, NOT `.fabric/server/fabric-loader-server-0.18.4-minecraft-1.21.1.jar`.

## JVM Arguments

**File**: `start.bat`

```bash
@echo off
title COBBLEVERSE - Pokemon Adventure Server
set JAVA_PATH=C:\Program Files\Eclipse Adoptium\jdk-21.0.11.10-hotspot\bin\java.exe
set SERVER_JAR=fabric-server-launch.jar
set MIN_RAM=10G
set MAX_RAM=20G

"%JAVA_PATH%" -Xms%MIN_RAM% -Xmx%MAX_RAM% ^
  -XX:+UseG1GC ^
  -XX:+ParallelRefProcEnabled ^
  -XX:MaxGCPauseMillis=150 ^
  -XX:+UnlockExperimentalVMOptions ^
  -XX:+DisableExplicitGC ^
  -XX:+AlwaysPreTouch ^
  -XX:G1NewSizePercent=30 ^
  -XX:G1MaxNewSizePercent=40 ^
  -XX:G1HeapRegionSize=8M ^
  -XX:G1ReservePercent=20 ^
  -XX:G1HeapWastePercent=5 ^
  -XX:G1MixedGCCountTarget=4 ^
  -XX:InitiatingHeapOccupancyPercent=15 ^
  -XX:G1MixedGCLiveThresholdPercent=90 ^
  -XX:G1RSetUpdatingPauseTimePercent=5 ^
  -XX:SurvivorRatio=32 ^
  -XX:+PerfDisableSharedMem ^
  -XX:MaxTenuringThreshold=1 ^
  -XX:ActiveProcessorCount=6 ^
  -Dusing.aikars.flags=https://mcflags.emc.gs ^
  -Daikars.new.flags=true ^
  -jar "%SERVER_JAR%" nogui
```

### Argument Explanation

- `-Xms10G` - Minimum heap: 10GB
- `-Xmx20G` - Maximum heap: 20GB
- `-XX:+UseG1GC` - G1 garbage collector
- `-XX:+ParallelRefProcEnabled` - Parallel reference processing
- `-XX:MaxGCPauseMillis=150` - Max GC pause 150ms
- `-XX:+AlwaysPreTouch` - Pre-touch memory pages
- `-jar fabric-server-launch.jar` - The ORIGINAL launcher (639B)

## Mods Configuration

### Total Mods: 325

### Critical Dependencies

| Mod | Requires | Purpose |
|-----|----------|---------|
| staff-panel | Fabric Loader ≥0.19.3 | Admin panel GUI |
| yawp | Fabric Loader ≥0.19.2 | World protection |
| accessories | Fabric API | Accessory system |
| architectury | Fabric API | Core library |

### Performance Mods

| Mod | Purpose |
|-----|---------|
| Lithium | General optimization |
| FerriteCore | Memory optimization |
| ServerCore | Server optimization |
| ThreadTweak | Threading optimization |
| LetMeDespawn | Entity cleanup |
| PacketFixer | Network optimization |

### Utility Mods

| Mod | Purpose |
|-----|---------|
| JourneyMap | Minimap |
| REI | Recipe viewer |
| AppleSkin | Food info |
| Xaero's Maps | World map |
| BlueMap | Web map (port 8101) |

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

## Monitoring

### Chunky Monitor

**Schedule**: Every 5 minutes
**Location**: `D:/share/scripts/chunky-auto-switch.sh`
**Logs**: `logs/chunky-alerts.log`

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
# G1GC (current - recommended)
-XX:+UseG1GC -XX:+ParallelRefProcEnabled -XX:MaxGCPauseMillis=150

# ZGC (experimental - not recommended yet)
-XX:+UseZGC -XX:+ZGenerational
```

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

## Version History

- **v1.0** - Initial setup
- **v1.1** - Added Cobblemon
- **v1.2** - Added FTB Chunks
- **v1.3** - Added BlueMap
- **v1.4** - Added Chunky
- **v1.5** - Added Staff Panel
- **v1.6** - Optimized performance
- **v1.7** - Upgraded to Fabric Loader 0.19.3 (2026-08-07)
- **v1.8** - Documented intermediary namespace requirement (2026-08-07)

---

**Last Updated**: August 7, 2026
