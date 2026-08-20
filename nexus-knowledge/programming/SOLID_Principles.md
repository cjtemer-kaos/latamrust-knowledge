# SOLID Principles

S: Single Responsibility -- one reason to change per class. O: Open/Closed -- open for extension, closed for modification. L: Liskov Substitution -- subtypes substitutable for base types (preconditions not strengthened, postconditions not weakened). I: Interface Segregation -- don't depend on unused interfaces, split fat interfaces. D: Dependency Inversion -- depend on abstractions not concretions, inject dependencies. Example: pass DB interface to service instead of hardcoding SQLAlchemy.
