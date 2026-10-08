package com.mixplus.mods.afkpowersave.client.afk;

import com.mixplus.mods.afkpowersave.api.AFKController;
import com.mixplus.mods.afkpowersave.client.AfkpowersaveClient;
import com.mixplus.mods.afkpowersave.client.config.AfkSettings;
import com.mixplus.mods.afkpowersave.client.config.StateSettings;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class Controller implements AFKController {
    private final MinecraftClient client;

    public Controller() {
        this.client = MinecraftClient.getInstance();
    }


    @Override
    public void start() {
        AfkSettings afkSettings = AfkpowersaveClient.getAfkSettings();
        StateSettings stateSettings = AfkpowersaveClient.getStateSetting();

        int fps = client.options.getMaxFps().getValue();
        int renderDistance = client.options.getViewDistance().getValue();

        stateSettings.setPreviousFps(fps);
        stateSettings.setPreviousRenderDistance(renderDistance);
        stateSettings.setAfkApplied(true);

        AfkSettings.HANDLER.save();

        client.options.getMaxFps().setValue(afkSettings.afkFps);
        client.options.getViewDistance().setValue(afkSettings.afkRenderDistance);

        if (client.player != null) {
            client.player.sendMessage(
                    Text.literal("AFK mode enabled").formatted(Formatting.GREEN),
                    true
            );
        }
    }

    @Override
    public void cancel() {
        restore();

        if (client.player != null) {
            client.player.sendMessage(
                    Text.literal("AFK mode disable").formatted(Formatting.YELLOW),
                    true
            );
        }
    }

    @Override
    public void restore() {
        StateSettings stateSettings = AfkpowersaveClient.getStateSetting();
        stateSettings.setAfkApplied(false);
        client.options.getMaxFps().setValue(stateSettings.getPreviousFps());
        client.options.getViewDistance().setValue(stateSettings.getPreviousRenderDistance());
    }
}
