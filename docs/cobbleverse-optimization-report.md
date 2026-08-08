# CobbleVerse Fabric 1.21.1 Server — Comprehensive Optimization Report
> Generated: 2026-08-08 | Server: Ryzen 5 2600 (6C/12T), 32GB RAM, Java 21, Fabric 0.19.3, 329 mods, 30 max players
> Current state: 93 'Can't keep up' events, avg 7.5s lag, worst 110s spike, 591 recipe parse errors

---

## 1. CRITICAL: New Cobblemon-Specific Optimization Mods

### 1a. CobbleLagClear (7,449 downloads — Server-side)
- **What it does:** Periodic cleanup of wild Pokémon entities + ground items + optional crop growth blocking
- **Why it matters:** The #1 cause of lag on Cobblemon servers is entity accumulation. Wild Pokémon despawner in vanilla Cobblemon is too slow.
- **Config:**
  - `cleanup_interval_minutes: 15` (default 20 — more aggressive)
  - `keep_shinies: true`
  - `keep_legendaries: true`
  - `keep_player_pokemon: true`
  - `keep_recent_spawns_minutes: 2` (avoids deleting freshly spawned Pokémon)
  - `keep_npc_pokemon: true`
  - `clear_ground_items: true` (major lag source — item piles from battles)
  - `block_crop_growth: false` (enable ONLY if farms cause lag)
  - Chat warnings: 10min, 5min, 3min, 1min before cleanup
- **Download:** `https://modrinth.com/mod/cobblelagclear`
- **Version for 1.21.1:** 0.1.3 (verified compatible)

### 1b. CobblemonChunkmenager (2,155 downloads — Server-side)
- **What it does:** Per-chunk Pokémon entity density management
  - **Spawn prevention:** Cancels spawns in chunks already at entity budget (default 16/chunk)
  - **Heatmap system:** Tracks chunk activity (HOT/WARM/COLD) — AI throttling for COLD chunks
  - **Budget enforcement:** Migrates excess wild Pokémon to nearby chunks or despawns them
  - **AI throttling:** Disables vanilla AI (pathfinding, movement) for Pokémon in COLD chunks
- **Config:**
  - `entity_budget_per_chunk: 16` (default — may want 10-12 for heavy servers)
  - `scan_interval_ticks: 100` (5 seconds)
  - `strategy: MIGRATE_THEN_DESPAWN` (default — try relocate first, despawn remainder)
  - `/ccm heatmap [radius]` command for visual debugging
- **Download:** `https://modrinth.com/mod/cobblemonchunkmenager`
- **Version for 1.21.1:** 1.1.0 (verified compatible)
- **IMPACT:** This directly addresses the "PokemonEntity DISCARDED" warnings — excess entities are being managed before they cause lag

### 1c. CobbleBoost (3,221 downloads — CLIENT-side only)
- **What it does:** Client-side Cobblemon rendering optimization
  - Pokemon render distance culling
  - LOD system (simplified models at distance)
  - Animation throttling for distant Pokémon
  - Particle limiter for particle storm effects
  - Model pre-caching
- **Impact:** Reduces client lag when many Pokémon are visible — less network sync needed
- **Download:** `https://modrinth.com/mod/cobbleboost`
- **Note:** Client-side only — players need it installed

---

## 2. server.properties Tuning (Performance-Critical Settings)

### Currently Set (verify these)
```properties
simulation-distance=4          # ✅ GOOD — fewer chunks ticked
view-distance=8                # ✅ OK — 8 chunks visible, 4 ticked
max-tick-time=120000           # ✅ GOOD — 2min watchdog, prevents false kills
max-players=30                 # Verify this matches actual config
```

