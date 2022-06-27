package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import com.jusipat.castleblocks.block.CastleBlock;
import com.jusipat.castleblocks.block.CastleBlockEntity;
import com.jusipat.castleblocks.block.CastleDoorBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
	private static final FabricBlockSettings CB_BLOCK_SETTINGS = FabricBlockSettings.of(Material.STONE).requiresTool().strength(2.5f, 8.0f);

	// CASTLE BLOCKS
	public static final Block CASTLE_BRICKS = new CastleBlock(CB_BLOCK_SETTINGS);
	public static final Block ANDESITE_CASTLE_BRICKS = new CastleBlock(CB_BLOCK_SETTINGS);
	public static final Block DIORITE_CASTLE_BRICKS = new CastleBlock(CB_BLOCK_SETTINGS);
	public static final Block GRANITE_CASTLE_BRICKS = new CastleBlock(CB_BLOCK_SETTINGS);
	public static final Block SANDSTONE_CASTLE_BRICKS = new CastleBlock(CB_BLOCK_SETTINGS);
	public static final Block DEEPSLATE_CASTLE_BRICKS = new CastleBlock(CB_BLOCK_SETTINGS.sounds(BlockSoundGroup.DEEPSLATE_BRICKS));
	public static final Block BLACKSTONE_CASTLE_BRICKS = new CastleBlock(CB_BLOCK_SETTINGS);
	public static final Block NETHER_CASTLE_BRICKS = new CastleBlock(CB_BLOCK_SETTINGS.sounds(BlockSoundGroup.NETHER_BRICKS));

	// CASTLE DOORS
	public static final CastleDoorBlock CASTLE_DOOR = new CastleDoorBlock(FabricBlockSettings.of(Material.WOOD).requiresTool().strength(2.5f, 8.0f).nonOpaque());

	public static final BlockEntityType<CastleBlockEntity> CASTLE_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(CastleBlockEntity::new, CASTLE_BRICKS, ANDESITE_CASTLE_BRICKS, DIORITE_CASTLE_BRICKS, GRANITE_CASTLE_BRICKS, SANDSTONE_CASTLE_BRICKS, DEEPSLATE_CASTLE_BRICKS, NETHER_CASTLE_BRICKS, BLACKSTONE_CASTLE_BRICKS).build();

	public static void registerBlocks() {

		// CASTLE BLOCKS
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "castle_bricks"), CASTLE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "andesite_castle_bricks"), ANDESITE_CASTLE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "diorite_castle_bricks"), DIORITE_CASTLE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "granite_castle_bricks"), GRANITE_CASTLE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "sandstone_castle_bricks"), SANDSTONE_CASTLE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "deepslate_castle_bricks"), DEEPSLATE_CASTLE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "blackstone_castle_bricks"), BLACKSTONE_CASTLE_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "nether_castle_bricks"), NETHER_CASTLE_BRICKS);

		// CASTLE DOORS

		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "castle_door"), CASTLE_DOOR);

		Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(CastleBlocksMod.MOD_ID, "castle_bricks"), CASTLE_BLOCK_ENTITY);
	}
}
