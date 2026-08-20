# cqrs-pattern

CQRS: Command Query Responsibility Segregation. 1) Commands: write operations (create, update, delete). 2) Queries: read operations. 3) Separate models: write model optimized for writes, read model for reads. 4) Event sourcing: store commands as events. 5) Projections: build read models from events.
