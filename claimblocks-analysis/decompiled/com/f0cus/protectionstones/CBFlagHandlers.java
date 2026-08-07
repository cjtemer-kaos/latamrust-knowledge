/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  me.lucko.fabric.api.permissions.v0.Permissions
 *  net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents
 *  net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
 *  net.fabricmc.fabric.api.event.player.AttackBlockCallback
 *  net.fabricmc.fabric.api.event.player.AttackEntityCallback
 *  net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents
 *  net.fabricmc.fabric.api.event.player.UseBlockCallback
 *  net.fabricmc.fabric.api.event.player.UseEntityCallback
 *  net.fabricmc.fabric.api.event.player.UseItemCallback
 *  net.minecraft.class_124
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1271
 *  net.minecraft.class_1282
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1747
 *  net.minecraft.class_1776
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2358
 *  net.minecraft.class_238
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_2530
 *  net.minecraft.class_2561
 *  net.minecraft.class_2586
 *  net.minecraft.class_2624
 *  net.minecraft.class_2680
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  net.minecraft.class_3965
 *  net.minecraft.class_3966
 *  net.minecraft.class_8111
 *  org.jetbrains.annotations.NotNull
 */
package com.f0cus.protectionstones;

import com.f0cus.protectionstones.CBManager;
import com.f0cus.protectionstones.CBRegion;
import com.f0cus.protectionstones.CBTexts;
import com.f0cus.protectionstones.CBUtils;
import com.f0cus.protectionstones.flags.Flags;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import me.lucko.fabric.api.permissions.v0.Permissions;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.class_124;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1271;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1747;
import net.minecraft.class_1776;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2358;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_2530;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2624;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.class_8111;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b\u00a2\u0006\u0004\b\u0011\u0010\u0003\u00a8\u0006\u0012"}, d2={"Lcom/f0cus/protectionstones/CBFlagHandlers;", "", "<init>", "()V", "Lnet/minecraft/class_3222;", "player", "", "message", "", "sendDenyMessage", "(Lnet/minecraft/class_3222;Ljava/lang/String;)V", "Lnet/minecraft/class_1657;", "Lcom/f0cus/protectionstones/CBRegion;", "area", "", "isMemberOrOwner", "(Lnet/minecraft/class_1657;Lcom/f0cus/protectionstones/CBRegion;)Z", "register", "ClaimBlocks"})
@SourceDebugExtension(value={"SMAP\nCBFlagHandlers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CBFlagHandlers.kt\ncom/f0cus/protectionstones/CBFlagHandlers\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,277:1\n1869#2,2:278\n*S KotlinDebug\n*F\n+ 1 CBFlagHandlers.kt\ncom/f0cus/protectionstones/CBFlagHandlers\n*L\n255#1:278,2\n*E\n"})
public final class CBFlagHandlers {
    @NotNull
    public static final CBFlagHandlers INSTANCE = new CBFlagHandlers();

    private CBFlagHandlers() {
    }

    private final void sendDenyMessage(class_3222 player, String message) {
        player.method_43502((class_2561)class_2561.method_43470((String)CBUtils.INSTANCE.translateColors(message)).method_27692(class_124.field_1061), true);
    }

    private final boolean isMemberOrOwner(class_1657 player, CBRegion area) {
        if (Permissions.check((class_1297)((class_1297)player), (String)"ps.admin", (int)2)) {
            return true;
        }
        return Intrinsics.areEqual((Object)area.getOwner(), (Object)player.method_5667()) || area.getMembers().contains(player.method_5667());
    }

    public final void register() {
        AttackBlockCallback.EVENT.register(CBFlagHandlers::register$lambda$0);
        UseBlockCallback.EVENT.register(CBFlagHandlers::register$lambda$1);
        UseItemCallback.EVENT.register(CBFlagHandlers::register$lambda$2);
        PlayerBlockBreakEvents.BEFORE.register(CBFlagHandlers::register$lambda$3);
        AttackEntityCallback.EVENT.register(CBFlagHandlers::register$lambda$4);
        UseEntityCallback.EVENT.register(CBFlagHandlers::register$lambda$5);
        ServerLivingEntityEvents.ALLOW_DAMAGE.register(CBFlagHandlers::register$lambda$6);
        ServerTickEvents.END_WORLD_TICK.register(CBFlagHandlers::register$lambda$7);
    }

