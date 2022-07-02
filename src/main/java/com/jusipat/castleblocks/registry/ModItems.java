package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import com.jusipat.castleblocks.block.fluid.ModFluids;
import com.jusipat.castleblocks.item.TrowelItem;
import com.jusipat.castleblocks.item.KeyItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
	public static final BlockItem CASTLE_BRICKS = new BlockItem(ModBlocks.CASTLE_BRICKS, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));
	public static final BlockItem ANDESITE_CASTLE_BRICKS = new BlockItem(ModBlocks.ANDESITE_CASTLE_BRICKS, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));
	public static final BlockItem DIORITE_CASTLE_BRICKS = new BlockItem(ModBlocks.DIORITE_CASTLE_BRICKS, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));
	public static final BlockItem GRANITE_CASTLE_BRICKS = new BlockItem(ModBlocks.GRANITE_CASTLE_BRICKS, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));
	public static final BlockItem SANDSTONE_CASTLE_BRICKS = new BlockItem(ModBlocks.SANDSTONE_CASTLE_BRICKS, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));
	public static final BlockItem RED_SANDSTONE_CASTLE_BRICKS = new BlockItem(ModBlocks.RED_SANDSTONE_CASTLE_BRICKS, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));
	public static final BlockItem DEEPSLATE_CASTLE_BRICKS = new BlockItem(ModBlocks.DEEPSLATE_CASTLE_BRICKS, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));
	public static final BlockItem BLACKSTONE_CASTLE_BRICKS = new BlockItem(ModBlocks.BLACKSTONE_CASTLE_BRICKS, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));
	public static final BlockItem NETHER_CASTLE_BRICKS = new BlockItem(ModBlocks.NETHER_CASTLE_BRICKS, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));

	public static final BlockItem CASTLE_DOOR = new BlockItem(ModBlocks.CASTLE_DOOR, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));

	public static final TrowelItem TROWEL = new TrowelItem(new FabricItemSettings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));
	public static final KeyItem KEY = new KeyItem(new FabricItemSettings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));

	public static final BucketItem PITCH_BUCKET = new BucketItem(ModFluids.PITCH_STILL, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP).maxCount(1));

	public static final Item RESIN = new Item(new FabricItemSettings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));

	public static void registerItems() {
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "castle_bricks"), CASTLE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "andesite_castle_bricks"), ANDESITE_CASTLE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "diorite_castle_bricks"), DIORITE_CASTLE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "granite_castle_bricks"), GRANITE_CASTLE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "sandstone_castle_bricks"), SANDSTONE_CASTLE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "red_sandstone_castle_bricks"), RED_SANDSTONE_CASTLE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "deepslate_castle_bricks"), DEEPSLATE_CASTLE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "blackstone_castle_bricks"), BLACKSTONE_CASTLE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "nether_castle_bricks"), NETHER_CASTLE_BRICKS);

		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "trowel"), TROWEL);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "key"), KEY);

		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "castle_door"), CASTLE_DOOR);

		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "pitch_bucket"), PITCH_BUCKET);

		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "resin"), RESIN);
	}
}
