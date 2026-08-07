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

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\bJ$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\u0013\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\b\u00a8\u0006\u0017"}, d2={"Lcom/f0cus/protectionstones/LoreStrings;", "", "", "stoneName", "stoneLore", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/f0cus/protectionstones/LoreStrings;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getStoneName", "getStoneLore", "ClaimBlocks"})
public final class LoreStrings {
    @NotNull
    private final String stoneName;
    @NotNull
    private final String stoneLore;

    public LoreStrings(@NotNull String stoneName, @NotNull String stoneLore) {
        Intrinsics.checkNotNullParameter((Object)stoneName, (String)"stoneName");
        Intrinsics.checkNotNullParameter((Object)stoneLore, (String)"stoneLore");
        this.stoneName = stoneName;
        this.stoneLore = stoneLore;
    }

    public /* synthetic */ LoreStrings(String string, String string2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            string = "&8&l\u2751 &5Claim Module &8- &f%s";
        }
        if ((n & 2) != 0) {
            string2 = "&7Deploy this module to establish a &f%s &7security perimeter.";
        }
        this(string, string2);
    }

    @NotNull
    public final String getStoneName() {
        return this.stoneName;
    }

    @NotNull
    public final String getStoneLore() {
        return this.stoneLore;
    }

    @NotNull
    public final String component1() {
        return this.stoneName;
    }

    @NotNull
    public final String component2() {
        return this.stoneLore;
    }

    @NotNull
    public final LoreStrings copy(@NotNull String stoneName, @NotNull String stoneLore) {
        Intrinsics.checkNotNullParameter((Object)stoneName, (String)"stoneName");
        Intrinsics.checkNotNullParameter((Object)stoneLore, (String)"stoneLore");
        return new LoreStrings(stoneName, stoneLore);
    }

    public static /* synthetic */ LoreStrings copy$default(LoreStrings loreStrings, String string, String string2, int n, Object object) {
        if ((n & 1) != 0) {
            string = loreStrings.stoneName;
        }
        if ((n & 2) != 0) {
            string2 = loreStrings.stoneLore;
        }
        return loreStrings.copy(string, string2);
    }

    @NotNull
    public String toString() {
        return "LoreStrings(stoneName=" + this.stoneName + ", stoneLore=" + this.stoneLore + ")";
    }

    public int hashCode() {
        int result = this.stoneName.hashCode();
        result = result * 31 + this.stoneLore.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoreStrings)) {
            return false;
        }
        LoreStrings loreStrings = (LoreStrings)other;
        if (!Intrinsics.areEqual((Object)this.stoneName, (Object)loreStrings.stoneName)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.stoneLore, (Object)loreStrings.stoneLore);
    }

    public LoreStrings() {
        this(null, null, 3, null);
    }
}
