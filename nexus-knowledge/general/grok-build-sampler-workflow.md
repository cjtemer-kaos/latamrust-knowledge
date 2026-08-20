# grok-build-sampler-workflow

GROK SAMPLER: 3-layer API (HTTP client -> Stream transforms -> Actor handle). Actor pattern with cancellation/retry. Typed event model (SamplingEvent on channel). Error classification with doom loop detection. GROK WORKFLOW: DAG-based workflow engine with safety budget constants (hard limits on cost, parallelism, host calls). Journal-based audit trail. Validation before execution. Host abstraction (IoC pattern). PATRONES PARA NEXUS: safety budget en workflow, journal audit trail para debug, IoC para host abstraction, doom loop detection en streaming.
