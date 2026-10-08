package com.mixplus.mods.afkpowersave.client.config;


import com.mixplus.mods.afkpowersave.api.AFKConfig;
import com.mixplus.mods.afkpowersave.api.ApplyTimeUnit;
import com.mixplus.mods.afkpowersave.client.AfkpowersaveClient;
import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.controller.EnumControllerBuilder;
import dev.isxander.yacl3.api.controller.IntegerSliderControllerBuilder;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class AfkSettings implements AFKConfig {
    public static final ConfigClassHandler<AfkSettings> HANDLER =
            ConfigClassHandler.createBuilder(AfkSettings.class)
                    .id(Identifier.of("afkpowersave", "afk"))
                    .serializer(config -> GsonConfigSerializerBuilder.create(config)
                            .setPath(
                                    FabricLoader.getInstance()
                                            .getConfigDir()
                                            .resolve("afkpowersave")
                                            .resolve("afk.json5")
                            )
                            .setJson5(true)
                            .build())
                    .build();

    @SerialEntry
    public boolean enabled = true;

    @Override
    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }


    @SerialEntry
    private ApplyTimeUnit afkApplyTimeUnit = ApplyTimeUnit.MINUTES;

    public void setAfkApplyTimeUnit(ApplyTimeUnit unit) {
        this.afkApplyTimeUnit = unit;
    }

    public ApplyTimeUnit getAfkApplyTimeUnit() {
        return this.afkApplyTimeUnit;
    }


    @SerialEntry
    public int afkApplyTime = 1;

    @Override
    public void setAfkApplyTime(int value) {
        this.afkApplyTime = value;
    }

    @Override
    public int getAfkApplyTime() {
        return this.afkApplyTime;
    }


    @SerialEntry
    public int afkFps = 10;

    @Override
    public void setAfkFps(int value) {
        this.afkFps = value;
    }

    @Override
    public int getAfkFps() {
        return this.afkFps;
    }


    @SerialEntry
    public int afkRenderDistance = 2;

    @Override
    public void setAfkRenderDistance(int value) {
        this.afkRenderDistance = value;
    }

    @Override
    public int getAfkRenderDistance() {
        return this.afkRenderDistance;
    }

    public ConfigCategory getCategory() {
        AfkSettings afkSettings = AfkpowersaveClient.getAfkSettings();
        return ConfigCategory.createBuilder()
                .name(Text.literal("AFK"))
                .option(
                        Option.<Boolean>createBuilder()
                                .name(Text.literal("Enable"))
                                .binding(
                                        true,
                                        afkSettings::isEnabled,
                                        afkSettings::setEnabled
                                )
                                .controller(TickBoxControllerBuilder::create)
                                .build()
                ).option(
                        Option.<ApplyTimeUnit>createBuilder()
                                .name(Text.literal("Apply Time Unit"))
                                .binding(
                                        ApplyTimeUnit.MINUTES,
                                        afkSettings::getAfkApplyTimeUnit,
                                        afkSettings::setAfkApplyTimeUnit
                                )
                                .controller(opt -> EnumControllerBuilder.create(opt)
                                        .enumClass(ApplyTimeUnit.class)
                                        .formatValue(value ->
                                                Text.translatable(
                                                        "afkpowersave.apply_time_unit." +
                                                                value.name().toLowerCase()
                                                )
                                        )
                                )
                                .build()
                ).option(
                        Option.<Integer>createBuilder()
                                .name(Text.literal("Apply Time"))
                                .binding(
                                        afkSettings.getAfkApplyTime(),
                                        afkSettings::getAfkApplyTime,
                                        afkSettings::setAfkApplyTime
                                )
                                .controller(opt -> IntegerSliderControllerBuilder.create(opt)
                                        .range(1, 60)
                                        .step(1)
                                )
                                .build()
                ).option(
                        Option.<Integer>createBuilder()
                                .name(Text.literal("FPS"))
                                .binding(
                                        afkSettings.getAfkFps(),
                                        afkSettings::getAfkFps,
                                        afkSettings::setAfkFps
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
                                        afkSettings.getAfkRenderDistance(),
                                        afkSettings::getAfkRenderDistance,
                                        afkSettings::setAfkRenderDistance
                                )
                                .controller(opt -> IntegerSliderControllerBuilder.create(opt)
                                        .range(2, 32)
                                        .step(1)
                                        .formatValue(value -> Text.literal(value + " chunks"))
                                )
                                .build()
                )
                .build();
    }

}
