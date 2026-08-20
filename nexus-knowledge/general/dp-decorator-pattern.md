# dp-decorator-pattern

Decorator Pattern (DP): agregar comportamiento dinámicamente.不同于Python decorators. class Logger: def __init__(self, wrappee): self._wrappee = wrappee; def __getattr__(self, name): return getattr(self._wrappee, name). Ejemplo: LoggingWriter(EncryptingWriter(file)). Stack de comportamientos.
