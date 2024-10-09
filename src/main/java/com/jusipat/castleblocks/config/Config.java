package com.jusipat.castleblocks.config;

import com.jusipat.castleblocks.CastleBlocksMod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.config.IConfigSpec;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = CastleBlocksMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue PVP_MODE = BUILDER
            .comment("Enables if castle bricks are harder to break if not the block owner\"")
            .define("PVP_MODE", true);
    private static final ModConfigSpec.BooleanValue SIEGE_MODE = BUILDER
            .comment("Enabling this will make destroying bricks placed by others impossible by hand! (TNT & cannons still work!)\"")
            .define("SIEGE_MODE", false);

    private static final ModConfigSpec.DoubleValue MODIFIER = BUILDER
            .comment("...")
            .translation("castleblocks.configuration.modifier")
            .defineInRange("hardness_modifier", 250.0, 0.0, 1000.0);

    private static final ModConfigSpec.DoubleValue BOULDER_DAMAGE = BUILDER
            .comment("...")
            .translation("castleblocks.configuration.boulder_damage")
            .defineInRange("boulder_damage", 2.0, 0.0, 1000.0);

    private static final ModConfigSpec.IntValue BOULDER_MAX_DAMAGE = BUILDER
            .comment("""
                        The max damage a boulder can do, default is 40.0""")
            .defineInRange("Boulder Damage Modifier", 40, 0, 1000);

    public static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean pvpMode;
    public static boolean siegeMode;
    public static double modifier;
    public static double boulderDamage;
    public static int boulderMaxDamage;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        pvpMode = PVP_MODE.get();
        siegeMode = SIEGE_MODE.get();
        modifier = MODIFIER.get();
        boulderDamage = BOULDER_DAMAGE.get();
        boulderMaxDamage = BOULDER_MAX_DAMAGE.get();
    }
}