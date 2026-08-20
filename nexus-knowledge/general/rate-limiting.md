# rate-limiting

Rate limiting: 1) Token bucket: tokens added at fixed rate. 2) Sliding window: count requests in window. 3) Fixed window: count in time period. 4) Leaky bucket: process at fixed rate. Redis: INCR + EXPIRE. Headers: X-RateLimit-Remaining, X-RateLimit-Reset.
