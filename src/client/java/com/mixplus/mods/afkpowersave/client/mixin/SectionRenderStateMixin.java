package com.mixplus.mods.afkpowersave.client.mixin;

import com.mixplus.mods.afkpowersave.client.AfkpowersaveClient;
import net.minecraft.client.render.BlockRenderLayerGroup;
import net.minecraft.client.render.SectionRenderState;
import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SectionRenderState.class)
public class SectionRenderStateMixin {

    @Inject(
            method = "renderSection",
            at = @At("HEAD"),
            cancellable = true
    )
    private void renderSection(
            BlockRenderLayerGroup group,
            CallbackInfo ci
    ) {
        if (AfkpowersaveClient.getConfig().isDisableTerrain()
                && AfkpowersaveClient.getDetector().isAFK()) {
            ci.cancel();
        }
    }
}
