# rest-pagination

REST pagination: 1) Offset: ?offset=20&limit=20 (simple, can skip). 2) Cursor: ?cursor=abc123&limit=20 (consistent, no skips). 3) Keyset: ?created_after=2024-01-01&limit=20 (efficient). Response: { data: [...], pagination: { total: 100, hasMore: true, next_cursor: 'xyz' } }.
