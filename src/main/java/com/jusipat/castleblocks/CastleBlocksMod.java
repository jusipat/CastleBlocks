package com.jusipat.castleblocks;

import com.jusipat.castleblocks.config.CommonConfigs;
import com.jusipat.castleblocks.registry.ModBlockEntities;
import com.jusipat.castleblocks.registry.ModBlocks;
import com.jusipat.castleblocks.registry.ModCreativeModeTabs;
import com.jusipat.castleblocks.registry.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(CastleBlocksMod.MOD_ID)
public class CastleBlocksMod {
    public static final String MOD_ID = "castleblocks";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public CastleBlocksMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModCreativeModeTabs.CREATIVE_MODE_TABS.register(eventBus);

        eventBus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, CommonConfigs.SPEC, "castleblocks-common.toml");
    }

    private void setup(final FMLCommonSetupEvent event) {

    }
}