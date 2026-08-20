# Direct: fabric-kotlin-mods/event-handling

Category: Minecraft-modding
Tags: fabric, 1.21.1, events, callbacks, fabric-api
Created: 2026-08-20T13:54:44.452399

---

FABRIC 1.21.1 EVENT HANDLING PATTERN: Fabric API events are instances of net.fabricmc.fabric.api.event.Event holding callbacks; register with event.register(callback). Naming convention EventNameCallback. Key groups: PlayerBlockBreakEvents.BEFORE/AFTER/CANCELED (server-side logic, Canceled fires if a listener cancels BEFORE); ServerLifecycleEvents.SERVER_STARTING/STARTED/STOPPING/STOPPED + BEFORE_SAVE/AFTER_SAVE + datapack reload hooks; ServerTickEvents.START_TICK/END_TICK; ServerPlayerEvents; ServerEntityEvents; ClientTickEvents (client). InteractionResult cooperation pattern: callbacks return ActionResult.PASS to let other mod listeners run, or SUCCESS/CONSUME/FAIL. Fabric API 0.104.0+1.21.1 exposes 166 events. Events often REPLACE mixins for common hooks - prefer events over raw mixins for compatibility.
