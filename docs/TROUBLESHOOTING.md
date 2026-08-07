# Troubleshooting Guide

## Common Issues

### "Namespace (intermediary) does not match current runtime namespace (official)"

**Symptoms**: Server crashes on startup with:
```
ClassTweakerFormatException: Namespace (intermediary) does not match current runtime namespace (official)
```

**Cause**: The `fabric-server-launch.jar` was overwritten by the Fabric Installer (616B) which does NOT include `intermediary-1.21.1.jar` in its Class-Path.

**Solution**:
```bash
# 1. Check launcher size
stat -c%s fabric-server-launch.jar  # Should be 639, not 616

# 2. If 616, restore backup
cp fabric-server-launch.jar.bak fabric-server-launch.jar

# 3. Verify intermediary in Class-Path
unzip -p fabric-server-launch.jar META-INF/MANIFEST.MF | grep intermediary
```

**Prevention**: NEVER run `java -jar fabric-installer.jar`. See `CRITICAL-RULES.md`.

---

### "NoClassDefFoundError: org/spongepowered/asm/launch/MixinBootstrap"

**Symptoms**: Server crashes on startup with:
```
java.lang.NoClassDefFoundError: org/spongepowered/asm/launch/MixinBootstrap
```

**Cause**: The `sponge-mixin-0.17.3+mixin.0.8.7.jar` is missing from `libraries/net/fabricmc/sponge-mixin/`.

**Solution**:
```bash
# 1. Check if directory exists
ls libraries/net/fabricmc/sponge-mixin/0.17.3+mixin.0.8.7/

# 2. If missing, download from Maven
mkdir -p libraries/net/fabricmc/sponge-mixin/0.17.3+mixin.0.8.7
curl -L -o libraries/net/fabricmc/sponge-mixin/0.17.3+mixin.0.8.7/sponge-mixin-0.17.3+mixin.0.8.7.jar \
  "https://maven.fabricmc.net/net/fabricmc/sponge-mixin/0.17.3+mixin.0.8.7/sponge-mixin-0.17.3+mixin.0.8.7.jar"
```

**Prevention**: NEVER delete the sponge-mixin directory. See `CRITICAL-RULES.md`.

---

### "staff-panel requires fabricloader >=0.19.3"

**Symptoms**: Server crashes with:
```
Incompatible mods found!
staff-panel 1.0.0 needs fabricloader >=0.19.3
yawp 0.6.3-beta3 needs fabricloader >=0.19.2
```

**Cause**: MCSS or start.bat is using the old 0.18.4 loader instead of 0.19.3.

**Solution**:
```bash
# 1. Check MCSS config
cat mcss_server_config.json | grep startupLine
# Must say: -jar fabric-server-launch.jar nogui
# NOT: -jar .fabric/server/fabric-loader-server-0.18.4-minecraft-1.21.1.jar

# 2. Fix if wrong
python3 -c "
import json
with open('mcss_server_config.json', 'r') as f:
    cfg = json.load(f)
cfg['startupLine'] = cfg['startupLine'].replace(
    '.fabric/server/fabric-loader-server-0.18.4-minecraft-1.21.1.jar',
    'fabric-server-launch.jar'
)
with open('mcss_server_config.json', 'w') as f:
    json.dump(cfg, f, indent=2)
"
```

**Prevention**: NEVER downgrade to 0.18.4. See `CRITICAL-RULES.md`.

---

### "Can't place blocks"

**Symptoms**: Player cannot place blocks

**Causes**:
1. World border restriction
2. Claim protection
3. FTB Chunks protection
4. LuckPerms restriction

**Solutions**:
```bash
# Check world border
mcrcon -H 127.0.0.1 -P 25575 -p <password> "worldborder get"

# Check player position (F3)
# Verify claim status
mcrcon -H 127.0.0.1 -P 25575 -p <password> "ftbchunks list"

# Bypass protection (admin)
mcrcon -H 127.0.0.1 -P 25575 -p <password> "ftbchunks admin bypass_protection"
```

---

### "RCON connection failed"

**Symptoms**: Cannot connect to RCON

**Causes**:
1. Wrong port (55555 vs 25575)
2. Server not running
3. Firewall blocking
4. Tailscale not connected

**Solutions**:
```bash
# Verify port
netstat -an | grep 25575

# Check server status
tasklist | grep java

# Test connection
mcrcon -H 127.0.0.1 -P 25575 -p <password> "list"

# Check Tailscale
tailscale status
```

---

### "Chunky not generating"

**Symptoms**: Chunky progress stuck

**Causes**:
1. Task not running
2. Memory issues
3. Server overload

**Solutions**:
```bash
# Check progress
mcrcon -H 127.0.0.1 -P 25575 -p <password> "chunky progress"

# Start task
mcrcon -H 127.0.0.1 -P 25575 -p <password> "chunky start"

# Check memory
mcrcon -H 127.0.0.1 -P 25575 -p <password> "memory"
```

---

### "Player kicked for mods"

