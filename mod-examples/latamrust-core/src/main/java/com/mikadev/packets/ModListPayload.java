package com.mikadev.packets;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

import com.mikadev.Anticheat;

/**
 * C2S (Client → Server) payload carrying the client's mod list.
 * Sent by the client in response to a RequestModsPayload from the server.
 *
 * IMPORTANTE (2026-08-17): payload de UN SOLO campo (mods), compatible con el
 * cliente actual. NO agregar loaderVersion/clientType (rompe compatibilidad con
 * el cliente distribuido).
 */
public record ModListPayload(List<String> mods) implements CustomPayload {

    public static final CustomPayload.Id<ModListPayload> ID =
            new CustomPayload.Id<>(Anticheat.MOD_LIST_CHANNEL);

    public static final PacketCodec<PacketByteBuf, ModListPayload> CODEC = new PacketCodec<>() {
        @Override
        public void encode(PacketByteBuf buf, ModListPayload payload) {
            buf.writeVarInt(payload.mods().size());
            for (String mod : payload.mods()) {
                buf.writeString(mod);
            }
        }
        @Override
        public ModListPayload decode(PacketByteBuf buf) {
            int size = buf.readVarInt();
            List<String> mods = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                mods.add(buf.readString());
            }
            return new ModListPayload(mods);
        }
    };

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