    private static final class_1269 register$lambda$0(class_1657 player, class_1937 world, class_1268 hand, class_2338 pos, class_2350 direction) {
        String string = world.method_27983().method_29177().toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String worldKey = string;
        Intrinsics.checkNotNull((Object)pos);
        CBRegion cBRegion = (CBRegion)CollectionsKt.firstOrNull(CBManager.INSTANCE.getAreasAt(pos, worldKey));
        if (cBRegion == null) {
            return class_1269.field_5811;
        }
        CBRegion areaAtPos = cBRegion;
        class_3222 class_32222 = player instanceof class_3222 ? (class_3222)player : null;
        if (class_32222 == null) {
            return class_1269.field_5811;
        }
        class_3222 playerMP = class_32222;
        if (Intrinsics.areEqual((Object)pos, (Object)areaAtPos.getCenterBlock())) {
            boolean isOwner = Intrinsics.areEqual((Object)areaAtPos.getOwner(), (Object)((class_3222)player).method_5667());
            boolean isAdmin = Permissions.check((class_1297)((class_1297)player), (String)"ps.admin", (int)2);
            if (isAdmin) {
                return class_1269.field_5811;
            }
            if (isOwner) {
                String msg = CBTexts.INSTANCE.getConfig().getMessages().getCenterBlockDeleteHint();
                playerMP.method_43496((class_2561)class_2561.method_43470((String)CBUtils.INSTANCE.translateColors(msg)));
                return class_1269.field_5814;
            }
            INSTANCE.sendDenyMessage(playerMP, CBTexts.INSTANCE.getConfig().getMessages().getNotOwner());
            return class_1269.field_5814;
        }
        if (!INSTANCE.isMemberOrOwner(player, areaAtPos) && !areaAtPos.getFlag(Flags.INSTANCE.getBLOCK_BREAK()).booleanValue()) {
            INSTANCE.sendDenyMessage(playerMP, CBTexts.INSTANCE.getConfig().getMessages().getBlockBreakDisabled());
            return class_1269.field_5814;
        }
        return class_1269.field_5811;
    }

    private static final class_1269 register$lambda$1(class_1657 player, class_1937 world, class_1268 hand, class_3965 hitResult) {
        class_2338 pos = hitResult.method_17777();
        class_2338 placePos = hitResult.method_17777().method_10093(hitResult.method_17780());
        String string = world.method_27983().method_29177().toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String worldKey = string;
        Intrinsics.checkNotNull((Object)placePos);
        CBRegion cBRegion = (CBRegion)CollectionsKt.firstOrNull(CBManager.INSTANCE.getAreasAt(placePos, worldKey));
        if (cBRegion == null) {
            return class_1269.field_5811;
        }
        CBRegion areaAtPos = cBRegion;
        class_3222 class_32222 = player instanceof class_3222 ? (class_3222)player : null;
        if (class_32222 == null) {
            return class_1269.field_5811;
        }
        class_3222 playerMP = class_32222;
        class_1799 stackInHand = ((class_3222)player).method_5998(hand);
        if (world.method_8320(pos).method_26204() instanceof class_2530 && !areaAtPos.getFlag(Flags.INSTANCE.getTNT_DETONATION()).booleanValue()) {
            INSTANCE.sendDenyMessage(playerMP, CBTexts.INSTANCE.getConfig().getMessages().getTntDisabled());
            return class_1269.field_5814;
        }
        if (INSTANCE.isMemberOrOwner(player, areaAtPos)) {
            return class_1269.field_5811;
        }
        if (stackInHand.method_7909() instanceof class_1747 && !areaAtPos.getFlag(Flags.INSTANCE.getBLOCK_PLACE()).booleanValue()) {
            INSTANCE.sendDenyMessage(playerMP, CBTexts.INSTANCE.getConfig().getMessages().getBlockPlaceDisabled());
            return class_1269.field_5814;
        }
        if (world.method_8321(pos) instanceof class_2624 && !areaAtPos.getFlag(Flags.INSTANCE.getCHEST_ACCESS()).booleanValue()) {
            INSTANCE.sendDenyMessage(playerMP, CBTexts.INSTANCE.getConfig().getMessages().getContainerAccessDisabled());
            return class_1269.field_5814;
        }
        if (!areaAtPos.getFlag(Flags.INSTANCE.getINTERACT()).booleanValue()) {
            INSTANCE.sendDenyMessage(playerMP, CBTexts.INSTANCE.getConfig().getMessages().getInteractionDisabled());
            return class_1269.field_5814;
        }
        return class_1269.field_5811;
    }

