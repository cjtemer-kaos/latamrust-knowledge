/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.CommandDispatcher
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.api.DedicatedServerModInitializer
 *  net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
 *  net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
 *  net.minecraft.class_2168
 *  net.minecraft.class_2170$class_5364
 *  net.minecraft.class_3218
 *  net.minecraft.class_7157
 *  net.minecraft.server.MinecraftServer
 *  org.jetbrains.annotations.NotNull
 */
package com.f0cus.protectionstones;

import com.f0cus.protectionstones.CBCommandHandler;
import com.f0cus.protectionstones.CBConfig;
import com.f0cus.protectionstones.CBEventHandler;
import com.f0cus.protectionstones.CBLocationsManager;
import com.f0cus.protectionstones.CBManager;
import com.f0cus.protectionstones.CBTexts;
import com.mojang.brigadier.CommandDispatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.class_2168;
import net.minecraft.class_2170;
import net.minecraft.class_3218;
import net.minecraft.class_7157;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lcom/f0cus/protectionstones/CBEntryPoint;", "Lnet/fabricmc/api/DedicatedServerModInitializer;", "<init>", "()V", "", "onInitializeServer", "", "MOD_ID", "Ljava/lang/String;", "ClaimBlocks"})
public final class CBEntryPoint
implements DedicatedServerModInitializer {
    @NotNull
    public static final CBEntryPoint INSTANCE = new CBEntryPoint();
    @NotNull
    public static final String MOD_ID = "claimblocks";

    private CBEntryPoint() {
    }

    public void onInitializeServer() {
        System.out.println((Object)"[claimblocks] Mod initializing...");
        CBConfig.INSTANCE.load();
        CommandRegistrationCallback.EVENT.register(CBEntryPoint::onInitializeServer$lambda$0);
        ServerLifecycleEvents.SERVER_STARTED.register(CBEntryPoint::onInitializeServer$lambda$1);
        ServerLifecycleEvents.SERVER_STOPPING.register(CBEntryPoint::onInitializeServer$lambda$2);
        CBEventHandler.INSTANCE.register();
        System.out.println((Object)"[claimblocks] Mod initialized successfully.");
    }

    private static final void onInitializeServer$lambda$0(CommandDispatcher dispatcher, class_7157 class_71572, class_2170.class_5364 class_53642) {
        Intrinsics.checkNotNull((Object)dispatcher);
        CBCommandHandler.INSTANCE.register((CommandDispatcher<class_2168>)dispatcher);
    }

    private static final void onInitializeServer$lambda$1(MinecraftServer server) {
        class_3218 world = server.method_30002();
        CBTexts.INSTANCE.load();
        CBManager.INSTANCE.load();
        Intrinsics.checkNotNull((Object)world);
        CBLocationsManager.INSTANCE.load(world);
    }

    private static final void onInitializeServer$lambda$2(MinecraftServer minecraftServer) {
        CBManager.INSTANCE.save();
        CBLocationsManager.INSTANCE.save();
        CBTexts.INSTANCE.save();
    }
}
