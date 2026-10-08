package com.mixplus.mods.afkpowersave.client.config;

import com.mixplus.mods.afkpowersave.api.RenderConfig;
import com.mixplus.mods.afkpowersave.client.AfkpowersaveClient;
import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class RenderSettings implements RenderConfig {
    public static final ConfigClassHandler<RenderSettings> HANDLER =
            ConfigClassHandler.createBuilder(RenderSettings.class)
                    .id(Identifier.of("afkpowersave", "render"))
                    .serializer(config -> GsonConfigSerializerBuilder.create(config)
                            .setPath(
                                    FabricLoader.getInstance()
                                            .getConfigDir()
                                            .resolve("afkpowersave")
                                            .resolve("render.json5")
                            )
                            .setJson5(true)
                            .build())
                    .build();

    @SerialEntry
    public boolean disableParticles = true;

    @Override
    public void setDisableParticles(boolean value) {
        this.disableParticles = value;
    }

    @Override
    public boolean isDisableParticles() {
        return this.disableParticles;
    }


    @SerialEntry
    public boolean disableDroppedItems = true;

    @Override
    public void setDisableDroppedItems(boolean value) {
        this.disableDroppedItems = value;
    }

    @Override
    public boolean isDisableDroppedItems() {
        return this.disableDroppedItems;
    }


    @SerialEntry
    public boolean disableEntityShadows = true;

    @Override
    public void setDisableEntityShadows(boolean value) {
        this.disableEntityShadows = value;
    }

    @Override
    public boolean isDisableEntityShadows() {
        return this.disableEntityShadows;
    }


    @SerialEntry
    public boolean disableEntities = true;

    @Override
    public void setDisableEntities(boolean value) {
        this.disableEntities = value;
    }

    @Override
    public boolean isDisableEntities() {
        return this.disableEntities;
    }


    @SerialEntry
    public boolean disableBlockEntities = true;

    @Override
    public void setDisableBlockEntities(boolean value) {
        this.disableBlockEntities = value;
    }

    @Override
    public boolean isDisableBlockEntities() {
        return this.disableBlockEntities;
    }


    @SerialEntry
    public boolean disableClouds = true;

    @Override
    public void setDisableClouds(boolean value) {
        this.disableClouds = value;
    }

    @Override
    public boolean isDisableClouds() {
        return this.disableClouds;
    }


    @SerialEntry
    public boolean disableWeather = true;

    @Override
    public void setDisableWeather(boolean value) {
        this.disableWeather = value;
    }

    @Override
    public boolean isDisableWeather() {
        return this.disableWeather;
    }


    @SerialEntry
    public boolean disableSky = true;

    @Override
    public void setDisableSky(boolean value) {
        this.disableSky = value;
    }

    @Override
    public boolean isDisableSky() {
        return this.disableSky;
    }


    @SerialEntry
    public boolean disableBlockDamage = true;

    @Override
    public void setDisableBlockDamage(boolean value) {
        this.disableBlockDamage = value;
    }

    @Override
    public boolean isDisableBlockDamage() {
        return this.disableBlockDamage;
    }


    @SerialEntry
    public boolean disableBlockOutline = true;

    @Override
    public void setDisableBlockOutline(boolean value) {
        this.disableBlockOutline = value;
    }

    @Override
    public boolean isDisableBlockOutline() {
        return this.disableBlockOutline;
    }


    @SerialEntry
    public boolean disableTerrain = false;

    @Override
    public void setDisableTerrain(boolean value) {
        this.disableTerrain = value;
    }

    @Override
    public boolean isDisableTerrain() {
        return this.disableTerrain;
    }

    public ConfigCategory getCategory() {
        RenderSettings renderSettings = AfkpowersaveClient.getRenderSettings();
        return ConfigCategory.createBuilder()
                .name(Text.literal("Render"))
                .option(
                        Option.<Boolean>createBuilder()
                                .name(Text.literal("Disable Particles"))
                                .binding(
                                        renderSettings.isDisableParticles(),
                                        renderSettings::isDisableParticles,
                                        renderSettings::setDisableParticles
                                )
                                .controller(TickBoxControllerBuilder::create)
                                .build()
                ).option(
                        Option.<Boolean>createBuilder()
                                .name(Text.literal("Hide Dropped Items"))
                                .binding(
                                        renderSettings.isDisableDroppedItems(),
                                        renderSettings::isDisableDroppedItems,
                                        renderSettings::setDisableDroppedItems
                                )
                                .controller(TickBoxControllerBuilder::create)
                                .build()
                ).option(
                        Option.<Boolean>createBuilder()
                                .name(Text.literal("Disable Entity Shadows"))
                                .binding(
                                        renderSettings.isDisableEntityShadows(),
                                        renderSettings::isDisableEntityShadows,
                                        renderSettings::setDisableEntityShadows
                                )
                                .controller(TickBoxControllerBuilder::create)
                                .build()
                ).option(
                        Option.<Boolean>createBuilder()
                                .name(Text.literal("Hide Entities"))
                                .binding(
                                        renderSettings.isDisableEntities(),
                                        renderSettings::isDisableEntities,
                                        renderSettings::setDisableEntities
                                )
                                .controller(TickBoxControllerBuilder::create)
                                .build()
                ).option(
                        Option.<Boolean>createBuilder()
                                .name(Text.literal("Hide Block Entities"))
                                .controller(TickBoxControllerBuilder::create)
                                .binding(
                                        renderSettings.isDisableBlockEntities(),
                                        renderSettings::isDisableBlockEntities,
                                        renderSettings::setDisableBlockEntities
                                )
                                .build()
                ).option(
                        Option.<Boolean>createBuilder()
                                .name(Text.literal("Disable Clouds"))
                                .controller(TickBoxControllerBuilder::create)
                                .binding(
                                        renderSettings.isDisableClouds(),
                                        renderSettings::isDisableClouds,
                                        renderSettings::setDisableClouds
                                )
                                .build()
                ).option(
                        Option.<Boolean>createBuilder()
                                .name(Text.literal("Disable Weather"))
                                .controller(TickBoxControllerBuilder::create)
                                .binding(
                                        renderSettings.isDisableWeather(),
                                        renderSettings::isDisableWeather,
                                        renderSettings::setDisableWeather
                                )
                                .build()
                ).option(
                        Option.<Boolean>createBuilder()
                                .name(Text.literal("Disable Sky"))
                                .controller(TickBoxControllerBuilder::create)
                                .binding(
                                        renderSettings.isDisableSky(),
                                        renderSettings::isDisableSky,
                                        renderSettings::setDisableSky
                                )
                                .build()
                ).option(
                        Option.<Boolean>createBuilder()
                                .name(Text.literal("Disable Block Damage"))
                                .controller(TickBoxControllerBuilder::create)
                                .binding(
                                        renderSettings.isDisableBlockDamage(),
                                        renderSettings::isDisableBlockDamage,
                                        renderSettings::setDisableBlockDamage
                                )
                                .build()
                ).option(
                        Option.<Boolean>createBuilder()
                                .name(Text.literal("Disable Block Outline"))
                                .controller(TickBoxControllerBuilder::create)
                                .binding(
                                        renderSettings.isDisableBlockOutline(),
                                        renderSettings::isDisableBlockOutline,
                                        renderSettings::setDisableBlockOutline
                                )
                                .build()
                ).option(
                        Option.<Boolean>createBuilder()
                                .name(Text.literal("Disable Terrain"))
                                .controller(TickBoxControllerBuilder::create)
                                .binding(
                                        renderSettings.isDisableTerrain(),
                                        renderSettings::isDisableTerrain,
                                        renderSettings::setDisableTerrain
                                )
                                .build()
                )
                .build();
    }
}
