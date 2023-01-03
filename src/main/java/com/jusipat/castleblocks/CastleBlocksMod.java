package com.jusipat.castleblocks;

import com.jusipat.castleblocks.registry.ModBlocks;
import com.jusipat.castleblocks.registry.ModItems;
import com.jusipat.castleblocks.registry.ModFuels;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.impl.itemgroup.FabricItemGroupBuilderImpl;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CastleBlocksMod implements ModInitializer {
	public static final String MOD_ID = "castleblocks";

	ItemGroup CASTLEBLOCKS_GROUP = FabricItemGroup.builder(new Identifier(MOD_ID, "items"))
			.icon(() -> new ItemStack(ModItems.DIAMOND_TROWEL))
			.entries((enabledFeatures, entries, operatorEnabled) -> {
				entries.add(ModItems.IRON_TROWEL);
				entries.add(ModItems.GOLD_TROWEL);
				entries.add(ModItems.DIAMOND_TROWEL);
				entries.add(ModItems.NETHERITE_TROWEL);
				entries.add(ModItems.CASTLE_BRICKS);
				entries.add(ModItems.ANDESITE_CASTLE_BRICKS);
				entries.add(ModItems.DIORITE_CASTLE_BRICKS);
				entries.add(ModItems.GRANITE_CASTLE_BRICKS);
				entries.add(ModItems.SANDSTONE_CASTLE_BRICKS);
				entries.add(ModItems.RED_SANDSTONE_CASTLE_BRICKS);
				entries.add(ModItems.DEEPSLATE_CASTLE_BRICKS);
				entries.add(ModItems.BLACKSTONE_CASTLE_BRICKS);
				entries.add(ModItems.NETHER_CASTLE_BRICKS);
				entries.add(ModItems.END_STONE_CASTLE_BRICKS);
				entries.add(ModItems.PURPUR_CASTLE_BRICKS);
				entries.add(ModItems.PRISMARINE_CASTLE_BRICKS);
				entries.add(ModItems.BRICK_CASTLE_BRICKS);
				entries.add(ModItems.PITCH_BUCKET);
				entries.add(ModItems.PITCH_CANDLE);
				entries.add(ModItems.TREE_TAP);
				entries.add(ModItems.RESIN);
				entries.add(ModItems.CASTLE_DOOR);
				entries.add(ModItems.KEY);
				entries.add(ModItems.BOULDER_BLOCK);
			})
			.build();

	@Override
	public void onInitialize() {
		ModBlocks.registerBlocks();
		ModItems.registerItems();
		ModFuels.registerFuels();
	}
}
