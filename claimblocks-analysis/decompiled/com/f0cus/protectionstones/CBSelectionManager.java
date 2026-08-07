/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_3222
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.f0cus.protectionstones;

import com.f0cus.protectionstones.TitleEditSession;
import com.f0cus.protectionstones.TitleEditState;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_3222;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u000eJ\u001d\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0018\u0010\nJ\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\fJ\u0015\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u000eR \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00060\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00140\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001eR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00060\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001e\u00a8\u0006!"}, d2={"Lcom/f0cus/protectionstones/CBSelectionManager;", "", "<init>", "()V", "Lnet/minecraft/class_3222;", "player", "", "oldAreaName", "", "startRenaming", "(Lnet/minecraft/class_3222;Ljava/lang/String;)V", "getRenamingArea", "(Lnet/minecraft/class_3222;)Ljava/lang/String;", "stopRenaming", "(Lnet/minecraft/class_3222;)V", "areaName", "Lcom/f0cus/protectionstones/TitleEditState;", "state", "startSettingTitle", "(Lnet/minecraft/class_3222;Ljava/lang/String;Lcom/f0cus/protectionstones/TitleEditState;)V", "Lcom/f0cus/protectionstones/TitleEditSession;", "getSettingTitleSession", "(Lnet/minecraft/class_3222;)Lcom/f0cus/protectionstones/TitleEditSession;", "stopSettingTitle", "startAddingMember", "getAddingMemberArea", "stopAddingMember", "", "Ljava/util/UUID;", "renamingArea", "Ljava/util/Map;", "settingTitle", "addingMember", "ClaimBlocks"})
public final class CBSelectionManager {
    @NotNull
    public static final CBSelectionManager INSTANCE = new CBSelectionManager();
    @NotNull
    private static final Map<UUID, String> renamingArea = new ConcurrentHashMap();
    @NotNull
    private static final Map<UUID, TitleEditSession> settingTitle = new ConcurrentHashMap();
    @NotNull
    private static final Map<UUID, String> addingMember = new ConcurrentHashMap();

    private CBSelectionManager() {
    }

    public final void startRenaming(@NotNull class_3222 player, @NotNull String oldAreaName) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)oldAreaName, (String)"oldAreaName");
        renamingArea.put(player.method_5667(), oldAreaName);
    }

    @Nullable
    public final String getRenamingArea(@NotNull class_3222 player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        return renamingArea.get(player.method_5667());
    }

    public final void stopRenaming(@NotNull class_3222 player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        renamingArea.remove(player.method_5667());
    }

    public final void startSettingTitle(@NotNull class_3222 player, @NotNull String areaName, @NotNull TitleEditState state) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)areaName, (String)"areaName");
        Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
        settingTitle.put(player.method_5667(), new TitleEditSession(areaName, state));
    }

    public static /* synthetic */ void startSettingTitle$default(CBSelectionManager cBSelectionManager, class_3222 class_32222, String string, TitleEditState titleEditState, int n, Object object) {
        if ((n & 4) != 0) {
            titleEditState = TitleEditState.TITLE;
        }
        cBSelectionManager.startSettingTitle(class_32222, string, titleEditState);
    }

    @Nullable
    public final TitleEditSession getSettingTitleSession(@NotNull class_3222 player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        return settingTitle.get(player.method_5667());
    }

    public final void stopSettingTitle(@NotNull class_3222 player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        settingTitle.remove(player.method_5667());
    }

    public final void startAddingMember(@NotNull class_3222 player, @NotNull String areaName) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)areaName, (String)"areaName");
        addingMember.put(player.method_5667(), areaName);
    }

    @Nullable
    public final String getAddingMemberArea(@NotNull class_3222 player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        return addingMember.get(player.method_5667());
    }

    public final void stopAddingMember(@NotNull class_3222 player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        addingMember.remove(player.method_5667());
    }
}