    private static final class_1271 register$lambda$2(class_1657 player, class_1937 world, class_1268 hand) {
        class_2338 class_23382;
        class_1799 stack = player.method_5998(hand);
        if (!(player instanceof class_3222)) {
            return class_1271.method_22430((Object)stack);
        }
        class_239 hitResult = ((class_3222)player).method_5745(5.0, 0.0f, false);
        if (hitResult.method_17783() == class_239.class_240.field_1332) {
            Intrinsics.checkNotNull((Object)hitResult, (String)"null cannot be cast to non-null type net.minecraft.world.phys.BlockHitResult");
            class_23382 = ((class_3965)hitResult).method_17777().method_10093(((class_3965)hitResult).method_17780());
        } else {
            class_23382 = ((class_3222)player).method_24515();
        }
        class_2338 posToCheck = class_23382;
        String string = world.method_27983().method_29177().toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String worldKey = string;
        Intrinsics.checkNotNull((Object)posToCheck);
        CBRegion cBRegion = (CBRegion)CollectionsKt.firstOrNull(CBManager.INSTANCE.getAreasAt(posToCheck, worldKey));
        if (cBRegion == null) {
            return class_1271.method_22430((Object)stack);
        }
        CBRegion area = cBRegion;
        if (INSTANCE.isMemberOrOwner(player, area)) {
            return class_1271.method_22430((Object)stack);
        }
        if (stack.method_7909() instanceof class_1776 && !area.getFlag(Flags.INSTANCE.getThrownEnderpearl()).booleanValue()) {
            ((class_3222)player).method_43502((class_2561)class_2561.method_43470((String)CBUtils.INSTANCE.translateColors(CBTexts.INSTANCE.getConfig().getMessages().getEnderpearlDisabled())).method_27692(class_124.field_1061), true);
            return class_1271.method_22431((Object)stack);
        }
        if (!(stack.method_7909() != class_1802.field_8705 && stack.method_7909() != class_1802.field_8187 || area.getFlag(Flags.INSTANCE.getBLOCK_PLACE()).booleanValue())) {
            INSTANCE.sendDenyMessage((class_3222)player, CBTexts.INSTANCE.getConfig().getMessages().getLiquidPlaceDisabled());
            return class_1271.method_22431((Object)stack);
        }
        return class_1271.method_22430((Object)stack);
    }

    private static final boolean register$lambda$3(class_1937 world, class_1657 player, class_2338 pos, class_2680 state, class_2586 blockEntity) {
        String string = world.method_27983().method_29177().toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String worldKey = string;
        Intrinsics.checkNotNull((Object)pos);
        CBRegion cBRegion = (CBRegion)CollectionsKt.firstOrNull(CBManager.INSTANCE.getAreasAt(pos, worldKey));
        if (cBRegion == null) {
            return true;
        }
        CBRegion areaAtPos = cBRegion;
        class_3222 class_32222 = player instanceof class_3222 ? (class_3222)player : null;
        if (class_32222 == null) {
            return true;
        }
        class_3222 playerMP = class_32222;
        if (!INSTANCE.isMemberOrOwner(player, areaAtPos) && !areaAtPos.getFlag(Flags.INSTANCE.getBLOCK_BREAK()).booleanValue()) {
            INSTANCE.sendDenyMessage(playerMP, CBTexts.INSTANCE.getConfig().getMessages().getBlockBreakDisabled());
            return false;
        }
        return true;
    }

