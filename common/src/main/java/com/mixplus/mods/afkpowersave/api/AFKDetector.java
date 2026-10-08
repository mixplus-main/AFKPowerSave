package com.mixplus.mods.afkpowersave.api;

public class AFKDetector {
    private final AFKController controller;
    private final InputProvider inputProvider;

    private long lastInputTime = System.currentTimeMillis();

    public boolean afk;
    private boolean restored = false;

    private static final boolean DEV = false;

    public AFKDetector(
            AFKController controller,
            InputProvider inputProvider
    ) {
        this.controller = controller;
        this.inputProvider = inputProvider;
    }


    public void tick(AFKConfig afkConfig, StateConfig stateConfig) {
        if (!restored) {
            if (stateConfig.isAfkApplied()) {
                controller.restore();
            }

            restored = true;
        }


        if (!afkConfig.isEnabled()) {
            return;
        }

        if (inputProvider.isInputPressed()) {
            if (this.afk) {
                controller.cancel();
            }

            this.afk = false;
            this.input();
            return;
        }

        if (!this.afk && isAFK(afkConfig)) {
            this.afk = true;
            controller.start();
        }

    }

    public void input() {
        this.lastInputTime = System.currentTimeMillis();
    }

    public boolean isAFK(AFKConfig afkConfig) {
        if (DEV) {
            return System.currentTimeMillis() - lastInputTime >= 5_000L;
        }

        long afkTime = switch (afkConfig.getAfkApplyTimeUnit()) {
            case SECONDS -> afkConfig.getAfkApplyTime() * 1_000L;
            case MINUTES -> afkConfig.getAfkApplyTime() * 60_000L;
        };

        return System.currentTimeMillis() - lastInputTime >= afkTime;
    }
}
