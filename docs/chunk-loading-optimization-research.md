# Chunk/World Loading Optimization Research — Fabric 1.21.1

## Problem
Server takes 4.7s to boot, but 110-second lag spikes when players join (chunk loading on 60k×60k world). 32GB RAM, Ryzen 5 2600 (6C/12T), 329 mods, view-distance=8, simulation-distance=8.

---

## 1. Pre-Generation Alternatives to Chunky (which is DISABLED)

### Option A: Fabric/Quilt Chunk Pregenerator (`fabricquilt-chunk-pregenerator`)
- **Source**: https://github.com/jaskarth/fabric-chunkpregenerator
- **Modrinth**: https://modrinth.com/mod/fabricquilt-chunk-pregenerator
- **Version**: 0.3.8 (last updated Sep 2025, supports 1.21.1)
- **Downloads**: 72K+
- **Commands**: `/pregen start <radius>`, `/pregen stop`, `/pregen status`
- **How it works**: Generates chunks in a square pattern. Single pregeneration task at a time. Simpler than Chunky, Fabric-native.
- **Caveat**: For 60k×60k world (30k radius from center = 30000 chunks), this would take a very long time. Better suited for smaller pregen areas around spawn/important locations.

### Option B: Chunk Pregenerator (datapack + mod) (`chunk-pregenerator`)
- **Modrinth**: https://modrinth.com/mod/chunk-pregenerator
- **Version**: v1.1 — BUT **no 1.21.1 version available** (latest supports 1.21.9+)
- **Status**: NOT compatible with 1.21.1 ❌

### Option C: Passive Chunk Pregenerator (`passivepregen`)
- **Modrinth**: https://modrinth.com/mod/passivepregen
- **Description**: Generates chunks passively around players, offline or online. Focuses on worldspawn and player-proximate areas.
- **Status**: **No 1.21.1 version** (last: 1.19.2) ❌

### Option D: Chunky + Chunky Offline (already installed but DISABLED)
- The user already has `chunky` + `chunky-offline` v1.4.23 in the modlist
- Chunky was DISABLED due to lag spikes causing 110s freezes (Phase 26 in troubleshooting skill)
- **Root cause of Chunky lag**: Running `chunky status/progress/cancel` via RCON on a large world triggers a directory scan (`FindNextFile0`) that blocks the main server thread for minutes
- **Workaround**: Never run chunky commands on live server. Use log parsing instead.

### Recommendation: Re-enable Chunky with guardrails
- Enable it but **only run pregeneration when server is empty/offline**
- Never run chunky commands while players are online
- Use `/pregen start` from Fabric Chunk Pregenerator for active pregeneration while players are online (simpler, less likely to cause massive freezes)

---

## 2. Fabric Mods for Chunk Loading Optimization

### Already Installed (verify these are configured):
| Mod | Status | Config Check |
|-----|--------|-------------|
| **C2ME** (Concurrent Chunk Management Engine) | ✅ Installed | `globalExecutorParallelism=8`, `midTickChunkTasksInterval=50000` |
| **Lithium** | ✅ Installed | Ensure `mixin.minimal_nonvanilla.world.expiring_chunk_tickets=false` |
| **ModernFix** | ✅ Installed | Verify chunk caching settings |
| **ServerCore** | ✅ Installed | `activation-range.enabled=true`, spawn intervals tuned |
| **ThreadTweak** | ✅ Installed | `threadPriority.main=5`, `threadPriority.game=5` |
| **Krypton** | ✅ Installed | v0.2.8 for 1.21.1 (networking optimization) |
| **VMP** (Very Many Players) | ✅ Installed | v0.2.0+beta.7.172 for 1.21.1 |

### Recommended Additions:
| Mod | Purpose | Version |
|-----|---------|---------|
| **Starlight** | Rewrites light engine for faster chunk loading | ❌ No 1.21.1 Fabric version (merged into vanilla 1.20+) |

### Key C2ME Settings for 60k×60k world:
```toml
# config/c2me.toml
globalExecutorParallelism = 8          # Uses more of 12 threads
midTickChunkTasksInterval = 50000      # Load chunks faster during ticks
```

---

## 3. JVM Flags for Faster Chunk I/O

### Current Flags (from skill):
```
-Xms10G -Xmx20G -XX:+UseG1GC -XX:ParallelGCThreads=6 -XX:ConcGCThreads=2
```

### Optimized Flags for Chunk Loading:
```bat
set MIN_RAM=10G
set MAX_RAM=20G
"%JAVA_PATH%" -Xms%MIN_RAM% -Xmx%MAX_RAM% ^
  -XX:+UseG1GC ^
  -XX:+ParallelRefProcEnabled ^
  -XX:MaxGCPauseMillis=150 ^
  -XX:+UnlockExperimentalVMOptions ^
  -XX:+DisableExplicitGC ^
  -XX:+AlwaysPreTouch ^
  -XX:G1NewSizePercent=30 ^
  -XX:G1MaxNewSizePercent=40 ^
  -XX:G1HeapRegionSize=8M ^
  -XX:G1ReservePercent=20 ^
  -XX:ActiveProcessorCount=6 ^
  -XX:ParallelGCThreads=6 ^
  -XX:ConcGCThreads=2 ^
  -XX:+UseStringDeduplication ^
  -XX:+ExitOnOutOfMemoryError ^
  -Dfml.readTimeout=120 ^
  -jar fabric-server-launch.jar nogui
```

