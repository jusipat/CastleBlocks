package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import com.jusipat.castleblocks.block.CustomStairsBlock;
import com.jusipat.castleblocks.block.StoneBlock;
import com.mojang.serialization.Lifecycle;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

public class ModBlocks {
	//Blocks
	public static final Block ANDESITE_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5f));
	public static final Block GRANITE_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5f));
	public static final Block CASTLE_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5f));




	//Stairs
	public static final Block ANDESITE_BRICK_STAIRS = new CustomStairsBlock(ANDESITE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(ANDESITE_BRICKS));
	public static final Block GRANITE_BRICK_STAIRS = new CustomStairsBlock(GRANITE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(GRANITE_BRICKS));


	public static void registerBlocks() {


		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "andesite_bricks"), ANDESITE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "granite_bricks"), GRANITE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "castle_bricks"), CASTLE_BRICKS);

		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "andesite_brick_stairs"), ANDESITE_BRICK_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "granite_brick_stairs"), GRANITE_BRICK_STAIRS);

		//Registry.BLOCK.set(Registry.BLOCK.getRawId(Blocks.STONE_BRICKS), RegistryKey.of(Registry.BLOCK.getKey(), (Registry.BLOCK.getId(Blocks.STONE_BRICKS))), new StoneBlock(AbstractBlock.Settings.copy(Blocks.STONE_BRICKS)), Lifecycle.stable());

	}

}
