package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import com.jusipat.castleblocks.item.TrowelItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {





	public static void registerItems() {

		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "andesite_bricks"),new BlockItem(ModBlocks.ANDESITE_BRICKS, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_MATERIALS)));
		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "granite_bricks"),new BlockItem(ModBlocks.GRANITE_BRICKS, new Item.Settings().group(CastleBlocksMod.CASTLEBLOCKS_MATERIALS)));

		// Tools

		Registry.register(Registry.ITEM, new Identifier(CastleBlocksMod.MOD_ID, "trowel"), TrowelItem.TROWEL);

	}


}
