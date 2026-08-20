# sql-subquery-cheat

Subqueries: SELECT * FROM t1 WHERE col IN (SELECT col FROM t2). SELECT * FROM t1 WHERE EXISTS (SELECT 1 FROM t2 WHERE t1.id = t2.fk).
