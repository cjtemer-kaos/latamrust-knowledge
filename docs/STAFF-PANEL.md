# Staff Panel - Complete Documentation

## Overview

The Staff Panel is a custom Fabric mod for server administration in LATAMRUST COBBLEMON.

## Installation

1. Copy `staffpanel-1.0.0.jar` to server's `mods/` folder
2. Restart server
3. Config files auto-generated in `config/staffpanel/`

## Commands Reference

### Jail System

```
/jail jail1 <player> [time]    - Jail a player
/jail unjail1 <player>         - Unjail a player
```

**Time Formats**:
- `24hs` or `24h` - 24 hours
- `30min` or `30m` - 30 minutes
- `2d` - 2 days
- `1h30min` - 1 hour 30 minutes
- `45s` - 45 seconds

**Examples**:
```
/jail jail1 Robben_ 24hs
/jail jail1 Robben_ 30min
/jail jail1 Robben_ 2d
/jail unjail1 Robben_
```

**Features**:
- Real-time duration (not game time)
- Movement allowed within cell (configurable radius)
- Auto-release when time expires
- JSON persistence (survives server restarts)
- Configurable coordinates

### Player Management

```
/ban <player>        - Ban a player
/unban <player>      - Unban a player
/mute <player>       - Mute a player
/kick <player>       - Kick a player
/tp <player>         - Teleport to player
/gm <player>         - Change gamemode
/invsee <player>     - View player inventory
```

## Configuration Files

### Jail Configuration

**File**: `config/staffpanel/staffpanel-jail.json`

```json
{
  "x": 0,
  "y": -60,
  "z": 0,
  "radius": 10,
  "comment": "Jail coordinates and radius"
}
```

**Parameters**:
- `x`, `y`, `z` - Jail center coordinates
- `radius` - Movement radius in blocks (default: 10)

### Jail Data

**File**: `config/staffpanel/jail-data.json`

```json
{
  "uuid1": 1691234567890,
  "uuid2": 1691234567890
}
```

**Format**: Player UUID → Release timestamp (milliseconds)

## Technical Details

### Architecture

- **Package**: `com.cobbleverse.staffpanel`
- **Main Class**: `StaffPanelMod.java`
- **Jail System**: `JailSystem.java`
- **Commands**: `StaffCommands.java`
- **Actions**: `StaffActions.java`

### Dependencies

- Fabric API
- Brigadier (command framework)
- Gson (JSON parsing)

### Event System

- **Server Tick**: Checks jail boundaries every 20 ticks (1 second)
- **Auto-release**: Checks if jail time expired
- **Boundary enforcement**: Teleports player back if outside radius

### Persistence

- **Config**: Loaded on server start
- **Jail Data**: Saved on every jail/unjail action
- **Survives Restart**: Yes (JSON files)

## Building from Source

```bash
cd staff-panel
./gradlew build
```

**Output**: `build/libs/staffpanel-1.0.0.jar`

## Troubleshooting

### "Jail coordinates not found"

1. Check `config/staffpanel/staffpanel-jail.json` exists
2. Verify coordinates are correct
3. Restart server

### "Player not released"

1. Check `jail-data.json` for expired entries
2. Verify system time is correct
3. Use `/jail unjail1 <player>` to force release

### "Can't move in jail"

1. Check `radius` in config (default: 10)
2. Verify coordinates are at correct Y level
3. Check for blocks obstructing movement

## Security Notes

- Only staff with permission level 2+ can use commands
- Jail coordinates stored in config (not hardcoded)
- RCON password never exposed in code

## Version History

- **v1.0.0** (August 2026) - Initial release
  - Basic jail system
  - Player management commands
  - JSON persistence
  - Configurable coordinates
