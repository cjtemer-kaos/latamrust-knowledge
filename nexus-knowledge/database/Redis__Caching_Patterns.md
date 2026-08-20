# Redis & Caching Patterns

Redis: in-memory data structure store (string, hash, list, set, sorted set, streams, bitmaps, HyperLogLog, Geospatial). Cache patterns: Cache-Aside (app checks cache, misses -> DB), Read-Through (cache loads from DB), Write-Through (write to cache + DB synchronously), Write-Behind (write to cache, async DB). Expiry strategies: TTL (absolute), LRU eviction (allkeys-lru, volatile-lru). Persistence: RDB (snapshot), AOF (append-only log), Redis Cluster (sharding + replication). Sentinel for HA. Pub/Sub for real-time messaging. Lua scripts for atomic operations.
