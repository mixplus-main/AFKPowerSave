package com.mixplus.mods.afkpowersave.client.mixin;

import com.mixplus.mods.afkpowersave.client.AfkpowersaveClient;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import net.minecraft.client.option.CloudRenderMode;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.FrameGraphBuilder;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.state.WorldRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.security.auth.callback.Callback;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {

    @Inject(
            method = "renderParticles(Lnet/minecraft/client/render/FrameGraphBuilder;Lcom/mojang/blaze3d/buffers/GpuBufferSlice;)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void renderParticles(
            FrameGraphBuilder frameGraphBuilder,
            GpuBufferSlice fogBuffer,
            CallbackInfo ci
    ) {
        if (AfkpowersaveClient.getRenderSettings().isDisableParticles()
                && AfkpowersaveClient.isAFK()) {
            ci.cancel();
        }
    }

    @Inject(
            method = "renderClouds",
            at = @At("HEAD"),
            cancellable = true
    )
    private void renderClouds(
            FrameGraphBuilder frameGraphBuilder,
            CloudRenderMode mode,
            Vec3d cameraPos,
            long l,
            float f,
            int i,
            float g,
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
            GpuBufferSlice gpuBufferSlice,
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
            GpuBufferSlice fogBuffer,
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
            VertexConsumerProvider.Immediate immediate,
            WorldRenderState renderStates,
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
            VertexConsumerProvider.Immediate immediate,
            MatrixStack matrices,
            boolean renderBlockOutline,
            WorldRenderState renderStates,
            CallbackInfo ci
    ) {
        if (AfkpowersaveClient.getRenderSettings().isDisableBlockOutline()
                && AfkpowersaveClient.isAFK()) {
            ci.cancel();
        }
    }
}