### Key Additions:
| Flag | Purpose |
|------|---------|
| `-XX:+AlwaysPreTouch` | Pre-touch all heap pages at startup — avoids latency spikes during chunk loading |
| `-XX:ActiveProcessorCount=6` | Use physical cores, not hyperthreads (Ryzen 2600 benefit) |
| `-XX:+UseStringDeduplication` | Deduplicate strings (saves RAM with 329 mods, many repeated names) |
| `-XX:MaxGCPauseMillis=150` | Shorter GC pauses (was 200 in standard Aikar) |

### For Chunk I/O Specifically:
- No JVM flag directly speeds up disk I/O
- **Key server.properties settings** (see below) have more impact

---

## 4. server.properties Settings Affecting Startup Loading

### Critical Settings:
```properties
# Already set (from skill):
view-distance=8                    # Good — don't increase for large worlds
simulation-distance=8              # Good — keep at 8 or lower

# ADD these:
sync-chunk-writes=false           # CRITICAL — was causing 100+ second lag spikes
max-tick-time=300000              # 5 minutes — prevents watchdog kills during chunk gen
pause-when-empty-seconds=0        # Disable pause when empty (helps with pregen)

# Already set:
rate-limit=0                      # Good — disabled rate limiting
network-compression-threshold=512 # Good — compress earlier for modded packets
```

### Why `sync-chunk-writes=false` is Critical:
- `sync-chunk-writes=true` (default) forces server to wait for disk I/O before continuing
- This causes massive lag spikes when chunks are being written to disk
- **Risk**: Some chunks may be lost on abrupt crash (backups compensate)
- **Impact**: Eliminates most 100+ second lag spikes

### Why `max-tick-time=300000` Matters:
- Default 60000 (60s) kills server during heavy chunk generation
- Litematica, Chunky, and player join chunk loading all cause tick spikes
- 5 minutes (300000ms) gives enough tolerance

---

## 5. Fabric-Specific Optimizations for World Loading

### A. C2ME Multi-threaded Chunk Loading
C2ME is the most impactful Fabric mod for chunk loading performance:
- Multi-threaded chunk generation and loading
- Parallel light engine
- Parallel biome/noise computation
- **Config**: `globalExecutorParallelism=8` uses more of 12 threads

### B. Lithium Game Logic Optimization
- Optimizes entity ticking, pathfinding, chunk loading
- **Critical config**: Disable the incompatible mixin:
  ```properties
  # config/lithium.properties
  mixin.minimal_nonvanilla.world.expiring_chunk_tickets=false
  ```

### C. ModernFix Performance
- Reduces memory usage and improves startup time
- Deduplicates climate parameters and locations
- Caches stronghold positions

### D. ServerCore Activation Range
- Only ticks entities near players (not all entities)
- Reduces CPU load during chunk loading
- **Config**: `activation-range.enabled: true`

### E. ThreadTweak Thread Priority
- Fixes server thread being starved by other threads
- **Config**: `threadPriority.main: 5`, `threadPriority.game: 5`

---

## 6. Practical Implementation Plan

### Phase 1: Immediate Impact (server.properties)
```properties
sync-chunk-writes=false
max-tick-time=300000
```

### Phase 2: JVM Optimization
Update `start.bat` with optimized flags from Section 3.

### Phase 3: C2ME Tuning
Verify `config/c2me.toml` has:
```toml
globalExecutorParallelism = 8
midTickChunkTasksInterval = 50000
```

### Phase 4: Re-enable Chunky (with guardrails)
- Enable chunky + chunky-offline
- **Only pregenerate when server is empty**
- Never run chunky commands while players are online
- Use log parsing for monitoring: `grep "Chunky.*running" logs/latest.log | tail -3`

### Phase 5: Spawn Rate Tuning
Reduce entity loading during chunk generation:
```json
// config/cobblemon/main.json
"pokemonPerChunk": 0.3,
"ticksBetweenSpawnAttempts": 30.0
```

```toml
// config/rctmod-server.toml
globalSpawnChance = 0.35
spawnIntervalTicks = 900
maxTrainersPerPlayer = 4
```

---

## Summary of Recommendations

| Priority | Action | Expected Impact |
|----------|--------|-----------------|
| 🔴 HIGH | Set `sync-chunk-writes=false` | Eliminates 100+ second lag spikes |
| 🔴 HIGH | Set `max-tick-time=300000` | Prevents watchdog kills during chunk gen |
| 🔴 HIGH | Verify C2ME parallelism=8 | Faster multi-threaded chunk loading |
| 🟡 MED | Optimize JVM flags | Better GC pauses, pre-touch pages |
| 🟡 MED | Re-enable Chunky (offline only) | Pre-generate important areas |
| 🟢 LOW | Add Fabric Chunk Pregenerator | Active pregen while players online |
| 🟢 LOW | Reduce Cobblemon/RCT spawn rates | Less entity loading per chunk |

---

## Research Sources
- Modrinth API: fabricquilt-chunk-pregenerator (72K downloads, 1.21.1 compatible)
- Modrinth API: C2ME-fabric (33M downloads, 0.4.0-alpha.0.23 for 1.21.1)
- Modrinth API: VMP-fabric (15M downloads, 0.2.0+beta.7.172 for 1.21.1)
- Minecraft Wiki: server.properties (view-distance, simulation-distance, sync-chunk-writes)
- Skills: minecraft-fabric-server, modded-minecraft-server-troubleshooting
- Aikar's G1GC Flags: https://mcflags.emc.gs
