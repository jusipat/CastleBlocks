package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import com.jusipat.castleblocks.item.TrowelItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
	public static final BlockItem CASTLE_BRICKS = new BlockItem(ModBlocks.CASTLE_BRICKS, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));
	public static final BlockItem ANDESITE_CASTLE_BRICKS = new BlockItem(ModBlocks.ANDESITE_CASTLE_BRICKS, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));
	public static final BlockItem DIORITE_CASTLE_BRICKS = new BlockItem(ModBlocks.DIORITE_CASTLE_BRICKS, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));
	public static final BlockItem GRANITE_CASTLE_BRICKS = new BlockItem(ModBlocks.GRANITE_CASTLE_BRICKS, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));
	public static final BlockItem SANDSTONE_CASTLE_BRICKS = new BlockItem(ModBlocks.SANDSTONE_CASTLE_BRICKS, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));

	public static final TrowelItem TROWEL = new TrowelItem(new FabricItemSettings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));

	public static void registerItems() {
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "castle_bricks"), CASTLE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "andesite_castle_bricks"), ANDESITE_CASTLE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "diorite_castle_bricks"), DIORITE_CASTLE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "granite_castle_bricks"), GRANITE_CASTLE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "sandstone_castle_bricks"), SANDSTONE_CASTLE_BRICKS);

		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "trowel"), TROWEL);
	}
}
