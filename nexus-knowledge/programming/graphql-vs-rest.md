# graphql-vs-rest

GraphQL vs REST:
REST: /api/users/123, /api/users/123/posts. Over/under fetching. Versioned endpoints. Simple caching.
GraphQL: POST /graphql { user(id:123) { name, posts { title } } }. Exact data. Single endpoint. No versioning. Complex caching.
Cuándo usar GraphQL: múltiples clientes, datos relacionados, mobile apps.
Cuándo REST: simple CRUD, caching importante, quick start.
