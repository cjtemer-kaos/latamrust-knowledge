# py-dataclasses

dataclasses: @dataclass class Point: x: float; y: float. Genera __init__, __repr__, __eq__ automáticamente. field(default_factory=list) para mutables. frozen=True para inmutables. slots=True para memoria. from dataclasses import asdict, astuple.
