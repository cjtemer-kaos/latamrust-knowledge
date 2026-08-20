# Apache Kafka Deep Dive

Kafka: distributed commit log. Topics (category) -> Partitions (ordered, immutable, replicated) -> Offsets (position). Producers: acks=0 (fire&forget), 1 (leader ack), all (full ISR ack). Consumers: consumer groups (each partition to one consumer in group). Exactly-once semantics: idempotent producer + transactions. Retention: time/size based, compacted topics (keep latest per key). ZooKeeper (legacy) vs KRaft (metadata in Kafka, 2.8+). Schema Registry: Avro/Protobuf/JSON Schema evolution. Kafka Connect: source/sink connectors. Replication factor: 3 for production.
