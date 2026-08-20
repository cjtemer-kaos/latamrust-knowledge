# db-query-optimization

Query optimization: 1) EXPLAIN ANALYZE for plans. 2) Avoid SELECT *. 3) JOIN order: smaller table first. 4) Subqueries → JOINs when possible. 5) EXISTS > IN for large sets. 6) Window functions > correlated subqueries. 7) Materialized views. 8) Partitioning for time-series.
