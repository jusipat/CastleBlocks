package com.jusipat.castleblocks;
import com.jusipat.castleblocks.config.Config;
import com.jusipat.castleblocks.registry.ModBlockEntities;
import com.jusipat.castleblocks.registry.ModBlocks;
import com.jusipat.castleblocks.registry.ModCreativeModeTabs;
import com.jusipat.castleblocks.registry.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(CastleBlocksMod.MOD_ID)
public class CastleBlocksMod {
    public static final String MOD_ID = "castleblocks";
    public CastleBlocksMod(IEventBus eventBus, ModContainer container) {
        eventBus.addListener(this::setup);
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModCreativeModeTabs.register(eventBus);
        container.registerConfig(ModConfig.Type.COMMON, Config.SPEC, "castleblocks-common.toml");
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

    }

    private void setup(final FMLCommonSetupEvent event) {}
}