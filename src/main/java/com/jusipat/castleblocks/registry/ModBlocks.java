package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

	public static final Block ANDESITE_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5f));
	public static final Block GRANITE_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5f));



	public static void registerBlocks() {

		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "andesite_bricks"), ANDESITE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "granite_bricks"), GRANITE_BRICKS);

	}

}
