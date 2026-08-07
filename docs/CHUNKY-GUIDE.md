# Chunky World Generation - Complete Guide

## Overview

Chunky is a Fabric mod for pre-generating Minecraft worlds to improve performance.

## Current Configuration

### Server Settings

| Property | Value |
|----------|-------|
| **World** | Overworld |
| **Center** | 0, 0 |
| **Radius** | 30,000 blocks |
| **Status** | Generating outer ring (15,000-30,000) |
| **ETA** | ~11.5 hours |
| **Rate** | ~334 chunks/second |

### Memory Allocation

```bash
-Xms10G -Xmx20G -XX:+AlwaysPreTouch
```

## RCON Commands

### Basic Commands

```bash
# Check progress
mcrcon -H 127.0.0.1 -P 25575 -p <password> "chunky progress"

# Start generation
mcrcon -H 127.0.0.1 -P 25575 -p <password> "chunky start"

# Cancel current task
mcrcon -H 127.0.0.1 -P 25575 -p <password> "chunky cancel"

# Confirm cancellation
mcrcon -H 127.0.0.1 -P 25575 -p <password> "chunky confirm"
```

### Configuration Commands

```bash
# Set world
mcrcon -H 127.0.0.1 -P 25575 -p <password> "chunky world world"

# Set center
mcrcon -H 127.0.0.1 -P 25575 -p <password> "chunky center 0 0"

# Set radius
mcrcon -H 127.0.0.1 -P 25575 -p <password> "chunky radius 30000"

# Set corners (alternative to radius)
mcrcon -H 127.0.0.1 -P 25575 -p <password> "chunky corners -30000 -30000 30000 30000"
```

### Progress Information

```bash
# Get detailed progress
mcrcon -H 127.0.0.1 -P 25575 -p <password> "chunky progress"
```

**Output Example**:
```
Chunky: Task 1 running for world 'world': Processing...
  170,969 chunks (1.22%) 334.1 chunks/sec, ETA 11:33:18, 23,000/1,000,000 chunks done
  Current chunk: (154, 198)
  Center: (0, 0), Radius: 30,000
```

## World Borders

### Border Configuration

| Dimension | Border Size | Center | Radius |
|-----------|-------------|--------|--------|
| **Overworld** | 60,000 x 60,000 | 0, 0 | ±30,000 |
| **Nether** | 7,500 x 7,500 | 0, 0 | ±3,750 |
| **End** | 30,000 x 30,000 | -150, 6 | ±15,000 |
| **Distortion** | 5,000 x 5,000 | -11, -4 | ±2,500 |
| **Nightmare** | 5,000 x 5,000 | 0, 0 | ±2,500 |

### Border Commands

```bash
# Check border size
mcrcon -H 127.0.0.1 -P 25575 -p <password> "worldborder get"

# Set border
mcrcon -H 127.0.0.1 -P 25575 -p <password> "worldborder set 60000"

# Set center
mcrcon -H 127.0.0.1 -P 25575 -p <password> "worldborder center 0 0"
```

## Important Notes

### Chunky Behavior

- **Skips existing chunks**: Chunky automatically skips chunks that are already generated
- **Ring generation**: When interior exists, only outer ring is generated
- **Resume capability**: Can cancel and resume without losing progress

### Current Status

- **Interior (0-15,000)**: Already generated
- **Outer ring (15,000-30,000)**: Currently generating
- **Total chunks**: ~1,000,000
- **Completion**: ~1.22% (170,969 chunks)

### Performance

- **Rate**: ~334 chunks/second
- **ETA**: ~11.5 hours
- **Memory**: 20GB allocated
- **CPU**: Multi-threaded generation

## Monitoring

### Automated Monitoring

The server has an automated monitor that:
- Checks Chunky progress every 5 minutes
- Reports status via Ollama AI
- Logs alerts to `D:/SERVIDOR/scripts/logs/chunky-alerts.log`

### Manual Monitoring

```bash
# Check progress
mcrcon -H 127.0.0.1 -P 25575 -p <password> "chunky progress"

# Check server status
mcrcon -H 127.0.0.1 -P 25575 -p <password> "list"

# Check TPS
mcrcon -H 127.0.0.1 -P 25575 -p <password> "tps"
```

## Troubleshooting

### "Chunky not generating"

1. Check if task is running: `chunky progress`
2. Verify world name: `chunky world world`
3. Check center: `chunky center 0 0`
4. Check radius: `chunky radius 30000`
5. Start task: `chunky start`

### "Slow generation"

1. Check memory allocation (20GB recommended)
2. Verify CPU usage
3. Check for other server processes
4. Monitor TPS (should be 20)

### "Chunks not loading"

1. Verify world border
2. Check player position
3. Verify claim status
4. Check FTB Chunks protection

## Configuration Files

### Chunky Config

**File**: `config/chunky.json`

```json
{
  "world": "world",
  "centerX": 0,
  "centerZ": 0,
  "radius": 30000,
  "shape": "square"
}
```

### Server Properties

**File**: `server.properties`

```properties
level-name=world
view-distance=12
simulation-distance=12
```

## Best Practices

1. **Pre-generate**: Always pre-generate before players join
2. **Monitor progress**: Check progress regularly
3. **Backup world**: Backup before large operations
4. **Test first**: Test on small area before full generation
5. **Document coordinates**: Keep record of center and radius

## Version Information

- **Chunky Version**: 1.4.23
- **Fabric Version**: 1.21.1
- **Minecraft Version**: 1.21.1

---

**Last Updated**: August 7, 2026
