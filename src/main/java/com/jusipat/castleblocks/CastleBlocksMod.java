package com.jusipat.castleblocks;

import com.jusipat.castleblocks.registry.ModBlocks;
import com.jusipat.castleblocks.registry.ModItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = CastleBlocksMod.MOD_ID, version = CastleBlocksMod.VERSION)
public class CastleBlocksMod {
	public static final String MOD_ID = "castleblocks";
	public static final String VERSION = "1.0";

//	public static final ItemGroup CASTLEBLOCKS_GROUP = FabricItemGroupBuilder.create(
//			new Identifier(MOD_ID, "items"))
//			.icon(() -> new ItemStack(ModItems.TROWEL))
//			.build();

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ModBlocks.registerBlocks();
		ModItems.registerItems();
	}

	public void onInitialize() {
		ModBlocks.registerBlocks();
		ModItems.registerItems();
	}
}
