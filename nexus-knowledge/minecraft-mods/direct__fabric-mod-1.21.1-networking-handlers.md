# Direct: fabric-mod-1.21.1-networking-handlers

Category: Minecraft-mods
Tags: direct-learned
Created: 2026-08-20T13:25:27.977603

---

Handlers de networking Fabric 1.21.1 (net.fabricmc.fabric.api.networking.v1): server -> ServerPlayNetworking.registerGlobalReceiver(CustomPayload.Id, PlayPayloadHandler) registra receptor serverbound para todas las conexiones (el payload debe estar registrado antes en PayloadTypeRegistry.playC2S(); retorna false si ya hay handler). El handler corre en el thread del server (thread-safe). Enviar al cliente: ServerPlayNetworking.send(ServerPlayerEntity, payload); ServerPlayNetworking.canSend(player, type) comprueba soporte del cliente. Client -> ClientPlayNetworking.registerGlobalReceiver en el entrypoint client (ClientModInitializer) para recibir del server y ClientPlayNetworking.send(payload) para enviar al server.
