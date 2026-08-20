# db-mvcc

MVCC (Multi-Version Concurrency Control): 1) Each transaction sees snapshot. 2) No read locks. 3) Write creates new version. 4) Vacuum: clean old versions. 5) Isolation levels: READ COMMITTED, REPEATABLE READ, SERIALIZABLE. 6) Deadlock detection. 7) Row-level locking.
