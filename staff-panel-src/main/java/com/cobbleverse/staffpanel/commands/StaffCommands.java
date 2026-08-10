package com.cobbleverse.staffpanel.commands;

import com.cobbleverse.staffpanel.StaffPanelMod;
import com.cobbleverse.staffpanel.menu.StaffActions;
import com.cobbleverse.staffpanel.menu.JailSystem;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class StaffCommands {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        // /staff — opens the panel
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

        // /sp — short alias
        dispatcher.register(literal("sp")
                .requires(source -> source.hasPermissionLevel(2))
                .executes(context -> {
                    ServerPlayerEntity player = context.getSource().getPlayerOrThrow();
                    StaffActions.openPanel(player);
                    return 1;
                })
        );

        // /staff ban <player> [reason]
        dispatcher.register(literal("staff")
                .requires(source -> source.hasPermissionLevel(2))
                .then(literal("ban")
                        .then(argument("player", StringArgumentType.word())
                                .executes(context -> {
                                    ServerPlayerEntity player = context.getSource().getPlayerOrThrow();
                                    String target = StringArgumentType.getString(context, "player");
                                    StaffActions.executeAction(player, "ban", target, "");
                                    return 1;
                                })
                                .then(argument("reason", StringArgumentType.greedyString())
                                        .executes(context -> {
                                            ServerPlayerEntity player = context.getSource().getPlayerOrThrow();
                                            String target = StringArgumentType.getString(context, "player");
                                            String reason = StringArgumentType.getString(context, "reason");
                                            StaffActions.executeAction(player, "ban", target, reason);
                                            return 1;
                                        })
                                )
                        )
                )
        );

        // /staff mute <player> [reason]
        dispatcher.register(literal("staff")
                .requires(source -> source.hasPermissionLevel(2))
                .then(literal("mute")
                        .then(argument("player", StringArgumentType.word())
                                .executes(context -> {
                                    ServerPlayerEntity player = context.getSource().getPlayerOrThrow();
                                    String target = StringArgumentType.getString(context, "player");
                                    StaffActions.executeAction(player, "mute", target, "");
                                    return 1;
                                })
                                .then(argument("reason", StringArgumentType.greedyString())
                                        .executes(context -> {
                                            ServerPlayerEntity player = context.getSource().getPlayerOrThrow();
                                            String target = StringArgumentType.getString(context, "player");
                                            String reason = StringArgumentType.getString(context, "reason");
                                            StaffActions.executeAction(player, "mute", target, reason);
                                            return 1;
                                        })
                                )
                        )
                )
        );

        // /staff kick <player> [reason]
        dispatcher.register(literal("staff")
                .requires(source -> source.hasPermissionLevel(2))
                .then(literal("kick")
                        .then(argument("player", StringArgumentType.word())
                                .executes(context -> {
                                    ServerPlayerEntity player = context.getSource().getPlayerOrThrow();
                                    String target = StringArgumentType.getString(context, "player");
                                    StaffActions.executeAction(player, "kick", target, "");
                                    return 1;
                                })
                                .then(argument("reason", StringArgumentType.greedyString())
                                        .executes(context -> {
                                            ServerPlayerEntity player = context.getSource().getPlayerOrThrow();
                                            String target = StringArgumentType.getString(context, "player");
                                            String reason = StringArgumentType.getString(context, "reason");
                                            StaffActions.executeAction(player, "kick", target, reason);
                                            return 1;
                                        })
                                )
                        )
                )
        );

        // /staff tp <player>
        dispatcher.register(literal("staff")
                .requires(source -> source.hasPermissionLevel(2))
                .then(literal("tp")
                        .then(argument("player", StringArgumentType.word())
                                .executes(context -> {
                                    ServerPlayerEntity player = context.getSource().getPlayerOrThrow();
                                    String target = StringArgumentType.getString(context, "player");
                                    StaffActions.executeAction(player, "teleport", target, "");
                                    return 1;
                                })
                        )
                )
        );

        // /staff gm <player>
        dispatcher.register(literal("staff")
                .requires(source -> source.hasPermissionLevel(2))
                .then(literal("gm")
                        .then(argument("player", StringArgumentType.word())
                                .executes(context -> {
                                    ServerPlayerEntity player = context.getSource().getPlayerOrThrow();
                                    String target = StringArgumentType.getString(context, "player");
                                    StaffActions.executeAction(player, "gamemode", target, "");
                                    return 1;
                                })
                        )
                )
        );

        // /staff list
        dispatcher.register(literal("staff")
                .requires(source -> source.hasPermissionLevel(2))
                .then(literal("list")
                        .executes(context -> {
                            ServerPlayerEntity player = context.getSource().getPlayerOrThrow();
                            StaffActions.showPlayerList(player);
                            return 1;
                        })
                )
        );

        // ===== JAIL COMMANDS =====
        
        // /jail jail1 <player> [time] [reason]
        dispatcher.register(literal("jail")
                .requires(source -> source.hasPermissionLevel(2))
                .then(literal("jail1")
                        .then(argument("player", StringArgumentType.word())
                                .executes(context -> {
                                    ServerPlayerEntity staff = context.getSource().getPlayerOrThrow();
                                    String target = StringArgumentType.getString(context, "player");
                                    JailSystem.jailPlayer(staff, target, "1h", StaffPanelMod.getConfigDir());
                                    return 1;
                                })
                                .then(argument("time", StringArgumentType.word())
                                        .executes(context -> {
                                            ServerPlayerEntity staff = context.getSource().getPlayerOrThrow();
                                            String target = StringArgumentType.getString(context, "player");
                                            String time = StringArgumentType.getString(context, "time");
                                            JailSystem.jailPlayer(staff, target, time, StaffPanelMod.getConfigDir());
                                            return 1;
                                        })
                                        .then(argument("reason", StringArgumentType.greedyString())
                                                .executes(context -> {
                                                    ServerPlayerEntity staff = context.getSource().getPlayerOrThrow();
                                                    String target = StringArgumentType.getString(context, "player");
                                                    String time = StringArgumentType.getString(context, "time");
                                                    JailSystem.jailPlayer(staff, target, time, StaffPanelMod.getConfigDir());
                                                    return 1;
                                                })
                                        )
                                )
                        )
                )
        );

        // /jail unjail1 <player>
        dispatcher.register(literal("jail")
                .then(literal("unjail1")
                        .then(argument("player", StringArgumentType.word())
                                .executes(context -> {
                                    ServerPlayerEntity staff = context.getSource().getPlayerOrThrow();
                                    String target = StringArgumentType.getString(context, "player");
                                    JailSystem.unjailPlayer(staff, target, StaffPanelMod.getConfigDir());
                                    return 1;
                                })
                        )
                )
        );

        // ===== SIMPLIFIED COMMANDS =====
        
        // /ban <player> [reason]
        dispatcher.register(literal("ban")
                .requires(source -> source.hasPermissionLevel(2))
                .then(argument("player", StringArgumentType.word())
                        .executes(context -> {
                            ServerPlayerEntity staff = context.getSource().getPlayerOrThrow();
                            String target = StringArgumentType.getString(context, "player");
                            StaffActions.executeAction(staff, "ban", target, "");
                            return 1;
                        })
                        .then(argument("reason", StringArgumentType.greedyString())
                                .executes(context -> {
                                    ServerPlayerEntity staff = context.getSource().getPlayerOrThrow();
                                    String target = StringArgumentType.getString(context, "player");
                                    String reason = StringArgumentType.getString(context, "reason");
                                    StaffActions.executeAction(staff, "ban", target, reason);
                                    return 1;
                                })
                        )
                )
        );

        // /unban <player>
        dispatcher.register(literal("unban")
                .requires(source -> source.hasPermissionLevel(2))
                .then(argument("player", StringArgumentType.word())
                        .executes(context -> {
                            ServerPlayerEntity staff = context.getSource().getPlayerOrThrow();
                            String target = StringArgumentType.getString(context, "player");
                            staff.getServer().getCommandManager().executeWithPrefix(
                                staff.getCommandSource(), "pardon " + target
                            );
                            staff.sendMessage(Text.literal("§2§l[Staff] §7Desbaneaste a §f" + target), false);
                            return 1;
                        })
                )
        );

        // /mute <player> [reason]
        dispatcher.register(literal("mute")
                .requires(source -> source.hasPermissionLevel(2))
                .then(argument("player", StringArgumentType.word())
                        .executes(context -> {
                            ServerPlayerEntity staff = context.getSource().getPlayerOrThrow();
                            String target = StringArgumentType.getString(context, "player");
                            StaffActions.executeAction(staff, "mute", target, "");
                            return 1;
                        })
                        .then(argument("reason", StringArgumentType.greedyString())
                                .executes(context -> {
                                    ServerPlayerEntity staff = context.getSource().getPlayerOrThrow();
                                    String target = StringArgumentType.getString(context, "player");
                                    String reason = StringArgumentType.getString(context, "reason");
                                    StaffActions.executeAction(staff, "mute", target, reason);
                                    return 1;
                                })
                        )
                )
        );

        // /unmute <player>
        dispatcher.register(literal("unmute")
                .requires(source -> source.hasPermissionLevel(2))
                .then(argument("player", StringArgumentType.word())
                        .executes(context -> {
                            ServerPlayerEntity staff = context.getSource().getPlayerOrThrow();
                            String target = StringArgumentType.getString(context, "player");
                            staff.getServer().getCommandManager().executeWithPrefix(
                                staff.getCommandSource(), " unmute " + target
                            );
                            staff.sendMessage(Text.literal("§2§l[Staff] §7Desmuteaste a §f" + target), false);
                            return 1;
                        })
                )
        );

        // /kick <player> [reason]
        dispatcher.register(literal("kick")
                .requires(source -> source.hasPermissionLevel(2))
                .then(argument("player", StringArgumentType.word())
                        .executes(context -> {
                            ServerPlayerEntity staff = context.getSource().getPlayerOrThrow();
                            String target = StringArgumentType.getString(context, "player");
                            StaffActions.executeAction(staff, "kick", target, "");
                            return 1;
                        })
                        .then(argument("reason", StringArgumentType.greedyString())
                                .executes(context -> {
                                    ServerPlayerEntity staff = context.getSource().getPlayerOrThrow();
                                    String target = StringArgumentType.getString(context, "player");
                                    String reason = StringArgumentType.getString(context, "reason");
                                    StaffActions.executeAction(staff, "kick", target, reason);
                                    return 1;
                                })
                        )
                )
        );

        // /tp <player>
        dispatcher.register(literal("tp")
                .requires(source -> source.hasPermissionLevel(2))
                .then(argument("player", StringArgumentType.word())
                        .executes(context -> {
                            ServerPlayerEntity staff = context.getSource().getPlayerOrThrow();
                            String target = StringArgumentType.getString(context, "player");
                            StaffActions.executeAction(staff, "teleport", target, "");
                            return 1;
                        })
                )
        );

        // /gm <player>
        dispatcher.register(literal("gm")
                .requires(source -> source.hasPermissionLevel(2))
                .then(argument("player", StringArgumentType.word())
                        .executes(context -> {
                            ServerPlayerEntity staff = context.getSource().getPlayerOrThrow();
                            String target = StringArgumentType.getString(context, "player");
                            StaffActions.executeAction(staff, "gamemode", target, "");
                            return 1;
                        })
                )
        );

        // /invsee <player>
        dispatcher.register(literal("invsee")
                .requires(source -> source.hasPermissionLevel(2))
                .then(argument("player", StringArgumentType.word())
                        .executes(context -> {
                            ServerPlayerEntity staff = context.getSource().getPlayerOrThrow();
                            String target = StringArgumentType.getString(context, "player");
                            StaffActions.executeAction(staff, "give", target, "");
                            return 1;
                        })
                )
        );
    }
}
