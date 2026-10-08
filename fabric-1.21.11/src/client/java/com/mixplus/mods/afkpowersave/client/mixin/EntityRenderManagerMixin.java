package com.mixplus.mods.afkpowersave.client.mixin;

import com.mixplus.mods.afkpowersave.client.AfkpowersaveClient;

import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.EntityRenderManager;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderManager.class)
public class EntityRenderManagerMixin {

    @Inject(
            method = "render(Lnet/minecraft/client/render/entity/state/EntityRenderState;Lnet/minecraft/client/render/state/CameraRenderState;DDDLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private <S extends EntityRenderState> void render(
            S renderState,
            CameraRenderState cameraState,
            double offsetX,
            double offsetY,
            double offsetZ,
            MatrixStack matrices,
            OrderedRenderCommandQueue queue,
            CallbackInfo ci
    ) {
        if (AfkpowersaveClient.getRenderSettings().isDisableEntities()
                && AfkpowersaveClient.isAFK()) {
            ci.cancel();
        }
    }
}
