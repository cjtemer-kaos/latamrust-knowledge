package com.mikadev;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mikadev.packets.ModListPayload;
import com.mikadev.packets.RequestModsPayload;

public class Anticheat implements ModInitializer {
    public static final String MOD_ID = "latamrust-core";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final Identifier MOD_LIST_CHANNEL = Identifier.of(MOD_ID, "mod_list");
    public static final Identifier REQUEST_MODS_CHANNEL = Identifier.of(MOD_ID, "request_mods");

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing LatamRust Core v2.0.0");

        // Register payload types for both directions
        // C2S: Client sends mod list to server
        PayloadTypeRegistry.playC2S().register(ModListPayload.ID, ModListPayload.CODEC);
        // S2C: Server requests mod list from client
        PayloadTypeRegistry.playS2C().register(RequestModsPayload.ID, RequestModsPayload.CODEC);

        LOGGER.info("LatamRust Core network channels registered");
    }
}
