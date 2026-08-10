package com.mikadev.packets;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

import com.mikadev.Anticheat;

/**
 * S2C (Server → Client) payload requesting the client to send its mod list.
 * The server sends this when a player joins the PLAY phase.
 */
public record RequestModsPayload() implements CustomPayload {

    public static final CustomPayload.Id<RequestModsPayload> ID =
            new CustomPayload.Id<>(Anticheat.REQUEST_MODS_CHANNEL);

    public static final PacketCodec<PacketByteBuf, RequestModsPayload> CODEC =
            PacketCodec.of(
                (buf, payload) -> { /* no data to encode */ },
                buf -> new RequestModsPayload()
            );

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
