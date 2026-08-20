# rest-best-practices

REST best practices: 1) Nouns for resources (/users, not /getUsers). 2) Plural nouns. 3) Versioning: /v1/users. 4) Filtering: ?status=active&sort=-created_at. 5) Pagination: ?page=2&limit=20 or cursor-based. 6) HATEOAS: links in responses. 7) Idempotency keys for POST.
