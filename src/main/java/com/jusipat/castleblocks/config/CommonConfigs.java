package com.jusipat.castleblocks.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static ForgeConfigSpec SPEC;

    public static ForgeConfigSpec.DoubleValue MODIFIER;
    public static ForgeConfigSpec.BooleanValue PVP_MODE;

    static {
        BUILDER.push("CastleBlocks Configuration");

        PVP_MODE = BUILDER.comment("Enables if castle bricks are harder to break if not the block owner")
                .define("PVP_MODE", true);

        MODIFIER = BUILDER.comment("""
                        Server must be restarted for changes to go into effect
                        Hardness modifier if not the block owner:
                        Higher values, harder to break
                        Lower values, easier to break
                        0.0 will break it instantly;
                        1.0 is Vanilla hardness""")
                .worldRestart()
                .defineInRange("Hardness Modifier", 80.0F, 0.0F, 1000.0);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}

