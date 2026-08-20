# Sistema de memoria - arquitectura, reglas, recuperacion de sesiones

SISTEMA DE MEMORIA - Arquitectura y uso correcto

3 CAPAS DE MEMORIA:
1. Hermes Memory Local (~/.hermes/memories/) - LIMITADA a 2200 chars
2. SuperNEXUS Brain (D:\...\supernexus-v2\brain) - ILIMITADA
3. Session Search (state.db) - Busqueda FTS5 en sesiones pasadas

REGLA DE ORO: Usar SuperNEXUS brain como store PRIMARIO
- brain_remember/importance=10 para info critica
- brain_remember/importance=8 para info importante
- brain_recall para recuperar contexto
- NO usar memory local para info que crezca

CUANDO USAR CADA UNA:
- Memory local: preferencias del usuario, correcciones rapidas
- SuperNEXUS brain: contexto de proyectos, soluciones, configuraciones
- Session Search: recuperar conversaciones pasadas (@session:profile/id)

RECUPERACION DE SESION CRASH:
1. session_search para encontrar la sesion
2. scroll para extraer contexto clave
3. brain_remember con importance=10
4. Usuario abre /new y recupera via brain_recall

ERROR COMUN: 'Context length exceeded'
- Causa: auxiliary compression usando modelo local (128K)
- Fix: auxiliary.compression con modelo EXTERNO + context_length: 200000
