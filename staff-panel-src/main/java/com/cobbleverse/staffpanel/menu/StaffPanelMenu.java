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
 * Staff Panel — Menú principal (hub).
 * 3 filas x 9 = 27 slots. Cada botón dispara el comando del mod existente
 * (Paradigm, Jail Logic, vanilla) — NUNCA sistemas propios.
 *
 * Diseño semántico por color (patrón Staff++):
 *   Fila 0: castigos (rojo=ban, naranja=mute, amarillo=warn, verde=kick, azul=jail, magenta=unjail)
 *   Fila 1: herramientas (tp, gamemode, invsee, vanish, espectar, curar, alimentar)
 *   Fila 2: utilidades (info, historial, staff chat, cerrar)
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

        // ===== FILA 0 — CASTIGOS (moderación) =====
        items[0] = createButton(Items.RED_WOOL, "§c§lBanear", "§7Baneo permanente de un jugador", "§7→ Paradigm /ban");
        items[1] = createButton(Items.ORANGE_WOOL, "§6§lMutear", "§7Silenciar el chat de un jugador", "§7→ Paradigm /mute");
        items[2] = createButton(Items.YELLOW_WOOL, "§e§lAdvertir", "§7Dar advertencia a un jugador", "§7→ Paradigm /warn");
        items[3] = createButton(Items.LIME_WOOL, "§a§lExpulsar", "§7Kickear a un jugador", "§7→ Paradigm /kick");
        items[4] = createButton(Items.LIGHT_BLUE_WOOL, "§b§lCarcel", "§7Enviar a la celda (730 79 1002)", "§7→ Jail Logic /jail imprison");
        items[5] = createButton(Items.MAGENTA_WOOL, "§d§lLiberar", "§7Sacar de la celda a un jugador", "§7→ Jail Logic /unjail");
        items[6] = createButton(Items.PINK_WOOL, "§f§lDesmutear", "§7Quitar silencio", "§7→ Paradigm /unmute");

        // ===== FILA 1 — HERRAMIENTAS =====
        items[9] = createButton(Items.ENDER_PEARL, "§5§lTeletransportar", "§7TP hacia un jugador", "§7→ vanilla /tp");
        items[10] = createButton(Items.DIAMOND_SWORD, "§2§lGamemode", "§7Alternar creative/survival", "§7→ Paradigm /gamemode");
        items[11] = createButton(Items.CHEST, "§1§lVer Inventario", "§7Inspeccionar inventario", "§7→ Paradigm /invsee");
        items[12] = createButton(Items.GHAST_TEAR, "§7§lVanish", "§7Activar/desactivar invisibilidad", "§7→ Paradigm /vanish");
        items[13] = createButton(Items.ENDER_EYE, "§5§lEspectar", "§7Espectar jugador en vanish", "§7→ Paradigm /spectate");
        items[14] = createButton(Items.GOLDEN_APPLE, "§e§lCurar", "§7Restaurar vida de un jugador", "§7→ Paradigm /heal");
        items[15] = createButton(Items.COOKED_BEEF, "§6§lAlimentar", "§7Restaurar hambre de un jugador", "§7→ Paradigm /feed");

        // ===== FILA 2 — UTILIDADES =====
        items[18] = createButton(Items.PLAYER_HEAD, "§d§lInfo Jugador", "§7Ver whois de un jugador", "§7→ Paradigm /whois");
        items[19] = createButton(Items.BOOK, "§3§lHistorial", "§7Ver castigos de un jugador", "§7→ Paradigm /history");
        items[20] = createButton(Items.NAME_TAG, "§c§lStaff Chat", "§7Activar/desactivar chat de staff", "§7→ Paradigm /sc");
        items[26] = createButton(Items.BARRIER, "§4§lCerrar", "§7Cerrar el panel");

        // Relleno con vidrio
        for (int i = 0; i < 27; i++) {
            if (items[i] == null) {
                items[i] = createButton(Items.GRAY_STAINED_GLASS_PANE, "§8", "");
            }
        }
        return items;
    }

    private static ItemStack createButton(net.minecraft.item.Item item, String name, String... loreLines) {
        ItemStack stack = new ItemStack(item);
        stack.set(DataComponentTypes.CUSTOM_NAME, Text.literal(name));
        if (loreLines != null && loreLines.length > 0) {
            List<Text> lore = new java.util.ArrayList<>();
            for (String line : loreLines) {
                if (line != null && !line.isEmpty()) {
                    lore.add(Text.literal(line));
                }
            }
            if (!lore.isEmpty()) {
                stack.set(DataComponentTypes.LORE, new LoreComponent(lore));
            }
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
            // Fila 0 — Castigos (requieren confirmación para ban/jail)
            case 0 -> StaffActions.openPlayerSelect(staffPlayer, "ban");
            case 1 -> StaffActions.openPlayerSelect(staffPlayer, "mute");
            case 2 -> StaffActions.openPlayerSelect(staffPlayer, "warn");
            case 3 -> StaffActions.openPlayerSelect(staffPlayer, "kick");
            case 4 -> StaffActions.openPlayerSelect(staffPlayer, "jail");
            case 5 -> StaffActions.openPlayerSelect(staffPlayer, "unjail");
            case 6 -> StaffActions.openPlayerSelect(staffPlayer, "unmute");
            // Fila 1 — Herramientas
            case 9 -> StaffActions.openPlayerSelect(staffPlayer, "teleport");
            case 10 -> StaffActions.openPlayerSelect(staffPlayer, "gamemode");
            case 11 -> StaffActions.openPlayerSelect(staffPlayer, "give");
            case 12 -> StaffActions.executeSelfAction(staffPlayer, "vanish");
            case 13 -> StaffActions.openPlayerSelect(staffPlayer, "spectate");
            case 14 -> StaffActions.openPlayerSelect(staffPlayer, "heal");
            case 15 -> StaffActions.openPlayerSelect(staffPlayer, "feed");
            // Fila 2 — Utilidades
            case 18 -> StaffActions.openPlayerSelect(staffPlayer, "info");
            case 19 -> StaffActions.openPlayerSelect(staffPlayer, "history");
            case 20 -> StaffActions.executeSelfAction(staffPlayer, "staffchat");
            case 26 -> staffPlayer.closeHandledScreen();
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
