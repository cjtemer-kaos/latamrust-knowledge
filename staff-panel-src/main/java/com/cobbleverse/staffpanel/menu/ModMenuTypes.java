package com.cobbleverse.staffpanel.menu;

import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.util.Identifier;

public class ModMenuTypes {
    public static final ScreenHandlerType<StaffPanelMenu> STAFF_PANEL =
            new ScreenHandlerType<>(StaffPanelMenu::new, FeatureFlags.VANILLA_FEATURES);

    public static final ScreenHandlerType<PlayerSelectMenu> PLAYER_SELECT =
            new ScreenHandlerType<>(PlayerSelectMenu::new, FeatureFlags.VANILLA_FEATURES);

    public static void register() {
        Registry.register(Registries.SCREEN_HANDLER,
                Identifier.of("staffpanel", "staff_panel"), STAFF_PANEL);
        Registry.register(Registries.SCREEN_HANDLER,
                Identifier.of("staffpanel", "player_select"), PLAYER_SELECT);
    }
}
