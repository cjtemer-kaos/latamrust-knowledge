# Direct: fabric-mod-1.21.1-networking-payloads-c2s-s2c

Category: Minecraft-mods
Tags: direct-learned
Created: 2026-08-20T13:25:21.187536

---

Networking Fabric 1.21.1 (sistema de payloads): se define un record que implementa CustomPayload con (1) CustomPayload.Type (id = ResourceLocation.fromNamespaceAndPath(MOD_ID, name)), (2) PacketCodec (yarn: PacketCodec/StreamCodec via ByteBufCodecs) y (3) override type(). Se registra en AMBOS lados antes de usarlo, normalmente en el init: PayloadTypeRegistry.playC2S().register(id, codec) para client->server y PayloadTypeRegistry.playS2C().register(id, codec) para server->client; existen configurationC2S()/configurationS2C() para la fase de configuracion. En yarn los paquetes son net.minecraft.network.packet.c2s.common.CustomPayloadC2SPacket y s2c.common.CustomPayloadS2CPacket. Requiere fabric-api (modulo fabric-networking-api-v1).
