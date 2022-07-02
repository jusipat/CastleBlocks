package com.jusipat.castleblocks;

import com.jusipat.castleblocks.block.fluid.ModFluids;
import com.jusipat.castleblocks.registry.ModBlocks;
import com.jusipat.castleblocks.registry.ModItems;
import com.jusipat.castleblocks.registry.ModRegistries;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class CastleBlocksMod implements ModInitializer {
	public static final String MOD_ID = "castleblocks";
	public static final ItemGroup CASTLEBLOCKS_GROUP = FabricItemGroupBuilder.create(
			new Identifier(MOD_ID, "items"))
			.icon(() -> new ItemStack(ModItems.TROWEL))
			.build();

	@Override
	public void onInitialize() {
		ModBlocks.registerBlocks();
		ModItems.registerItems();
		ModRegistries.registerModFuels();

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
