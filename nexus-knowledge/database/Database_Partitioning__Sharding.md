# Database Partitioning & Sharding

Horizontal partitioning (sharding): split rows across servers by key (hash range, consistent hashing). Vertical partitioning: split columns, hot vs cold data. PostgreSQL partitioning: RANGE (by date), LIST (by region), HASH. Partition pruning: query planner skips non-matching partitions. Sharding strategies: application-level (complex), proxy-based (Vitess, Citus), DB-native (CockroachDB). Challenges: cross-shard queries, distributed transactions (2PC/XA), resharding, hot spots. Prefer partitioning before sharding.
