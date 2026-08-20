# gap2-episodic-memory-6-types

EPISODIC MEMORY IMPLEMENTADO: src/brain/episodic_memory.py. EpisodicMemory SQLite-backed (episodes.db). Episode dataclass: what/why/where/learned + 6 categories (WORK/EPISODIC/SEMANTIC/PROCEDURAL/SENSORY/SCRATCHPAD) + importance/access_count/tags. FTS5 full-text search. upsert_by_topic (engram pattern - update same topic instead of append). decay_importance (forgetting curve). Singleton pattern. Inspirado en lethe (DMN background cognition) y engram (topic key upserts).
