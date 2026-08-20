# Direct: paradigm_restart

Category: Learned
Tags: paradigm, restart, autorestart
Created: 2026-08-17T23:16:16.748474

---

Restart automatico de Paradigm: config/paradigm/restarts.json. Usar restartType:"Realtime" + realTimeInterval:["04:00","16:00"] (hora de Montevideo UTC-3, el JVM del server la respeta). restartEnable:true en main.json. Recargar en vivo SIN reiniciar el server: /paradigm reload restart (NOTA: es 'restart' singular, 'paradigm reload restarts' da 'Unknown config'). El restart emite un stop server-side que MCSS detecta y relanza el server en ~9-10s (comportamiento verificado). No choca: las scheduledTasks de MCSS estan vacias (MCSS no programa restarts propios, no hay doble responsable).
