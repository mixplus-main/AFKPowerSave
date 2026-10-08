package com.mixplus.mods.afkpowersave.client.config;



import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import dev.isxander.yacl3.api.YetAnotherConfigLib;

import net.minecraft.text.Text;

public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        YetAnotherConfigLib.Builder builder = YetAnotherConfigLib.createBuilder()
                .title(Text.literal("AFK PowerSave"))
                .category(
                        AfkSettings.HANDLER.instance().getCategory()
                )
                .category(
                        RenderSettings.HANDLER.instance().getCategory()
                )
                .save(() -> {
                    AfkSettings.HANDLER.save();
                    RenderSettings.HANDLER.save();
                });




        return parentScreen -> builder
                .save(() -> {
                    AfkSettings.HANDLER.save();

                    RenderSettings.HANDLER.save();

                })
                .build()
                .generateScreen(parentScreen);
    }
}