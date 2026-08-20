# Direct: Proceso repetible fix NaoriDZN_ bucle

Category: Server
Tags: fix, naori, bucle, spawn, repetible
Created: 2026-08-20T01:18:30.030291

---

PROCESO REPETIBLE fix NaoriDZN_ bug bucle (2026-08-20 01:1x): NaoriDZN_ (uuid 71dfa362) volvio a quedar en bucle. DIAGNOSTICO: loguea en pos VALIDA (-481,56,2626) pero MUERE inmediatamente al entrar ('was blown up by Creeper') y el sistema muerte/grave (LenientDeath+Universal-Graves grave 40) lo desconecta -> bucle de entrar/morir/disconnect. (NO es la Pos en void como la vez anterior). FIX aplicado con server parado: mover playerdata Pos a spawn seguro (877,74,1059, zona protegida sin creeper) y limpiar respawn. Backup: playerdata/71dfa362....dat.bak-loopfix-051754. IMPORTANTE: el bucle puede repetirse si NaoriDZN_ vuelve a esa zona letal o a su tumba (grave 40); si pasa de nuevo la solucion es reubicar el spawn a zona segura. Pendiente: iniciar server y verificar. NUNCA tocar server sin permiso.
