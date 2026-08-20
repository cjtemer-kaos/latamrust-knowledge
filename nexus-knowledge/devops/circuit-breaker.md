# circuit-breaker

Circuit breaker pattern: 1) Closed: normal, track failures. 2) Open: too many failures, block calls. 3) Half-open: test with limited calls. Implementation: failure_threshold=5, recovery_timeout=30s. Libraries: pybreaker (Python), Hystrix (Java), opossum (Node).
