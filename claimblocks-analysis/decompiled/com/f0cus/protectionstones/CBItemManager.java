/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.properties.Property
 *  com.mojang.authlib.properties.PropertyMap
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.CharsKt
 *  net.minecraft.class_124
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_2487
 *  net.minecraft.class_2561
 *  net.minecraft.class_5250
 *  net.minecraft.class_9279
 *  net.minecraft.class_9290
 *  net.minecraft.class_9296
 *  net.minecraft.class_9334
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.f0cus.protectionstones;

import com.f0cus.protectionstones.CBConfig;
import com.f0cus.protectionstones.CBHeadAPI;
import com.f0cus.protectionstones.CBTexts;
import com.f0cus.protectionstones.CBUtils;
import com.f0cus.protectionstones.StoneConfig;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import net.minecraft.class_124;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_2487;
import net.minecraft.class_2561;
import net.minecraft.class_5250;
import net.minecraft.class_9279;
import net.minecraft.class_9290;
import net.minecraft.class_9296;
import net.minecraft.class_9334;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ#\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2={"Lcom/f0cus/protectionstones/CBItemManager;", "", "<init>", "()V", "", "stoneType", "Lnet/minecraft/class_1799;", "getStone", "(Ljava/lang/String;)Lnet/minecraft/class_1799;", "stack", "getStoneType", "(Lnet/minecraft/class_1799;)Ljava/lang/String;", "typeOverride", "updateStoneLore", "(Lnet/minecraft/class_1799;Ljava/lang/String;)Lnet/minecraft/class_1799;", "PS_TAG_KEY", "Ljava/lang/String;", "ClaimBlocks"})
@SourceDebugExtension(value={"SMAP\nCBItemManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CBItemManager.kt\ncom/f0cus/protectionstones/CBItemManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,89:1\n1#2:90\n*E\n"})
public final class CBItemManager {
    @NotNull
    public static final CBItemManager INSTANCE = new CBItemManager();
    @NotNull
    private static final String PS_TAG_KEY = "protectionstones:stone_type";

    private CBItemManager() {
    }

    @Nullable
    public final class_1799 getStone(@NotNull String stoneType) {
        class_9279 class_92792;
        Intrinsics.checkNotNullParameter((Object)stoneType, (String)"stoneType");
        Map<String, StoneConfig> map = CBConfig.INSTANCE.getStones();
        String string = stoneType.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toLowerCase(...)");
        StoneConfig stoneConfig = map.get(string);
        if (stoneConfig == null) {
            return null;
        }
        StoneConfig config = stoneConfig;
        class_1799 stack = new class_1799((class_1935)class_1802.field_8575);
        String texture = CBHeadAPI.INSTANCE.getTexture(config.getHead());
        if (texture != null) {
            UUID id = UUID.randomUUID();
            PropertyMap properties = new PropertyMap();
            properties.put((Object)"textures", (Object)new Property("textures", texture));
            class_9296 profile = new class_9296(Optional.empty(), Optional.of(id), properties);
            stack.method_57379(class_9334.field_49617, (Object)profile);
        }
        if ((class_92792 = (class_9279)stack.method_57824(class_9334.field_49628)) == null || (class_92792 = class_92792.method_57461()) == null) {
            class_92792 = new class_2487();
        }
        class_9279 tag = class_92792;
        tag.method_10582(PS_TAG_KEY, stoneType);
        stack.method_57379(class_9334.field_49628, (Object)class_9279.method_57456((class_2487)tag));
        return this.updateStoneLore(stack, stoneType);
    }

    @Nullable
    public final String getStoneType(@NotNull class_1799 stack) {
        String string;
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        class_9279 class_92792 = (class_9279)stack.method_57824(class_9334.field_49628);
        if (class_92792 == null || (class_92792 = class_92792.method_57461()) == null) {
            return null;
        }
        class_9279 tag = class_92792;
        String it = string = tag.method_10558(PS_TAG_KEY);
        boolean bl = false;
        Intrinsics.checkNotNull((Object)it);
        return ((CharSequence)it).length() > 0 ? string : null;
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public final class_1799 updateStoneLore(@NotNull class_1799 stack, @Nullable String typeOverride) {
        String string;
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        String string2 = typeOverride;
        if (string2 == null && (string2 = this.getStoneType(stack)) == null) {
            return null;
        }
        String stoneType = string2;
        Map<String, StoneConfig> map = CBConfig.INSTANCE.getStones();
        String string3 = stoneType.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"toLowerCase(...)");
        StoneConfig stoneConfig = map.get(string3);
        if (stoneConfig == null) {
            return stack;
        }
        StoneConfig config = stoneConfig;
        String string4 = stoneType;
        if (((CharSequence)string4).length() > 0) {
            void it22;
            char c = string4.charAt(0);
            StringBuilder stringBuilder = new StringBuilder();
            int n = 0;
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"ROOT");
            StringBuilder stringBuilder2 = stringBuilder.append((Object)CharsKt.titlecase((char)it22, (Locale)locale));
            String it22 = string4;
            n = 1;
            String string5 = it22.substring(n);
            Intrinsics.checkNotNullExpressionValue((Object)string5, (String)"substring(...)");
            string = stringBuilder2.append(string5).toString();
        } else {
            string = string4;
        }
        String capType = string;
        int sizeX = config.getRadius_x();
        int sizeZ = config.getRadius_z();
        String sizeDesc = "(" + sizeX + "R x Full-H x " + sizeZ + "R)";
        String nameStr = config.getDisplay_name();
        stack.method_57379(class_9334.field_49631, (Object)class_2561.method_43470((String)CBUtils.INSTANCE.translateColors(nameStr)).method_27692(class_124.field_1067));
        Object[] objectArray = CBTexts.INSTANCE.getConfig().getLore().getStoneLore();
        Object[] objectArray2 = new Object[]{sizeDesc};
        String string6 = String.format((String)objectArray, Arrays.copyOf(objectArray2, objectArray2.length));
        Intrinsics.checkNotNullExpressionValue((Object)string6, (String)"format(...)");
        String loreStr = string6;
        objectArray = new class_5250[]{class_2561.method_43470((String)CBUtils.INSTANCE.translateColors(loreStr)), class_2561.method_43470((String)"")};
        stack.method_57379(class_9334.field_49632, (Object)new class_9290(CollectionsKt.listOf((Object[])objectArray)));
        return stack;
    }

    public static /* synthetic */ class_1799 updateStoneLore$default(CBItemManager cBItemManager, class_1799 class_17992, String string, int n, Object object) {
        if ((n & 2) != 0) {
            string = null;
        }
        return cBItemManager.updateStoneLore(class_17992, string);
    }
}
