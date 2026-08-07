package com.cobbleverse.staffpanel.client;

import net.fabricmc.api.ClientModInitializer;

public class StaffPanelClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Staff panel is inventory-based (vanilla compatible)
        // No client-side code needed — the vanilla GUI renders it
    }
}
