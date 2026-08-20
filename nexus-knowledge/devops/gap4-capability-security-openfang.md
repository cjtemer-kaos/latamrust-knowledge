# gap4-capability-security-openfang

CAPABILITY SECURITY IMPLEMENTADO: src/core/capability_security.py. CapabilityManager con 15 capabilities: READ_FILES, WRITE_FILES, EXECUTE_SHELL, NETWORK_ACCESS, BROWSER_CONTROL, VOICE_CONTROL, MEMORY_WRITE, MEMORY_DELETE, GEMA_SPAWN, GEMA_KILL, MODEL_SWITCH, CONFIG_CHANGE, REDIS_PUBSUB, DANGEROUS_ACTIONS, ADMIN. CapabilitySet: immutable, time-limited, per-gema. SecurityPolicy: default (READ+WRITE allowed), restricted (EXEC/NET/DANGEROUS/CONFIG need approval). Audit log de todos los cambios. Inspirado en openfang capability-based security.
