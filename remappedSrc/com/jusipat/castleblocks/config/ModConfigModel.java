package com.jusipat.castleblocks.config;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.RestartRequired;


@Modmenu(modId = "castleblocks")
@Config(name = "castleblocks_config", wrapperName = "CastleBlocksConfig")
public class ModConfigModel {
    @RestartRequired
    public boolean castleBlocksPvP = true;
    @RestartRequired
    public float castleBrickHardness = 2.5f;
    @RestartRequired
    public float castleBrickResistance = 11.0f;
    @RestartRequired
    public float outsideOwnerCoefficient = 0.01f;
}

