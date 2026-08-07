/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_3222
 *  net.minecraft.class_5250
 *  net.minecraft.class_5903
 *  net.minecraft.class_5904
 *  net.minecraft.class_5905
 *  net.minecraft.server.MinecraftServer
 *  org.jetbrains.annotations.NotNull
 */
package com.f0cus.protectionstones;

import com.f0cus.protectionstones.CBManager;
import com.f0cus.protectionstones.CBRegion;
import com.f0cus.protectionstones.CBTexts;
import com.f0cus.protectionstones.CBUtils;
import com.f0cus.protectionstones.CBVisualizationManager;
import com.f0cus.protectionstones.flags.Flags;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_3222;
import net.minecraft.class_5250;
import net.minecraft.class_5903;
import net.minecraft.class_5904;
import net.minecraft.class_5905;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fR&\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00120\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0014"}, d2={"Lcom/f0cus/protectionstones/CBTracker;", "", "<init>", "()V", "Lnet/minecraft/server/MinecraftServer;", "server", "", "tick", "(Lnet/minecraft/server/MinecraftServer;)V", "Ljava/util/UUID;", "playerUuid", "onPlayerDisconnect", "(Ljava/util/UUID;)V", "", "", "", "playerAreaCache", "Ljava/util/Map;", "Lnet/minecraft/class_243;", "lastSafePosition", "ClaimBlocks"})
@SourceDebugExtension(value={"SMAP\nCBTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CBTracker.kt\ncom/f0cus/protectionstones/CBTracker\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,92:1\n1563#2:93\n1634#2,3:94\n*S KotlinDebug\n*F\n+ 1 CBTracker.kt\ncom/f0cus/protectionstones/CBTracker\n*L\n25#1:93\n25#1:94,3\n*E\n"})
public final class CBTracker {
    @NotNull
    public static final CBTracker INSTANCE = new CBTracker();
    @NotNull
    private static final Map<UUID, Set<String>> playerAreaCache = new ConcurrentHashMap();
    @NotNull
    private static final Map<UUID, class_243> lastSafePosition = new ConcurrentHashMap();

    private CBTracker() {
    }

    /*
     * WARNING - void declaration
     */
    public final void tick(@NotNull MinecraftServer server) {
        Intrinsics.checkNotNullParameter((Object)server, (String)"server");
        for (class_3222 player : server.method_3760().method_14571()) {
            CBRegion area;
            void $this$mapTo$iv$iv;
            String worldKey;
            class_2338 playerPos = player.method_24515();
            UUID playerUuid = player.method_5667();
            Intrinsics.checkNotNullExpressionValue((Object)player.method_37908().method_27983().method_29177().toString(), (String)"toString(...)");
            Intrinsics.checkNotNull((Object)playerPos);
            List<CBRegion> currentAreas = CBManager.INSTANCE.getAreasAt(playerPos, worldKey);
            Iterable $this$map$iv = currentAreas;
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                CBRegion cBRegion = (CBRegion)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl = false;
                collection.add(it.getName());
            }
            Set currentAreaNames = CollectionsKt.toSet((Iterable)((List)destination$iv$iv));
            Intrinsics.checkNotNull((Object)playerUuid);
            Set<String> previousAreas = playerAreaCache.getOrDefault(playerUuid, SetsKt.emptySet());
            Set enteredAreas = SetsKt.minus((Set)currentAreaNames, (Iterable)previousAreas);
            Set leftAreas = SetsKt.minus(previousAreas, (Iterable)currentAreaNames);
            if (currentAreas.isEmpty()) {
                lastSafePosition.put(playerUuid, player.method_19538());
            }
            if (!((Collection)enteredAreas).isEmpty()) {
                for (String areaName : enteredAreas) {
                    String msg;
                    if (CBManager.INSTANCE.getRegions().get(areaName) == null) continue;
                    if (area.getEnterTitle() != null || area.getEnterSubtitle() != null) {
                        int fadeIn = 10;
                        int stay = 70;
                        int fadeOut = 20;
                        player.field_13987.method_14364((class_2596)new class_5905(fadeIn, stay, fadeOut));
                        if (area.getEnterSubtitle() != null) {
                            class_5250 subtitleComponent = class_2561.method_43470((String)CBUtils.INSTANCE.translateColors(area.getEnterSubtitle()));
                            player.field_13987.method_14364((class_2596)new class_5903((class_2561)subtitleComponent));
                        }
                        if (area.getEnterTitle() != null) {
                            class_5250 titleComponent = class_2561.method_43470((String)CBUtils.INSTANCE.translateColors(area.getEnterTitle()));
                            player.field_13987.method_14364((class_2596)new class_5904((class_2561)titleComponent));
                        }
                    }
                    if (!area.getFlag(Flags.INSTANCE.getNOTIFY_ENTER_EXIT()).booleanValue()) continue;
                    String string = CBTexts.INSTANCE.getConfig().getNotifications().getEntering();
                    Object[] objectArray = new Object[]{area.getName()};
                    Intrinsics.checkNotNullExpressionValue((Object)String.format(string, Arrays.copyOf(objectArray, objectArray.length)), (String)"format(...)");
                    player.method_43496(CBUtils.INSTANCE.createSuccessMessage(msg));
                }
            }
            if (!((Collection)leftAreas).isEmpty()) {
                for (String areaName : leftAreas) {
                    String msg;
                    if (CBManager.INSTANCE.getRegions().get(areaName) == null || !area.getFlag(Flags.INSTANCE.getNOTIFY_ENTER_EXIT()).booleanValue()) continue;
                    String string = CBTexts.INSTANCE.getConfig().getNotifications().getLeaving();
                    Object[] objectArray = new Object[]{area.getName()};
                    Intrinsics.checkNotNullExpressionValue((Object)String.format(string, Arrays.copyOf(objectArray, objectArray.length)), (String)"format(...)");
                    player.method_43496(CBUtils.INSTANCE.createSuccessMessage(msg));
                }
            }
            playerAreaCache.put(playerUuid, currentAreaNames);
        }
    }

    public final void onPlayerDisconnect(@NotNull UUID playerUuid) {
        Intrinsics.checkNotNullParameter((Object)playerUuid, (String)"playerUuid");
        playerAreaCache.remove(playerUuid);
        lastSafePosition.remove(playerUuid);
        CBVisualizationManager.INSTANCE.onPlayerDisconnect(playerUuid);
    }
}
