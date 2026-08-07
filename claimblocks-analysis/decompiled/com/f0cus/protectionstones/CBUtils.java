/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.minecraft.class_124
 *  net.minecraft.class_2561
 *  net.minecraft.class_3222
 *  net.minecraft.class_3312
 *  net.minecraft.class_5250
 *  net.minecraft.server.MinecraftServer
 *  org.jetbrains.annotations.NotNull
 */
package com.f0cus.protectionstones;

import com.f0cus.protectionstones.CBTexts;
import com.mojang.authlib.GameProfile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.class_124;
import net.minecraft.class_2561;
import net.minecraft.class_3222;
import net.minecraft.class_3312;
import net.minecraft.class_5250;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\t\u0010\nJ/\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00102\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2={"Lcom/f0cus/protectionstones/CBUtils;", "", "<init>", "()V", "", "text", "translateColors", "(Ljava/lang/String;)Ljava/lang/String;", "Lnet/minecraft/class_2561;", "createSuccessMessage", "(Ljava/lang/String;)Lnet/minecraft/class_2561;", "Lnet/minecraft/server/MinecraftServer;", "server", "", "Ljava/util/UUID;", "uuids", "Ljava/util/concurrent/CompletableFuture;", "", "Lcom/mojang/authlib/GameProfile;", "getGameProfiles", "(Lnet/minecraft/server/MinecraftServer;Ljava/util/Collection;)Ljava/util/concurrent/CompletableFuture;", "uuid", "getGameProfile", "(Lnet/minecraft/server/MinecraftServer;Ljava/util/UUID;)Ljava/util/concurrent/CompletableFuture;", "ClaimBlocks"})
@SourceDebugExtension(value={"SMAP\nCBUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CBUtils.kt\ncom/f0cus/protectionstones/CBUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,69:1\n1869#2,2:70\n*S KotlinDebug\n*F\n+ 1 CBUtils.kt\ncom/f0cus/protectionstones/CBUtils\n*L\n41#1:70,2\n*E\n"})
public final class CBUtils {
    @NotNull
    public static final CBUtils INSTANCE = new CBUtils();

    private CBUtils() {
    }

    @NotNull
    public final String translateColors(@NotNull String text) {
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        return StringsKt.replace$default((String)text, (char)'&', (char)'\u00a7', (boolean)false, (int)4, null);
    }

    @NotNull
    public final class_2561 createSuccessMessage(@NotNull String text) {
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        class_5250 prefix = class_2561.method_43470((String)this.translateColors(CBTexts.INSTANCE.getConfig().getPrefix())).method_27692(class_124.field_1067);
        class_5250 separator = class_2561.method_43470((String)" - ").method_27692(class_124.field_1080);
        class_124[] class_124Array = new class_124[]{class_124.field_1068, class_124.field_1056};
        class_5250 content = class_2561.method_43470((String)text).method_27695(class_124Array);
        class_5250 class_52502 = prefix.method_10852((class_2561)separator).method_10852((class_2561)content);
        Intrinsics.checkNotNullExpressionValue((Object)class_52502, (String)"append(...)");
        return (class_2561)class_52502;
    }

    @NotNull
    public final CompletableFuture<List<GameProfile>> getGameProfiles(@NotNull MinecraftServer server, @NotNull Collection<UUID> uuids) {
        Intrinsics.checkNotNullParameter((Object)server, (String)"server");
        Intrinsics.checkNotNullParameter(uuids, (String)"uuids");
        CompletableFuture<List<GameProfile>> completableFuture = CompletableFuture.supplyAsync(() -> CBUtils.getGameProfiles$lambda$0(server, uuids));
        Intrinsics.checkNotNullExpressionValue(completableFuture, (String)"supplyAsync(...)");
        return completableFuture;
    }

    @NotNull
    public final CompletableFuture<GameProfile> getGameProfile(@NotNull MinecraftServer server, @NotNull UUID uuid) {
        Intrinsics.checkNotNullParameter((Object)server, (String)"server");
        Intrinsics.checkNotNullParameter((Object)uuid, (String)"uuid");
        CompletableFuture<GameProfile> completableFuture = CompletableFuture.supplyAsync(() -> CBUtils.getGameProfile$lambda$0(server, uuid));
        Intrinsics.checkNotNullExpressionValue(completableFuture, (String)"supplyAsync(...)");
        return completableFuture;
    }

    private static final List getGameProfiles$lambda$0(MinecraftServer $server, Collection $uuids) {
        List profiles = new ArrayList();
        class_3312 profileCache = $server.method_3793();
        Iterable $this$forEach$iv = $uuids;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            UUID uuid = (UUID)element$iv;
            boolean bl = false;
            class_3222 onlinePlayer = $server.method_3760().method_14602(uuid);
            if (onlinePlayer != null) {
                GameProfile gameProfile = onlinePlayer.method_7334();
                Intrinsics.checkNotNullExpressionValue((Object)gameProfile, (String)"getGameProfile(...)");
                profiles.add(gameProfile);
                continue;
            }
            Object object = profileCache;
            if (object == null || (object = object.method_14512(uuid)) == null) continue;
            ((Optional)object).ifPresent(arg_0 -> CBUtils.getGameProfiles$lambda$0$0$1(arg_0 -> CBUtils.getGameProfiles$lambda$0$0$0(profiles, arg_0), arg_0));
        }
        return profiles;
    }

    private static final Unit getGameProfiles$lambda$0$0$0(List $profiles, GameProfile it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        $profiles.add(it);
        return Unit.INSTANCE;
    }

    private static final void getGameProfiles$lambda$0$0$1(Function1 $tmp0, Object p0) {
        $tmp0.invoke(p0);
    }

    private static final GameProfile getGameProfile$lambda$0(MinecraftServer $server, UUID $uuid) {
        Object object;
        class_3222 onlinePlayer = $server.method_3760().method_14602($uuid);
        return onlinePlayer != null ? onlinePlayer.method_7334() : ((object = $server.method_3793()) != null && (object = object.method_14512($uuid)) != null ? (GameProfile)((Optional)object).orElse(null) : null);
    }
}