**Symptoms**: Player kicked on join

**Causes**:
1. Invalid mod installed
2. Mod not in allowed list
3. LuckPerms group not exempt

**Solutions**:
```bash
# Check player's mods
mcrcon -H 127.0.0.1 -P 25575 -p <password> "latamrust mods <player>"

# Check allowed mods
cat config/latamrust-core.config

# Add to exempt group
mcrcon -H 127.0.0.1 -P 25575 -p <password> "lp user <player> parent set staff"
```

---

### "Jail not working"

**Symptoms**: Jail command fails

**Causes**:
1. Config not loaded
2. Coordinates wrong
3. Permission missing

**Solutions**:
```bash
# Check config
cat config/staffpanel/staffpanel-jail.json

# Verify coordinates
mcrcon -H 127.0.0.1 -P 25575 -p <password> "tp <player> 0 -60 0"

# Check permissions
mcrcon -H 127.0.0.1 -P 25575 -p <password> "lp user <player> permissions"
```

---

## Performance Issues

### High Latency

**Solutions**:
```bash
# Check TPS
mcrcon -H 127.0.0.1 -P 25575 -p <password> "tps"

# Check players
mcrcon -H 127.0.0.1 -P 25575 -p <password> "list"

# Reduce view distance
mcrcon -H 127.0.0.1 -P 25575 -p <password> "view-distance 8"
```

### Memory Issues

**Solutions**:
```bash
# Check memory
mcrcon -H 127.0.0.1 -P 25575 -p <password> "memory"

# Kill entities
mcrcon -H 127.0.0.1 -P 25575 -p <password> "kill @e[type=item]"

# Restart server
mcrcon -H 127.0.0.1 -P 25575 -p <password> "restart"
```

---

## Connection Issues

### "Connection refused"

**Solutions**:
```bash
# Check server
tasklist | grep java

# Check port
netstat -an | grep 25575

# Check firewall
netsh advfirewall firewall show rule name="RCON"
```

### "Authentication failed"

**Solutions**:
```bash
# Check server.properties
grep "rcon" server.properties

# Verify password
mcrcon -H 127.0.0.1 -P 25575 -p <password> "list"
```

### "Timeout"

**Solutions**:
```bash
# Test connection
tailscale ping 100.83.148.88

# Increase timeout
mcrcon -t 10 -H 127.0.0.1 -P 25575 -p <password> "list"

# Check server
mcrcon -H 127.0.0.1 -P 25575 -p <password> "tps"
```

---

## World Issues

### "World corruption"

**Solutions**:
```bash
# Restore backup
xcopy /E /I "D:\backups\world-latest" "D:\SERVIDOR\servers\LATAMRUST COBBLEMON\world"

# Use MCASelector
# Download from https://github.com/Toolbox4Minecraft/mcaselector
```

### "Chunks not loading"

**Solutions**:
```bash
# Check view distance
mcrcon -H 127.0.0.1 -P 25575 -p <password> "view-distance"

# Increase view distance
mcrcon -H 127.0.0.1 -P 25575 -p <password> "view-distance 12"

# Check TPS
mcrcon -H 127.0.0.1 -P 25575 -p <password> "tps"
```

---

## Mod Issues

### "Mod conflict"

**Symptoms**: Game crashes or behaves oddly

**Solutions**:
1. Check mod compatibility
2. Update mods
3. Remove conflicting mod
4. Check logs

### "Mod not loading"

**Solutions**:
```bash
# Check logs
cat logs/latest.log | grep "modname"

# Verify mod in mods folder
ls mods/ | grep "modname"

# Check version compatibility
cat mods/modname.jar
```

---

## Logging

### Server Logs

**Location**: `logs/latest.log`

```bash
# View recent logs
tail -100 logs/latest.log

# Search for errors
grep "ERROR" logs/latest.log

# Search for warnings
grep "WARN" logs/latest.log
```

### Anticheat Logs

**Location**: `logs/latamrust-core.log`

```bash
# View anticheat logs
tail -100 logs/latamrust-core.log
```

### Chunky Logs

**Location**: `logs/chunky-alerts.log`

```bash
# View chunky logs
tail -100 logs/chunky-alerts.log
```

---

## Getting Help

### Resources

- [Fabric Wiki](https://fabricmc.net/wiki/)
- [Cobblemon Discord](https://discord.gg/cobblemon)
- [LuckPerms Docs](https://luckperms.net/)
- [FTB Wiki](https://feed-the-beast.com/)

### Support

1. Check logs first
2. Search error message
3. Check documentation (`CRITICAL-RULES.md` first!)
4. Ask in Discord

## Version History

- **v1.0** - Initial guide
- **v1.1** - Added common issues
- **v1.2** - Added performance issues
- **v1.3** - Added connection issues
- **v1.4** - Added classTweaker/namespace issues (2026-08-07)
- **v1.5** - Added fabric-loader-server-0.18.4 issue (2026-08-07)

---

**Last Updated**: August 7, 2026
