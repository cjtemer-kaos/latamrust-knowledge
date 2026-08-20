# event-sourcing

Event sourcing: 1) Store events, not state. 2) State = fold events. 3) Events are immutable. 4) Replay: rebuild state from events. 5) Temporal queries: state at time T. 6) Audit trail: complete history. 7) Snapshots: periodic state saves. Tech: EventStoreDB, Kafka.
