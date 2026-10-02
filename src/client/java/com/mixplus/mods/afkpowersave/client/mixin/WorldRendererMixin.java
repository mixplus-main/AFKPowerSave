package com.mixplus.mods.afkpowersave.client.mixin;

import com.mixplus.mods.afkpowersave.client.AfkpowersaveClient;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import net.minecraft.client.option.CloudRenderMode;
import net.minecraft.client.render.*;
import net.minecraft.client.util.ObjectAllocator;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

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
        if (AfkpowersaveClient.getConfig().isDisableClouds()
                && AfkpowersaveClient.getDetector().isAFK()) {
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
        if (AfkpowersaveClient.getConfig().isDisableWeather()
                && AfkpowersaveClient.getDetector().isAFK()) {
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
        if (AfkpowersaveClient.getConfig().isDisableSky()
                && AfkpowersaveClient.getDetector().isAFK()) {
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
        if (AfkpowersaveClient.getConfig().isDisableBlockDamage()
                && AfkpowersaveClient.getDetector().isAFK()) {
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
        if (AfkpowersaveClient.getConfig().isDisableBlockOutline()
                && AfkpowersaveClient.getDetector().isAFK()) {
            ci.cancel();
        }
    }

    @Inject(
            method = "render",
            at = @At("HEAD"),
            cancellable = true
    )
    private void render(
            ObjectAllocator allocator,
            RenderTickCounter tickCounter,
            boolean renderBlockOutline,
            Camera camera,
            Matrix4f positionMatrix,
            Matrix4f projectionMatrix,
            GpuBufferSlice fog,
            Vector4f fogColor,
            boolean shouldRenderSky,
            CallbackInfo ci
    ) {
        if (AfkpowersaveClient.getConfig().isDisableTerrain()
                && AfkpowersaveClient.getDetector().isAFK()) {
            ci.cancel();
        }
    }



}