### Recommended Additional Settings
```properties
# NETWORK OPTIMIZATION
network-compression-threshold=256   # Default is fine; lower to 64 if bandwidth is OK but latency matters
rate-limit=0                        # ✅ Already set — prevents false kicks

# CHUNK OPTIMIZATION
sync-chunk-writes=false             # ⚠️ CRITICAL — allows async chunk saves off main thread
                                    # Paper forces this false; Fabric does NOT — you must set it manually
max-chained-neighbor-updates=1000000  # Default — prevents cascading block update lag

# ENTITY OPTIMIZATION  
entity-broadcast-range-percentage=100  # Default; reduce to 75-80 if entity tracking lag
                                      # Lower = entities disappear sooner at distance
                                      # ⚠️ Affects Pokémon visibility range

# WORLD OPTIMIZATION
max-world-size=60000                  # Match your 60k×60k world border
pause-when-empty-seconds=60           # Saves resources when no players online

# ANTI-EXPLOIT
chat-spam-threshold-seconds=10        # Default
command-spam-threshold-seconds=10     # Default
```

### Key Insight: `sync-chunk-writes=false`
> "Note for users that are on vanilla, Fabric or Spigot - go to your server.properties and change `sync-chunk-writes` to `false`. This option is forcibly set to false on Paper and forks, but on other server implementations you need to switch this to false manually. This allows the server to save chunks off the main thread, lessening the load on the main tick loop."
> — YouHaveTrouble's Minecraft Optimization Guide

---

## 3. Cobblemon Configuration Optimizations (from source code analysis)

### 3a. Spawning Config (`config/cobblemon/main.json`)
```json
{
  "pokemonPerChunk": 0.3,              // Default: 1.0 → REDUCE significantly
  "pokeSnackPokemonPerChunk": 1.0,    // Default: 2.0 → reduce
  "ticksBetweenSpawnAttempts": 30.0,   // Default: 20.0 → INCREASE (less frequent checks)
  "maximumSpawnsPerPass": 1,           // Default: 8 → REDUCE (fewer per attempt)
  "enableSpawning": true,
  "minimumDistanceBetweenEntities": 8.0, // Default: 8.0 — keep or increase to 10
  "spawningZoneDiameter": 8,           // Default: 8 — keep
  "spawningZoneHeight": 16,            // Default: 16 — keep
  "minimumSpawningZoneDistanceFromPlayer": 16.0,  // Default: 16 — keep
  "maximumSpawningZoneDistanceFromPlayer": 64.0   // Default: 64 — keep
}
```

### 3b. Despawner Config (from CobblemonConfig.kt source)
```json
{
  "despawnerNearDistance": 32,     // Default: 32 — Pokémon within 32 blocks are safe
  "despawnerFarDistance": 96,      // Default: 96 — Pokémon beyond 96 blocks despawn
  "despawnerMinAgeTicks": 600,     // Default: 600 (30 sec) — minimum age before despawn eligible
  "despawnerMaxAgeTicks": 3600     // Default: 3600 (3 min) — maximum age before forced despawn
}
```
**Tuning:** For high-player servers, consider:
- `despawnerFarDistance: 80` (despawn sooner)
- `despawnerMaxAgeTicks: 2400` (2 min instead of 3 min)

### 3c. Storage Config
```json
{
  "pokemonSaveIntervalSeconds": 30,   // Default: 30 — reduce to 60 if disk I/O is an issue
  "storageFormat": "nbt"              // Default: nbt — MongoDB option available for high-scale
}
```

### 3d. Pasture Config (if using pasture blocks)
```json
{
  "defaultPasturedPokemonLimit": 16,  // Default: 16
  "pastureBlockUpdateTicks": 40,       // Default: 40 — increase to 60-80 to reduce tick load
  "pastureMaxWanderDistance": 32,      // Default: 32
  "pastureMaxPerChunk": 4             // Default: 4 — reduce to 2 if pastures cause lag
}
```

---

## 4. Already Installed Mods — Config Audit Required

### CRITICAL: These mods ship with BAD defaults that cause lag

| Mod | Config File | Bad Default | Recommended Fix |
|-----|------------|-------------|-----------------|
| **ThreadTweak** | `threadtweak.json` | Main thread priority = **1** (minimum) | → **5** (normal) |
| **ServerCore** | `servercore/config.yml` | `activation-range: enabled: false` | → **true** |
| **ServerCore** | `servercore/config.yml` | Monster `spawn-interval: 1` | → **4** |
| **PacketFixer** | `packetfixer.json` | `allSizesUnlimited: true` | → **false** |

