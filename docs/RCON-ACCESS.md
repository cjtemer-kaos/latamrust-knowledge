# RCON Access Guide

## Overview

RCON (Remote Console) allows remote server administration.

## Configuration

| Property | Value |
|----------|-------|
| **Host** | 127.0.0.1 (local) |
| **Port** | 25575 |
| **Password** | See server config |
| **Client** | mcrcon |

## Usage

### Local Access

```bash
mcrcon -H 127.0.0.1 -P 25575 -p <password> "list"
```

### Remote Access (Tailscale)

```bash
mcrcon -H 100.83.148.88 -P 25575 -p <password> "list"
```

## Commands

### Server Management

```bash
# List players
mcrcon -H 127.0.0.1 -P 25575 -p <password> "list"

# Check TPS
mcrcon -H 127.0.0.1 -P 25575 -p <password> "tps"

# Save world
mcrcon -H 127.0.0.1 -P 25575 -p <password> "save-all"

# Restart server
mcrcon -H 127.0.0.1 -P 25575 -p <password> "restart"
```

### Player Management

```bash
# Kick player
mcrcon -H 127.0.0.1 -P 25575 -p <password> "kick <player>"

# Ban player
mcrcon -H 127.0.0.1 -P 25575 -p <password> "ban <player>"

# Unban player
mcrcon -H 127.0.0.1 -P 25575 -p <password> "pardon <player>"

# Op player
mcrcon -H 127.0.0.1 -P 25575 -p <password> "op <player>"
```

### World Management

```bash
# Check world border
mcrcon -H 127.0.0.1 -P 25575 -p <password> "worldborder get"

# Set world border
mcrcon -H 127.0.0.1 -P 25575 -p <password> "worldborder set 60000"

# Check time
mcrcon -H 127.0.0.1 -P 25575 -p <password> "time query daytime"
```

### Chunky Commands

```bash
# Check progress
mcrcon -H 127.0.0.1 -P 25575 -p <password> "chunky progress"

# Start generation
mcrcon -H 127.0.0.1 -P 25575 -p <password> "chunky start"

# Cancel task
mcrcon -H 127.0.0.1 -P 25575 -p <password> "chunky cancel"
```

### LuckPerms Commands

```bash
# Check permissions
mcrcon -H 127.0.0.1 -P 25575 -p <password> "lp user <player> permissions"

# Add permission
mcrcon -H 127.0.0.1 -P 25575 -p <password> "lp user <player> permission set <perm> true"
```

## Remote Access Setup

### Tailscale Configuration

1. **Install Tailscale** on both devices
2. **Login** with same account
3. **Use Tailscale IP** for remote access

### Connection Flow

```
Admin (Spain) → Tailscale → 100.83.148.88:25575 → RCON
```

### Firewall Rules

```bash
# Allow RCON through firewall
netsh advfirewall firewall add rule name="RCON" dir=in action=allow protocol=tcp localport=25575
```

## Security Notes

- ⚠️ **Never expose RCON password publicly**
- ⚠️ **Use strong password**
- ⚠️ **Limit access to trusted staff**
- ⚠️ **Monitor RCON logs**

## Troubleshooting

### "Connection refused"

1. Check server is running
2. Verify port: 25575 (not 55555)
3. Check firewall rules
4. Verify Tailscale connection

### "Authentication failed"

1. Check password
2. Verify RCON is enabled in server.properties
3. Check server.properties:
   ```
   enable-rcon=true
   rcon.port=25575
   rcon.password=<password>
   ```

### "Timeout"

1. Check network connection
2. Verify Tailscale status
3. Check server load
4. Increase timeout: `mcrcon -t 10 ...`

## Server Properties

**File**: `server.properties`

```properties
enable-rcon=true
rcon.port=25575
rcon.password=<password>
server-port=55555
```

## Monitoring

### Automated Monitoring

The server has automated monitoring:
- **Chunky Monitor**: Every 5 minutes
- **Ollama AI**: Status analysis
- **Logs**: `logs/chunky-alerts.log`

### Manual Monitoring

```bash
# Check server status
mcrcon -H 127.0.0.1 -P 25575 -p <password> "list"

# Check TPS
mcrcon -H 127.0.0.1 -P 25575 -p <password> "tps"

# Check memory
mcrcon -H 127.0.0.1 -P 25575 -p <password> "memory"
```

## Version History

- **v1.0** - Initial setup
- **v1.1** - Added Tailscale support
- **v1.2** - Added automated monitoring

---

**Last Updated**: August 7, 2026
