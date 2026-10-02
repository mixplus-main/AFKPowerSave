package com.mixplus.mods.afkpowersave.client;

import com.mixplus.mods.afkpowersave.client.afk.AFKDetector;
import com.mixplus.mods.afkpowersave.client.config.Config;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class AfkpowersaveClient implements ClientModInitializer {
    private static final Config config = new Config();
    private static AFKDetector detector;


    @Override
    public void onInitializeClient() {
        Config.HANDLER.load();
        detector = new AFKDetector();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            detector.tick();
        });
    }

    public static Config getConfig() {
        return Config.HANDLER.instance();
    }

    public static AFKDetector getDetector() {
        return detector;
    }


}
