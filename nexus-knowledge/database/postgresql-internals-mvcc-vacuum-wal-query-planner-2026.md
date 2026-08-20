# postgresql-internals-mvcc-vacuum-wal-query-planner-2026

# PostgreSQL internals: 1) MVCC (Multi-Version Concurrency Control): each row (tuple) has hidden colum

PostgreSQL internals: 1) MVCC (Multi-Version Concurrency Control): each row (tuple) has hidden columns xmin (creating XID) and xmax (deleting/updating XID). UPDATE = logical delete (set xmax on old tuple) + insert new tuple. Readers never block writers. Snapshot isolation: each tx sees DB as of star

## Temas


## Codigo