    private static final class_1269 register$lambda$4(class_1657 player, class_1937 world, class_1268 hand, class_1297 entity, class_3966 hitResult) {
        String string = world.method_27983().method_29177().toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String worldKey = string;
        class_2338 pos = entity.method_24515();
        Intrinsics.checkNotNull((Object)pos);
        CBRegion cBRegion = (CBRegion)CollectionsKt.firstOrNull(CBManager.INSTANCE.getAreasAt(pos, worldKey));
        if (cBRegion == null) {
            return class_1269.field_5811;
        }
        CBRegion areaAtPos = cBRegion;
        class_3222 class_32222 = player instanceof class_3222 ? (class_3222)player : null;
        if (class_32222 == null) {
            return class_1269.field_5811;
        }
        class_3222 playerMP = class_32222;
        if (!INSTANCE.isMemberOrOwner(player, areaAtPos) && !areaAtPos.getFlag(Flags.INSTANCE.getBLOCK_BREAK()).booleanValue()) {
            INSTANCE.sendDenyMessage(playerMP, CBTexts.INSTANCE.getConfig().getMessages().getEntityAttackDisabled());
            return class_1269.field_5814;
        }
        return class_1269.field_5811;
    }

    private static final class_1269 register$lambda$5(class_1657 player, class_1937 world, class_1268 hand, class_1297 entity, class_3966 hitResult) {
        String string = world.method_27983().method_29177().toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String worldKey = string;
        class_2338 pos = entity.method_24515();
        Intrinsics.checkNotNull((Object)pos);
        CBRegion cBRegion = (CBRegion)CollectionsKt.firstOrNull(CBManager.INSTANCE.getAreasAt(pos, worldKey));
        if (cBRegion == null) {
            return class_1269.field_5811;
        }
        CBRegion areaAtPos = cBRegion;
        class_3222 class_32222 = player instanceof class_3222 ? (class_3222)player : null;
        if (class_32222 == null) {
            return class_1269.field_5811;
        }
        class_3222 playerMP = class_32222;
        if (!INSTANCE.isMemberOrOwner(player, areaAtPos) && !areaAtPos.getFlag(Flags.INSTANCE.getINTERACT()).booleanValue()) {
            INSTANCE.sendDenyMessage(playerMP, CBTexts.INSTANCE.getConfig().getMessages().getEntityInteractDisabled());
            return class_1269.field_5814;
        }
        return class_1269.field_5811;
    }

    private static final boolean register$lambda$6(class_1309 entity, class_1282 source, float amount) {
        String string = entity.method_37908().method_27983().method_29177().toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String worldKey = string;
        class_2338 class_23382 = entity.method_24515();
        Intrinsics.checkNotNullExpressionValue((Object)class_23382, (String)"blockPosition(...)");
        CBRegion cBRegion = (CBRegion)CollectionsKt.firstOrNull(CBManager.INSTANCE.getAreasAt(class_23382, worldKey));
        if (cBRegion == null) {
            return true;
        }
        CBRegion area = cBRegion;
        if (entity instanceof class_1657 && area.getFlag(Flags.INSTANCE.getINVINCIBILITY()).booleanValue()) {
            return source.method_49708(class_8111.field_44869);
        }
        return true;
    }

    private static final void register$lambda$7(class_3218 world) {
        List list = world.method_18456();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"players(...)");
        Iterable $this$forEach$iv = list;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            CBRegion area;
            String worldKey;
            class_3222 player = (class_3222)element$iv;
            boolean bl = false;
            Intrinsics.checkNotNullExpressionValue((Object)world.method_27983().method_29177().toString(), (String)"toString(...)");
            class_2338 class_23382 = player.method_24515();
            Intrinsics.checkNotNullExpressionValue((Object)class_23382, (String)"blockPosition(...)");
            List<CBRegion> areas = CBManager.INSTANCE.getAreasAt(class_23382, worldKey);
            if (areas.isEmpty() || (area = (CBRegion)CollectionsKt.first(areas)).getFlag(Flags.INSTANCE.getFIRE_SPREAD()).booleanValue()) continue;
            class_238 box = player.method_5829().method_1014(16.0);
            for (class_2338 pos : class_2338.method_10097((class_2338)class_2338.method_49637((double)box.field_1323, (double)box.field_1322, (double)box.field_1321), (class_2338)class_2338.method_49637((double)box.field_1320, (double)box.field_1325, (double)box.field_1324))) {
                if (!(world.method_8320(pos).method_26204() instanceof class_2358)) continue;
                world.method_22352(pos, false);
            }
        }
    }
}
