package com.mixplus.mods.afkpowersave.client.afk;

import com.mixplus.mods.afkpowersave.client.AfkpowersaveClient;
import com.mixplus.mods.afkpowersave.client.config.Config;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class Controller {
    private final Config config;
    private final MinecraftClient client;

    public Controller() {
        this.config = AfkpowersaveClient.getConfig();
        this.client = MinecraftClient.getInstance();
    }


    public void run(boolean afk) {
        if (!afk) {
            this.cancel();
            return;
        }

        this.start();
    }

    public void start() {
        int fps = client.options.getMaxFps().getValue();
        int renderDistance = client.options.getViewDistance().getValue();

        config.setPreviousFps(fps);
        config.setPreviousRenderDistance(renderDistance);
        config.setAfkApplied(true);

        Config.HANDLER.save();

        client.options.getMaxFps().setValue(config.afkFps);
        client.options.getViewDistance().setValue(config.afkRenderDistance);

        if (client.player != null) {
            client.player.sendMessage(
                    Text.literal("AFK mode enabled").formatted(Formatting.GREEN),
                    true
            );
        }
    }

    public void cancel() {
        restore();

        if (client.player != null) {
            client.player.sendMessage(
                    Text.literal("AFK mode disable").formatted(Formatting.YELLOW),
                    true
            );
        }
    }

    public void restore() {
        config.setAfkApplied(false);
        client.options.getMaxFps().setValue(config.getPreviousFps());
        client.options.getViewDistance().setValue(config.getPreviousRenderDistance());
    }
}
