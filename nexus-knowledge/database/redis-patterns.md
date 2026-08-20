# redis-patterns

Redis patterns: 1) Cache: SET key value EX 3600. 2) Session: HSET session:123 name 'John'. 3) Rate limiting: INCR + EXPIRE. 4) Pub/Sub: PUBLISH channel message / SUBSCRIBE channel. 5) Queue: LPUSH + BRPOP. 6) Leaderboard: ZADD + ZRANK. 7) Rate limit sliding window: sorted sets.
