package com.mixplus.mods.afkpowersave.client.impl;

import com.mixplus.mods.afkpowersave.api.InputProvider;
import net.minecraft.client.MinecraftClient;

public class FabricInputProvider implements InputProvider {
    private final MinecraftClient client = MinecraftClient.getInstance();

    @Override
    public boolean isInputPressed() {
        return client.options.forwardKey.isPressed()
                || client.options.backKey.isPressed()
                || client.options.leftKey.isPressed()
                || client.options.rightKey.isPressed()
                || client.options.jumpKey.isPressed();
    }
}
