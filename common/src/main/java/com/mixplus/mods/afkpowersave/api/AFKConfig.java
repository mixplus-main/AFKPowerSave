package com.mixplus.mods.afkpowersave.api;

public interface AFKConfig {

    //Enabled
    void setEnabled(boolean value);

    boolean isEnabled();

    void setAfkApplyTimeUnit(ApplyTimeUnit unit);

    ApplyTimeUnit getAfkApplyTimeUnit();


    //ApplyMinutes
    void setAfkApplyTime(int value);

    int getAfkApplyTime();


    //Fps
    void setAfkFps(int value);

    int getAfkFps();


    //RenderDistance
    void setAfkRenderDistance(int value);

    int getAfkRenderDistance();
}
