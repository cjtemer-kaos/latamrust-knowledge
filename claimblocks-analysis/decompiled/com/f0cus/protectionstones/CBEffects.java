/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.internal.ProgressionUtilKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2338
 *  net.minecraft.class_2390
 *  net.minecraft.class_2394
 *  net.minecraft.class_3218
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3f
 */
package com.f0cus.protectionstones;

import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2338;
import net.minecraft.class_2390;
import net.minecraft.class_2394;
import net.minecraft.class_3218;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lcom/f0cus/protectionstones/CBEffects;", "", "<init>", "()V", "Lnet/minecraft/class_3218;", "world", "Lnet/minecraft/class_2338;", "pos1", "pos2", "", "showCube", "(Lnet/minecraft/class_3218;Lnet/minecraft/class_2338;Lnet/minecraft/class_2338;)V", "ClaimBlocks"})
public final class CBEffects {
    @NotNull
    public static final CBEffects INSTANCE = new CBEffects();

    private CBEffects() {
    }

    public final void showCube(@NotNull class_3218 world, @NotNull class_2338 pos1, @NotNull class_2338 pos2) {
        int z;
        int y;
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos1, (String)"pos1");
        Intrinsics.checkNotNullParameter((Object)pos2, (String)"pos2");
        int minX = Math.min(pos1.method_10263(), pos2.method_10263());
        int minY = Math.min(pos1.method_10264(), pos2.method_10264());
        int minZ = Math.min(pos1.method_10260(), pos2.method_10260());
        int maxX = Math.max(pos1.method_10263(), pos2.method_10263());
        int maxY = Math.max(pos1.method_10264(), pos2.method_10264());
        int maxZ = Math.max(pos1.method_10260(), pos2.method_10260());
        class_2390 particle = new class_2390(new Vector3f(0.8f, 0.2f, 1.0f), 1.0f);
        int x = minX;
        int n = ProgressionUtilKt.getProgressionLastElement((int)minX, (int)maxX, (int)3);
        if (x <= n) {
            while (true) {
                double xPos = (double)x + 0.5;
                world.method_14199((class_2394)particle, xPos, (double)minY + 0.5, (double)minZ + 0.5, 1, 0.0, 0.0, 0.0, 0.0);
                world.method_14199((class_2394)particle, xPos, (double)maxY + 0.5, (double)minZ + 0.5, 1, 0.0, 0.0, 0.0, 0.0);
                world.method_14199((class_2394)particle, xPos, (double)minY + 0.5, (double)maxZ + 0.5, 1, 0.0, 0.0, 0.0, 0.0);
                world.method_14199((class_2394)particle, xPos, (double)maxY + 0.5, (double)maxZ + 0.5, 1, 0.0, 0.0, 0.0, 0.0);
                if (x == n) break;
                x += 3;
            }
        }
        if ((y = minY) <= (n = ProgressionUtilKt.getProgressionLastElement((int)minY, (int)maxY, (int)3))) {
            while (true) {
                double yPos = (double)y + 0.5;
                world.method_14199((class_2394)particle, (double)minX + 0.5, yPos, (double)minZ + 0.5, 1, 0.0, 0.0, 0.0, 0.0);
                world.method_14199((class_2394)particle, (double)maxX + 0.5, yPos, (double)minZ + 0.5, 1, 0.0, 0.0, 0.0, 0.0);
                world.method_14199((class_2394)particle, (double)minX + 0.5, yPos, (double)maxZ + 0.5, 1, 0.0, 0.0, 0.0, 0.0);
                world.method_14199((class_2394)particle, (double)maxX + 0.5, yPos, (double)maxZ + 0.5, 1, 0.0, 0.0, 0.0, 0.0);
                if (y == n) break;
                y += 3;
            }
        }
        if ((z = minZ) <= (n = ProgressionUtilKt.getProgressionLastElement((int)minZ, (int)maxZ, (int)3))) {
            while (true) {
                double zPos = (double)z + 0.5;
                world.method_14199((class_2394)particle, (double)minX + 0.5, (double)minY + 0.5, zPos, 1, 0.0, 0.0, 0.0, 0.0);
                world.method_14199((class_2394)particle, (double)maxX + 0.5, (double)minY + 0.5, zPos, 1, 0.0, 0.0, 0.0, 0.0);
                world.method_14199((class_2394)particle, (double)minX + 0.5, (double)maxY + 0.5, zPos, 1, 0.0, 0.0, 0.0, 0.0);
                world.method_14199((class_2394)particle, (double)maxX + 0.5, (double)maxY + 0.5, zPos, 1, 0.0, 0.0, 0.0, 0.0);
                if (z == n) break;
                z += 3;
            }
        }
    }
}
