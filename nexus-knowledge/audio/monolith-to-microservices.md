# monolith-to-microservices

Migration strategy: 1) Strangler fig: gradually extract. 2) Domain-driven: identify bounded contexts. 3) Anti-corruption layer: translate between old/new. 4) Feature flags: toggle new services. 5) Data migration: dual write → sync → cutover. 6) Testing: parallel running.
