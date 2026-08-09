package com.cobbleverse.staffpanel.menu;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles all staff actions: opening sub-menus, executing commands, etc.
 */
public class StaffActions {

    // ===== OPEN PANELS =====

    public static void openPanel(ServerPlayerEntity player) {
        player.openHandledScreen(new SimpleNamedScreenHandlerFactory(
                (syncId, playerInventory, p) -> new StaffPanelMenu(syncId, playerInventory, (ServerPlayerEntity) p),
                Text.literal("§c§lPanel de Staff")
        ));
    }

    public static void openPlayerSelect(ServerPlayerEntity player, String action) {
        List<String> onlinePlayers = getOnlinePlayerNames(player);
        String[] names = onlinePlayers.toArray(new String[0]);

        player.openHandledScreen(new SimpleNamedScreenHandlerFactory(
                (syncId, playerInventory, p) -> new PlayerSelectMenu(
                        syncId, playerInventory, (ServerPlayerEntity) p, action, names),
                Text.literal("§e§lSeleccionar Jugador — " + getActionName(action))
        ));
    }

    // ===== EXECUTE ACTIONS =====

    public static void executeAction(ServerPlayerEntity staff, String action, String targetName, String reason) {
        switch (action) {
            case "ban" -> executeBan(staff, targetName, reason);
            case "mute" -> executeMute(staff, targetName, reason);
            case "warn" -> executeWarn(staff, targetName, reason);
            case "kick" -> executeKick(staff, targetName, reason);
            case "jail" -> executeJail(staff, targetName, reason);
            case "teleport" -> executeTeleport(staff, targetName, reason);
            case "gamemode" -> executeGamemode(staff, targetName, reason);
            case "give" -> executeGive(staff, targetName, reason);
            case "info" -> executeInfo(staff, targetName, reason);
            case "spectate" -> executeSpectate(staff, targetName, reason);
        }
    }

    // ===== INDIVIDUAL ACTIONS =====

    private static void executeBan(ServerPlayerEntity staff, String target, String reason) {
        if (reason != null && !reason.isEmpty()) {
            staff.getServer().getCommandManager().executeWithPrefix(
                    staff.getCommandSource(), "ban " + target + " " + reason);
            staff.sendMessage(Text.literal("§c§l[Staff] §7Baneaste a §f" + target + " §7— §c" + reason), false);
        } else {
            staff.getServer().getCommandManager().executeWithPrefix(
                    staff.getCommandSource(), "ban " + target + " [Staff Panel]");
            staff.sendMessage(Text.literal("§c§l[Staff] §7Baneaste a §f" + target), false);
        }
    }

    private static void executeMute(ServerPlayerEntity staff, String target, String reason) {
        if (reason != null && !reason.isEmpty()) {
            staff.getServer().getCommandManager().executeWithPrefix(
                    staff.getCommandSource(), "mute " + target + " " + reason);
            staff.sendMessage(Text.literal("§6§l[Staff] §7Mutearste a §f" + target + " §7— §6" + reason), false);
        } else {
            staff.getServer().getCommandManager().executeWithPrefix(
                    staff.getCommandSource(), "mute " + target);
            staff.sendMessage(Text.literal("§6§l[Staff] §7Mutearste a §f" + target), false);
        }
    }

    private static void executeWarn(ServerPlayerEntity staff, String target, String reason) {
        if (reason != null && !reason.isEmpty()) {
            staff.getServer().getCommandManager().executeWithPrefix(
                    staff.getCommandSource(), "warn " + target + " " + reason);
            staff.sendMessage(Text.literal("§e§l[Staff] §7Advertiste a §f" + target + " §7— §e" + reason), false);
        } else {
            staff.getServer().getCommandManager().executeWithPrefix(
                    staff.getCommandSource(), "warn " + target + " [Staff Panel]");
            staff.sendMessage(Text.literal("§e§l[Staff] §7Advertiste a §f" + target), false);
        }
    }

    private static void executeKick(ServerPlayerEntity staff, String target, String reason) {
        if (reason != null && !reason.isEmpty()) {
            staff.getServer().getCommandManager().executeWithPrefix(
                    staff.getCommandSource(), "kick " + target + " " + reason);
            staff.sendMessage(Text.literal("§a§l[Staff] §7Expulsaste a §f" + target + " §7— §a" + reason), false);
        } else {
            staff.getServer().getCommandManager().executeWithPrefix(
                    staff.getCommandSource(), "kick " + target + " [Staff Panel]");
            staff.sendMessage(Text.literal("§a§l[Staff] §7Expulsaste a §f" + target), false);
        }
    }

