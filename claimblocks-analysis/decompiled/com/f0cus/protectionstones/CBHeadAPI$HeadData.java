/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.f0cus.protectionstones;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\tJ\u0010\u0010\u000b\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u000b\u0010\tJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H\u00d6\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\u0015\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0019\u0010\t\u00a8\u0006\u001a"}, d2={"Lcom/f0cus/protectionstones/CBHeadAPI$HeadData;", "", "", "name", "uuid", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/f0cus/protectionstones/CBHeadAPI$HeadData;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getName", "getUuid", "getValue", "ClaimBlocks"})
public static final class CBHeadAPI.HeadData {
    @NotNull
    private final String name;
    @NotNull
    private final String uuid;
    @NotNull
    private final String value;

    public CBHeadAPI.HeadData(@NotNull String name, @NotNull String uuid, @NotNull String value) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)uuid, (String)"uuid");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        this.name = name;
        this.uuid = uuid;
        this.value = value;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getUuid() {
        return this.uuid;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final String component2() {
        return this.uuid;
    }

    @NotNull
    public final String component3() {
        return this.value;
    }

    @NotNull
    public final CBHeadAPI.HeadData copy(@NotNull String name, @NotNull String uuid, @NotNull String value) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)uuid, (String)"uuid");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        return new CBHeadAPI.HeadData(name, uuid, value);
    }

    public static /* synthetic */ CBHeadAPI.HeadData copy$default(CBHeadAPI.HeadData headData, String string, String string2, String string3, int n, Object object) {
        if ((n & 1) != 0) {
            string = headData.name;
        }
        if ((n & 2) != 0) {
            string2 = headData.uuid;
        }
        if ((n & 4) != 0) {
            string3 = headData.value;
        }
        return headData.copy(string, string2, string3);
    }

    @NotNull
    public String toString() {
        return "HeadData(name=" + this.name + ", uuid=" + this.uuid + ", value=" + this.value + ")";
    }

    public int hashCode() {
        int result = this.name.hashCode();
        result = result * 31 + this.uuid.hashCode();
        result = result * 31 + this.value.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CBHeadAPI.HeadData)) {
            return false;
        }
        CBHeadAPI.HeadData headData = (CBHeadAPI.HeadData)other;
        if (!Intrinsics.areEqual((Object)this.name, (Object)headData.name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.uuid, (Object)headData.uuid)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.value, (Object)headData.value);
    }
}
