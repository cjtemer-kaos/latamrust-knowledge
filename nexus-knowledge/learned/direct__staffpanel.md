# Direct: staffpanel

Category: Learned
Tags: staff-panel, latamrust, fabric-mod
Created: 2026-08-17T23:15:35.368438

---

Staff panel = GUI que dispara comandos EXISTENTES de mods (jailmod, Paradigm), NUNCA sistemas propios. Jail real: /jail imprison <p> <seg> <razon> y /unjail <p> (comando raiz, NO 'unjail player' que no existe). El JailSystem propio (teleport 0,-60,0 al void) causa que jugadores queden atrapados en el void y aviso residual [Carcel] en memoria. Tiempo de jail es en SEGUNDOS (la GUI pasa minutos*60). La celda debe quedar centrada en el cubo Yawp carcel (732,80,1002) para que el flag exec-command Denied bloquee /home y /spawn (si esta en el borde z=1000 el preso sale con 1 bloque). Capturar razon en chat con ServerMessageEvents.ALLOW_CHAT_MESSAGE (devuelve boolean; return false = consume). PITFALL critico: en onChat verificar el jailPending ANTES que pending, o el jail no se ejecuta y se aplica un mute accidental. Mute permanente de jugador offline se revoca en la DB de Paradigm config/paradigm/data/paradigm.db tabla moderation_punishment_ledger (marcar revoked_at_ms). Unmute = /unmute <p>. Quitar warning = /paradigm punishment revoke warn <p>. Historial = /paradigm punishment history <p>.
