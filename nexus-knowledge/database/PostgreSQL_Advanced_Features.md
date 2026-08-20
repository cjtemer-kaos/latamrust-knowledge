# PostgreSQL Advanced Features

PostgreSQL advanced: CTE (WITH clause, recursive queries for tree/graph), window functions (ROW_NUMBER, RANK, LAG/LEAD over PARTITION BY), JSONB (index with GIN, path operators @>, ->, ->>), full-text search (tsvector/tsquery with GIN index), extensions (PostGIS, pgvector, pg_stat_statements, uuid-ossp, pg_cron). VACUUM: autovacuum configured by workload, prevents XID wraparound. COPY for bulk load. LISTEN/NOTIFY for async notifications. Row-level security (RLS) for multi-tenant. Logical replication for selective data sync.
