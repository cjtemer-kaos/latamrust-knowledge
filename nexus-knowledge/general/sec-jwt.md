# sec-jwt

JWT security: 1) Header.Payload.Signature. 2) alg: HS256 (symmetric) or RS256 (asymmetric). 3) Never use 'none' algorithm. 4) Validate all claims (exp, iss, aud). 5) Short expiry (15min). 6) Refresh tokens with rotation. 7) Blacklist for logout.
