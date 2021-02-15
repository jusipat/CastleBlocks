package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import com.jusipat.castleblocks.block.CastleBlock;
import com.jusipat.castleblocks.block.CastleBlockEntity;
import com.jusipat.castleblocks.block.CustomStairsBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Collections;

public class ModBlocks {
	// Blocks
	public static final Block ANDESITE_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5f));
	public static final Block GRANITE_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5f));
	public static final Block CASTLE_BRICKS = new CastleBlock(FabricBlockSettings.of(Material.STONE).hardness(1.5f));

	// Block Entity Types
	public static final BlockEntityType<CastleBlockEntity> CASTLE_BLOCK_ENTITY = new BlockEntityType<>(CastleBlockEntity::new, Collections.singleton(CASTLE_BRICKS), null);

	// Stairs
	public static final Block ANDESITE_BRICK_STAIRS = new CustomStairsBlock(ANDESITE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(ANDESITE_BRICKS));
	public static final Block GRANITE_BRICK_STAIRS = new CustomStairsBlock(GRANITE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(GRANITE_BRICKS));

	public static void registerBlocks() {
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "andesite_bricks"), ANDESITE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "granite_bricks"), GRANITE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "castle_bricks"), CASTLE_BRICKS);

		Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(CastleBlocksMod.MOD_ID, "castle_bricks"), CASTLE_BLOCK_ENTITY);

		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "andesite_brick_stairs"), ANDESITE_BRICK_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "granite_brick_stairs"), GRANITE_BRICK_STAIRS);
	}

}
