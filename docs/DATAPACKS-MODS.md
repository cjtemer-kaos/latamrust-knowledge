# Datapacks & Mods Created - Complete List

## Custom Datapacks

### COBBLEVERSE-DP-v31.zip

**Location**: `datapacks/COBBLEVERSE-DP-v31.zip`
**Size**: 4.6 MB
**Status**: Active

**Features**:
- No Ender Dragon
- No Hunger
- Custom recipes
- Loot tables
- Mob modifications

### NEWMOON ISLAND Datapack

**Location**: Server datapacks folder
**Status**: Active

**Features**:
- Custom island generation
- Moon phase mechanics
- Special loot

### Jail System Datapack

**Location**: `datapacks/jail-system/`
**Status**: Replaced by Staff Panel mod

**Features**:
- Function-based jail system
- Simple teleport mechanics

## Custom Mods

### Staff Panel v1.0.0

**Location**: `D:/share/staff-panel/`
**JAR**: `D:/share/staff-panel/build/libs/staffpanel-1.0.0.jar`
**Status**: Built, pending deployment

**Features**:
- Jail system with time-based release
- Player management commands
- JSON persistence
- Configurable coordinates
- Real-time duration

**Commands**:
- `/jail jail1 <player> [time]`
- `/jail unjail1 <player>`
- `/ban`, `/unban`, `/mute`, `/kick`
- `/tp`, `/gm`, `/invsee`

**Package**: `com.cobbleverse.staffpanel`

## ClaimBlocks Analysis

**Location**: `D:/share/claimblocks-analysis/`
**Status**: Analyzed, pending decision

**Features**:
- Fabric 1.21.1 compatible
- Kotlin + GooeyLibs2
- 11 protection flags
- Configurable stone templates
- JSON persistence

**Commands**:
- `/cb menu`
- `/cb claim`
- `/cb unclaim`
- `/cb add <player>`
- `/cb remove <player>`

## Server Configuration

### World Borders

| Dimension | Size | Center | Radius |
|-----------|------|--------|--------|
| Overworld | 60,000 | 0, 0 | ±30,000 |
| Nether | 7,500 | 0, 0 | ±3,750 |
| End | 30,000 | -150, 6 | ±15,000 |
| Distortion | 5,000 | -11, -4 | ±2,500 |
| Nightmare | 5,000 | 0, 0 | ±2,500 |

### Day/Night Cycle

- Day: 50 minutes
- Night: 10 minutes
- Weather: No rain (datapack)

### Performance

- RAM: 20GB (`-Xms10G -Xmx20G`)
- Chunky: Generating 30,000 radius
- Rate: ~334 chunks/second

## LuckPerms Ranks

| Rank | Level | Notes |
|------|-------|-------|
| admin | Highest | Full control |
| staff+ | High | Senior staff |
| staff | Medium | Basic staff |
| builder | Medium | Build permissions |
| director | Special | Server director |
| vipx | Special | Premium VIP |
| vip | Special | VIP |
| trainer | Game | Pokemon trainer |
| default | Lowest | New players |

## Network Configuration

### Tailscale

| Device | IP | Location |
|--------|-----|----------|
| Server | 100.83.148.88 | Uruguay |
| PC1 | 100.94.236.93 | Local |

### Ports

- **Game**: 55555
- **RCON**: 25575
- **BlueMap**: 8101

## Monitoring

### Chunky Monitor

- **Location**: `D:/share/scripts/chunky-monitor.sh`
- **Schedule**: Every 5 minutes
- **Logs**: `logs/chunky-alerts.log`

### Ollama AI

- **Model**: qwen3.5:2b
- **Purpose**: Status analysis
- **Frequency**: Every 5 minutes

## Troubleshooting

### "Can't place blocks"

1. Check world border: `/worldborder get`
2. Check F3 coordinates
3. Verify claim status
4. Check FTB Chunks protection

### RCON Issues

1. Verify port: 25575 (not 55555)
2. Check server is running
3. Verify Tailscale connection
4. Check firewall rules

### Chunky Issues

1. Check progress: `chunky progress`
2. Verify world name: `chunky world world`
3. Check center: `chunky center 0 0`
4. Check radius: `chunky radius 30000`

## Version History

- **v1.0** - Initial server setup
- **v1.1** - Added Cobblemon
- **v1.2** - Added FTB Chunks
- **v1.3** - Added BlueMap
- **v1.4** - Added Chunky
- **v1.5** - Added Staff Panel
- **v1.6** - Added ClaimBlocks analysis

---

**Last Updated**: August 7, 2026
