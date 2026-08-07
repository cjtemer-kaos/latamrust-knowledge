# LATAMRUST Anticheat - Complete Documentation

## Overview

The LATAMRUST anticheat is a custom Fabric mod called **latamrust-core** that validates player mods.

## How It Works

### Mod Validation

1. **Client connects** → Server receives mod list
2. **Server checks** → Compares against allowed mods list
3. **If invalid mod** → Player is kicked
4. **If valid mod** → Player is allowed to join

### Configuration Files

#### `latamrust-core.config`

```properties
# Comma-separated list of allowed Fabric mod IDs
# Players with mods NOT on this list will be kicked
allowed_mods=,mod1,mod2,mod3,...

# LuckPerms groups exempt from checks
exempt_groups=admin,staff+,staff,builder
```

#### `latamrust-core.json`

Contains detailed mod information and version checks.

### Exempt Groups

Players in these LuckPerms groups bypass anticheat checks:
- `admin`
- `staff+`
- `staff`
- `builder`

### Allowed Mods

The server allows **483 mods** (as of last check). The list includes:

- **Core mods**: Fabric API, Cobblemon, etc.
- **Performance**: Lithium, Sodium, FerriteCore, etc.
- **Utility**: JourneyMap, REI, Xaero's maps, etc.
- **Client**: OptiFine alternatives, shaders, etc.

### Bypass Mechanism

```java
// From latamrust-core
if (exempt_groups.contains(player.getLuckPermsGroup())) {
    return; // Skip check
}
```

### Detection Methods

1. **Mod list comparison** - Checks installed mods
2. **Version validation** - Ensures correct mod versions
3. **Permission check** - Exempts staff groups

### Logs

Anticheat logs are stored in:
```
logs/latamrust-core.log
```

### Commands

```bash
# Check player's mods (RCON)
mcrcon -H 127.0.0.1 -P 25575 -p <password> "latamrust mods <player>"

# Reload config
mcrcon -H 127.0.0.1 -P 25575 -p <password> "latamrust reload"
```

## Security Notes

- **Never disable anticheat** - Configure root cause instead
- **Staff exemption** - Only for trusted staff members
- **Mod list** - Keep updated with server changes
- **Logs** - Monitor for suspicious activity

## Troubleshooting

### "Player kicked for invalid mods"

1. Check `latamrust-core.config`
2. Verify mod ID is in allowed list
3. Check LuckPerms group

### "Staff member being checked"

1. Verify LuckPerms group is in `exempt_groups`
2. Check group name spelling
3. Reload config

## Version History

- **v1.0** - Initial release
- **v1.1** - Added LuckPerms exemption
- **v1.2** - Updated mod list

---

**Last Updated**: August 7, 2026
