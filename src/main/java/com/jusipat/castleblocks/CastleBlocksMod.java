package com.jusipat.castleblocks;

import com.jusipat.castleblocks.registry.ModBlocks;
import com.jusipat.castleblocks.registry.ModFuels;
import com.jusipat.castleblocks.registry.ModItemGroup;
import com.jusipat.castleblocks.registry.ModItems;
import net.fabricmc.api.ModInitializer;

public class CastleBlocksMod implements ModInitializer {
	public static final String MOD_ID = "castleblocks";

	@Override
	public void onInitialize() {
		ModBlocks.registerBlocks();
		ModItems.registerItems();
		ModFuels.registerFuels();
		ModItemGroup.registerItemGroup();
	}
}
