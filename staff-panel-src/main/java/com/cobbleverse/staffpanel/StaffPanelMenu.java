package com.cobbleverse.staffpanel;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class StaffPanelMenu extends GenericContainerScreenHandler {
    private final SimpleInventory panelInventory;

    public StaffPanelMenu(int syncId, PlayerInventory playerInventory) {
        super(ScreenHandlerType.GENERIC_9X3, syncId, playerInventory, new SimpleInventory(27), 3);
        this.panelInventory = (SimpleInventory) this.getInventory();
        
        // Initialize panel items
        initPanel();
    }

    private void initPanel() {
        // Row 0: Player management buttons
        panelInventory.setStack(0, createButton(Items.RED_WOOL, "§c§lBanear", "§7Banear a un jugador"));
        panelInventory.setStack(1, createButton(Items.ORANGE_WOOL, "§6§lMutear", "§7Mutear a un jugador"));
        panelInventory.setStack(2, createButton(Items.YELLOW_WOOL, "§e§lAdvertir", "§7Dar advertencia"));
        panelInventory.setStack(3, createButton(Items.LIME_WOOL, "§a§lExpulsar", "§7Expulsar jugador"));
        panelInventory.setStack(4, createButton(Items.LIGHT_BLUE_WOOL, "§b§lCongelar", "§7Congelar jugador"));
        
        // Row 1: Server tools
        panelInventory.setStack(9, createButton(Items.PAPER, "§d§lLista Jugadores", "§7Ver jugadores online"));
        panelInventory.setStack(10, createButton(Items.CHEST, "§1§lVer Inventario", "§7Ver inventario de jugador"));
        panelInventory.setStack(11, createButton(Items.DIAMOND_SWORD, "§5§lGamemode", "§7Cambiar modo de juego"));
        
        // Fill empty slots with glass panes
        for (int i = 0; i < 27; i++) {
            if (panelInventory.getStack(i).isEmpty()) {
                panelInventory.setStack(i, createButton(Items.GRAY_STAINED_GLASS_PANE, "§8", ""));
            }
        }
    }

    private ItemStack createButton(net.minecraft.item.Item item, String name, String lore) {
        ItemStack stack = new ItemStack(item);
        stack.set(net.minecraft.component.DataComponentTypes.CUSTOM_NAME, Text.literal(name));
        if (lore != null && !lore.isEmpty()) {
            stack.set(net.minecraft.component.DataComponentTypes.LORE, 
                new net.minecraft.component.type.LoreComponent(List.of(Text.literal(lore))));
        }
        return stack;
    }

    @Override
    public void onSlotClick(int slotIndex, int button, SlotActionType actionType, PlayerEntity player) {
        if (slotIndex >= 0 && slotIndex < 27) {
            // Handle panel button click - send command to server
            handleButtonClick(slotIndex, player);
            return;
        }
        super.onSlotClick(slotIndex, button, actionType, player);
    }

    private void handleButtonClick(int slotIndex, PlayerEntity player) {
        if (!(player instanceof net.minecraft.server.network.ServerPlayerEntity serverPlayer)) {
            return;
        }
        
        var commandSource = serverPlayer.getCommandSource();
        
        switch (slotIndex) {
            case 0 -> commandSource.getServer().getCommandManager().executeWithPrefix(commandSource, "banhammer ban @s Razón");
            case 1 -> commandSource.getServer().getCommandManager().executeWithPrefix(commandSource, "banhammer mute @s");
            case 2 -> commandSource.getServer().getCommandManager().executeWithPrefix(commandSource, "warn @s");
            case 3 -> commandSource.getServer().getCommandManager().executeWithPrefix(commandSource, "kick @s Expulsado por staff");
            case 4 -> commandSource.getServer().getCommandManager().executeWithPrefix(commandSource, "function jail:freeze @s");
            case 9 -> commandSource.getServer().getCommandManager().executeWithPrefix(commandSource, "list");
            case 10 -> commandSource.getServer().getCommandManager().executeWithPrefix(commandSource, "invsee @s");
            case 11 -> commandSource.getServer().getCommandManager().executeWithPrefix(commandSource, "gamemode creative @s");
        }
        
        // Close the menu after click - use ServerPlayerEntity method
        serverPlayer.closeHandledScreen();
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}