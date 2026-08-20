# CQRS & Event Sourcing

CQRS: separate read and write models -- commands mutate, queries read (possibly different data stores or schemas). Benefits: optimize read/write independently, scale separately. Event Sourcing: store all state changes as event sequence; current state = fold over events. Benefits: full audit trail, time travel, temporal queries. Costs: event store complexity, eventual consistency, schema evolution. Often used together but each can exist standalone.
