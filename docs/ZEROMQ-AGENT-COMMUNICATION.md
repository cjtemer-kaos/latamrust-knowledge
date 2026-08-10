# ZeroMQ — Comunicación entre Agentes IA en LAN

> **Fecha**: 2026-08-10
> **Objetivo**: Comunicación real-time entre PC1 (Hermes) y PC2 (Hermes) vía LAN
> **Solución**: ZeroMQ (pyzmq) — sin broker, peer-to-peer, sub-millisecond

## ¿Por qué ZeroMQ?

| Solución | Latencia | Broker | Complejidad |
|----------|----------|--------|-------------|
| **ZeroMQ** | 10-500μs | No | Baja |
| NATS | ~1ms | Sí | Media |
| WebSocket | ~5ms | Sí | Media |
| gRPC | 1-5ms | No | Alta |
| Redis | 100μs-5ms | Sí | Media |

**ZeroMQ gana** porque:
- Sin servidor externo (peer-to-peer)
- Sub-millisecond en LAN
- asyncio nativo
- Solo `pip install pyzmq`

## Instalación

```bash
pip install pyzmq
```

## Arquitectura

```
PC1 (Hermes Agent)              PC2 (Hermes Agent)
┌─────────────────┐            ┌─────────────────┐
│  DEALER socket  │◄──────────►│  ROUTER socket  │
│  PUB socket     │◄──────────►│  SUB socket     │
└────────┬────────┘            └────────┬────────┘
         │                              │
         └────────── LAN ──────────────┘
              (192.168.1.16)
```

## Patrones de Comunicación

### 1. REQ/REP (Comandos)
```python
# PC1 (Client)
import zmq
context = zmq.Context()
socket = context.socket(zmq.DEALER)
socket.connect("tcp://192.168.1.16:5555")
socket.send_json({"command": "execute", "task": "check_server_status"})
response = socket.recv_json()

# PC2 (Server)
context = zmq.Context()
socket = context.socket(zmq.ROUTER)
socket.bind("tcp://*:5555")
message = socket.recv_json()
# Process command...
socket.send_json({"status": "ok", "result": "..."})
```

### 2. PUB/SUB (Heartbeats & Events)
```python
# PC1 (Publisher)
context = zmq.Context()
pub_socket = context.socket(zmq.PUB)
pub_socket.bind("tcp://*:5556")
pub_socket.send_json({"type": "heartbeat", "agent": "pc1", "status": "online"})

# PC2 (Subscriber)
context = zmq.Context()
sub_socket = context.socket(zmq.SUB)
sub_socket.connect("tcp://192.168.1.16:5556")
sub_socket.setsockopt_string(zmq.SUBSCRIBE, "")
```

### 3. DEALER/ROUTER (Bidireccional Async)
```python
# Ambos agentes usan DEALER para comunicación asíncrona
context = zmq.Context()
socket = context.socket(zmq.DEALER)
socket.connect("tcp://192.168.1.16:5557")
socket.setsockopt(zmq.IDENTITY, b"pc1-agent")
socket.send_json({"to": "pc2-agent", "message": "Tarea completada"})
```

## Benchmark LAN

| Tamaño mensaje | Latencia promedio |
|----------------|-------------------|
| 64 bytes | 12μs |
| 1 KB | 45μs |
| 10 KB | 180μs |
| 100 KB | 1.2ms |
| 1 MB | 8.5ms |

## Puertos Recomendados

| Puerto | Uso |
|--------|-----|
| 5555 | REQ/REP (comandos) |
| 5556 | PUB/SUB (heartbeats) |
| 5557 | DEALER/ROUTER (async) |

## Próximos Pasos

1. Implementar servidor ZeroMQ en PC2
2. Implementar cliente ZeroMQ en PC1
3. Integrar con Hermes Agent via MCP
4. Testear latencia real en LAN
5. Agregar reconexión automática
6. Documentar API

## Fuentes

- ZeroMQ: https://zeromq.org/
- pyzmq: https://github.com/zeromq/pyzmq
- Benchmark: https://stackoverflow.com/questions/22545939/zeromq-performance
