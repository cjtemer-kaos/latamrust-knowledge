# supernexus_v2_test_all_features_fix

# supernexus-v2: 27 errors en test_all_features.py arreglados (2026-06-06)

2. **`tests/test_all_features.py`**: Añadido `__test__ = False` a `TestResult` class local (evita que pytest intente colectarla como test class)

## Temas
- `tests/conftest.py` (NUEVO)**: Define `TestResult` class + `@pytest.fixture` `r` que:
- Yielda un TestResult fresco por test (function-scoped)
- Imprime cada sub-check para visibilidad
- Raise AssertionError si `r.failed > 0` (pytest reporta falla real, no silent pass)
- `tests/test_all_features.py`**: Añadido `__test__ = False` a `TestResult` class local (evita que pytest intente colectarla como test class)
- `pyproject.toml`**: Añadido `asyncio_mode = "auto"` para auto-marcar 5 funciones `async def` sin `@pytest.mark.asyncio` explícito
- Línea 767: `bus.subscribe("message", handler)` → `await bus.subscribe(...)` (asyncio warning: "coroutine 'EventBus.subscribe' was never awaited")
- Línea 797: `status.get("identity", {}).get("name") == "DirectorNexus"` → `"NEXUS IA"` (IDENTITY["name"] real es "NEXUS IA" en director.py:254)

## Codigo

