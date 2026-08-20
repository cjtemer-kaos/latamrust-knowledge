# arch-microservices

Microservices: 1) Cada servicio = deploy independiente. 2) Communication: sync (REST/gRPC) o async (queues). 3) Data isolation: cada servicio su DB. 4) Service mesh (Istio) para networking. 5) API Gateway para routing. 6) Circuit breaker para fault tolerance. 7) Distributed tracing. Cuándo usar: >50 devs, deploy frecuente, escalado independiente.
