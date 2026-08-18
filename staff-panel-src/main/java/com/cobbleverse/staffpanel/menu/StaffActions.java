package com.cobbleverse.staffpanel.menu;

import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

/**
 * Ejecuta acciones del StaffPanel delegando en los comandos de los mods
 * existentes (Paradigm, Jail Logic, vanilla). NUNCA implementa sistemas propios.
 *
 * Regla: cada acción = executeWithPrefix con el comando del mod dueño.
 */
public class StaffActions {

    // ===== EJECUCIÓN DE ACCIONES =====

    /**
     * Ejecuta una acción sobre un jugador objetivo usando el comando del mod correcto.
     */
    public static void executeAction(ServerPlayerEntity staff, String action, String targetName, String reason) {
        String r = (reason == null || reason.isEmpty()) ? "[Staff Panel]" : reason;
        switch (action) {
            case "ban" -> run(staff, "ban " + targetName + " " + r);
            case "mute" -> run(staff, "mute " + targetName + " " + r);
            case "warn" -> run(staff, "warn " + targetName + " " + r);
            case "kick" -> run(staff, "kick " + targetName + " " + r);
            case "jail" -> run(staff, "jail imprison " + targetName + " " + r + " [Staff Panel]"); // r = segundos (ver JailTimeMenu); reason OBLIGATORIO
            case "unjail" -> run(staff, "jail unjail " + targetName);
            case "teleport" -> run(staff, "tp " + staff.getName().getString() + " " + targetName);
            case "gamemode" -> toggleGamemode(staff, targetName);
            case "give" -> run(staff, "invsee " + targetName);
            case "info" -> run(staff, "whois " + targetName);
            case "spectate" -> {
                run(staff, "vanish");
                run(staff, "spectator " + targetName);
            }
            case "heal" -> run(staff, "heal " + targetName);
            case "feed" -> run(staff, "feed " + targetName);
            case "history" -> run(staff, "paradigm punishment history " + targetName);
            default -> staff.sendMessage(Text.literal("§4§l[Staff] §7Acción desconocida: " + action), false);
        }
    }

    /** Ejecuta acciones que NO necesitan jugador objetivo (vanish toggle, staff chat). */
    public static void executeSelfAction(ServerPlayerEntity staff, String action) {
        switch (action) {
            case "vanish" -> run(staff, "vanish");
            case "staffchat" -> run(staff, "sc");
            case "fly" -> run(staff, "fly");
            case "god" -> run(staff, "god");
            default -> staff.sendMessage(Text.literal("§4§l[Staff] §7Acción desconocida: " + action), false);
        }
    }

    /** Alterna gamemode del jugador (creative ↔ survival) usando Paradigm. */
    private static void toggleGamemode(ServerPlayerEntity staff, String targetName) {
        ServerPlayerEntity target = staff.getServer().getPlayerManager().getPlayer(targetName);
        if (target != null) {
            String current = target.interactionManager.getGameMode().getName();
            String newMode = current.equals("creative") ? "survival" : "creative";
            run(staff, "gamemode " + newMode + " " + targetName);
            staff.sendMessage(Text.literal("§2§l[Staff] §7Gamemode de §f" + targetName + " §7→ §f" + newMode), false);
        } else {
            staff.sendMessage(Text.literal("§4§l[Staff] §7Jugador §f" + targetName + " §7no encontrado"), false);
        }
    }

    /** Ejecuta un comando como el staff (permisos del staff se aplican). */
    public static void run(ServerPlayerEntity staff, String command) {
        staff.getServer().getCommandManager().executeWithPrefix(staff.getCommandSource(), command);
    }

    // ===== MENÚS =====

    /** Abre el panel principal. */
    public static void openPanel(ServerPlayerEntity player) {
        player.openHandledScreen(new SimpleNamedScreenHandlerFactory(
                (syncId, playerInventory, p) -> new StaffPanelMenu(syncId, playerInventory, (ServerPlayerEntity) p),
                Text.literal("§c§lPanel de Staff")
        ));
    }

    /** Abre el selector de jugadores para una acción. */
    public static void openPlayerSelect(ServerPlayerEntity player, String action) {
        openPlayerSelect(player, action, 0);
    }

    /** Abre el selector de jugadores con página específica. */
    public static void openPlayerSelect(ServerPlayerEntity player, String action, int page) {
        java.util.List<String> onlinePlayers = getOnlinePlayerNames(player);
        player.openHandledScreen(new SimpleNamedScreenHandlerFactory(
                (syncId, playerInventory, p) -> new PlayerSelectMenu(
                        syncId, playerInventory, (ServerPlayerEntity) p, action,
                        onlinePlayers.toArray(new String[0]), page),
                Text.literal("§e§lSeleccionar Jugador — " + getActionName(action))
        ));
    }

    /** Abre el selector de duración para jail. */
    public static void openJailTimeSelect(ServerPlayerEntity player, String targetName) {
        player.openHandledScreen(new SimpleNamedScreenHandlerFactory(
                (syncId, playerInventory, p) -> new JailTimeMenu(syncId, playerInventory, (ServerPlayerEntity) p, targetName),
                Text.literal("§b§lCarcel — Duración para §f" + targetName)
        ));
    }

    /** Abre la confirmación para acciones destructivas. */
    public static void openConfirmation(ServerPlayerEntity staff, String action, String targetName, String extra) {
        String message = "§7¿Confirmas " + getActionName(action).toLowerCase()
                + " a §f" + targetName + "§7?" + (extra.isEmpty() ? "" : "\n§8" + extra);
        staff.openHandledScreen(new SimpleNamedScreenHandlerFactory(
                (syncId, playerInventory, p) -> new ConfirmationMenu(syncId, playerInventory, (ServerPlayerEntity) p, action, targetName, extra),
                Text.literal("§6§lConfirmar — " + getActionName(action))
        ));
    }

    // ===== HELPERS =====

    public static java.util.List<String> getOnlinePlayerNames(ServerPlayerEntity staff) {
        java.util.List<String> names = new java.util.ArrayList<>();
        for (ServerPlayerEntity p : staff.getServer().getPlayerManager().getPlayerList()) {
            names.add(p.getName().getString());
        }
        return names;
    }

    public static String getActionName(String action) {
        return switch (action) {
            case "ban" -> "Banear";
            case "mute" -> "Mutear";
            case "warn" -> "Advertir";
            case "kick" -> "Expulsar";
            case "jail" -> "Carcel";
            case "unjail" -> "Liberar";
            case "teleport" -> "Teletransportar";
            case "gamemode" -> "Modo de Juego";
            case "give" -> "Dar Items";
            case "info" -> "Info Jugador";
            case "spectate" -> "Espectar";
            case "heal" -> "Curar";
            case "feed" -> "Alimentar";
            case "vanish" -> "Vanish";
            case "history" -> "Historial";
            default -> action;
        };
    }
}
