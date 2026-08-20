# Recuperacion de sesiones crasheadas - flujo, session_search, brain_recall

RECUPERACION DE SESIONES CRASHEADAS

PROBLEMA: Sesion supera context_length (128K-200K tokens) -> Hermes muere

FLUJO DE RECUPERACION:
1. session_search(query="palabras clave") para encontrar la sesion
2. session_search(session_id="ID", around_message_id=N) para scroll
3. Identificar contexto clave de la sesion
4. brain_remember(content="contexto", importance=10) para guardar
5. Usuario abre /new en Hermes
6. brain_recall(query="topic") para recuperar contexto

EJEMPLO DE USO:
session_search(query="latamrust launcher anticheat", sort="newest")
-> Encontrar sesion -> scroll -> extraer contexto
-> brain_remember(content="Contexto completo: ...", importance=10)
-> /new -> brain_recall(query="latamrust")

BRAIN RECALL - BUSQUEDA:
- brain_recall(query="palabras clave") - busca por topic/content
- brain_recall() - lista todo
- Retorna: topic, content, source, date, importance

BRAIN REMEMBER - ALMACENAMIENTO:
- brain_remember(content="texto", topic="titulo", importance=N)
- importance: 10=critico, 8=importante, 5=normal
- El brain es ILIMITADO - usar sin miedo
