package com.mixplus.mods.afkpowersave.client.mixin;

import com.mixplus.mods.afkpowersave.client.AfkpowersaveClient;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumerProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Queue;

@Mixin(ParticleManager.class)
public class ParticleManagerMixin {

    @Inject(method = "renderParticles(Lnet/minecraft/client/render/Camera;FLnet/minecraft/client/render/VertexConsumerProvider$Immediate;Lnet/minecraft/client/particle/ParticleTextureSheet;Ljava/util/Queue;)V", at = @At("HEAD"), cancellable = true)
    private static void disableParticles(
            Camera camera,
            float tickProgress,
            VertexConsumerProvider.Immediate vertexConsumers,
            ParticleTextureSheet sheet,
            Queue<Particle> particles,
            CallbackInfo ci
    ) {
        if (AfkpowersaveClient.getRenderSettings().isDisableParticles()
                && AfkpowersaveClient.isAFK()) {
            ci.cancel();
        }
    }
}
