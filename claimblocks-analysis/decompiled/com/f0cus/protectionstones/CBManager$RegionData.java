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

import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2338;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\"\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\b\u0082\b\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0004H\u00c6\u0003\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u001a\u0010\u0015J\u0010\u0010\u001b\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u001b\u0010\u0019J\u0010\u0010\u001c\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u001c\u0010\u0019J\u001c\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0004\b\u001f\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b!\u0010\u0015J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\"\u0010\u0015J\u0012\u0010#\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b#\u0010\u0015J\u009a\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001\u00a2\u0006\u0004\b$\u0010%J\u001a\u0010(\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010+\u001a\u00020*H\u00d6\u0001\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b-\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010.\u001a\u0004\b/\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u00100\u001a\u0004\b1\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u00102\u001a\u0004\b3\u0010\u0019R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010.\u001a\u0004\b4\u0010\u0015R\u0017\u0010\t\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\t\u00102\u001a\u0004\b5\u0010\u0019R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\n\u00102\u001a\u0004\b6\u0010\u0019R#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u00107\u001a\u0004\b8\u0010\u001eR\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u00109\u001a\u0004\b:\u0010 R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010.\u001a\u0004\b;\u0010\u0015R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010.\u001a\u0004\b<\u0010\u0015R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010.\u001a\u0004\b=\u0010\u0015\u00a8\u0006>"}, d2={"Lcom/f0cus/protectionstones/CBManager$RegionData;", "", "", "name", "Ljava/util/UUID;", "owner", "Lnet/minecraft/class_2338;", "centerBlock", "stoneType", "pos1", "pos2", "", "flags", "", "members", "enterTitle", "enterSubtitle", "world", "<init>", "(Ljava/lang/String;Ljava/util/UUID;Lnet/minecraft/class_2338;Ljava/lang/String;Lnet/minecraft/class_2338;Lnet/minecraft/class_2338;Ljava/util/Map;Ljava/util/Set;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "()Ljava/util/UUID;", "component3", "()Lnet/minecraft/class_2338;", "component4", "component5", "component6", "component7", "()Ljava/util/Map;", "component8", "()Ljava/util/Set;", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/util/UUID;Lnet/minecraft/class_2338;Ljava/lang/String;Lnet/minecraft/class_2338;Lnet/minecraft/class_2338;Ljava/util/Map;Ljava/util/Set;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/f0cus/protectionstones/CBManager$RegionData;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getName", "Ljava/util/UUID;", "getOwner", "Lnet/minecraft/class_2338;", "getCenterBlock", "getStoneType", "getPos1", "getPos2", "Ljava/util/Map;", "getFlags", "Ljava/util/Set;", "getMembers", "getEnterTitle", "getEnterSubtitle", "getWorld", "ClaimBlocks"})
private static final class CBManager.RegionData {
    @NotNull
    private final String name;
    @NotNull
    private final UUID owner;
    @NotNull
    private final class_2338 centerBlock;
    @Nullable
    private final String stoneType;
    @NotNull
    private final class_2338 pos1;
    @NotNull
    private final class_2338 pos2;
    @NotNull
    private final Map<String, Object> flags;
    @Nullable
    private final Set<UUID> members;
    @Nullable
    private final String enterTitle;
    @Nullable
    private final String enterSubtitle;
    @Nullable
    private final String world;

