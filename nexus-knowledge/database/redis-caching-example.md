# redis-caching-example

Redis caching: import redis; r = redis.Redis(); def get_user(id): cache_key = f'user:{id}'; cached = r.get(cache_key); if cached: return json.loads(cached); user = db.query(id); r.setex(cache_key, 3600, json.dumps(user)); return user.
