package com.jusipat.castleblocks.item;

import com.jusipat.castleblocks.CastleBlocksMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;


import java.util.List;

public class TrowelItem extends Item {


	public static final TrowelItem TROWEL = new TrowelItem(new FabricItemSettings().group(CastleBlocksMod.CASTLEBLOCKS_MATERIALS));

	public TrowelItem(Settings settings) {
		super(settings);
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add(new TranslatableText("item.castleblocks.trowel.tooltip"));




	}
}
