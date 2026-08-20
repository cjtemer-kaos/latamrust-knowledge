# dp-observer

Observer Pattern: notificar múltiples suscriptores. Python: class EventEmitter: def __init__(self): self._listeners = {}; def on(self, event, fn): self._listeners.setdefault(event, []).append(fn); def emit(self, event, *a): [fn(*a) for fn in self._listeners.get(event, [])]. Usos: event systems, UI reactivity, pub/sub.