    public CBManager.RegionData(@NotNull String name, @NotNull UUID owner, @NotNull class_2338 centerBlock, @Nullable String stoneType, @NotNull class_2338 pos1, @NotNull class_2338 pos2, @NotNull Map<String, ? extends Object> flags, @Nullable Set<UUID> members, @Nullable String enterTitle, @Nullable String enterSubtitle, @Nullable String world) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)owner, (String)"owner");
        Intrinsics.checkNotNullParameter((Object)centerBlock, (String)"centerBlock");
        Intrinsics.checkNotNullParameter((Object)pos1, (String)"pos1");
        Intrinsics.checkNotNullParameter((Object)pos2, (String)"pos2");
        Intrinsics.checkNotNullParameter(flags, (String)"flags");
        this.name = name;
        this.owner = owner;
        this.centerBlock = centerBlock;
        this.stoneType = stoneType;
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.flags = flags;
        this.members = members;
        this.enterTitle = enterTitle;
        this.enterSubtitle = enterSubtitle;
        this.world = world;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final UUID getOwner() {
        return this.owner;
    }

    @NotNull
    public final class_2338 getCenterBlock() {
        return this.centerBlock;
    }

    @Nullable
    public final String getStoneType() {
        return this.stoneType;
    }

    @NotNull
    public final class_2338 getPos1() {
        return this.pos1;
    }

    @NotNull
    public final class_2338 getPos2() {
        return this.pos2;
    }

    @NotNull
    public final Map<String, Object> getFlags() {
        return this.flags;
    }

    @Nullable
    public final Set<UUID> getMembers() {
        return this.members;
    }

    @Nullable
    public final String getEnterTitle() {
        return this.enterTitle;
    }

    @Nullable
    public final String getEnterSubtitle() {
        return this.enterSubtitle;
    }

    @Nullable
    public final String getWorld() {
        return this.world;
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final UUID component2() {
        return this.owner;
    }

    @NotNull
    public final class_2338 component3() {
        return this.centerBlock;
    }

    @Nullable
    public final String component4() {
        return this.stoneType;
    }

    @NotNull
    public final class_2338 component5() {
        return this.pos1;
    }

    @NotNull
    public final class_2338 component6() {
        return this.pos2;
    }

    @NotNull
    public final Map<String, Object> component7() {
        return this.flags;
    }

    @Nullable
    public final Set<UUID> component8() {
        return this.members;
    }

    @Nullable
    public final String component9() {
        return this.enterTitle;
    }

    @Nullable
    public final String component10() {
        return this.enterSubtitle;
    }

    @Nullable
    public final String component11() {
        return this.world;
    }

    @NotNull
    public final CBManager.RegionData copy(@NotNull String name, @NotNull UUID owner, @NotNull class_2338 centerBlock, @Nullable String stoneType, @NotNull class_2338 pos1, @NotNull class_2338 pos2, @NotNull Map<String, ? extends Object> flags, @Nullable Set<UUID> members, @Nullable String enterTitle, @Nullable String enterSubtitle, @Nullable String world) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)owner, (String)"owner");
        Intrinsics.checkNotNullParameter((Object)centerBlock, (String)"centerBlock");
        Intrinsics.checkNotNullParameter((Object)pos1, (String)"pos1");
        Intrinsics.checkNotNullParameter((Object)pos2, (String)"pos2");
        Intrinsics.checkNotNullParameter(flags, (String)"flags");
        return new CBManager.RegionData(name, owner, centerBlock, stoneType, pos1, pos2, flags, members, enterTitle, enterSubtitle, world);
    }

    public static /* synthetic */ CBManager.RegionData copy$default(CBManager.RegionData regionData, String string, UUID uUID, class_2338 class_23382, String string2, class_2338 class_23383, class_2338 class_23384, Map map, Set set, String string3, String string4, String string5, int n, Object object) {
        if ((n & 1) != 0) {
            string = regionData.name;
        }
        if ((n & 2) != 0) {
            uUID = regionData.owner;
        }
        if ((n & 4) != 0) {
            class_23382 = regionData.centerBlock;
        }
        if ((n & 8) != 0) {
            string2 = regionData.stoneType;
        }
        if ((n & 0x10) != 0) {
            class_23383 = regionData.pos1;
        }
        if ((n & 0x20) != 0) {
            class_23384 = regionData.pos2;
        }
        if ((n & 0x40) != 0) {
            map = regionData.flags;
        }
        if ((n & 0x80) != 0) {
            set = regionData.members;
        }
        if ((n & 0x100) != 0) {
            string3 = regionData.enterTitle;
        }
        if ((n & 0x200) != 0) {
            string4 = regionData.enterSubtitle;
        }
        if ((n & 0x400) != 0) {
            string5 = regionData.world;
        }
        return regionData.copy(string, uUID, class_23382, string2, class_23383, class_23384, map, set, string3, string4, string5);
    }

    @NotNull
    public String toString() {
        return "RegionData(name=" + this.name + ", owner=" + this.owner + ", centerBlock=" + this.centerBlock + ", stoneType=" + this.stoneType + ", pos1=" + this.pos1 + ", pos2=" + this.pos2 + ", flags=" + this.flags + ", members=" + this.members + ", enterTitle=" + this.enterTitle + ", enterSubtitle=" + this.enterSubtitle + ", world=" + this.world + ")";
    }

    public int hashCode() {
        int result = this.name.hashCode();
        result = result * 31 + this.owner.hashCode();
        result = result * 31 + this.centerBlock.hashCode();
        result = result * 31 + (this.stoneType == null ? 0 : this.stoneType.hashCode());
        result = result * 31 + this.pos1.hashCode();
        result = result * 31 + this.pos2.hashCode();
        result = result * 31 + ((Object)this.flags).hashCode();
        result = result * 31 + (this.members == null ? 0 : ((Object)this.members).hashCode());
        result = result * 31 + (this.enterTitle == null ? 0 : this.enterTitle.hashCode());
        result = result * 31 + (this.enterSubtitle == null ? 0 : this.enterSubtitle.hashCode());
        result = result * 31 + (this.world == null ? 0 : this.world.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CBManager.RegionData)) {
            return false;
        }
        CBManager.RegionData regionData = (CBManager.RegionData)other;
        if (!Intrinsics.areEqual((Object)this.name, (Object)regionData.name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.owner, (Object)regionData.owner)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.centerBlock, (Object)regionData.centerBlock)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.stoneType, (Object)regionData.stoneType)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.pos1, (Object)regionData.pos1)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.pos2, (Object)regionData.pos2)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.flags, regionData.flags)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.members, regionData.members)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.enterTitle, (Object)regionData.enterTitle)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.enterSubtitle, (Object)regionData.enterSubtitle)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.world, (Object)regionData.world);
    }
}
