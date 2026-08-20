# autopsia_integration_fase_c

Fase C completada. 3 módulos integrados desde autopsias:

1. **auto_commit.py** (patrón Aider) — src/core/auto_commit.py
   - Auto-commit con mensajes generados por Director (GRATIS)
   - Attribution via Co-authored-by trailer
   - API: POST /api/autocommit, GET /api/autocommit/recent

2. **log_curator.py** (patrón DCLM/Dolma) — src/core/log_curator.py
   - Dedup hash-based (BFF pattern) para logs/memorias/conversaciones
   - Quality scoring (repetición, ratio alfa, garbage patterns)
   - Cleanup automático de hashes viejos
   - API: POST /api/curator/curate, GET /api/curator/stats, POST /api/curator/cleanup

3. **muon_trainer.py** (patrón modded-nanogpt) — src/core/muon_trainer.py
   - Orchestrador de fine-tuning en PC2 con Muon optimizer
   - Prep de datasets desde logs NEXUS con dedup integrada
   - API: POST /api/trainer/prepare, POST /api/trainer/launch, GET /api/trainer/jobs

9 endpoints nuevos en server.py. Backend necesita restart.
