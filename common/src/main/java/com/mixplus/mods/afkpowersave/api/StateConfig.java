package com.mixplus.mods.afkpowersave.api;

public interface StateConfig {

    //PreviousFps
    void setPreviousFps(int value);

    int getPreviousFps();


    //previousRenderDistance
    void setPreviousRenderDistance(int value);

    int getPreviousRenderDistance();


    //afkApplied
    void setAfkApplied(boolean value);

    boolean isAfkApplied();
}
