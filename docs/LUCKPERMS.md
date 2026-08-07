# LuckPerms Configuration Guide

## Overview

LuckPerms is the permission system for LATAMRUST COBBLEMON.

## Ranks

| Rank | Level | Permissions |
|------|-------|-------------|
| `admin` | Highest | Full control |
| `staff+` | High | Senior staff |
| `staff` | Medium | Basic staff |
| `builder` | Medium | Build permissions |
| `director` | Special | Server director |
| `vipx` | Special | Premium VIP |
| `vip` | Special | VIP |
| `trainer` | Game | Pokemon trainer |
| `default` | Lowest | New players |

## Commands

### User Management

```bash
# Check user permissions
mcrcon -H 127.0.0.1 -P 25575 -p <password> "lp user <player> permissions"

# Set rank
mcrcon -H 127.0.0.1 -P 25575 -p <password> "lp user <player> parent set <rank>"

# Add permission
mcrcon -H 127.0.0.1 -P 25575 -p <password> "lp user <player> permission set <perm> true"

# Remove permission
mcrcon -H 127.0.0.1 -P 25575 -p <password> "lp user <player> permission unset <perm>"
```

### Group Management

```bash
# Check group permissions
mcrcon -H 127.0.0.1 -P 25575 -p <password> "lp group <rank> permissions"

# Add permission to group
mcrcon -H 127.0.0.1 -P 25575 -p <password> "lp group <rank> permission set <perm> true"

# Remove permission from group
mcrcon -H 127.0.0.1 -P 25575 -p <password> "lp group <rank> permission unset <perm>"
```

### Web Editor

```bash
# Open web editor
mcrcon -H 127.0.0.1 -P 25575 -p <password> "lp editor"
```

**URL**: http://localhost:8080/editor

## Permission Nodes

### Cobblemon

```
cobblemon.commandpokemon        # /pokemon
cobblemon.commandpc            # /pc
cobblemon.commandpokedex       # /pokedex
cobblemon.commandbattle        # /battle
cobblemon.commandtrade         # /trade
```

### Staff Panel

```
staffpanel.jail                 # /jail
staffpanel.ban                  # /ban
staffpanel.unban                # /unban
staffpanel.mute                 # /mute
staffpanel.kick                 # /kick
staffpanel.tp                   # /tp
staffpanel.gm                   # /gm
staffpanel.invsee               # /invsee
```

### FTB Chunks

```
ftbchunks.chunk_claim           # Claim chunks
ftbchunks.chunk_unclaim         # Unclaim chunks
ftbchunks.admin                 # Admin bypass
```

### ClaimBlocks

```
claimblocks.claim               # Create claims
claimblocks.unclaim             # Remove claims
claimblocks.admin               # Admin bypass
```

### World Edit

```
worldedit.selection.pos         # //pos
worldedit.selection.expand      # //expand
worldedit.set                   # //set
worldedit.copy                  # //copy
worldedit.paste                 # //paste
```

## Exempt Groups (Anticheat)

Players in these groups bypass anticheat checks:
- `admin`
- `staff+`
- `staff`
- `builder`

## Configuration

### Config File

**File**: `config/luckperms/luckperms.yml`

```yaml
server: latamrust
address: localhost
config:
  instance: default
  storage-method: json
  use-server-uuid: true
  include-global: true
  include-global-world: true
  auto-op: false
  default-meta-weight: 0
  strict-argument-suggestions: true
  non-world-specific-groups-in-context: true
```

### Web Editor Setup

1. Run `/lp editor` in game
2. Open URL in browser
3. Make changes
4. Export and apply

## Common Tasks

### Add New Rank

```bash
# Create group
mcrcon -H 127.0.0.1 -P 25575 -p <password> "lp creategroup <rank>"

# Set prefix
mcrcon -H 127.0.0.1 -P 25575 -p <password> "lp group <rank> meta set prefix &7[<rank>] "

# Add permissions
mcrcon -H 127.0.0.1 -P 25575 -p <password> "lp group <rank> permission set <perm> true"
```

### Set Player Rank

```bash
# Set rank
mcrcon -H 127.0.0.1 -P 25575 -p <password> "lp user <player> parent set <rank>"

# Check rank
mcrcon -H 127.0.0.1 -P 25575 -p <password> "lp user <player> parents"
```

### Backup Permissions

```bash
# Export permissions
mcrcon -H 127.0.0.1 -P 25575 -p <password> "lp export > backup.json"
```

## Troubleshooting

### "Permission denied"

1. Check player rank
2. Verify permission node
3. Check group permissions
4. Reload LuckPerms: `/lp reload`

### "Rank not showing"

1. Check prefix configuration
2. Verify chat plugin
3. Check format string

### "Web editor not working"

1. Check port 8080
2. Verify firewall rules
3. Check server.properties

## Best Practices

1. **Use groups** - Assign permissions to groups, not players
2. **Web editor** - Use for complex permission changes
3. **Backup regularly** - Export permissions frequently
4. **Test changes** - Verify before applying
5. **Document changes** - Keep record of modifications

## Version History

- **v1.0** - Initial setup
- **v1.1** - Added Cobblemon permissions
- **v1.2** - Added Staff Panel permissions
- **v1.3** - Added anticheat exemption

---

**Last Updated**: August 7, 2026
