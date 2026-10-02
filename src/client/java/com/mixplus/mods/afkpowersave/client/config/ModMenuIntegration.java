package com.mixplus.mods.afkpowersave.client.config;

import com.mixplus.mods.afkpowersave.client.AfkpowersaveClient;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.api.controller.BooleanControllerBuilder;
import dev.isxander.yacl3.api.controller.IntegerSliderControllerBuilder;
import dev.isxander.yacl3.gui.controllers.string.number.IntegerFieldController;
import net.minecraft.text.Text;

public class ModMenuIntegration implements ModMenuApi {
    private final Config config;
    public ModMenuIntegration() {
        this.config = AfkpowersaveClient.getConfig();
    }

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        YetAnotherConfigLib.Builder builder = YetAnotherConfigLib.createBuilder();
        builder.title(Text.literal("AFK PowerSave"));




        builder.category(
                this.afkCategory()
        );

        builder.category(
                this.renderCategory()
        );


        return parentScreen -> builder
                .save(Config.HANDLER::save)
                .build()
                .generateScreen(parentScreen);
    }

    private ConfigCategory afkCategory() {
        ConfigCategory afkCategory = ConfigCategory.createBuilder()
                .name(Text.literal("AFK"))
                .option(
                        Option.<Boolean>createBuilder()
                                .name(Text.literal("Enable"))
                                .binding(
                                        config.isEnabled(),
                                        config::isEnabled,
                                        config::setEnabled
                                )
                                .controller(BooleanControllerBuilder::create)
                                .build()
                ).option(
                        Option.<Integer>createBuilder()
                                .name(Text.literal("Apply Time"))
                                .binding(
                                        config.getAfkApplyMinutes(),
                                        config::getAfkApplyMinutes,
                                        config::setAfkApplyMinutes
                                )
                                .controller(opt -> IntegerSliderControllerBuilder.create(opt)
                                        .range(1, 60)
                                        .formatValue(value -> Text.literal(value + " minutes"))
                                        .step(1)
                                )
                                .build()
                ).option(
                        Option.<Integer>createBuilder()
                                .name(Text.literal("FPS"))
                                .binding(
                                        config.getAfkFps(),
                                        config::getAfkFps,
                                        config::setAfkFps
                                )
                                .controller(opt -> IntegerSliderControllerBuilder.create(opt)
                                        .range(10, 250)
                                        .formatValue(value -> Text.literal(value + " fps"))
                                        .step(10)
                                )
                                .build()
                ).option(
                        Option.<Integer>createBuilder()
                                .name(Text.literal("Renderer Distance"))
                                .binding(
                                        config.getAfkRenderDistance(),
                                        config::getAfkRenderDistance,
                                        config::setAfkRenderDistance
                                )
                                .controller(opt -> IntegerSliderControllerBuilder.create(opt)
                                        .range(2, 32)
                                        .step(1)
                                        .formatValue(value -> Text.literal(value + " chunks"))
                                )
                                .build()
                )
                .build();
        return afkCategory;
    }

    private ConfigCategory renderCategory() {

        return ConfigCategory.createBuilder()
                .name(Text.literal("Render"))
                .option(
                        Option.<Boolean>createBuilder()
                                .name(Text.literal("Disable Particles"))
                                .binding(
                                        config.isDisableParticles(),
                                        config::isDisableParticles,
                                        config::setDisableParticles
                                )
                                .controller(BooleanControllerBuilder::create)
                                .build()
                ).option(
                        Option.<Boolean>createBuilder()
                                .name(Text.literal("Hide Dropped Items"))
                                .binding(
                                        config.isDisableDroppedItems(),
                                        config::isDisableDroppedItems,
                                        config::setDisableDroppedItems
                                )
                                .controller(BooleanControllerBuilder::create)
                                .build()
                ).option(
                        Option.<Boolean>createBuilder()
                                .name(Text.literal("Disable Entity Shadows"))
                                .binding(
                                        config.isDisableEntityShadows(),
                                        config::isDisableEntityShadows,
                                        config::setDisableEntityShadows
                                )
                                .controller(BooleanControllerBuilder::create)
                                .build()
                ).option(
                        Option.<Boolean>createBuilder()
                                .name(Text.literal("Hide Entities"))
                                .binding(
                                        config.isDisableEntities(),
                                        config::isDisableEntities,
                                        config::setDisableEntities
                                )
                                .controller(BooleanControllerBuilder::create)
                                .build()
                ).option(
                        Option.<Boolean>createBuilder()
                                .name(Text.literal("Hide Block Entities"))
                                .controller(BooleanControllerBuilder::create)
                                .binding(
                                        config.isDisableBlockEntities(),
                                        config::isDisableBlockEntities,
                                        config::setDisableBlockEntities
                                )
                                .build()
                ).option(
                        Option.<Boolean>createBuilder()
                                .name(Text.literal("Disable Clouds"))
                                .controller(BooleanControllerBuilder::create)
                                .binding(
                                        config.isDisableClouds(),
                                        config::isDisableClouds,
                                        config::setDisableClouds
                                )
                                .build()
                ).option(
                        Option.<Boolean>createBuilder()
                                .name(Text.literal("Disable Weather"))
                                .controller(BooleanControllerBuilder::create)
                                .binding(
                                        config.isDisableWeather(),
                                        config::isDisableWeather,
                                        config::setDisableWeather
                                )
                                .build()
                ).option(
                        Option.<Boolean>createBuilder()
                                .name(Text.literal("Disable Sky"))
                                .controller(BooleanControllerBuilder::create)
                                .binding(
                                        config.isDisableSky(),
                                        config::isDisableSky,
                                        config::setDisableSky
                                )
                                .build()
                ).option(
                        Option.<Boolean>createBuilder()
                                .name(Text.literal("Disable Block Damage"))
                                .controller(BooleanControllerBuilder::create)
                                .binding(
                                        config.isDisableBlockDamage(),
                                        config::isDisableBlockDamage,
                                        config::setDisableBlockDamage
                                )
                                .build()
                ).option(
                        Option.<Boolean>createBuilder()
                                .name(Text.literal("Disable Block Outline"))
                                .controller(BooleanControllerBuilder::create)
                                .binding(
                                        config.isDisableBlockOutline(),
                                        config::isDisableBlockOutline,
                                        config::setDisableBlockOutline
                                )
                                .build()
                ).option(
                        Option.<Boolean>createBuilder()
                                .name(Text.literal("Disable Terrain"))
                                .controller(BooleanControllerBuilder::create)
                                .binding(
                                        config.isDisableTerrain(),
                                        config::isDisableTerrain,
                                        config::setDisableTerrain
                                )
                                .build()
                )
                .build();
    }
}
