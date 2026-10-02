package com.mixplus.mods.afkpowersave.client.afk;

import com.mixplus.mods.afkpowersave.client.AfkpowersaveClient;
import com.mixplus.mods.afkpowersave.client.config.Config;
import net.minecraft.client.MinecraftClient;

public class AFKDetector {
    private final MinecraftClient client;
    private final Config config;
    private final Controller controller;
    private long lastInputTime = System.currentTimeMillis();

    private boolean afk;
    private boolean restored = false;

    private static final boolean DEV = false;

    public AFKDetector() {
        this.client = MinecraftClient.getInstance();
        this.config = AfkpowersaveClient.getConfig();
        this.controller = new Controller();


    }

    public void tick() {
        if (client.world == null || client.options == null) {
            return;
        }

        if (!restored) {
            if (config.isAfkApplied()) {
                controller.restore();
            }

            restored = true;
        }

        if (!config.isEnabled()) {
            return;
        }

        if (client.options.forwardKey.isPressed()
                || client.options.backKey.isPressed()
                || client.options.leftKey.isPressed()
                || client.options.rightKey.isPressed()
                || client.options.jumpKey.isPressed()
        ) {


            if (this.afk) {
                controller.cancel();
            }

            this.afk = false;
            this.input();
            return;
        }

        if (!this.afk && isAFK()) {
            this.afk = true;
            controller.start();
        }


    }

    public void input() {
        this.lastInputTime = System.currentTimeMillis();
    }

    public boolean isAFK() {
        if (DEV) {
            return System.currentTimeMillis() - lastInputTime >= 5_000L;
        }

        long afkTime = config.getAfkApplyMinutes() * 60_000L;

        return System.currentTimeMillis() - lastInputTime >= afkTime;
    }
}
