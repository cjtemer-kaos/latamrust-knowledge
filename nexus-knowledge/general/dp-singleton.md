# dp-singleton

Singleton Pattern: una instancia única global. Python: class Singleton: _instance = None; def __new__(cls): if cls._instance is None: cls._instance = super().__new__(cls). Usos: configuración global, connection pool, cache compartido. Anti-pattern si impide testing o crea acoplamiento. Alternativa: dependency injection.
