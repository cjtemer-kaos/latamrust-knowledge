package com.cobbleverse.staffpanel.menu;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;

import java.util.List;

/**
 * Player selection menu — shows online players as clickable heads.
 * Action determines what happens when a player is clicked.
 */
public class PlayerSelectMenu extends GenericContainerScreenHandler {
    private final ServerPlayerEntity staffPlayer;
    private final String action;
    private final String[] playerNames;

    // Client constructor
    public PlayerSelectMenu(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, null, "ban", new String[0]);
    }

    // Server constructor
    public PlayerSelectMenu(int syncId, PlayerInventory playerInventory,
                            ServerPlayerEntity player, String action, String[] playerNames) {
        super(ScreenHandlerType.GENERIC_9X6, syncId, playerInventory,
                buildContainer(playerNames, action), 6);
        this.staffPlayer = player;
        this.action = action;
        this.playerNames = playerNames;
    }

    private static SimpleInventory buildContainer(String[] names, String action) {
        SimpleInventory container = new SimpleInventory(54);

        // Title item
        String actionName = getActionName(action);
        container.setStack(0, createInfoItem(Items.NAME_TAG,
                "§e§lAccion: " + actionName, "§7Selecciona un jugador de la lista"));

        // Player heads (slots 9-44 = rows 1-4)
        for (int i = 0; i < Math.min(names.length, 36); i++) {
            int slot = 9 + i;
            container.setStack(slot, createInfoItem(Items.PLAYER_HEAD,
                    "§f" + names[i], "§7Click para " + actionName.toLowerCase()));
        }

        // Fill remaining with glass
        for (int i = 0; i < 54; i++) {
            if (container.getStack(i).isEmpty()) {
                container.setStack(i, createInfoItem(Items.GRAY_STAINED_GLASS_PANE, "§8", ""));
            }
        }

        // Back button (slot 49 = row 5, center)
        container.setStack(49, createInfoItem(Items.ARROW, "§c§lVolver", "§7Volver al panel principal"));

        return container;
    }

    private static String getActionName(String action) {
        return switch (action) {
            case "ban" -> "Banear";
            case "mute" -> "Mutear";
            case "warn" -> "Advertir";
            case "kick" -> "Expulsar";
            case "jail" -> "Carcel";
            case "teleport" -> "Teletransportar";
            case "gamemode" -> "Gamemode";
            case "give" -> "Dar Items";
            case "info" -> "Info Jugador";
            default -> action;
        };
    }

    private static ItemStack createInfoItem(net.minecraft.item.Item item, String name, String lore) {
        ItemStack stack = new ItemStack(item);
        stack.set(DataComponentTypes.CUSTOM_NAME, Text.literal(name));
        if (lore != null && !lore.isEmpty()) {
            stack.set(DataComponentTypes.LORE, new LoreComponent(List.of(Text.literal(lore))));
        }
        return stack;
    }

    @Override
    public void onSlotClick(int slotIndex, int button,
                            SlotActionType actionType, PlayerEntity player) {
        if (staffPlayer == null) {
            super.onSlotClick(slotIndex, button, actionType, player);
            return;
        }

        // Back button
        if (slotIndex == 49) {
            StaffActions.openPanel(staffPlayer);
            return;
        }

        // Player head clicked (slots 9-44)
        if (slotIndex >= 9 && slotIndex < 45) {
            int playerIndex = slotIndex - 9;
            if (playerIndex < playerNames.length) {
                String targetName = playerNames[playerIndex];
                StaffActions.executeAction(staffPlayer, action, targetName);
            }
            return;
        }

        super.onSlotClick(slotIndex, button, actionType, player);
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
