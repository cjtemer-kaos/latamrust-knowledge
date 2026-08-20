# Clean/Hexagonal/Onion Architecture

Clean Architecture (Bob Martin): rings inward -- Entities, Use Cases, Interface Adapters, Frameworks. Dependency Rule: source deps point inward. Hexagonal (Ports & Adapters): core domain with ports (interfaces) + adapters (implementations). Inbound adapters (REST/gRPC/CLI) call core; outbound adapters (DB/queue/email) implement core ports. Onion: Domain at center, Application ring, Infrastructure outer. All goal: testable, infrastructure-independent core.
