package com.mixplus.mods.afkpowersave.client.mixin;

import com.mixplus.mods.afkpowersave.client.AfkpowersaveClient;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import net.minecraft.client.option.CloudRenderMode;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.FrameGraphBuilder;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {

    @Inject(
            method = "renderClouds",
            at = @At("HEAD"),
            cancellable = true
    )
    private void renderClouds(
            FrameGraphBuilder frameGraphBuilder,
            CloudRenderMode mode,
            Vec3d cameraPos,
            float cloudPhase,
            int color,
            float cloudHeight,
            CallbackInfo ci
    ) {
        if (AfkpowersaveClient.getRenderSettings().isDisableClouds()
                && AfkpowersaveClient.isAFK()) {
            ci.cancel();
        }
    }

    @Inject(
            method = "renderWeather",
            at = @At("HEAD"),
            cancellable = true
    )
    private void renderWeather(
            FrameGraphBuilder frameGraphBuilder,
            Vec3d cameraPos,
            float tickProgress,
            GpuBufferSlice fog,
            CallbackInfo ci
    ) {
        if (AfkpowersaveClient.getRenderSettings().isDisableWeather()
                && AfkpowersaveClient.isAFK()) {
            ci.cancel();
        }
    }

    @Inject(
            method = "renderSky",
            at = @At("HEAD"),
            cancellable = true
    )
    private void renderSky(
            FrameGraphBuilder frameGraphBuilder,
            Camera camera,
            float tickProgress,
            GpuBufferSlice fog,
            CallbackInfo ci
    ) {
        if (AfkpowersaveClient.getRenderSettings().isDisableSky()
                && AfkpowersaveClient.isAFK()) {
            ci.cancel();
        }
    }

    @Inject(
            method = "renderBlockDamage",
            at = @At("HEAD"),
            cancellable = true
    )
    private void renderBlockDamage(
            MatrixStack matrices,
            Camera camera,
            VertexConsumerProvider.Immediate vertexConsumers,
            CallbackInfo ci
    ) {
        if (AfkpowersaveClient.getRenderSettings().isDisableBlockDamage()
                && AfkpowersaveClient.isAFK()) {
            ci.cancel();
        }
    }

    @Inject(
            method = "renderTargetBlockOutline",
            at = @At("HEAD"),
            cancellable = true
    )
    private void renderTargetBlockOutline(
            Camera camera,
            VertexConsumerProvider.Immediate vertexConsumers,
            MatrixStack matrices,
            boolean translucent,
            CallbackInfo ci
    ) {
        if (AfkpowersaveClient.getRenderSettings().isDisableBlockOutline()
                && AfkpowersaveClient.isAFK()) {
            ci.cancel();
        }
    }



}
