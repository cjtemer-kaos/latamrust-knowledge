# arch-hexagonal

Hexagonal Architecture (Ports & Adapters): 1) Core domain expone ports (interfaces). 2) Adapters implementan ports (DB adapter, web adapter). 3) Easy testing: mock adapters. 4) Switch DB/UI sin cambiar core. Ventaja sobre Clean: más intuitivo. Ejemplo: UserService (core) ← RepositoryPort (interface) ← PostgresAdapter.
