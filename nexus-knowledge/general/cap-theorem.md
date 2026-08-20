# cap-theorem

CAP theorem: 1) Consistency: every read gets latest write. 2) Availability: every request gets response. 3) Partition tolerance: system works despite network failures. Trade-off: pick 2. CP systems: MongoDB, HBase. AP systems: Cassandra, DynamoDB. CA systems: single-node Postgres (no partition tolerance).
