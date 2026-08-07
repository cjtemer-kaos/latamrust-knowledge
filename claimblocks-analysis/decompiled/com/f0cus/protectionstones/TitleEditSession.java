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

import com.f0cus.protectionstones.TitleEditState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004H\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u00c6\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H\u00d6\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\u0015\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u000b\u00a8\u0006\u001a"}, d2={"Lcom/f0cus/protectionstones/TitleEditSession;", "", "", "areaName", "Lcom/f0cus/protectionstones/TitleEditState;", "state", "<init>", "(Ljava/lang/String;Lcom/f0cus/protectionstones/TitleEditState;)V", "component1", "()Ljava/lang/String;", "component2", "()Lcom/f0cus/protectionstones/TitleEditState;", "copy", "(Ljava/lang/String;Lcom/f0cus/protectionstones/TitleEditState;)Lcom/f0cus/protectionstones/TitleEditSession;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAreaName", "Lcom/f0cus/protectionstones/TitleEditState;", "getState", "ClaimBlocks"})
public final class TitleEditSession {
    @NotNull
    private final String areaName;
    @NotNull
    private final TitleEditState state;

    public TitleEditSession(@NotNull String areaName, @NotNull TitleEditState state) {
        Intrinsics.checkNotNullParameter((Object)areaName, (String)"areaName");
        Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
        this.areaName = areaName;
        this.state = state;
    }

    @NotNull
    public final String getAreaName() {
        return this.areaName;
    }

    @NotNull
    public final TitleEditState getState() {
        return this.state;
    }

    @NotNull
    public final String component1() {
        return this.areaName;
    }

    @NotNull
    public final TitleEditState component2() {
        return this.state;
    }

    @NotNull
    public final TitleEditSession copy(@NotNull String areaName, @NotNull TitleEditState state) {
        Intrinsics.checkNotNullParameter((Object)areaName, (String)"areaName");
        Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
        return new TitleEditSession(areaName, state);
    }

    public static /* synthetic */ TitleEditSession copy$default(TitleEditSession titleEditSession, String string, TitleEditState titleEditState, int n, Object object) {
        if ((n & 1) != 0) {
            string = titleEditSession.areaName;
        }
        if ((n & 2) != 0) {
            titleEditState = titleEditSession.state;
        }
        return titleEditSession.copy(string, titleEditState);
    }

    @NotNull
    public String toString() {
        return "TitleEditSession(areaName=" + this.areaName + ", state=" + this.state + ")";
    }

    public int hashCode() {
        int result = this.areaName.hashCode();
        result = result * 31 + this.state.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TitleEditSession)) {
            return false;
        }
        TitleEditSession titleEditSession = (TitleEditSession)other;
        if (!Intrinsics.areEqual((Object)this.areaName, (Object)titleEditSession.areaName)) {
            return false;
        }
        return this.state == titleEditSession.state;
    }
}
