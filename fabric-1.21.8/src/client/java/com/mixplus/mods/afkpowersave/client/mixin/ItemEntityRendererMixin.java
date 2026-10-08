package com.mixplus.mods.afkpowersave.client.mixin;

import com.mixplus.mods.afkpowersave.client.AfkpowersaveClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.ItemEntityRenderer;
import net.minecraft.client.render.entity.state.ItemEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntityRenderer.class)
public class ItemEntityRendererMixin {

    @Inject(
            method = "render(Lnet/minecraft/client/render/entity/state/ItemEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void render(
            ItemEntityRenderState state,
            MatrixStack matrices,
            VertexConsumerProvider providers,
            int light,
            CallbackInfo ci
    ) {
        if (AfkpowersaveClient.getRenderSettings().isDisableDroppedItems()
                && AfkpowersaveClient.isAFK()) {
            ci.cancel();
        }
    }
}
