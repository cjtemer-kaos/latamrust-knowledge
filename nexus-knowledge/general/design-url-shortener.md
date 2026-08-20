# design-url-shortener

URL shortener: 1) API: POST /shorten (url) → short_url. GET /:id → redirect. 2) Storage: DB (id → url mapping). 3) ID generation: base62 counter, hash + collision check. 4) Caching: Redis for hot URLs. 5) Analytics: click tracking. 6) Scaling: sharding by ID. 7) Custom domains.
