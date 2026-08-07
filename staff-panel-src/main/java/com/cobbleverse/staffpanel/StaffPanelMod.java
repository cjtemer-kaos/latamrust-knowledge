package com.cobbleverse.staffpanel;

import com.cobbleverse.staffpanel.commands.StaffCommands;
import com.cobbleverse.staffpanel.menu.JailSystem;
import com.cobbleverse.staffpanel.menu.ModMenuTypes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class StaffPanelMod implements ModInitializer {
    public static final String MOD_ID = "staffpanel";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    private static File configDir;

    @Override
    public void onInitialize() {
        LOGGER.info("CobbleVerse Staff Panel initializing...");

        // Register menu types
        ModMenuTypes.register();

        // Register commands
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            StaffCommands.register(dispatcher);
        });

        // Register server tick event for jail boundary checking
        ServerTickEvents.END_SERVER_TICK.register(this::onServerTick);

        LOGGER.info("CobbleVerse Staff Panel loaded!");
    }
    
    private void onServerTick(MinecraftServer server) {
        // Set config dir on first tick
        if (configDir == null) {
            configDir = new File(server.getRunDirectory().toFile(), "config");
            JailSystem.loadConfig(configDir);
            JailSystem.loadData(configDir);
        }
        
        // Check jail boundaries every 20 ticks (1 second)
        if (server.getTicks() % 20 == 0) {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                JailSystem.checkJailBoundaries(player, configDir);
            }
        }
    }
    
    public static File getConfigDir() {
        return configDir;
    }
}
