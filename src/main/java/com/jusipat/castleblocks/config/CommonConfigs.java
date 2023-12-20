package com.jusipat.castleblocks.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static ForgeConfigSpec SPEC;
    public static ForgeConfigSpec.DoubleValue MODIFIER;
    public static ForgeConfigSpec.BooleanValue PVP_MODE;
    public static ForgeConfigSpec.DoubleValue BOULDER_DAMAGE;
    public static ForgeConfigSpec.IntValue BOULDER_MAX_DAMAGE;

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
                .defineInRange("Hardness Modifier", 250.0, 0.0, 1000.0);

        BOULDER_DAMAGE = BUILDER.comment("""
                        Damage that the boulder block does per block fallen,
                        default is 2.0""")
                .defineInRange("Boulder Gravity Damage Modifier", 2.0, 0.0, 1000.0);

        BOULDER_MAX_DAMAGE = BUILDER.comment("""
                        Max damage a boulder can do, default is 40.0""")
                .defineInRange("Boulder Damage Modifier", 40, 0, 1000);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}