### Other Installed Mods to Verify
- **Lithium** — Should be fine with defaults, but check `config/lithium.toml` for any overrides
- **FerriteCore** — Memory deduplication, usually fine
- **EntityCulling** — Check that it's not culling Cobblemon entities too aggressively
- **Krypton** — Network optimization, usually fine
- **ModernFix** — Already configured with user overrides ✅

---

## 5. Network Optimization for 30+ Players

### 5a. Krypton (already installed)
- Network stack optimization — should be fine with defaults
- Verify `config/krypton.toml` has compression enabled

### 5b. PulseNet (NEW — 3,590 downloads)
- **What it does:** Replaces per-packet network flushes with smart batching
- **Impact:** Reduces kernel syscall overhead and CPU usage
- **Compatibility:** Works alongside Krypton
- **⚠️ WARNING:** Requires Minecraft 26.1+ / Java 25+ — NOT compatible with 1.21.1
- **Status:** NOT RECOMMENDED for this server version

### 5c. Network Tuning (server.properties)
```properties
network-compression-threshold=256   # Default; lower to 64 if bandwidth allows
rate-limit=0                        # Already set ✅
```

### 5d. Entity Broadcast Range
- `entity-broadcast-range-percentage=100` → reduce to **80** if entity tracking lag
- This reduces how far entities are sent to clients, reducing packet volume
- Trade-off: Pokémon may pop in/out at shorter distances

---

## 6. Disk I/O Optimization

### 6a. Chunk Writes
```properties
sync-chunk-writes=false   # ⚠️ CRITICAL — async chunk saves
```

### 6b. Storage Format
- Cobblemon supports NBT (default) and MongoDB
- For 30 players: NBT is fine
- For 100+ players: Consider MongoDB for concurrent saves

### 6c. Save Interval
```json
"pokemonSaveIntervalSeconds": 60   // Increase from 30 to 60 (less frequent saves)
```

### 6d. Disk Recommendations
- Use SSD for server files (world + config)
- If on HDD: Consider moving world to SSD
- `pause-when-empty-seconds=60` saves writes when no players online

---

## 7. GC Tuning for G1GC with 20GB Heap

### Current Flags (from skill references)
```bash
-Xms8G -Xmx16G -XX:+UseG1GC -XX:+ParallelRefProcEnabled -XX:MaxGCPauseMillis=200 \
-XX:+UnlockExperimentalVMOptions -XX:+DisableExplicitGC -XX:+AlwaysPreTouch \
-XX:G1NewSizePercent=30 -XX:G1MaxNewSizePercent=40 -XX:G1HeapRegionSize=8M \
-XX:G1ReservePercent=20 -XX:G1HeapWastePercent=5 -XX:G1MixedGCCountTarget=4 \
-XX:InitiatingHeapOccupancyPercent=15 -XX:G1MixedGCLiveThresholdPercent=90 \
-XX:G1RSetUpdatingPauseTimePercent=5 -XX:SurvivorRatio=32 \
-XX:+PerfDisableSharedMem -XX:MaxTenuringThreshold=1
```

### Recommended Adjustments for 20GB Heap
```bash
# Scale region size for larger heap
-XX:G1HeapRegionSize=16M          # Was 8M; for 20GB heap, 16M is better

# More aggressive young gen for Pokémon entity churn
-XX:G1NewSizePercent=35           # Was 30; more young gen = less promotion
-XX:G1MaxNewSizePercent=50        # Was 40; allow more headroom

# Faster concurrent cycle initiation
-XX:InitiatingHeapOccupancyPercent=20  # Was 15; for 20GB, 20% is fine

# ZGC Alternative (JDK 21+)
# If pauses are still problematic, consider ZGC:
# -XX:+UseZGC -XX:+ZGenerational
# ZGC has sub-millisecond pauses but slightly higher throughput cost
```

### Monitoring GC
```bash
# Add to JVM flags for GC logging:
-Xlog:gc*:file=logs/gc.log:time,uptime,level,tags:filecount=5,filesize=50M

# Or for G1-specific details:
-XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xlog:gc*:gc.log:time,uptime,level,tags:filecount=5,filesize=50M
```

---

## 8. Chunk Loading Strategies

