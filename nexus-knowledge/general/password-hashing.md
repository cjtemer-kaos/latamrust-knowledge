# password-hashing

Password hashing seguro: import bcrypt. hashed = bcrypt.hashpw(password.encode(), bcrypt.gensalt(rounds=12)). if bcrypt.checkpw(password.encode(), hashed): login_ok(). NUNCA: MD5, SHA1, SHA256 sin salt. SIEMPRE: bcrypt, argon2, scrypt. bcrypt: auto-salt, factor de trabajo. argon2: memory-hard, resistente GPU.
