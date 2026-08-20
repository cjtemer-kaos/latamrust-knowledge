# api-versioning

API versioning: 1) URL path: /api/v1/users. 2) Header: Accept-Version: v2. 3) Query param: /users?version=2. Mejor: URL path (más explícito, cache-friendly). Estrategia: versionar solo breaking changes. Deprecation: 6 meses. Migration guide por versión.