### 8a. C2ME (DISABLED — log spam issue)
- Was flooding logs with 48K+ "Unknown registry key" errors
- **Recommendation:** Wait for fixed version; the log spam kills performance
- If re-enabled: `globalExecutorParallelism = 8`, `midTickChunkTasksInterval = 50000`

### 8b. Chunky (Pre-generation)
- Already installed ✅
- **CRITICAL:** Pause Chunky during gameplay: `chunky pause`
- Pre-generation causes massive lag spikes — do it during off-hours only
- For 60k×60k world: Consider pre-generating in stages

### 8c. View/Simulation Distance
```
simulation-distance=4    # Only 4 chunks ticked — REDUCE if lag persists to 3
view-distance=8          # 8 chunks visible — could reduce to 7
```
**Rule:** `simulation-distance` should be ≤ `view-distance`. Lower simulation = less ticking.

### 8d. FTB Chunks (Player-loaded chunks)
- Players can force-load chunks via FTB Chunks claims
- **Limit:** 512 chunks per player (hard client-side cap)
- Consider reducing claim limits for lower ranks to prevent excessive chunk loading

### 8e. World Border
- Already set to 60k×60k ✅
- This limits chunk generation — good for performance
- Ensure Nether border is also set (8x smaller = 7500×7500)

---

## 9. Entity Processing Optimizations (Pokemon-Specific)

### 9a. The Core Problem
Cobblemon Pokémon are custom entities with:
- Complex AI (pathfinding, movement goals)
- Battle system (Showdown engine)
- Model/animation rendering
- Per-chunk spawning system
- Each Pokémon = 1 entity with full tick cost

### 9b. Entity Count Management
**Current:** 93 "Can't keep up" events = entity overload

**Solution stack:**
1. **CobbleLagClear** — Periodic cleanup of excess wild Pokémon
2. **CobblemonChunkmenager** — Per-chunk budget enforcement + AI throttling
3. **Cobblemon despawner** — Reduce `despawnerFarDistance` and `despawnerMaxAgeTicks`
4. **Reduce `pokemonPerChunk`** from 1.0 → 0.3
5. **Reduce `maximumSpawnsPerPass`** from 8 → 1

### 9c. Vanilla Mob Optimization
- **ServerCore activation-range** — MUST be enabled (fix from audit)
- **ServerCore spawn-interval** — Set to 4 (not 1)
- **LetMeDespawn** (already installed?) — Allows mobs with picked-up items to despawn
  - Requires: Almanac library mod
  - 21M+ downloads — very popular
  - Config: `config/letmedespawn.json`
  - Commands: `/letmedespawn add <mobName>` to exclude specific mobs

### 9d. Entity Culling
- **EntityCulling** (already installed) — Skips rendering entities behind walls
- Verify it's not culling Cobblemon entities too aggressively
- Check config for entity type whitelist/blacklist

### 9e. Maximum Spawn Attempts Warning
- "Maximum spawn attempts reached" = chunk has too many queued spawns
- Fix: Reduce `pokemonPerChunk` and `ticksBetweenSpawnAttempts`
- This is a density control mechanism — reducing spawn rates helps

---

## 10. Memory Management with 329 Mods

### 10a. Current Memory Setup
- RAM: 16GB allocated (Xms8G Xmx16G) — from skill reference
- Total system: 32GB
- Docker was consuming 6.8GB (now fixed) ✅

### 10b. Memory Optimization Mods
| Mod | Purpose | Status |
|-----|---------|--------|
| **FerriteCore** | Memory deduplication | ✅ Installed |
| **Saturn** | Memory leak fixes + GC optimization | ⚠️ NOT installed — consider adding |
| **MemoryLeakFix** | Fixes specific memory leaks | ⚠️ NOT installed — 35M downloads, highly recommended |
| **ModernFix** | All-in-one perf + memory | ✅ Installed with custom config |

### 10c. Saturn (NEW — 5M downloads)
- Optimizes memory usage across the board
- Fixes in-game memory leaks
- Reduces GC heap pressure
- Works on both client and server
- **Download:** `https://modrinth.com/mod/saturn`
- **Recommendation:** ADD THIS MOD

