# migration-strategies

Database migrations: 1) Versionadas (Alembic, Flyway). 2) Up + down migrations. 3) Backward compatible: rename column → add new → migrate data → drop old. 4) Zero-downtime: expand-contract pattern. 5) Feature flags para switch. 6) Backup antes de migrar. 7) Test migrations en staging. 8) Rollback plan documentado.
