# LATAMRUST COBBLEMON - Server Knowledge Base

Complete documentation for the LATAMRUST COBBLEMON server (Fabric 1.21.1).

## 📋 Table of Contents

- [Server Overview](#server-overview)
- [World Configuration](#world-configuration)
- [Mods List](#mods-list)
- [Staff Panel](#staff-panel)
- [Chunky World Generation](#chunky-world-generation)
- [ClaimBlocks System](#claimblocks-system)
- [RCON Access](#rcon-access)
- [Tailscale Network](#tailscale-network)
- [Commands Reference](#commands-reference)

## 🎮 Server Overview

| Property | Value |
|----------|-------|
| **Server Name** | LATAMRUST COBBLEMON |
| **Platform** | Fabric 1.21.1 |
| **Loader Version** | 0.19.3 |
| **Total Mods** | 204 |
| **Game Port** | 55555 |
| **RCON Port** | 25575 |
| **RCON Password** | See server config |
| **BlueMap Port** | 8101 |
| **RAM Allocation** | 20GB (`-Xms10G -Xmx20G`) |
| **Manager** | MCSS |

## 🌍 World Configuration

### World Borders

| Dimension | Border Size | Center | Radius |
|-----------|-------------|--------|--------|
| **Overworld** | 60,000 x 60,000 | 0, 0 | ±30,000 |
| **Nether** | 7,500 x 7,500 | 0, 0 | ±3,750 (1:8 ratio) |
| **End** | 30,000 x 30,000 | -150, 6 | ±15,000 |
| **Distortion** | 5,000 x 5,000 | -11, -4 | ±2,500 |
| **Nightmare** | 5,000 x 5,000 | 0, 0 | ±2,500 |

**Important**: World border blocks ALL interaction outside bounds (creative + OP too).

### Day/Night Cycle

- **Day duration**: 50 minutes
- **Night duration**: 10 minutes
- **Weather**: No rain (datapack)

### Legendary Structure Coordinates

| Structure | Coordinates |
|-----------|-------------|
| Ash | -3360, ~304 |
| Torre Rocket | -8496, ~4032 |
| Radio Rocket | -11792, ~9904 |
| Dawn Tower | -5600, ~-2080 |
| Dusk Tower | -9008, ~-2608 |
| Kanto League | -1856, ~368 |
| Eternatus Cocoon | -12736, ~672 |

## 📦 Mods List

### Core Mods

- **Fabric API** - Core Fabric functionality
- **Cobblemon** - Pokemon mod
- **LuckPerms** - Permission system
- **BlueMap** - Web-based map
- **Chunky** - Pre-generation
- **FTB Chunks** - Chunk protection
- **FTB Teams** - Team system

### Performance Mods

- **Lithium** - General optimization
- **Phosphor** - Lighting engine
- **Sodium** - Rendering (client)
- **Starlight** - Light engine
- **FerriteCore** - Memory optimization

### Utility Mods

- **JourneyMap** - Minimap
- **Roughly Enough Items (REI)** - Recipe viewer
- **AppleSkin** - Food/hunger info
- **Xaero's Minimap** - Minimap
- **Xaero's World Map** - World map

## 👮 Staff Panel

### Overview

Custom Fabric mod for server administration.

**Location**: `D:/share/staff-panel/`
**JAR**: `D:/share/staff-panel/build/libs/staffpanel-1.0.0.jar`

### Commands

| Command | Description | Syntax |
|---------|-------------|--------|
| `/jail jail1` | Jail player | `/jail jail1 <player> [time]` |
| `/jail unjail1` | Unjail player | `/jail unjail1 <player>` |
| `/ban` | Ban player | `/ban <player>` |
| `/unban` | Unban player | `/unban <player>` |
| `/mute` | Mute player | `/mute <player>` |
| `/kick` | Kick player | `/kick <player>` |
| `/tp` | Teleport to player | `/tp <player>` |
| `/gm` | Change gamemode | `/gm <player>` |
| `/invsee` | View inventory | `/invsee <player>` |

### Jail System

**Features**:
- ✅ Real-time duration (not game time)
- ✅ Movement allowed within cell (10 block radius)
- ✅ Auto-release when time expires
- ✅ JSON persistence (survives restarts)
- ✅ Configurable coordinates

**Time Formats**:
- `24hs` or `24h` - 24 hours
- `30min` or `30m` - 30 minutes
- `2d` - 2 days
- `1h30min` - 1 hour 30 minutes

**Configuration**:
```json
// config/staffpanel/staffpanel-jail.json
{
  "x": 0,
  "y": -60,
  "z": 0,
  "radius": 10,
  "comment": "Jail coordinates and radius"
}
```

## 🌐 Chunky World Generation

### Current Task

- **World**: Overworld
- **Center**: 0, 0
- **Radius**: 30,000 blocks
- **Status**: Generating outer ring (15,000-30,000)
- **ETA**: ~11.5 hours
- **Rate**: ~334 chunks/second

### Commands

```bash
# Via RCON
mcrcon -H 127.0.0.1 -P 25575 -p <password> "chunky progress"
mcrcon -H 127.0.0.1 -P 25575 -p <password> "chunky start"
mcrcon -H 127.0.0.1 -P 25575 -p <password> "chunky cancel"
mcrcon -H 127.0.0.1 -P 25575 -p <password> "chunky confirm"
```

### Notes

- Chunky skips already generated chunks
- Interior (0-15,000) was generated previously
- Only outer ring (15,000-30,000) is being generated

## 🏠 ClaimBlocks System

### Overview

ClaimBlocks v1.0 (based on ProtectionStones concept, but Fabric-native).

**Location**: `D:/share/claimblocks-analysis/`

### Features

- ✅ Fabric 1.21.1 compatible
- ✅ Kotlin + GooeyLibs2
- ✅ 11 protection flags
- ✅ Configurable stone templates (10x10 to 150x150)
- ✅ Manual member management (no FTB Teams integration)
- ✅ JSON persistence

### Commands

```
/cb menu - Open ClaimBlocks menu
/cb claim - Create claim
/cb unclaim - Remove claim
/cb add <player> - Add member
/cb remove <player> - Remove member
```

### Configuration

- **Config file**: `config/ClaimBlocks/claims.json`
- **Stone types**: 8 templates
- **Sizes**: 10x10 to 150x150 blocks
- **Flags**: 11 protection options

## 🔌 RCON Access

### Configuration

| Property | Value |
|----------|-------|
| **Host** | 127.0.0.1 (local) |
| **Port** | 25575 |
| **Password** | See server config |
| **Client** | mcrcon |

### Usage

```bash
# Local access
mcrcon -H 127.0.0.1 -P 25575 -p <password> "list"

# Remote access (Tailscale)
mcrcon -H 100.83.148.88 -P 25575 -p <password> "list"
```

### Important Notes

- ⚠️ Port 55555 is game port (not RCON)
- ⚠️ Port 25575 is RCON port
- ⚠️ Never expose RCON password publicly

## 🌐 Tailscale Network

### Network Configuration

| Device | Tailscale IP | Location |
|--------|--------------|----------|
| **Server (LATAMRUST)** | 100.83.148.88 | Uruguay |
| **PC1 (Admin)** | 100.94.236.93 | Local |
| **PC2 (Server Host)** | 192.168.1.16 | LAN |

### Connection Flow

```
Robben (Spain) → Tailscale → 100.83.148.88:25575 → RCON
```

### Setup Instructions

1. Install Tailscale on both devices
2. Login with same account
3. Use Tailscale IP for remote access
4. No port forwarding needed

## 📊 LuckPerms Ranks

| Rank | Permission Level | Notes |
|------|------------------|-------|
| `admin` | Highest | Full control |
| `staff+` | High | Senior staff |
| `staff` | Medium | Basic staff |
| `builder` | Medium | Build permissions |
| `director` | Special | Server director |
| `vipx` | Special | Premium VIP |
| `vip` | Special | VIP |
| `trainer` | Game | Pokemon trainer |
| `default` | Lowest | New players |

## 🛠️ Troubleshooting

### "Can't place blocks"

1. Check world border: `/worldborder get`
2. Check F3 coordinates
3. Verify claim status
4. Check FTB Chunks protection

### RCON Connection Issues

1. Verify port: 25575 (not 55555)
2. Check server is running
3. Verify Tailscale connection
4. Check firewall rules

### Chunky Issues

1. Check progress: `chunky progress`
2. Verify world name: `chunky world world`
3. Check center: `chunky center 0 0`
4. Check radius: `chunky radius 30000`

## 📝 Notes

- **Server Location**: Uruguay
- **Admin Location**: Uruguay (LAN)
- **Staff Location**: Spain (Remote via Tailscale)
- **Language**: Spanish (admin)
- **Timezone**: UTC-3

## 🔗 Useful Links

- [Fabric API](https://fabricmc.net/develop/)
- [Cobblemon](https://cobblemon.com/)
- [LuckPerms](https://luckperms.net/)
- [BlueMap](https://bluemap.net/)
- [FTB Chunks](https://feed-the-beast.com/)

---

**Last Updated**: August 7, 2026
**Maintained by**: KAOS_MCS
