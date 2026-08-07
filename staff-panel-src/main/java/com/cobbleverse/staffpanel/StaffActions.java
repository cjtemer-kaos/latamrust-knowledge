package com.cobbleverse.staffpanel;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class StaffActions {
    
    public static void handleAction(ServerPlayerEntity player, String action, String target) {
        ServerCommandSource source = player.getCommandSource();
        
        switch (action.toLowerCase()) {
            case "ban" -> executeCommand(source, "banhammer ban " + target + " Baneado por staff");
            case "mute" -> executeCommand(source, "banhammer mute " + target);
            case "kick" -> executeCommand(source, "kick " + target + " Expulsado por staff");
            case "unjail" -> executeCommand(source, "function jail:unjail {target:\"" + target + "\"}");
            case "tp" -> executeCommand(source, "tp " + player.getName().getString() + " " + target);
            case "gm" -> executeCommand(source, "gamemode creative " + target);
            case "gms" -> executeCommand(source, "gamemode survival " + target);
            default -> player.sendMessage(Text.literal("§cAcción desconocida: " + action), false);
        }
    }
    
    private static void executeCommand(ServerCommandSource source, String command) {
        source.getServer().getCommandManager().executeWithPrefix(source, command);
    }
}
