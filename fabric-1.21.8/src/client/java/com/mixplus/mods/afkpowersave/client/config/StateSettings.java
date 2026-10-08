package com.mixplus.mods.afkpowersave.client.config;

import com.mixplus.mods.afkpowersave.api.StateConfig;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;

public class StateSettings implements StateConfig {
    public static final ConfigClassHandler<StateSettings> HANDLER =
            ConfigClassHandler.createBuilder(StateSettings.class)
                    .id(Identifier.of("afkpowersave", "afk"))
                    .serializer(config -> GsonConfigSerializerBuilder.create(config)
                            .setPath(
                                    FabricLoader.getInstance()
                                            .getConfigDir()
                                            .resolve("afkpowersave")
                                            .resolve("state.json5")
                            )
                            .setJson5(true)
                            .build())
                    .build();



    @SerialEntry
    public int previousFps = 160;

    @Override
    public void setPreviousFps(int value) {
        this.previousFps = value;
    }

    @Override
    public int getPreviousFps() {
        return this.previousFps;
    }


    @SerialEntry
    public int previousRenderDistance = 13;

    @Override
    public void setPreviousRenderDistance(int value) {
        this.previousRenderDistance = value;
    }

    @Override
    public int getPreviousRenderDistance() {
        return this.previousRenderDistance;
    }


    @SerialEntry
    public boolean afkApplied;

    @Override
    public void setAfkApplied(boolean value) {
        this.afkApplied = value;
    }

    @Override
    public boolean isAfkApplied() {
        return this.afkApplied;
    }
}
