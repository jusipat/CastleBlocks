package com.jusipat.castleblocks;

import com.jusipat.castleblocks.item.TrowelItem;
import com.jusipat.castleblocks.registry.ModBlocks;
import com.jusipat.castleblocks.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.util.Identifier;

public class CastleBlocksMod implements ModInitializer {

	public static final String MOD_ID = "castleblocks";


	public static final ItemGroup CASTLEBLOCKS_MATERIALS = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "materials"),
			() -> new ItemStack(ModBlocks.ANDESITE_BRICKS));

	public static final ItemGroup CASTLEBLOCKS_TOOLS = FabricItemGroupBuilder.create(
			new Identifier(MOD_ID, "tools"))
			.icon(() -> new ItemStack(ModBlocks.ANDESITE_BRICKS))
			.build();


	@Override
	public void onInitialize() {
		ModItems.registerItems();
		ModBlocks.registerBlocks();

	}
}
