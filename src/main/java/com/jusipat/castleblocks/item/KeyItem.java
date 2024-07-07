package com.jusipat.castleblocks.item;

import net.minecraft.component.type.NbtComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;

import java.util.List;

public class KeyItem extends Item {
	public KeyItem(Settings settings) {
		super(settings.maxCount(1));
	}

	@Override
	public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
		NbtCompound nbt = NbtComponent.DEFAULT.copyNbt();
		if (nbt.contains("door_location")) {
			int[] coordArray = nbt.getIntArray("door_location");
			String positionString = "X: " + coordArray[0] + ", Y: " + coordArray[1] + ", Z: " + coordArray[2];
			tooltip.add(Text.translatable("item.castleblocks.key.tooltip", positionString));
		}
	}
}