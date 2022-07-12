package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import com.jusipat.castleblocks.block.CastleBlock;
import com.jusipat.castleblocks.block.CastleBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Collections;

public class ModBlocks {
	private static final FabricBlockSettings CB_BLOCK_SETTINGS = FabricBlockSettings.of(Material.STONE).requiresTool().strength(2.5f, 8.0f);
	public static final Block CASTLE_BRICKS = new CastleBlock(CB_BLOCK_SETTINGS);
	public static final Block ANDESITE_CASTLE_BRICKS = new CastleBlock(CB_BLOCK_SETTINGS);
	public static final Block DIORITE_CASTLE_BRICKS = new CastleBlock(CB_BLOCK_SETTINGS);
	public static final Block GRANITE_CASTLE_BRICKS = new CastleBlock(CB_BLOCK_SETTINGS);
	public static final Block SANDSTONE_CASTLE_BRICKS = new CastleBlock(CB_BLOCK_SETTINGS);
	public static final Block RED_SANDSTONE_CASTLE_BRICKS = new CastleBlock(CB_BLOCK_SETTINGS);
	public static final Block BLACKSTONE_CASTLE_BRICKS = new CastleBlock(CB_BLOCK_SETTINGS.sounds(BlockSoundGroup.STONE));
	public static final Block NETHER_CASTLE_BRICKS = new CastleBlock(CB_BLOCK_SETTINGS.sounds(BlockSoundGroup.NETHER_BRICKS));
	public static final Block PURPUR_CASTLE_BRICKS = new CastleBlock(CB_BLOCK_SETTINGS.sounds(BlockSoundGroup.STONE));
	public static final Block BRICK_CASTLE_BRICKS = new CastleBlock(CB_BLOCK_SETTINGS);
	public static final Block PRISMARINE_CASTLE_BRICKS = new CastleBlock(CB_BLOCK_SETTINGS);
	public static final Block END_STONE_CASTLE_BRICKS = new CastleBlock(CB_BLOCK_SETTINGS.strength(3.0f,10.0f).sounds(BlockSoundGroup.STONE));


	public static final BlockEntityType<CastleBlockEntity> CASTLE_BLOCK_ENTITY = new BlockEntityType<>(CastleBlockEntity::new, Collections.singleton(CASTLE_BRICKS), null);

	public static void registerBlocks() {
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "castle_bricks"), CASTLE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "andesite_castle_bricks"), ANDESITE_CASTLE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "diorite_castle_bricks"), DIORITE_CASTLE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "granite_castle_bricks"), GRANITE_CASTLE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "sandstone_castle_bricks"), SANDSTONE_CASTLE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "red_sandstone_castle_bricks"), RED_SANDSTONE_CASTLE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "blackstone_castle_bricks"), BLACKSTONE_CASTLE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "nether_castle_bricks"), NETHER_CASTLE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "purpur_castle_bricks"), PURPUR_CASTLE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "end_stone_castle_bricks"), END_STONE_CASTLE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "brick_castle_bricks"), BRICK_CASTLE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "prismarine_castle_bricks"), PRISMARINE_CASTLE_BRICKS);

		Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(CastleBlocksMod.MOD_ID, "castle_bricks"), CASTLE_BLOCK_ENTITY);
	}
}
