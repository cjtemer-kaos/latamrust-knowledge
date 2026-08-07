# ClaimBlocks vs FTB Teams - Decision Guide

## Overview

This document helps decide between ClaimBlocks and FTB Teams for chunk protection.

## Current Setup

### FTB Chunks (Active)

**Status**: Active
**Purpose**: Chunk protection
**Config**: `config/ftbchunks/`

**Features**:
- Chunk claiming
- Team-based protection
- Admin bypass: `ftbchunks admin bypass_protection`

### FTB Teams (Active)

**Status**: Active
**Purpose**: Team management
**Config**: `config/ftbteams/`

**Features**:
- Team creation
- Member management
- Alliance system

## Options

### Option 1: Keep Both (Recommended)

**Pros**:
- ✅ No changes needed
- ✅ Both systems work together
- ✅ FTB Teams handles teams
- ✅ FTB Chunks handles protection

**Cons**:
- ❌ Two systems to manage
- ❌ Potential conflicts

### Option 2: Replace with ClaimBlocks

**Pros**:
- ✅ Single system
- ✅ Better performance
- ✅ More customization
- ✅ Fabric-native

**Cons**:
- ❌ Need to migrate
- ❌ Lose FTB Teams features
- ❌ Manual member management

### Option 3: Remove FTB Teams, Keep FTB Chunks

**Pros**:
- ✅ Simpler setup
- ✅ Keep chunk protection
- ✅ Use ClaimBlocks for teams

**Cons**:
- ❌ Lose FTB Teams features
- ❌ Need to configure ClaimBlocks

## ClaimBlocks Features

### Stone Templates

| Size | Dimensions | Description |
|------|------------|-------------|
| Small | 10x10 | Single chunk |
| Medium | 30x30 | Small base |
| Large | 50x50 | Medium base |
| XL | 100x100 | Large base |
| XXL | 150x150 | Huge base |

### Protection Flags

1. **Block Breaking** - Prevent mining
2. **Block Placement** - Prevent building
3. **Explosions** - Prevent TNT
4. **Fire** - Prevent fire spread
5. **Mob Spawning** - Prevent mob spawns
6. **PvP** - Prevent player vs player
7. **Item Pickup** - Prevent item pickup
8. **Redstone** - Prevent redstone
9. **Hopper** - Prevent hopper transfer
10. **Fluid Flow** - Prevent water/lava
11. **Mob Griefing** - Prevent mob damage

### Commands

```
/cb menu - Open menu
/cb claim - Create claim
/cb unclaim - Remove claim
/cb add <player> - Add member
/cb remove <player> - Remove member
/cb info - Claim info
/cb list - List claims
```

### Configuration

**File**: `config/ClaimBlocks/claims.json`

```json
{
  "claims": [
    {
      "owner": "uuid",
      "x": 0,
      "z": 0,
      "size": "medium",
      "members": ["uuid1", "uuid2"],
      "flags": {
        "block_break": false,
        "block_place": false,
        "pvp": false
      }
    }
  ]
}
```

## Migration Guide

### From FTB Teams to ClaimBlocks

1. **Export FTB Teams data**
2. **Import to ClaimBlocks**
3. **Update permissions**
4. **Test protection**
5. **Remove FTB Teams**

### Steps

```bash
# 1. Export FTB Teams
mcrcon -H 127.0.0.1 -P 25575 -p <password> "ftbteams export"

# 2. Import to ClaimBlocks
mcrcon -H 127.0.0.1 -P 25575 -p <password> "cb import ftbteams"

# 3. Update permissions
mcrcon -H 127.0.0.1 -P 25575 -p <password> "lp editor"

# 4. Test
mcrcon -H 127.0.0.1 -P 25575 -p <password> "cb list"

# 5. Remove FTB Teams
rm config/ftbteams/
```

## Recommendation

**Keep Both Systems** for now:
- FTB Teams for team management
- FTB Chunks for protection
- ClaimBlocks for advanced features

**Future**: Migrate to ClaimBlocks when stable.

## References

- [FTB Chunks Wiki](https://feed-the-beast.com/)
- [ClaimBlocks GitHub](https://github.com/)
- [LuckPerms Docs](https://luckperms.net/)

---

**Last Updated**: August 7, 2026
