package com.mikadev;

import java.util.List;
import java.util.stream.Collectors;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;

import com.mikadev.packets.ModListPayload;
import com.mikadev.packets.RequestModsPayload;

/**
 * Client-side verification logic.
 * When the server requests mod list, client collects and sends it.
 */
public class AnticheatClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Anticheat.LOGGER.info("[LatamRust] Client initializing...");

        ClientPlayNetworking.registerGlobalReceiver(RequestModsPayload.ID, (payload, context) -> {
            Anticheat.LOGGER.info("[LatamRust] Server requested mod list, collecting...");

            List<String> mods = FabricLoader.getInstance().getAllMods()
                    .stream()
                    .map(ModContainer::getMetadata)
                    .map(meta -> meta.getId())
                    .collect(Collectors.toList());

            Anticheat.LOGGER.info("[LatamRust] Sending {} mods to server", mods.size());
            ClientPlayNetworking.send(new ModListPayload(mods));
        });

        Anticheat.LOGGER.info("[LatamRust] Client initialized");
    }
}
