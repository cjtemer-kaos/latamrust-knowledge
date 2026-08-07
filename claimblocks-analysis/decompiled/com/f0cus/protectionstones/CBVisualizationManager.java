/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  net.minecraft.server.MinecraftServer
 *  org.jetbrains.annotations.NotNull
 */
package com.f0cus.protectionstones;

import com.f0cus.protectionstones.CBEffects;
import com.f0cus.protectionstones.CBRegion;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014R,\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u0019"}, d2={"Lcom/f0cus/protectionstones/CBVisualizationManager;", "", "<init>", "()V", "Lnet/minecraft/class_3222;", "player", "Lcom/f0cus/protectionstones/CBRegion;", "region", "", "durationSeconds", "", "show", "(Lnet/minecraft/class_3222;Lcom/f0cus/protectionstones/CBRegion;J)V", "Lnet/minecraft/server/MinecraftServer;", "server", "tick", "(Lnet/minecraft/server/MinecraftServer;)V", "Ljava/util/UUID;", "playerUuid", "onPlayerDisconnect", "(Ljava/util/UUID;)V", "", "Lkotlin/Pair;", "viewingPlayers", "Ljava/util/Map;", "ClaimBlocks"})
public final class CBVisualizationManager {
    @NotNull
    public static final CBVisualizationManager INSTANCE = new CBVisualizationManager();
    @NotNull
    private static final Map<UUID, Pair<CBRegion, Long>> viewingPlayers = new ConcurrentHashMap();

    private CBVisualizationManager() {
    }

    public final void show(@NotNull class_3222 player, @NotNull CBRegion region, long durationSeconds) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
        long expiryTime = System.currentTimeMillis() + durationSeconds * (long)1000;
        viewingPlayers.put(player.method_5667(), (Pair<CBRegion, Long>)TuplesKt.to((Object)region, (Object)expiryTime));
    }

    public static /* synthetic */ void show$default(CBVisualizationManager cBVisualizationManager, class_3222 class_32222, CBRegion cBRegion, long l, int n, Object object) {
        if ((n & 4) != 0) {
            l = 10L;
        }
        cBVisualizationManager.show(class_32222, cBRegion, l);
    }

    public final void tick(@NotNull MinecraftServer server) {
        Intrinsics.checkNotNullParameter((Object)server, (String)"server");
        long currentTime = System.currentTimeMillis();
        Iterator<Map.Entry<UUID, Pair<CBRegion, Long>>> iterator = viewingPlayers.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<UUID, Pair<CBRegion, Long>> entry = iterator.next();
            class_3222 player = server.method_3760().method_14602(entry.getKey());
            Pair<CBRegion, Long> pair = entry.getValue();
            CBRegion region = (CBRegion)pair.component1();
            long expiryTime = ((Number)pair.component2()).longValue();
            if (player == null || currentTime > expiryTime) {
                iterator.remove();
                continue;
            }
            class_3218 class_32182 = player.method_51469();
            Intrinsics.checkNotNullExpressionValue((Object)class_32182, (String)"serverLevel(...)");
            CBEffects.INSTANCE.showCube(class_32182, region.getPos1(), region.getPos2());
        }
    }

    public final void onPlayerDisconnect(@NotNull UUID playerUuid) {
        Intrinsics.checkNotNullParameter((Object)playerUuid, (String)"playerUuid");
        viewingPlayers.remove(playerUuid);
    }
}
