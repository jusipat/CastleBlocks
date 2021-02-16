package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import com.jusipat.castleblocks.item.TrowelItem;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModItems {
	public static final Item TROWEL = new TrowelItem().setUnlocalizedName("trowel").setTextureName("castleblocks:trowel").setMaxStackSize(1).setMaxDamage(TrowelItem.MAX_USES).setCreativeTab(CastleBlocksMod.CASTLEBLOCKS_TAB);

	public static void registerItems() {
		GameRegistry.registerItem(TROWEL, "trowel");
		GameRegistry.addShapedRecipe(new ItemStack(TROWEL),
			" I",
			"S ",
			'I', Items.iron_ingot,
			'S', Items.stick
		);
	}
}
