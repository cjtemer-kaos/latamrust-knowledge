/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.f0cus.protectionstones;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0011\u0010\u000fJB\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\u0018\u0010\fJ\u0010\u0010\u0019\u001a\u00020\u0005H\u00d6\u0001\u00a2\u0006\u0004\b\u0019\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001c\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001f\u0010\u000fR\u0017\u0010\b\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b \u0010\u000f\u00a8\u0006!"}, d2={"Lcom/f0cus/protectionstones/StoneConfig;", "", "", "radius_x", "radius_z", "", "head_info", "head", "display_name", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "()I", "component2", "component3", "()Ljava/lang/String;", "component4", "component5", "copy", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/f0cus/protectionstones/StoneConfig;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "I", "getRadius_x", "getRadius_z", "Ljava/lang/String;", "getHead_info", "getHead", "getDisplay_name", "ClaimBlocks"})
public final class StoneConfig {
    private final int radius_x;
    private final int radius_z;
    @NotNull
    private final String head_info;
    @NotNull
    private final String head;
    @NotNull
    private final String display_name;

    public StoneConfig(int radius_x, int radius_z, @NotNull String head_info, @NotNull String head, @NotNull String display_name) {
        Intrinsics.checkNotNullParameter((Object)head_info, (String)"head_info");
        Intrinsics.checkNotNullParameter((Object)head, (String)"head");
        Intrinsics.checkNotNullParameter((Object)display_name, (String)"display_name");
        this.radius_x = radius_x;
        this.radius_z = radius_z;
        this.head_info = head_info;
        this.head = head;
        this.display_name = display_name;
    }

    public /* synthetic */ StoneConfig(int n, int n2, String string, String string2, String string3, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 1) != 0) {
            n = 5;
        }
        if ((n3 & 2) != 0) {
            n2 = 5;
        }
        if ((n3 & 4) != 0) {
            string = "Use 'Value' from minecraft-heads.com";
        }
        if ((n3 & 8) != 0) {
            string2 = "Coal Ore";
        }
        if ((n3 & 0x10) != 0) {
            string3 = "&8Coal Protection";
        }
        this(n, n2, string, string2, string3);
    }

    public final int getRadius_x() {
        return this.radius_x;
    }

    public final int getRadius_z() {
        return this.radius_z;
    }

    @NotNull
    public final String getHead_info() {
        return this.head_info;
    }

    @NotNull
    public final String getHead() {
        return this.head;
    }

    @NotNull
    public final String getDisplay_name() {
        return this.display_name;
    }

    public final int component1() {
        return this.radius_x;
    }

    public final int component2() {
        return this.radius_z;
    }

    @NotNull
    public final String component3() {
        return this.head_info;
    }

    @NotNull
    public final String component4() {
        return this.head;
    }

    @NotNull
    public final String component5() {
        return this.display_name;
    }

    @NotNull
    public final StoneConfig copy(int radius_x, int radius_z, @NotNull String head_info, @NotNull String head, @NotNull String display_name) {
        Intrinsics.checkNotNullParameter((Object)head_info, (String)"head_info");
        Intrinsics.checkNotNullParameter((Object)head, (String)"head");
        Intrinsics.checkNotNullParameter((Object)display_name, (String)"display_name");
        return new StoneConfig(radius_x, radius_z, head_info, head, display_name);
    }

    public static /* synthetic */ StoneConfig copy$default(StoneConfig stoneConfig, int n, int n2, String string, String string2, String string3, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = stoneConfig.radius_x;
        }
        if ((n3 & 2) != 0) {
            n2 = stoneConfig.radius_z;
        }
        if ((n3 & 4) != 0) {
            string = stoneConfig.head_info;
        }
        if ((n3 & 8) != 0) {
            string2 = stoneConfig.head;
        }
        if ((n3 & 0x10) != 0) {
            string3 = stoneConfig.display_name;
        }
        return stoneConfig.copy(n, n2, string, string2, string3);
    }

    @NotNull
    public String toString() {
        return "StoneConfig(radius_x=" + this.radius_x + ", radius_z=" + this.radius_z + ", head_info=" + this.head_info + ", head=" + this.head + ", display_name=" + this.display_name + ")";
    }

    public int hashCode() {
        int result = Integer.hashCode(this.radius_x);
        result = result * 31 + Integer.hashCode(this.radius_z);
        result = result * 31 + this.head_info.hashCode();
        result = result * 31 + this.head.hashCode();
        result = result * 31 + this.display_name.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoneConfig)) {
            return false;
        }
        StoneConfig stoneConfig = (StoneConfig)other;
        if (this.radius_x != stoneConfig.radius_x) {
            return false;
        }
        if (this.radius_z != stoneConfig.radius_z) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.head_info, (Object)stoneConfig.head_info)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.head, (Object)stoneConfig.head)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.display_name, (Object)stoneConfig.display_name);
    }

    public StoneConfig() {
        this(0, 0, null, null, null, 31, null);
    }
}
