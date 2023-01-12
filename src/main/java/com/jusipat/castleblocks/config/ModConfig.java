package com.jusipat.castleblocks.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "castleblocks")
public class ModConfig implements ConfigData {

    @ConfigEntry.Gui.Tooltip
    public static boolean castleBlocksPvP = true;
    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Gui.Tooltip
    public static float castleBrickHardness = 2.5f;
    @ConfigEntry.Gui.Tooltip
    public static float castleBrickResistance = 11.0f;
    @ConfigEntry.Gui.Tooltip
    public static float outsideOwnerCoefficient = 0.01f;
}
