# dp-strategy

Strategy Pattern: intercambiar algoritmos en runtime. Python: pass function as argument. Ejemplo: def process(data, strategy=serialize_json): return strategy(data). Ventaja: Open/Closed Principle. Usos: validación, serialización, sorting, caching, retry policies.