### 10d. MemoryLeakFix (NEW — 35M downloads)
- Fixes specific memory leaks in Minecraft
- Both client and server
- Very high download count = proven stable
- **Download:** `https://modrinth.com/mod/memoryleakfix`
- **Recommendation:** ADD THIS MOD

### 10e. JVM Memory Flags
```bash
# For 32GB system with 20GB heap target:
-Xms10G -Xmx20G

# Or keep current 16GB if stability is good:
-Xms8G -Xmx16G

# Key: -XX:+AlwaysPreTouch ensures heap is committed at startup
# Avoids latency spikes from OS memory allocation during gameplay
```

### 10f. ModernFix Config (already set)
```properties
mixin.perf.cache_strongholds=true
mixin.bugfix.missing_block_entities=true
mixin.perf.deduplicate_climate_parameters=true
mixin.perf.deduplicate_location=true
mixin.feature.cause_lag_by_disabling_threads=false
mixin.perf.thread_priorities=true
```

---

## 11. Additional Optimization Mods to Consider

### High Priority (Server-side, proven)
| Mod | Slug | Downloads | Why |
|-----|------|-----------|-----|
| **CobbleLagClear** | `cobblelagclear` | 7,449 | Periodic Pokémon + item cleanup |
| **CobblemonChunkmenager** | `cobblemonchunkmenager` | 2,155 | Per-chunk entity budget + AI throttle |
| **Saturn** | `saturn` | 5,074,738 | Memory leak fixes + GC optimization |
| **MemoryLeakFix** | `memoryleakfix` | 35,733,984 | Specific memory leak fixes |
| **More Culling** | `moreculling` | 59,110,480 | Advanced entity/block culling |
| **LazyDFU** | `lazydfu` | 14,004,304 | Faster boot (deferred init) |
| **LetMeDespawn** | `lmd` | 21,331,762 | Mobs with items can despawn |
| **Starlight** | `starlight` | 15,206,158 | Rewrites light engine for perf |

### Medium Priority (Client-side)
| Mod | Slug | Downloads | Why |
|-----|------|-----------|-----|
| **CobbleBoost** | `cobbleboost` | 3,221 | Cobblemon rendering optimization |
| **More Culling** | `moreculling` | 59M | Advanced culling |
| **Entity Distance** | `entity-distance` | 9,470 | Adjustable entity render distance |

### NOT Recommended (Version Incompatible)
| Mod | Reason |
|-----|--------|
| **PulseNet** | Requires Minecraft 26.1+ / Java 25+ |
| **DimensionalThreading** | No Fabric 1.21.1 version available |

---

## 12. RCT (Random Cobblemon Trainers) Optimization

### Already Configured
```toml
globalSpawnChance = 0.35        # Reduced from 0.55
spawnIntervalTicks = 900        # Increased from 600
spawnIntervalTicksMaximum = 4800 # Increased from 2400
maxTrainersPerPlayer = 4        # Reduced from 6
maxTrainersTotal = 60           # Keep
```

### Additional Tuning
- RCT trainers are entities too — each one = tick cost
- If lag persists: reduce `maxTrainersTotal` to 40
- Consider `spawnIntervalTicks = 1200` (check every 60 sec instead of 45)

---

## 13. Raid Dens Optimization

### Already Configured
```json5
"dimension_spawn_rate": {"minecraft:overworld": 1200}  // Increased from 800
```

### Additional Tuning
- Raid dens spawn Pokémon entities too
- If too many dens: increase to 1600
- Check `cobblemonraiddens` config for max dens per chunk

---

## 14. JVM Flags — Complete Recommended Set