    private static void executeJail(ServerPlayerEntity staff, String target, String reason) {
        staff.getServer().getCommandManager().executeWithPrefix(
                staff.getCommandSource(), "jail " + target + " default 10m [Staff Panel]");
        staff.sendMessage(Text.literal("§b§l[Staff] §7Enviaste a carcel a §f" + target), false);
    }

    private static void executeTeleport(ServerPlayerEntity staff, String target, String reason) {
        staff.getServer().getCommandManager().executeWithPrefix(
                staff.getCommandSource(), "tp " + staff.getName().getString() + " " + target);
        staff.sendMessage(Text.literal("§5§l[Staff] §7Te teletransportaste a §f" + target), false);
    }

    private static void executeGamemode(ServerPlayerEntity staff, String target, String reason) {
        ServerPlayerEntity targetPlayer = staff.getServer().getPlayerManager().getPlayer(target);
        if (targetPlayer != null) {
            String currentMode = targetPlayer.interactionManager.getGameMode().getName();
            String newMode = currentMode.equals("creative") ? "survival" : "creative";
            staff.getServer().getCommandManager().executeWithPrefix(
                    staff.getCommandSource(), "gamemode " + newMode + " " + target);
            staff.sendMessage(Text.literal("§2§l[Staff] §7Gamemode de §f" + target + " §7→ §f" + newMode), false);
        }
    }

    private static void executeGive(ServerPlayerEntity staff, String target, String reason) {
        staff.getServer().getCommandManager().executeWithPrefix(
                staff.getCommandSource(), "invsee " + target);
        staff.sendMessage(Text.literal("§1§l[Staff] §7Abriendo inventario de §f" + target), false);
    }

    private static void executeInfo(ServerPlayerEntity staff, String target, String reason) {
        staff.getServer().getCommandManager().executeWithPrefix(
                staff.getCommandSource(), "data get entity " + target);
        staff.sendMessage(Text.literal("§d§l[Staff] §7Info de §f" + target + " §7→ ver chat"), false);
    }

    private static void executeSpectate(ServerPlayerEntity staff, String target, String reason) {
        staff.getServer().getCommandManager().executeWithPrefix(
                staff.getCommandSource(), "vanish on");
        staff.getServer().getCommandManager().executeWithPrefix(
                staff.getCommandSource(), "spectate " + target);
        staff.sendMessage(Text.literal("§5§l[Staff] §7Espectando a §f" + target + " §7en vanish"), false);
    }

    // ===== PLAYER LIST =====

    public static void showPlayerList(ServerPlayerEntity staff) {
        List<String> players = getOnlinePlayerNames(staff);
        StringBuilder sb = new StringBuilder();
        sb.append("§d§l═══ Jugadores Online (").append(players.size()).append(") ═══\n");
        for (String name : players) {
            ServerPlayerEntity p = staff.getServer().getPlayerManager().getPlayer(name);
            if (p != null) {
                String gm = p.interactionManager.getGameMode().getName();
                sb.append("§f").append(name).append(" §7| Modo: §e").append(gm).append("\n");
            }
        }
        staff.sendMessage(Text.literal(sb.toString()), false);
    }

    // ===== PUNISHMENT HISTORY =====

    public static void showPunishmentHistory(ServerPlayerEntity staff) {
        staff.getServer().getCommandManager().executeWithPrefix(
                staff.getCommandSource(), "banhammer list");
        staff.sendMessage(Text.literal("§4§l[Staff] §7Historial de castigos → ver chat"), false);
    }

    // ===== HELPERS =====

    private static List<String> getOnlinePlayerNames(ServerPlayerEntity staff) {
        List<String> names = new ArrayList<>();
        for (ServerPlayerEntity p : staff.getServer().getPlayerManager().getPlayerList()) {
            names.add(p.getName().getString());
        }
        return names;
    }

    private static String getActionName(String action) {
        return switch (action) {
            case "ban" -> "Banear";
            case "mute" -> "Mutear";
            case "warn" -> "Advertir";
            case "kick" -> "Expulsar";
            case "jail" -> "Carcel";
            case "teleport" -> "Teletransportar";
            case "gamemode" -> "Modo de Juego";
            case "give" -> "Dar Items";
            case "info" -> "Info Jugador";
            case "spectate" -> "Espectar";
            default -> action;
        };
    }
}
