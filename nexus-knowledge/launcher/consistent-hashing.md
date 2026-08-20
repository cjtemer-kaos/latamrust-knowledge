# consistent-hashing

Consistent hashing: virtual nodes on ring. When node added/removed, only nearby keys move. Used in: Redis Cluster, DynamoDB, CDNs. Implementation: hash(key) → position on ring. Find next node clockwise. Virtual nodes: each physical node has multiple positions for better distribution.
