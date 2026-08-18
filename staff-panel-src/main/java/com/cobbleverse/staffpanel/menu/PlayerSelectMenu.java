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
 * Selección de jugador — muestra jugadores online como cabezas clickeables.
 * 6 filas: 4 filas de jugadores (36) + fila de navegación (volver, páginas).
 *
 * Flujo: hub → [acción] → jugador → confirmación (si destructiva) → comando del mod.
 */
public class PlayerSelectMenu extends GenericContainerScreenHandler {
    private static final int PLAYER_SLOTS_START = 9;   // fila 1
    private static final int PLAYER_SLOTS_END = 44;    // fila 4 (36 jugadores por página)
    private static final int PAGE_SIZE = 36;

    private final ServerPlayerEntity staffPlayer;
    private final String action;
    private final String[] allPlayerNames;
    private final int page;

    // Client constructor
    public PlayerSelectMenu(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, null, "ban", new String[0], 0);
    }

    // Server constructor (página 0)
    public PlayerSelectMenu(int syncId, PlayerInventory playerInventory,
                            ServerPlayerEntity player, String action, String[] playerNames) {
        this(syncId, playerInventory, player, action, playerNames, 0);
    }

    // Server constructor (con página)
    public PlayerSelectMenu(int syncId, PlayerInventory playerInventory,
                            ServerPlayerEntity player, String action, String[] playerNames, int page) {
        super(ScreenHandlerType.GENERIC_9X6, syncId, playerInventory,
                buildContainer(playerNames, action, page), 6);
        this.staffPlayer = player;
        this.action = action;
        this.allPlayerNames = playerNames;
        this.page = page;
    }

    private static SimpleInventory buildContainer(String[] names, String action, int page) {
        SimpleInventory container = new SimpleInventory(54);
        String actionName = StaffActions.getActionName(action);

        // Título / info
        container.setStack(0, createInfoItem(Items.NAME_TAG,
                "§e§l" + actionName, "§7Click en un jugador para " + actionName.toLowerCase()));

        // Cabezas de jugador (paginado)
        int start = page * PAGE_SIZE;
        int end = Math.min(start + PAGE_SIZE, names.length);
        for (int i = start; i < end; i++) {
            int slot = PLAYER_SLOTS_START + (i - start);
            container.setStack(slot, createInfoItem(Items.PLAYER_HEAD,
                    "§f" + names[i], "§7Click para " + actionName.toLowerCase()));
        }

        // Relleno
        for (int i = 0; i < 54; i++) {
            if (container.getStack(i).isEmpty()) {
                container.setStack(i, createInfoItem(Items.GRAY_STAINED_GLASS_PANE, "§8", ""));
            }
        }

        // Navegación (fila 5)
        int totalPages = Math.max(1, (int) Math.ceil(names.length / (double) PAGE_SIZE));
        container.setStack(45, createInfoItem(Items.ARROW, "§c§lVolver", "§7Panel principal"));
        if (page > 0) {
            container.setStack(47, createInfoItem(Items.SPECTRAL_ARROW, "§e§l◀ Anterior", "§7Página " + page + "/" + totalPages));
        }
        container.setStack(49, createInfoItem(Items.PAPER, "§7Página " + (page + 1) + "/" + totalPages, "§7" + names.length + " jugadores online"));
        if (page < totalPages - 1) {
            container.setStack(51, createInfoItem(Items.SPECTRAL_ARROW, "§e§lSiguiente ▶", "§7Página " + (page + 2) + "/" + totalPages));
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

        // Volver al panel
        if (slotIndex == 45) {
            StaffActions.openPanel(staffPlayer);
            return;
        }
        // Página anterior
        if (slotIndex == 47 && page > 0) {
            StaffActions.openPlayerSelect(staffPlayer, action, page - 1);
            return;
        }
        // Página siguiente
        if (slotIndex == 51 && (page + 1) * PAGE_SIZE < allPlayerNames.length) {
            StaffActions.openPlayerSelect(staffPlayer, action, page + 1);
            return;
        }
        // Jugador clickeado
        if (slotIndex >= PLAYER_SLOTS_START && slotIndex <= PLAYER_SLOTS_END) {
            int index = page * PAGE_SIZE + (slotIndex - PLAYER_SLOTS_START);
            if (index < allPlayerNames.length) {
                String targetName = allPlayerNames[index];
                onPlayerSelected(targetName);
            }
            return;
        }

        super.onSlotClick(slotIndex, button, actionType, player);
    }

    /** Decide el siguiente paso según la acción (confirmación para destructivas). */
    private void onPlayerSelected(String targetName) {
        switch (action) {
            case "ban", "jail" -> StaffActions.openConfirmation(staffPlayer, action, targetName, "");
            case "jail-time" -> StaffActions.openJailTimeSelect(staffPlayer, targetName);
            default -> StaffActions.executeAction(staffPlayer, action, targetName, "");
        }
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
