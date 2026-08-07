package com.cobbleverse.staffpanel;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;

public class StaffPanelMenuProvider implements NamedScreenHandlerFactory {
    private final Text title = Text.literal("§c§lStaff Panel");

    @Override
    public Text getDisplayName() {
        return title;
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new StaffPanelMenu(syncId, playerInventory);
    }
}
