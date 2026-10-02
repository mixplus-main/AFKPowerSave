package com.mixplus.mods.afkpowersave.client.config;

import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.fabricmc.loader.api.FabricLoader;

import net.minecraft.util.Identifier;

public class Config {
    public static final ConfigClassHandler<Config> HANDLER =
            ConfigClassHandler.createBuilder(Config.class)
                    .id(Identifier.of("afkpowersave", "config"))
                    .serializer(config -> GsonConfigSerializerBuilder.create(config)
                            .setPath(FabricLoader.getInstance()
                                    .getConfigDir()
                                    .resolve("afkpowersave.json5"))
                            .setJson5(true)
                            .build())
                    .build();





    @SerialEntry
    public boolean enabled = true;

    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    public boolean isEnabled() {
        return this.enabled;
    }


    @SerialEntry
    public int afkApplyMinutes = 1;

    public void setAfkApplyMinutes(int value) {
        this.afkApplyMinutes = value;
    }

    public int getAfkApplyMinutes() {
        return this.afkApplyMinutes;
    }


    @SerialEntry
    public int afkFps = 10;

    public void setAfkFps(int value) {
        this.afkFps = value;
    }

    public int getAfkFps() {
        return this.afkFps;
    }


    @SerialEntry
    public int afkRenderDistance = 2;

    public void setAfkRenderDistance(int value) {
        this.afkRenderDistance = value;
    }

    public int getAfkRenderDistance() {
        return this.afkRenderDistance;
    }


    @SerialEntry
    public int previousFps = 160;

    public void setPreviousFps(int value) {
        this.previousFps = value;
    }

    public int getPreviousFps() {
        return this.previousFps;
    }


    @SerialEntry
    public int previousRenderDistance = 13;

    public void setPreviousRenderDistance(int value) {
        this.previousRenderDistance = value;
    }

    public int getPreviousRenderDistance() {
        return this.previousRenderDistance;
    }


    @SerialEntry
    public boolean afkApplied;

    public void setAfkApplied(boolean value) {
        this.afkApplied = value;
    }

    public boolean isAfkApplied() {
        return this.afkApplied;
    }


    @SerialEntry
    public boolean disableParticles = true;

    public void setDisableParticles(boolean value) {
        this.disableParticles = value;
    }

    public boolean isDisableParticles() {
        return this.disableParticles;
    }


    @SerialEntry
    public boolean disableDroppedItems = true;

    public void setDisableDroppedItems(boolean value) {
        this.disableDroppedItems = value;
    }

    public boolean isDisableDroppedItems() {
        return this.disableDroppedItems;
    }


    @SerialEntry
    public boolean disableEntityShadows = true;

    public void setDisableEntityShadows(boolean value) {
        this.disableEntityShadows = value;
    }

    public boolean isDisableEntityShadows() {
        return this.disableEntityShadows;
    }


    @SerialEntry
    public boolean disableEntities = true;

    public void setDisableEntities(boolean value) {
        this.disableEntities = value;
    }

    public boolean isDisableEntities() {
        return this.disableEntities;
    }


    @SerialEntry
    public boolean disableBlockEntities = true;

    public void setDisableBlockEntities(boolean value) {
        this.disableBlockEntities = value;
    }

    public boolean isDisableBlockEntities() {
        return this.disableBlockEntities;
    }


    @SerialEntry
    public boolean disableClouds = true;

    public void setDisableClouds(boolean value) {
        this.disableClouds = value;
    }

    public boolean isDisableClouds() {
        return this.disableClouds;
    }


    @SerialEntry
    public boolean disableWeather = true;

    public void setDisableWeather(boolean value) {
        this.disableWeather = value;
    }

    public boolean isDisableWeather() {
        return this.disableWeather;
    }


    @SerialEntry
    public boolean disableSky = true;

    public void setDisableSky(boolean value) {
        this.disableSky = value;
    }

    public boolean isDisableSky() {
        return this.disableSky;
    }


    @SerialEntry
    public boolean disableBlockDamage = true;

    public void setDisableBlockDamage(boolean value) {
        this.disableBlockDamage = value;
    }

    public boolean isDisableBlockDamage() {
        return this.disableBlockDamage;
    }



    @SerialEntry
    public boolean disableBlockOutline = true;

    public void setDisableBlockOutline(boolean value) {
        this.disableBlockOutline = value;
    }

    public boolean isDisableBlockOutline() {
        return this.disableBlockOutline;
    }


    @SerialEntry
    public boolean disableTerrain = false;

    public void setDisableTerrain(boolean value) {
        this.disableTerrain = value;
    }

    public boolean isDisableTerrain() {
        return this.disableTerrain;
    }

}
