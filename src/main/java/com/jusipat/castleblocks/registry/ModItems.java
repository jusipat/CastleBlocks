package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import com.jusipat.castleblocks.block.fluid.ModFluids;
import com.jusipat.castleblocks.item.trowels.DiamondTrowelItem;
import com.jusipat.castleblocks.item.trowels.GoldTrowelItem;
import com.jusipat.castleblocks.item.trowels.IronTrowelItem;
import com.jusipat.castleblocks.item.KeyItem;
import com.jusipat.castleblocks.item.trowels.NetheriteTrowelItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
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
	public static final BlockItem END_STONE_CASTLE_BRICKS = new BlockItem(ModBlocks.END_STONE_CASTLE_BRICKS, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));
	public static final BlockItem PURPUR_CASTLE_BRICKS = new BlockItem(ModBlocks.PURPUR_CASTLE_BRICKS, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));
	public static final BlockItem PRISMARINE_CASTLE_BRICKS = new BlockItem(ModBlocks.PRISMARINE_CASTLE_BRICKS, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));
	public static final BlockItem BRICK_CASTLE_BRICKS = new BlockItem(ModBlocks.BRICK_CASTLE_BRICKS, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));

	public static final BlockItem CASTLE_DOOR = new BlockItem(ModBlocks.CASTLE_DOOR, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));

	public static final IronTrowelItem IRON_TROWEL = new IronTrowelItem(new FabricItemSettings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));
	public static final DiamondTrowelItem DIAMOND_TROWEL = new DiamondTrowelItem(new FabricItemSettings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));
	public static final GoldTrowelItem GOLD_TROWEL = new GoldTrowelItem(new FabricItemSettings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));
	public static final NetheriteTrowelItem NETHERITE_TROWEL = new NetheriteTrowelItem(new FabricItemSettings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));

	public static final KeyItem KEY = new KeyItem(new FabricItemSettings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));

	public static final BucketItem PITCH_BUCKET = new BucketItem(ModFluids.PITCH_STILL, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP).maxCount(1));

	public static final Item RESIN = new Item(new FabricItemSettings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));
	public static final Item PITCH = new Item(new FabricItemSettings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));

	public static void registerItems() {
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "castle_bricks"), CASTLE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "andesite_castle_bricks"), ANDESITE_CASTLE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "diorite_castle_bricks"), DIORITE_CASTLE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "granite_castle_bricks"), GRANITE_CASTLE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "sandstone_castle_bricks"), SANDSTONE_CASTLE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "red_sandstone_castle_bricks"), RED_SANDSTONE_CASTLE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "nether_castle_bricks"), NETHER_CASTLE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "deepslate_castle_bricks"), DEEPSLATE_CASTLE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "blackstone_castle_bricks"), BLACKSTONE_CASTLE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "purpur_castle_bricks"), PURPUR_CASTLE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "brick_castle_bricks"), BRICK_CASTLE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "end_stone_castle_bricks"), END_STONE_CASTLE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "prismarine_castle_bricks"), PRISMARINE_CASTLE_BRICKS);

		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "iron_trowel"), IRON_TROWEL);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "gold_trowel"), GOLD_TROWEL);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "diamond_trowel"), DIAMOND_TROWEL);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "netherite_trowel"), NETHERITE_TROWEL);

		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "key"), KEY);

		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "castle_door"), CASTLE_DOOR);

		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "pitch_bucket"), PITCH_BUCKET);

		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "resin"), RESIN);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "pitch"), PITCH);
	}
}
