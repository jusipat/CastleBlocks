package com.jusipat.castleblocks.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue PVP_MODE;

    static {
        BUILDER.push("CastleBlocks Configuration");

        PVP_MODE = BUILDER.comment("Enables if castle bricks are harder to break if not the original placer")
                .define("true/false", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}

