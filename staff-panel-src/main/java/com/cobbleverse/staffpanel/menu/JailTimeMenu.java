package com.cobbleverse.staffpanel.menu;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
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

import java.util.List;

/**
 * Selector de duración para /jail imprison <jugador> <segundos> <razón>.
 * Elige tiempo → ejecuta el comando del Jail Logic mod directamente.
 */
public class JailTimeMenu extends GenericContainerScreenHandler {
    // Durations in seconds: 10m, 30m, 1h, 3h, 12h, 1d, 7d
    private static final int[] DURATIONS = {600, 1800, 3600, 10800, 43200, 86400, 604800};
    private static final String[] DURATION_NAMES = {"10 min", "30 min", "1 hora", "3 horas", "12 horas", "1 día", "7 días"};

    private final ServerPlayerEntity staffPlayer;
    private final String targetName;

    // Client constructor
    public JailTimeMenu(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, null, "");
    }

    // Server constructor
    public JailTimeMenu(int syncId, PlayerInventory playerInventory,
                        ServerPlayerEntity player, String targetName) {
        super(ScreenHandlerType.GENERIC_9X3, syncId, playerInventory,
                buildContainer(targetName), 3);
        this.staffPlayer = player;
        this.targetName = targetName;
    }

    private static SimpleInventory buildContainer(String targetName) {
        SimpleInventory container = new SimpleInventory(27);

        // Título
        container.setStack(4, createInfoItem(Items.IRON_BARS,
                "§b§lCarcel — " + targetName, "§7Elige la duración"));

        // Duraciones (fila 1, slots 10-16)
        for (int i = 0; i < DURATIONS.length; i++) {
            container.setStack(10 + i, createInfoItem(Items.CLOCK,
                    "§e§l" + DURATION_NAMES[i], "§7Enviar a " + targetName + " por " + DURATION_NAMES[i]));
        }

        // Volver (fila 2, slot 18)
        container.setStack(18, createInfoItem(Items.ARROW, "§c§lVolver", "§7Panel principal"));

        // Relleno
        for (int i = 0; i < 27; i++) {
            if (container.getStack(i).isEmpty()) {
                container.setStack(i, createInfoItem(Items.GRAY_STAINED_GLASS_PANE, "§8", ""));
            }
        }
        return container;
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
    public void onSlotClick(int slotIndex, int button, SlotActionType actionType, PlayerEntity player) {
        if (staffPlayer == null) {
            super.onSlotClick(slotIndex, button, actionType, player);
            return;
        }

        // Volver
        if (slotIndex == 18) {
            StaffActions.openPanel(staffPlayer);
            return;
        }

        // Duración elegida (slots 10-16)
        if (slotIndex >= 10 && slotIndex <= 16) {
            int durationIndex = slotIndex - 10;
            if (durationIndex < DURATIONS.length) {
                int seconds = DURATIONS[durationIndex];
                // /jail imprison <jugador> <segundos> <razón> — Jail Logic mod
                StaffActions.executeAction(staffPlayer, "jail", targetName, String.valueOf(seconds));
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
