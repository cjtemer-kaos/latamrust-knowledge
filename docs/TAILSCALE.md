# Tailscale Network Guide

## Overview

Tailscale provides secure remote access to the LATAMRUST server.

## Network Configuration

### Devices

| Device | Tailscale IP | Location | Purpose |
|--------|--------------|----------|---------|
| **Server (LATAMRUST)** | 100.83.148.88 | Uruguay | Game server |
| **PC1 (Admin)** | 100.94.236.93 | Local | Admin workstation |
| **PC2 (Server Host)** | 192.168.1.16 | LAN | Server host |

### Connection Flow

```
Robben (Spain) → Tailscale → 100.83.148.88:25575 → RCON
```

## Setup Instructions

### Server Setup

1. **Install Tailscale**
   ```bash
   # Windows
   winget install Tailscale.Tailscale
   
   # Or download from https://tailscale.com/download
   ```

2. **Login**
   ```bash
   tailscale login
   ```

3. **Verify IP**
   ```bash
   tailscale status
   ```

### Client Setup (Robben)

1. **Install Tailscale**
   ```bash
   # Windows
   winget install Tailscale.Tailscale
   ```

2. **Login with same account**
   ```bash
   tailscale login
   ```

3. **Verify connection**
   ```bash
   tailscale ping 100.83.148.88
   ```

## Remote Access

### RCON Access

```bash
# From Robben's machine (Spain)
mcrcon -H 100.83.148.88 -P 25575 -p <password> "list"
```

### Game Access

```
Server Address: 100.83.148.88:55555
```

### Web Access (BlueMap)

```
URL: http://100.83.148.88:8101
```

## Configuration

### Server Properties

**File**: `server.properties`

```properties
server-ip=0.0.0.0
server-port=55555
```

### Firewall Rules

```bash
# Allow game port
netsh advfirewall firewall add rule name="Minecraft" dir=in action=allow protocol=tcp localport=55555

# Allow RCON
netsh advfirewall firewall add rule name="RCON" dir=in action=allow protocol=tcp localport=25575

# Allow BlueMap
netsh advfirewall firewall add rule name="BlueMap" dir=in action=allow protocol=tcp localport=8101
```

## Security Notes

### Best Practices

1. **Use strong password** for RCON
2. **Limit access** to trusted staff
3. **Monitor logs** for suspicious activity
4. **Regular backups** of server data
5. **Update Tailscale** regularly

### Password Management

- **Never expose** RCON password publicly
- **Use unique password** for each service
- **Change regularly** (monthly)
- **Store securely** (password manager)

## Troubleshooting

### "Connection refused"

1. Check Tailscale status: `tailscale status`
2. Verify server is running
3. Check firewall rules
4. Verify port: 25575 (not 55555)

### "Timeout"

1. Check network connection
2. Verify Tailscale ping: `tailscale ping 100.83.148.88`
3. Check server load
4. Increase timeout: `mcrcon -t 10 ...`

### "Authentication failed"

1. Check password
2. Verify RCON is enabled
3. Check server.properties

### "High latency"

1. Check Tailscale relay
2. Verify direct connection
3. Check network congestion
4. Contact Tailscale support

## Monitoring

### Tailscale Status

```bash
# Check status
tailscale status

# Check connection
tailscale ping 100.83.148.88

# Check peers
tailscale peers
```

### Server Status

```bash
# Check players
mcrcon -H 100.83.148.88 -P 25575 -p <password> "list"

# Check TPS
mcrcon -H 100.83.148.88 -P 25575 -p <password> "tps"
```

## Performance

### Latency

- **Local (Uruguay)**: ~5ms
- **Spain to Uruguay**: ~150ms
- **Acceptable**: <200ms

### Bandwidth

- **RCON**: ~1 KB/s
- **Game**: ~100 KB/s per player
- **BlueMap**: ~50 KB/s

## Version History

- **v1.0** - Initial setup
- **v1.1** - Added BlueMap access
- **v1.2** - Optimized firewall rules

---

**Last Updated**: August 7, 2026
