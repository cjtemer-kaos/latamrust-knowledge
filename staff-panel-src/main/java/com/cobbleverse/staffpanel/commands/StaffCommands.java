package com.cobbleverse.staffpanel.commands;

import com.cobbleverse.staffpanel.menu.StaffActions;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;

import static net.minecraft.server.command.CommandManager.literal;

/**
 * Registra SOLO los comandos de apertura del panel.
 * NO registra comandos duplicados (ban, mute, kick, jail...) — esos pertenecen
 * a Paradigm y Jail Logic. El panel es la GUI que los dispara.
 */
public class StaffCommands {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        // /staff — abre el panel
        dispatcher.register(literal("staff")
                .requires(source -> source.hasPermissionLevel(2))
                .executes(context -> {
                    ServerPlayerEntity player = context.getSource().getPlayerOrThrow();
                    StaffActions.openPanel(player);
                    return 1;
                })
        );

        // /staffpanel — alias
        dispatcher.register(literal("staffpanel")
                .requires(source -> source.hasPermissionLevel(2))
                .executes(context -> {
                    ServerPlayerEntity player = context.getSource().getPlayerOrThrow();
                    StaffActions.openPanel(player);
                    return 1;
                })
        );

        // /sp — alias corto
        dispatcher.register(literal("sp")
                .requires(source -> source.hasPermissionLevel(2))
                .executes(context -> {
                    ServerPlayerEntity player = context.getSource().getPlayerOrThrow();
                    StaffActions.openPanel(player);
                    return 1;
                })
        );
    }
}
