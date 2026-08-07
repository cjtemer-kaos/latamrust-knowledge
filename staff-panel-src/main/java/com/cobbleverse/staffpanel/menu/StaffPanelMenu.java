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
 * Staff Panel — Main menu (inventory-based, vanilla compatible).
 * 3 rows x 9 cols = 27 slots.
 * Buttons: Ban, Mute, Kick, Jail, Teleport, Gamemode, Give, Player Info, Player List.
 */
public class StaffPanelMenu extends GenericContainerScreenHandler {
    private final ServerPlayerEntity staffPlayer;

    // Client constructor
    public StaffPanelMenu(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, null);
    }

    // Server constructor
    public StaffPanelMenu(int syncId, PlayerInventory playerInventory, ServerPlayerEntity player) {
        super(ScreenHandlerType.GENERIC_9X3, syncId, playerInventory, buildPanelContainer(), 3);
        this.staffPlayer = player;
    }

    private static SimpleInventory buildPanelContainer() {
        SimpleInventory container = new SimpleInventory(27);
        ItemStack[] items = getPanelItems();
        for (int i = 0; i < 27; i++) {
            container.setStack(i, items[i]);
        }
        return container;
    }

    private static ItemStack[] getPanelItems() {
        ItemStack[] items = new ItemStack[27];

        // Row 0 — Player actions
        items[0] = createButton(Items.NETHER_STAR, "§c§lBanear Jugador", "§7Banear a un jugador del servidor");
        items[1] = createButton(Items.BONE, "§6§lMutear Jugador", "§7Silenciar a un jugador en el chat");
        items[2] = createButton(Items.PAPER, "§e§lAdvertir", "§7Dar una advertencia a un jugador");
        items[3] = createButton(Items.ARROW, "§a§lExpulsar (Kick)", "§7Expulsar jugador del servidor");
        items[4] = createButton(Items.IRON_BARS, "§b§lCarcel (Jail)", "§7Enviar jugador a la carcel");

        // Row 1 — Server tools
        items[9] = createButton(Items.ENDER_PEARL, "§5§lTeletransportar", "§7TP a jugador / TP jugador a ti");
        items[10] = createButton(Items.GRASS_BLOCK, "§2§lGamemode", "§7Cambiar modo de juego (creative/survival)");
        items[11] = createButton(Items.CHEST, "§1§lDar Items (Give)", "§7Dar items a un jugador");
        items[12] = createButton(Items.PLAYER_HEAD, "§d§lInfo Jugador", "§7Ver info: rank, IP, playtime, etc.");

        // Row 2 — Utilities
        items[18] = createButton(Items.BOOK, "§3§lLista de Jugadores", "§7Ver todos los jugadores online");
        items[19] = createButton(Items.CLOCK, "§4§lHistorial Castigos", "§7Ver castigos anteriores (BanHammer)");

        // Fill empty slots with gray glass
        for (int i = 0; i < 27; i++) {
            if (items[i] == null) {
                items[i] = createButton(Items.GRAY_STAINED_GLASS_PANE, "§8", "");
            }
        }
        return items;
    }

    private static ItemStack createButton(net.minecraft.item.Item item, String name, String lore) {
        ItemStack stack = new ItemStack(item);
        stack.set(DataComponentTypes.CUSTOM_NAME, Text.literal(name));
        if (lore != null && !lore.isEmpty()) {
            stack.set(DataComponentTypes.LORE, new LoreComponent(List.of(Text.literal(lore))));
        }
        return stack;
    }

    @Override
    public void onSlotClick(int slotIndex, int button, SlotActionType actionType, PlayerEntity player) {
        if (slotIndex >= 0 && slotIndex < 27 && staffPlayer != null) {
            handleButtonClick(slotIndex);
            return;
        }
        super.onSlotClick(slotIndex, button, actionType, player);
    }

    private void handleButtonClick(int slotIndex) {
        if (staffPlayer == null) return;

        switch (slotIndex) {
            case 0 -> StaffActions.openPlayerSelect(staffPlayer, "ban");
            case 1 -> StaffActions.openPlayerSelect(staffPlayer, "mute");
            case 2 -> StaffActions.openPlayerSelect(staffPlayer, "warn");
            case 3 -> StaffActions.openPlayerSelect(staffPlayer, "kick");
            case 4 -> StaffActions.openPlayerSelect(staffPlayer, "jail");
            case 9 -> StaffActions.openPlayerSelect(staffPlayer, "teleport");
            case 10 -> StaffActions.openPlayerSelect(staffPlayer, "gamemode");
            case 11 -> StaffActions.openPlayerSelect(staffPlayer, "give");
            case 12 -> StaffActions.openPlayerSelect(staffPlayer, "info");
            case 18 -> StaffActions.showPlayerList(staffPlayer);
            case 19 -> StaffActions.showPunishmentHistory(staffPlayer);
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
