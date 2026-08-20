# supernexus-director-fix-cerebro-primero

FIX 2026-07-24: Director iba directo a web research sin consultar cerebro. FIX: agregar paso de brain recall ANTES de _research_and_persist(). Flujo corregido: 1) CEREBRO obtener_conocimientos() + filtro keywords. 2) Si hay match: sintetiza LLM con conocimiento. 3) Si NO: web research + sage guarda. BUG original: linea 568 director.py solo tenia if not _is_action and not _is_conversational -> web. FALTA: paso de busqueda en cerebro.
