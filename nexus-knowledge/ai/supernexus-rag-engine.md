# supernexus-rag-engine

RAG ENGINE: src/core/rag_engine.py. RAGEngine con SQLite + Ollama embeddings (nomic-embed-text). DB: ~/.nexus/rag_index.db. Metodos: index_file(path, chunk_size) indexa documentos. search(query, top_k) busqueda semantica por cosine similarity. index_directory(dir) indexa directorio completo. Chunking: 800 chars por chunk, overlap 100. Embeddings via Ollama /api/embeddings. Uso: indexar repomix dumps, PLAN.md, autopsias, documentacion. OpenCode usa rag_index y rag_search via MCP para buscar en el codebase indexado.
