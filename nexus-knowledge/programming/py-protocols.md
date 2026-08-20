# py-protocols

Protocols (PEP 544): Structural typing. from typing import Protocol. class Printable(Protocol): def print(self) -> None: ... Cualquier clase con print() satisface el protocol sin heredar. Más flexible que ABC. Python 3.8+.
