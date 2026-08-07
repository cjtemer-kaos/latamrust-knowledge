/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package com.f0cus.protectionstones;

import com.f0cus.protectionstones.TitleEditState;
import kotlin.Metadata;

@Metadata(mv={2, 2, 0}, k=3, xi=48)
public static final class CBEventHandler.WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        int[] nArray = new int[TitleEditState.values().length];
        try {
            nArray[TitleEditState.TITLE.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            nArray[TitleEditState.SUBTITLE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        $EnumSwitchMapping$0 = nArray;
    }
}
