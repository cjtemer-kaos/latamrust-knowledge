/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  com.mojang.brigadier.CommandDispatcher
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.IntegerArgumentType
 *  com.mojang.brigadier.arguments.StringArgumentType
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  com.mojang.brigadier.builder.RequiredArgumentBuilder
 *  com.mojang.brigadier.context.CommandContext
 *  com.mojang.brigadier.suggestion.Suggestions
 *  com.mojang.brigadier.suggestion.SuggestionsBuilder
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.CharsKt
 *  me.lucko.fabric.api.permissions.v0.Permissions
 *  net.minecraft.class_124
 *  net.minecraft.class_1297
 *  net.minecraft.class_1799
 *  net.minecraft.class_2168
 *  net.minecraft.class_2170
 *  net.minecraft.class_2172
 *  net.minecraft.class_2186
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_2561
 *  net.minecraft.class_2583
 *  net.minecraft.class_3222
 *  net.minecraft.class_3965
 *  net.minecraft.class_5250
 *  net.minecraft.server.MinecraftServer
 *  org.jetbrains.annotations.NotNull
 */
package com.f0cus.protectionstones;

import com.f0cus.protectionstones.CBConfig;
import com.f0cus.protectionstones.CBItemManager;
import com.f0cus.protectionstones.CBLocationsManager;
import com.f0cus.protectionstones.CBManager;
import com.f0cus.protectionstones.CBRegion;
import com.f0cus.protectionstones.CBTexts;
import com.f0cus.protectionstones.CBUtils;
import com.f0cus.protectionstones.CBVisualizationManager;
import com.f0cus.protectionstones.gui.CBMenuProvider;
import com.mojang.authlib.GameProfile;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import me.lucko.fabric.api.permissions.v0.Permissions;
import net.minecraft.class_124;
import net.minecraft.class_1297;
import net.minecraft.class_1799;
import net.minecraft.class_2168;
import net.minecraft.class_2170;
import net.minecraft.class_2172;
import net.minecraft.class_2186;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_239;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_3222;
import net.minecraft.class_3965;
import net.minecraft.class_5250;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2={"Lcom/f0cus/protectionstones/CBCommandHandler;", "", "<init>", "()V", "Lcom/mojang/brigadier/CommandDispatcher;", "Lnet/minecraft/class_2168;", "dispatcher", "", "register", "(Lcom/mojang/brigadier/CommandDispatcher;)V", "source", "sendHelpMessage", "(Lnet/minecraft/class_2168;)V", "Lcom/mojang/brigadier/suggestion/SuggestionsBuilder;", "builder", "Ljava/util/concurrent/CompletableFuture;", "Lcom/mojang/brigadier/suggestion/Suggestions;", "suggestStoneTypes", "(Lcom/mojang/brigadier/suggestion/SuggestionsBuilder;)Ljava/util/concurrent/CompletableFuture;", "ClaimBlocks"})
public final class CBCommandHandler {
    @NotNull
    public static final CBCommandHandler INSTANCE = new CBCommandHandler();

    private CBCommandHandler() {
    }

