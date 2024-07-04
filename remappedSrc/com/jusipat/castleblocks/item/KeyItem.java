package com.jusipat.castleblocks.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class KeyItem extends Item {
	public KeyItem(net.minecraft.item.Item.Settings settings) {
		super(settings.maxCount(1));
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, net.minecraft.item.Item.TooltipContext tooltipContext) {
		NbtCompound nbt = itemStack.getOrCreateNbt();
		if (nbt.contains("door_location")) {
			int[] coordArray = nbt.getIntArray("door_location");
			String positionString = "X: " + coordArray[0] + ", Y: " + coordArray[1] + ", Z: " + coordArray[2];
			tooltip.add(Text.translatable("item.castleblocks.key.tooltip", positionString));
		}
	}
}