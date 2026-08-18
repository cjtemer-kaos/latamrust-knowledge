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
 * Confirmación de acciones destructivas (patrón Staff++):
 * libro con el mensaje al centro, vidrio VERDE "Confirmar" a la derecha,
 * vidrio ROJO "Cancelar" a la izquierda. Clic en verde = ejecuta comando del mod.
 */
public class ConfirmationMenu extends GenericContainerScreenHandler {
    private static final int CONFIRM_SLOTS = 16; // verde a la derecha
    private static final int CANCEL_SLOTS = 9;   // rojo a la izquierda

    private final ServerPlayerEntity staffPlayer;
    private final String action;
    private final String targetName;
    private final String extra;

    // Client constructor
    public ConfirmationMenu(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, null, "ban", "", "");
    }

    // Server constructor
    public ConfirmationMenu(int syncId, PlayerInventory playerInventory,
                            ServerPlayerEntity player, String action, String targetName, String extra) {
        super(ScreenHandlerType.GENERIC_9X3, syncId, playerInventory,
                buildContainer(action, targetName, extra), 3);
        this.staffPlayer = player;
        this.action = action;
        this.targetName = targetName;
        this.extra = extra;
    }

    private static SimpleInventory buildContainer(String action, String targetName, String extra) {
        SimpleInventory container = new SimpleInventory(27);
        String actionName = StaffActions.getActionName(action);

        // Libro con mensaje al centro
        String msg = "§6¿" + actionName + " a §f" + targetName + "§6?";
        if (extra != null && !extra.isEmpty()) {
            msg += "\n§8" + extra;
        }
        container.setStack(4, createInfoItem(Items.BOOK, "§6§lConfirmar " + actionName, msg));

        // Verde = confirmar (derecha, slots 15-17 y 24-26)
        for (int s : new int[]{15, 16, 17, 24, 25, 26}) {
            container.setStack(s, createInfoItem(Items.GREEN_STAINED_GLASS_PANE,
                    "§a§l✔ CONFIRMAR", "§7Ejecutar " + actionName.toLowerCase() + " de " + targetName));
        }

        // Rojo = cancelar (izquierda, slots 9-11 y 18-20)
        for (int s : new int[]{9, 10, 11, 18, 19, 20}) {
            container.setStack(s, createInfoItem(Items.RED_STAINED_GLASS_PANE,
                    "§c§l✖ CANCELAR", "§7Volver al panel"));
        }

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

        // Confirmar (verde)
        if (slotIndex == 15 || slotIndex == 16 || slotIndex == 17 ||
            slotIndex == 24 || slotIndex == 25 || slotIndex == 26) {
            confirm();
            return;
        }

        // Cancelar (rojo) — volver al panel
        if (slotIndex == 9 || slotIndex == 10 || slotIndex == 11 ||
            slotIndex == 18 || slotIndex == 19 || slotIndex == 20) {
            StaffActions.openPanel(staffPlayer);
            return;
        }

        super.onSlotClick(slotIndex, button, actionType, player);
    }

    private void confirm() {
        switch (action) {
            case "jail" -> StaffActions.openJailTimeSelect(staffPlayer, targetName);
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
