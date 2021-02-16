package com.jusipat.castleblocks;

import com.jusipat.castleblocks.registry.ModBlocks;
import com.jusipat.castleblocks.registry.ModItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod(modid = CastleBlocksMod.MOD_ID, version = CastleBlocksMod.VERSION)
public class CastleBlocksMod {
	public static final String MOD_ID = "castleblocks";
	public static final String VERSION = "1.0.2-forge";

	public static final CreativeTabs CASTLEBLOCKS_TAB = new CreativeTabs("castleblocks") {
		@Override
		public Item getTabIconItem() {
			return ModItems.TROWEL;
		}
	};

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ModBlocks.registerBlocks();
		ModItems.registerItems();
	}
}
