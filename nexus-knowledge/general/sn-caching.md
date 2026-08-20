# sn-caching

Caching strategies: 1) In-memory: functools.lru_cache. 2) Redis: SET key value EX ttl. 3) HTTP cache: Cache-Control headers. 4) Memoization: @cached_property. 5) CDN: CloudFront. 6) Database: materialized views. 7) Application: invalidate on write.
