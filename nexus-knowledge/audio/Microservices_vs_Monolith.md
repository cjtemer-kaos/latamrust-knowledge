# Microservices vs Monolith

Monolith: simpler dev/debug, single deploy, shared memory/DB, faster inter-module calls. Good for startups, <10 devs, bounded domains. Microservices: independent deploy/scaling, tech diversity, fault isolation, team autonomy. Cost: network latency, distributed transactions (Saga pattern), eventual consistency, observability overhead, debugging across services. Best for large teams, scaling sub-services independently, polyglot persistence. Pattern: start monolith ? extract bounded contexts as microservices incrementally. Strangler Fig pattern for migration.
