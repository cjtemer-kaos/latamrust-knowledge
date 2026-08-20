# grok-build-sandbox

GROK SANDBOX: Landlock (Linux) / Seatbelt (macOS) sandboxing. Profiles: nono (full restrict), relaxed, custom. Network policy via seccomp per child. Singleton state via OnceLock. PATRONES PARA NEXUS: bubblewrap (bwrap) or docker --read-only for sandboxing, iptables rules or bubblewrap --net flags for network policy, module-level _initialized = False + Lock for singleton.
