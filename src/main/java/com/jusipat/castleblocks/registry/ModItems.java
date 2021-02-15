package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import com.jusipat.castleblocks.item.TrowelItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
	public static final BlockItem CASTLE_BRICKS_ITEM = new BlockItem(ModBlocks.CASTLE_BRICKS, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));
	public static final TrowelItem TROWEL = new TrowelItem(new FabricItemSettings().group(CastleBlocksMod.CASTLEBLOCKS_GROUP));

	public static void registerItems() {
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "castle_bricks"), CASTLE_BRICKS_ITEM);
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "trowel"), TROWEL);
	}
}
