# grok-build-hooks

GROK HOOKS: Runtime hook system for pre/post tool execution. File discovery: find hook scripts in .grok/hooks/ directories. Child process execution with timeout. Fail-open pattern: try/catch with logging (hooks never crash the agent). Hot-reload via filesystem watcher. Hooks: pre-tool, post-tool, on-error, on-session-start, on-session-end. PATRONES PARA NEXUS: pathlib.Path.glob() for hook discovery, subprocess.run() with timeout, fail-open pattern, hot-reload via file watcher.
