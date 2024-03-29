package com.jusipat.castleblocks;

import com.jusipat.castleblocks.config.ModConfig;
import com.jusipat.castleblocks.registry.ModBlocks;
import com.jusipat.castleblocks.registry.ModFluids;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;

public class CastleBlocksClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
        ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CASTLE_DOOR, RenderLayer.getCutout());
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.PITCH_STILL,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 0x1a1a00));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.PITCH_FLOWING,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 0x1a1a00));
    }
}