    public final void register(@NotNull CommandDispatcher<class_2168> dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, (String)"dispatcher");
        dispatcher.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)class_2170.method_9247((String)"cb").then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)class_2170.method_9247((String)"menu").requires(CBCommandHandler::register$lambda$0)).executes(CBCommandHandler::register$lambda$1)).then(((RequiredArgumentBuilder)class_2170.method_9244((String)"target", (ArgumentType)((ArgumentType)class_2186.method_9305())).requires(CBCommandHandler::register$lambda$2)).executes(CBCommandHandler::register$lambda$3)))).then(((LiteralArgumentBuilder)class_2170.method_9247((String)"info").requires(CBCommandHandler::register$lambda$4)).executes(CBCommandHandler::register$lambda$5))).then(((LiteralArgumentBuilder)class_2170.method_9247((String)"view").requires(CBCommandHandler::register$lambda$6)).executes(CBCommandHandler::register$lambda$7))).then(((LiteralArgumentBuilder)class_2170.method_9247((String)"delete").requires(CBCommandHandler::register$lambda$8)).executes(CBCommandHandler::register$lambda$9))).then(((LiteralArgumentBuilder)class_2170.method_9247((String)"add").requires(CBCommandHandler::register$lambda$10)).then(class_2170.method_9244((String)"target", (ArgumentType)((ArgumentType)class_2186.method_9305())).executes(CBCommandHandler::register$lambda$11)))).then(((LiteralArgumentBuilder)class_2170.method_9247((String)"get").requires(CBCommandHandler::register$lambda$12)).then(class_2170.method_9244((String)"type", (ArgumentType)((ArgumentType)StringArgumentType.string())).suggests(CBCommandHandler::register$lambda$13).executes(CBCommandHandler::register$lambda$14)))).then(((LiteralArgumentBuilder)class_2170.method_9247((String)"give").requires(CBCommandHandler::register$lambda$15)).then(class_2170.method_9244((String)"user", (ArgumentType)((ArgumentType)class_2186.method_9305())).then(class_2170.method_9244((String)"type", (ArgumentType)((ArgumentType)StringArgumentType.string())).suggests(CBCommandHandler::register$lambda$16).then(class_2170.method_9244((String)"amount", (ArgumentType)((ArgumentType)IntegerArgumentType.integer((int)1, (int)64))).executes(CBCommandHandler::register$lambda$17)))))).executes(CBCommandHandler::register$lambda$18));
    }

    private final void sendHelpMessage(class_2168 source) {
        class_124[] class_124Array = new class_124[]{class_124.field_1064, class_124.field_1067};
        class_5250 userTitle = class_2561.method_43470((String)"--- ClaimBlocks System Administration ---").method_27695(class_124Array);
        source.method_45068((class_2561)userTitle);
        class_2583 commandStyle = class_2583.field_24360.method_10977(class_124.field_1075).method_10982(Boolean.valueOf(true));
        class_2583 descStyle = class_2583.field_24360.method_10977(class_124.field_1068).method_10978(Boolean.valueOf(true));
        class_5250 bullet = class_2561.method_43470((String)"\u2022 ").method_27692(class_124.field_1080);
        CBCommandHandler.sendHelpMessage$sendCommand(commandStyle, descStyle, source, bullet, "/cb menu", "Access the management interface.");
        CBCommandHandler.sendHelpMessage$sendCommand(commandStyle, descStyle, source, bullet, "/cb view", "Toggle boundary visualization.");
        CBCommandHandler.sendHelpMessage$sendCommand(commandStyle, descStyle, source, bullet, "/cb delete", "Permanently remove the observed module.");
        CBCommandHandler.sendHelpMessage$sendCommand(commandStyle, descStyle, source, bullet, "/cb add <user>", "Authorize a new user to the current claim.");
        if (Permissions.check((class_2172)((class_2172)source), (String)"cb.admin", (int)2)) {
            source.method_45068((class_2561)class_2561.method_43470((String)""));
            class_124[] class_124Array2 = new class_124[]{class_124.field_1063, class_124.field_1067};
            class_5250 adminTitle = class_2561.method_43470((String)"--- Authorized Personnel Only ---").method_27695(class_124Array2);
            source.method_45068((class_2561)adminTitle);
            CBCommandHandler.sendHelpMessage$sendCommand(commandStyle, descStyle, source, bullet, "/cb info", "Shows information of the protection you are standing in.");
            CBCommandHandler.sendHelpMessage$sendCommand(commandStyle, descStyle, source, bullet, "/cb menu <user>", "Opens the protection list of a specific user.");
            CBCommandHandler.sendHelpMessage$sendCommand(commandStyle, descStyle, source, bullet, "/cb get <type>", "Gets a single protection stone (1x).");
            CBCommandHandler.sendHelpMessage$sendCommand(commandStyle, descStyle, source, bullet, "/cb give <user> <type> <amount>", "Gives protection stone(s) to a player.");
        }
    }

    private final CompletableFuture<Suggestions> suggestStoneTypes(SuggestionsBuilder builder) {
        CompletableFuture completableFuture = class_2172.method_9265((Iterable)CBConfig.INSTANCE.getStones().keySet(), (SuggestionsBuilder)builder);
        Intrinsics.checkNotNullExpressionValue((Object)completableFuture, (String)"suggest(...)");
        return completableFuture;
    }

    private static final boolean register$lambda$0(class_2168 source) {
        return Permissions.check((class_2172)((class_2172)source), (String)"cb.user", (int)0);
    }

    private static final int register$lambda$1(CommandContext ctx) {
        class_3222 player = ((class_2168)ctx.getSource()).method_9207();
        Intrinsics.checkNotNull((Object)player);
        CBMenuProvider.INSTANCE.openAreaList(player, player.method_5667());
        return 1;
    }

    private static final boolean register$lambda$2(class_2168 source) {
        return Permissions.check((class_2172)((class_2172)source), (String)"cb.admin", (int)2);
    }

    private static final int register$lambda$3(CommandContext ctx) {
        class_3222 player = ((class_2168)ctx.getSource()).method_9207();
        class_3222 target = class_2186.method_9315((CommandContext)ctx, (String)"target");
        Intrinsics.checkNotNull((Object)player);
        CBMenuProvider.INSTANCE.openAreaList(player, target.method_5667());
        return 1;
    }

    private static final boolean register$lambda$4(class_2168 source) {
        return Permissions.check((class_2172)((class_2172)source), (String)"cb.admin", (int)2);
    }

    /*
     * WARNING - void declaration
     */
    private static final int register$lambda$5(CommandContext ctx) {
        String string;
        Object object;
        class_3222 player = ((class_2168)ctx.getSource()).method_9207();
        String string2 = player.method_37908().method_27983().method_29177().toString();
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toString(...)");
        String worldKey = string2;
        class_2338 class_23382 = player.method_24515();
        Intrinsics.checkNotNullExpressionValue((Object)class_23382, (String)"blockPosition(...)");
        CBRegion area = (CBRegion)CollectionsKt.firstOrNull(CBManager.INSTANCE.getAreasAt(class_23382, worldKey));
        if (area == null) {
            ((class_2168)ctx.getSource()).method_9213((class_2561)class_2561.method_43470((String)CBUtils.INSTANCE.translateColors(CBTexts.INSTANCE.getConfig().getMessages().getNoStandingInProtection())).method_27692(class_124.field_1061));
            return 0;
        }
        MinecraftServer minecraftServer = player.field_13995;
        Intrinsics.checkNotNullExpressionValue((Object)minecraftServer, (String)"server");
        List<GameProfile> list = CBUtils.INSTANCE.getGameProfiles(minecraftServer, CollectionsKt.listOf((Object)area.getOwner())).get();
        Intrinsics.checkNotNullExpressionValue(list, (String)"get(...)");
        GameProfile profile = (GameProfile)CollectionsKt.firstOrNull(list);
        Object object2 = profile;
        if (object2 == null || (object2 = object2.getName()) == null) {
            String string3 = area.getOwner().toString();
            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"toString(...)");
            int n = 0;
            int n2 = 8;
            String string4 = string3.substring(n, n2);
            object2 = string4;
            Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"substring(...)");
        }
        Object ownerName = object2;
        int minX = Math.min(area.getPos1().method_10263(), area.getPos2().method_10263());
        int minY = Math.min(area.getPos1().method_10264(), area.getPos2().method_10264());
        int minZ = Math.min(area.getPos1().method_10260(), area.getPos2().method_10260());
        int maxX = Math.max(area.getPos1().method_10263(), area.getPos2().method_10263());
        int maxY = Math.max(area.getPos1().method_10264(), area.getPos2().method_10264());
        int maxZ = Math.max(area.getPos1().method_10260(), area.getPos2().method_10260());
        String string5 = area.getStoneType();
        if (((CharSequence)string5).length() > 0) {
            String string6;
            void it;
            char c = string5.charAt(0);
            StringBuilder stringBuilder = new StringBuilder();
            boolean bl = false;
            if (Character.isLowerCase((char)it)) {
                Locale locale = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"ROOT");
                string6 = CharsKt.titlecase((char)it, (Locale)locale);
            } else {
                string6 = String.valueOf((char)it);
            }
            StringBuilder stringBuilder2 = stringBuilder.append((Object)string6);
            object = string5;
            int n = 1;
            String string7 = ((String)object).substring(n);
            Intrinsics.checkNotNullExpressionValue((Object)string7, (String)"substring(...)");
            string = stringBuilder2.append(string7).toString();
        } else {
            string = string5;
        }
        String stoneTypeCapitalized = string;
        object = new class_124[]{class_124.field_1065, class_124.field_1067};
        class_5250 message = class_2561.method_43470((String)("--- Claim Information: " + area.getName() + " ---")).method_27695((class_124[])object).method_10852((class_2561)class_2561.method_43470((String)"\nType: ").method_27692(class_124.field_1080)).method_10852((class_2561)class_2561.method_43470((String)stoneTypeCapitalized).method_27692(class_124.field_1068)).method_10852((class_2561)class_2561.method_43470((String)"\nOwner: ").method_27692(class_124.field_1080)).method_10852((class_2561)class_2561.method_43470((String)ownerName).method_27692(class_124.field_1075)).method_10852((class_2561)class_2561.method_43470((String)"\nCenter: ").method_27692(class_124.field_1080)).method_10852((class_2561)class_2561.method_43470((String)(area.getCenterBlock().method_10263() + " " + area.getCenterBlock().method_10264() + " " + area.getCenterBlock().method_10260())).method_27692(class_124.field_1068)).method_10852((class_2561)class_2561.method_43470((String)"\nSize: ").method_27692(class_124.field_1080)).method_10852((class_2561)class_2561.method_43470((String)(maxX - minX + 1 + "x" + (maxY - minY + 1) + "x" + (maxZ - minZ + 1))).method_27692(class_124.field_1068));
        ((class_2168)ctx.getSource()).method_9226(() -> CBCommandHandler.register$lambda$5$1(message), false);
        return 1;
    }

    private static final class_2561 register$lambda$5$1(class_5250 $message) {
        return (class_2561)$message;
    }

    private static final boolean register$lambda$6(class_2168 source) {
        return Permissions.check((class_2172)((class_2172)source), (String)"cb.user", (int)0);
    }

    private static final int register$lambda$7(CommandContext ctx) {
        class_3222 player = ((class_2168)ctx.getSource()).method_9207();
        String string = player.method_37908().method_27983().method_29177().toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String worldKey = string;
        class_2338 class_23382 = player.method_24515();
        Intrinsics.checkNotNullExpressionValue((Object)class_23382, (String)"blockPosition(...)");
        CBRegion area = (CBRegion)CollectionsKt.firstOrNull(CBManager.INSTANCE.getAreasAt(class_23382, worldKey));
        if (area == null) {
            ((class_2168)ctx.getSource()).method_9213((class_2561)class_2561.method_43470((String)"You are not standing inside a protection."));
            return 0;
        }
        Intrinsics.checkNotNull((Object)player);
        CBVisualizationManager.show$default(CBVisualizationManager.INSTANCE, player, area, 0L, 4, null);
        ((class_2168)ctx.getSource()).method_9226(CBCommandHandler::register$lambda$7$0, false);
        return 1;
    }

    private static final class_2561 register$lambda$7$0() {
        return CBUtils.INSTANCE.createSuccessMessage(CBTexts.INSTANCE.getConfig().getMessages().getBoundariesShown());
    }

    private static final boolean register$lambda$8(class_2168 source) {
        return Permissions.check((class_2172)((class_2172)source), (String)"cb.user", (int)0);
    }

    private static final int register$lambda$9(CommandContext ctx) {
        class_3222 player = ((class_2168)ctx.getSource()).method_9207();
        class_239 hitResult = player.method_5745(20.0, 0.0f, false);
        if (hitResult.method_17783() == class_239.class_240.field_1332) {
            Intrinsics.checkNotNull((Object)hitResult, (String)"null cannot be cast to non-null type net.minecraft.world.phys.BlockHitResult");
            class_2338 blockPos = ((class_3965)hitResult).method_17777();
            String string = player.method_37908().method_27983().method_29177().toString();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
            String worldKey = string;
            Intrinsics.checkNotNull((Object)blockPos);
            CBRegion area = CBManager.INSTANCE.getAreaAtCenter(blockPos, worldKey);
            if (area != null) {
                boolean isOwner = Intrinsics.areEqual((Object)area.getOwner(), (Object)player.method_5667());
                boolean isAdmin = Permissions.check((class_1297)((class_1297)player), (String)"cb.admin", (int)2);
                if (isOwner || isAdmin) {
                    CBManager.INSTANCE.getRegions().remove(area.getName());
                    CBManager.INSTANCE.save();
                    CBLocationsManager.INSTANCE.removeLocation(area.getOwner(), area.getCenterBlock());
                    player.method_51469().method_8652(area.getCenterBlock(), class_2246.field_10124.method_9564(), 2);
                    class_1799 class_17992 = CBItemManager.INSTANCE.getStone(area.getStoneType());
                    if (class_17992 != null) {
                        class_1799 stoneStack = class_17992;
                        boolean bl = false;
                        player.method_31548().method_7394(stoneStack);
                    }
                    ((class_2168)ctx.getSource()).method_9226(() -> CBCommandHandler.register$lambda$9$1(area), true);
                    return 1;
                }
                ((class_2168)ctx.getSource()).method_9213((class_2561)class_2561.method_43470((String)CBUtils.INSTANCE.translateColors(CBTexts.INSTANCE.getConfig().getMessages().getNotOwner())).method_27692(class_124.field_1061));
                return 0;
            }
        }
        ((class_2168)ctx.getSource()).method_9213((class_2561)class_2561.method_43470((String)"You must be looking at your protection stone to delete it."));
        return 0;
    }

    private static final class_2561 register$lambda$9$1(CBRegion $area) {
        String string = CBTexts.INSTANCE.getConfig().getMessages().getDeletedSuccess();
        Object[] objectArray = new Object[]{$area.getName()};
        String string2 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"format(...)");
        String msg = string2;
        return CBUtils.INSTANCE.createSuccessMessage(msg);
    }

    private static final boolean register$lambda$10(class_2168 source) {
        return Permissions.check((class_2172)((class_2172)source), (String)"cb.user", (int)0);
    }

    private static final int register$lambda$11(CommandContext ctx) {
        class_3222 player = ((class_2168)ctx.getSource()).method_9207();
        class_3222 target = class_2186.method_9315((CommandContext)ctx, (String)"target");
        String string = player.method_37908().method_27983().method_29177().toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String worldKey = string;
        class_2338 class_23382 = player.method_24515();
        Intrinsics.checkNotNullExpressionValue((Object)class_23382, (String)"blockPosition(...)");
        CBRegion area = (CBRegion)CollectionsKt.firstOrNull(CBManager.INSTANCE.getAreasAt(class_23382, worldKey));
        if (area == null) {
            ((class_2168)ctx.getSource()).method_9213((class_2561)class_2561.method_43470((String)CBUtils.INSTANCE.translateColors(CBTexts.INSTANCE.getConfig().getMessages().getNoStandingInProtection())).method_27692(class_124.field_1061));
            return 0;
        }
        if (!Intrinsics.areEqual((Object)area.getOwner(), (Object)player.method_5667())) {
            ((class_2168)ctx.getSource()).method_9213((class_2561)class_2561.method_43470((String)CBUtils.INSTANCE.translateColors(CBTexts.INSTANCE.getConfig().getMessages().getNoPermissionEdit())).method_27692(class_124.field_1061));
            return 0;
        }
        if (Intrinsics.areEqual((Object)target.method_5667(), (Object)player.method_5667())) {
            ((class_2168)ctx.getSource()).method_9213((class_2561)class_2561.method_43470((String)CBUtils.INSTANCE.translateColors(CBTexts.INSTANCE.getConfig().getMessages().getCannotAddSelf())).method_27692(class_124.field_1054));
            return 0;
        }
        if (area.getMembers().contains(target.method_5667())) {
            String string2 = CBTexts.INSTANCE.getConfig().getMessages().getAlreadyMember();
            Object[] objectArray = new Object[]{target.method_5477().getString()};
            String string3 = String.format(string2, Arrays.copyOf(objectArray, objectArray.length));
            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"format(...)");
            String msg = string3;
            ((class_2168)ctx.getSource()).method_9213((class_2561)class_2561.method_43470((String)CBUtils.INSTANCE.translateColors(msg)).method_27692(class_124.field_1054));
            return 0;
        }
        Set<UUID> set = area.getMembers();
        UUID uUID = target.method_5667();
        Intrinsics.checkNotNullExpressionValue((Object)uUID, (String)"getUUID(...)");
        set.add(uUID);
        CBManager.INSTANCE.save();
        ((class_2168)ctx.getSource()).method_9226(() -> CBCommandHandler.register$lambda$11$0(target), true);
        target.method_43502((class_2561)class_2561.method_43470((String)("You have been added as a member to the protection '" + area.getName() + "'.")).method_27692(class_124.field_1060), true);
        return 1;
    }

    private static final class_2561 register$lambda$11$0(class_3222 $target) {
        String string = CBTexts.INSTANCE.getConfig().getMessages().getMemberAdded();
        Object[] objectArray = new Object[]{$target.method_5477().getString()};
        String string2 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"format(...)");
        String msg = string2;
        return CBUtils.INSTANCE.createSuccessMessage(msg);
    }

    private static final boolean register$lambda$12(class_2168 source) {
        return Permissions.check((class_2172)((class_2172)source), (String)"cb.admin", (int)2);
    }

    private static final CompletableFuture register$lambda$13(CommandContext ctx, SuggestionsBuilder builder) {
        Intrinsics.checkNotNull((Object)builder);
        return INSTANCE.suggestStoneTypes(builder);
    }

    private static final int register$lambda$14(CommandContext ctx) {
        class_3222 player = ((class_2168)ctx.getSource()).method_9207();
        String string = StringArgumentType.getString((CommandContext)ctx, (String)"type");
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getString(...)");
        String string2 = string.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toLowerCase(...)");
        String type2 = string2;
        class_1799 stoneStack = CBItemManager.INSTANCE.getStone(type2);
        if (stoneStack != null) {
            player.method_31548().method_7394(stoneStack);
            ((class_2168)ctx.getSource()).method_9226(() -> CBCommandHandler.register$lambda$14$0(type2), true);
            return 1;
        }
        ((class_2168)ctx.getSource()).method_9213((class_2561)class_2561.method_43470((String)("Invalid stone type: " + type2)));
        return 0;
    }

    private static final class_2561 register$lambda$14$0(String $type) {
        return CBUtils.INSTANCE.createSuccessMessage("Gave you 1x " + $type + " stone.");
    }

    private static final boolean register$lambda$15(class_2168 source) {
        return Permissions.check((class_2172)((class_2172)source), (String)"cb.admin", (int)2);
    }

    private static final CompletableFuture register$lambda$16(CommandContext ctx, SuggestionsBuilder builder) {
        Intrinsics.checkNotNull((Object)builder);
        return INSTANCE.suggestStoneTypes(builder);
    }

    private static final int register$lambda$17(CommandContext ctx) {
        class_3222 targetPlayer = class_2186.method_9315((CommandContext)ctx, (String)"user");
        String string = StringArgumentType.getString((CommandContext)ctx, (String)"type");
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getString(...)");
        String string2 = string.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toLowerCase(...)");
        String type2 = string2;
        int amount = IntegerArgumentType.getInteger((CommandContext)ctx, (String)"amount");
        class_1799 stoneStack = CBItemManager.INSTANCE.getStone(type2);
        if (stoneStack != null) {
            stoneStack.method_7939(amount);
            targetPlayer.method_31548().method_7394(stoneStack);
            ((class_2168)ctx.getSource()).method_9226(() -> CBCommandHandler.register$lambda$17$0(amount, type2, targetPlayer), true);
            return 1;
        }
        ((class_2168)ctx.getSource()).method_9213((class_2561)class_2561.method_43470((String)("Invalid stone type: " + type2)));
        return 0;
    }

    private static final class_2561 register$lambda$17$0(int $amount, String $type, class_3222 $targetPlayer) {
        return CBUtils.INSTANCE.createSuccessMessage("Gave " + $amount + " x " + $type + " stone to " + $targetPlayer.method_5477().getString() + ".");
    }

    private static final int register$lambda$18(CommandContext ctx) {
        Object object = ctx.getSource();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
        INSTANCE.sendHelpMessage((class_2168)object);
        return 1;
    }

    private static final void sendHelpMessage$sendCommand(class_2583 commandStyle, class_2583 descStyle, class_2168 $source, class_5250 bullet, String command, String description) {
        class_5250 cmdComponent = class_2561.method_43470((String)command).method_27696(commandStyle);
        class_5250 descComponent = class_2561.method_43470((String)(" - " + description)).method_27696(descStyle);
        $source.method_45068((class_2561)bullet.method_27661().method_10852((class_2561)cmdComponent).method_10852((class_2561)descComponent));
    }
}
