package com.jusipat.castleblocks.config;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;


@Modmenu(modId = "castleblocks")
@Config(name = "castleblocks_config", wrapperName = "CastleBlocksConfig")
public class ModConfigModel {
    public static boolean castleBlocksPvP = true;
    public static float castleBrickHardness = 2.5f;
    public static float castleBrickResistance = 11.0f;
    public static float outsideOwnerCoefficient = 0.01f;
}

