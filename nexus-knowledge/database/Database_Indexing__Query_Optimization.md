# Database Indexing & Query Optimization

B-tree index: balance between reads/writes, good for range/equality. Covering index: includes all columns needed by query (no table lookup). Composite index: column order matters -- most selective first. Partial index (WHERE clause): smaller, faster. Index-only scan: fastest, all data in index. EXPLAIN ANALYZE: read plan, seq scan vs index scan vs bitmap scan. Tips: index foreign keys, watch cardinality, avoid functions on indexed columns (WHERE UPPER(name) = 'X' skips index), use GIN for JSONB/arrays, BRIN for large ordered tables.
