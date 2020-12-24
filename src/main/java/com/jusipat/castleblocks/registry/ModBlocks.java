package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import com.jusipat.castleblocks.block.CustomStairsBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

	public static final Block ANDESITE_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5f));
	public static final Block GRANITE_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5f));
	public static final Block ANDESITE_BRICK_STAIRS = new CustomStairsBlock(ANDESITE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(ANDESITE_BRICKS));


	public static void registerBlocks() {

		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "andesite_bricks"), ANDESITE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "granite_bricks"), GRANITE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "andesite_brick_stairs"), ANDESITE_BRICK_STAIRS);

	}

}
