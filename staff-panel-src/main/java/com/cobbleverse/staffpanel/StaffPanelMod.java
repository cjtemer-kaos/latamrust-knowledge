package com.cobbleverse.staffpanel;

import com.cobbleverse.staffpanel.commands.StaffCommands;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StaffPanelMod implements ModInitializer {
    public static final String MOD_ID = "staffpanel";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("CobbleVerse Staff Panel initializing...");

        // Registrar comandos de apertura (/staff, /staffpanel, /sp)
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            StaffCommands.register(dispatcher);
        });

        // NOTA: el jail lo gestiona el mod "Jail Logic" (jailmod) — el panel
        // solo dispara sus comandos via executeWithPrefix. Sin sistemas propios.

        LOGGER.info("CobbleVerse Staff Panel loaded!");
    }
}
