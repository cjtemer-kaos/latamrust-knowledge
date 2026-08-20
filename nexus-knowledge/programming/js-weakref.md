# js-weakref

WeakRef & FinalizationRegistry: WeakRef(obj) holds weak reference. GC can collect. registry.register(obj, token) for cleanup. Use cases: caches, DOM node tracking, resource management. Don't rely on finalization timing.