```bash
"D:/SERVIDOR/jdk-21.0.4+7/bin/java.exe" \
-Xms10G -Xmx20G \
-XX:+UseG1GC \
-XX:+ParallelRefProcEnabled \
-XX:MaxGCPauseMillis=200 \
-XX:+UnlockExperimentalVMOptions \
-XX:+DisableExplicitGC \
-XX:+AlwaysPreTouch \
-XX:G1NewSizePercent=35 \
-XX:G1MaxNewSizePercent=50 \
-XX:G1HeapRegionSize=16M \
-XX:G1ReservePercent=20 \
-XX:G1HeapWastePercent=5 \
-XX:G1MixedGCCountTarget=4 \
-XX:InitiatingHeapOccupancyPercent=20 \
-XX:G1MixedGCLiveThresholdPercent=90 \
-XX:G1RSetUpdatingPauseTimePercent=5 \
-XX:SurvivorRatio=32 \
-XX:+PerfDisableSharedMem \
-XX:MaxTenuringThreshold=1 \
-Dusing.aikars.flags=https://mcflags.emc.gs \
-Daikars.new.flags=true \
-Xlog:gc*:file=logs/gc.log:time,uptime,level,tags:filecount=5,filesize=50M \
--enable-native-access=ALL-UNNAMED \
--add-opens=java.base/java.lang=ALL-UNNAMED \
--add-opens=java.base/java.nio=ALL-UNNAMED \
--add-opens=java.base/sun.misc=ALL-UNNAMED \
-jar fabric-server.jar nogui
```

---

## 15. Implementation Priority Order

### Phase 1: Quick Wins (Do First)
1. ✅ Set `sync-chunk-writes=false` in server.properties
2. ✅ Audit ThreadTweak, ServerCore, PacketFixer configs (fix bad defaults)
3. ✅ Reduce `pokemonPerChunk` to 0.3
4. ✅ Reduce `maximumSpawnsPerPass` to 1
5. ✅ Increase `ticksBetweenSpawnAttempts` to 30

### Phase 2: New Mods (Install One at a Time)
1. Install **CobbleLagClear** → configure cleanup interval
2. Install **CobblemonChunkmenager** → configure entity budget
3. Install **Saturn** → memory optimization
4. Install **MemoryLeakFix** → leak fixes
5. Install **More Culling** → advanced culling
6. Install **LazyDFU** → faster boot
7. Install **LetMeDespawn** + **Almanac** → mob despawn fix

### Phase 3: JVM Tuning
1. Update JVM flags to scaled 20GB heap
2. Add GC logging
3. Monitor for 24-48 hours
4. Adjust if needed

### Phase 4: Monitoring
1. Use **spark** profiler to identify remaining hotspots
2. Monitor `logs/gc.log` for GC pause patterns
3. Check "Can't keep up" frequency after changes
4. Use CobblemonChunkmenager's `/ccm heatmap` to visualize entity density

---

## 16. Summary of Expected Impact

| Optimization | Expected Lag Reduction | Risk |
|-------------|----------------------|------|
| CobbleLagClear periodic cleanup | **HIGH** — removes excess entities | Low (safe rules) |
| CobblemonChunkmenager budget | **HIGH** — prevents entity buildup | Low (migration strategy) |
| Reduce pokemonPerChunk | **HIGH** — fewer spawns overall | Medium (less Pokémon visible) |
| sync-chunk-writes=false | **MEDIUM** — async saves | Low |
| ThreadTweak priority fix | **MEDIUM** — server thread gets CPU | None |
| ServerCore activation-range | **MEDIUM** — distant mobs don't tick | Low |
| Saturn + MemoryLeakFix | **MEDIUM** — prevents OOM | None |
| More Culling | **LOW-MEDIUM** — rendering optimization | Low |
| JVM flag scaling | **LOW-MEDIUM** — better GC behavior | Low |

**Combined expected result:** "Can't keep up" events should drop from 93/night to <10, with average lag under 1 second.

---

## Files Created
- `C:\Users\cjtr\.hermes\plans\cobbleverse-optimization-report.md` — This comprehensive report

## Sources Consulted
- CobblemonConfig.kt source code (GitLab: cable-mc/cobblemon)
- Modrinth API (CobbleLagClear, CobblemonChunkmenager, CobbleBoost, Saturn, MemoryLeakFix, LetMeDespawn, MoreCulling, PulseNet, ModernFix, Starlight, LazyDFU)
- YouHaveTrouble's Minecraft Optimization Guide (GitHub)
- Minecraft Wiki server.properties documentation
- Existing skill references (performance-mod-config-audit.md, jvm-flags.md, cobbleverse-current-state.md)
- Cobblemon Wiki (limited — server page was empty)
