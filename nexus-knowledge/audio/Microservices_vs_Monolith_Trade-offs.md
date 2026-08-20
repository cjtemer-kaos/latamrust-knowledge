# Microservices vs Monolith Trade-offs

Monolith: simpler dev/debug, single deploy, shared DB, fast internal calls. Best for startups, <10 devs, bounded domains. Microservices: independent deploy/scale, tech diversity, fault isolation, team autonomy. Costs: network latency, distributed txns (Saga pattern), eventual consistency, observability overhead. Strategy: start monolith, extract bounded contexts incrementally via Strangler Fig pattern. Don't start with microservices.
