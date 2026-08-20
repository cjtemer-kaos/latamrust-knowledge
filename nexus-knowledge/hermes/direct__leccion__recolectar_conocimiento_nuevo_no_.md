# Direct: Leccion: recolectar conocimiento NUEVO no duplicar

Category: Hermes
Tags: leccion, opencode, recoleccion, duplicado
Created: 2026-08-20T13:32:44.113840

---

CORRECCION DIRECTOR (2026-08-20, usuario señalo el bug): opencode estaba consultando NEXUS primero y luego duplicando lo que ya existia, en vez de recolectar conocimiento NUEVO. La idea NO es duplicar lo que hay, es llenar huecos: buscar en INTERNET el conocimiento que NEXUS NO tiene. PROCESO ANTI-DUPLICADO obligatorio para toda delegacion de recoleccion: 1) consultar NEXUS /api/memory/search para saber que existe; 2) buscar en internet SOLO los huecos/informacion nueva; 3) guardar SOLO novedades (3-6 items); 4) no re-confirmar ni duplicar; si no hay nada nuevo, guardar 0. Aplicado al cron y al steer de tanda 3. La meta es AUMENTAR cobertura, no duplicar.
