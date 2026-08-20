# Direct: FIX definitivo NaoriDZN_ spawn seguro

Category: Server
Tags: fix, naori, spawn, loop, definitivo
Created: 2026-08-20T01:28:31.413862

---

FIX DEFINITIVO NaoriDZN_ (2026-08-20 ~01:28): el playerdata se sobrescribia con pos -480,56,2626 (zona del creeper que lo mataba y crasheaba su cliente a los 3s de entrar -> loop 'entra bien pero se desconecta a los 3s' sin error de server, cliente crashea). FIX con server parado: Pos y Spawn a 877,74,1059 (spawn seguro LATAMRUST, protegido, sin creeper), LastDeathLocation eliminado. Backup: playerdata/71dfa362...dat.bak-definitivo-052808. Asi entra seguro y si muere vuelve al spawn (no al punto del bug). NOTA: /ld restore NaoriDZN_ fallaba con <--[HERE] porque NaoriDZN_ no estaba online estable (LenientDeath requiere jugador online/parseo). Sus items estan en la tumba #40/tumba o en LenientDeath backup. Pendiente: iniciar server, verificar que entra sin crashear, y si hace falta recuperar items.
