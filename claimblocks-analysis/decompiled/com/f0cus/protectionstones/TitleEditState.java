/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package com.f0cus.protectionstones;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lcom/f0cus/protectionstones/TitleEditState;", "", "<init>", "(Ljava/lang/String;I)V", "TITLE", "SUBTITLE", "ClaimBlocks"})
public final class TitleEditState
extends Enum<TitleEditState> {
    public static final /* enum */ TitleEditState TITLE = new TitleEditState();
    public static final /* enum */ TitleEditState SUBTITLE = new TitleEditState();
    private static final /* synthetic */ TitleEditState[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static TitleEditState[] values() {
        return (TitleEditState[])$VALUES.clone();
    }

    public static TitleEditState valueOf(String value) {
        return Enum.valueOf(TitleEditState.class, value);
    }

    @NotNull
    public static EnumEntries<TitleEditState> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = titleEditStateArray = new TitleEditState[]{TitleEditState.TITLE, TitleEditState.SUBTITLE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}
