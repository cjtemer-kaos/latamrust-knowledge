/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2338
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.f0cus.protectionstones;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2338;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004H\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u00c6\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0004H\u00d6\u0001\u00a2\u0006\u0004\b\u0016\u0010\rJ\u0010\u0010\u0017\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\u0017\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u000f\u00a8\u0006\u001e"}, d2={"Lcom/f0cus/protectionstones/StoneLocationData;", "", "", "stoneType", "", "size", "Lnet/minecraft/class_2338;", "coords", "<init>", "(Ljava/lang/String;ILnet/minecraft/class_2338;)V", "component1", "()Ljava/lang/String;", "component2", "()I", "component3", "()Lnet/minecraft/class_2338;", "copy", "(Ljava/lang/String;ILnet/minecraft/class_2338;)Lcom/f0cus/protectionstones/StoneLocationData;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getStoneType", "I", "getSize", "Lnet/minecraft/class_2338;", "getCoords", "ClaimBlocks"})
public final class StoneLocationData {
    @NotNull
    private final String stoneType;
    private final int size;
    @NotNull
    private final class_2338 coords;

    public StoneLocationData(@NotNull String stoneType, int size, @NotNull class_2338 coords) {
        Intrinsics.checkNotNullParameter((Object)stoneType, (String)"stoneType");
        Intrinsics.checkNotNullParameter((Object)coords, (String)"coords");
        this.stoneType = stoneType;
        this.size = size;
        this.coords = coords;
    }

    @NotNull
    public final String getStoneType() {
        return this.stoneType;
    }

    public final int getSize() {
        return this.size;
    }

    @NotNull
    public final class_2338 getCoords() {
        return this.coords;
    }

    @NotNull
    public final String component1() {
        return this.stoneType;
    }

    public final int component2() {
        return this.size;
    }

    @NotNull
    public final class_2338 component3() {
        return this.coords;
    }

    @NotNull
    public final StoneLocationData copy(@NotNull String stoneType, int size, @NotNull class_2338 coords) {
        Intrinsics.checkNotNullParameter((Object)stoneType, (String)"stoneType");
        Intrinsics.checkNotNullParameter((Object)coords, (String)"coords");
        return new StoneLocationData(stoneType, size, coords);
    }

    public static /* synthetic */ StoneLocationData copy$default(StoneLocationData stoneLocationData, String string, int n, class_2338 class_23382, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string = stoneLocationData.stoneType;
        }
        if ((n2 & 2) != 0) {
            n = stoneLocationData.size;
        }
        if ((n2 & 4) != 0) {
            class_23382 = stoneLocationData.coords;
        }
        return stoneLocationData.copy(string, n, class_23382);
    }

    @NotNull
    public String toString() {
        return "StoneLocationData(stoneType=" + this.stoneType + ", size=" + this.size + ", coords=" + this.coords + ")";
    }

    public int hashCode() {
        int result = this.stoneType.hashCode();
        result = result * 31 + Integer.hashCode(this.size);
        result = result * 31 + this.coords.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoneLocationData)) {
            return false;
        }
        StoneLocationData stoneLocationData = (StoneLocationData)other;
        if (!Intrinsics.areEqual((Object)this.stoneType, (Object)stoneLocationData.stoneType)) {
            return false;
        }
        if (this.size != stoneLocationData.size) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.coords, (Object)stoneLocationData.coords);
    }
}
