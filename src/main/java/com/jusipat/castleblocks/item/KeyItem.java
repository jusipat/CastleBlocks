package com.jusipat.castleblocks.item;

import com.jusipat.castleblocks.block.CastleBlockEntity;
import com.jusipat.castleblocks.block.CastleDoorBlock;
import com.jusipat.castleblocks.block.CastleDoorEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class KeyItem extends Item {
	public static final Map<Identifier, Identifier> blockMap = new HashMap<>();

	public KeyItem(Settings settings) {
		super(settings.maxCount(1));
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

		NbtCompound nbt = itemStack.getOrCreateNbt();
		if (nbt.contains("door_location")) {
			int[] coordArray = nbt.getIntArray("door_location");
			String positionString = "X: " + coordArray[0] + ", Y: " + coordArray[1] + ", Z: " + coordArray[2];
			tooltip.add(new TranslatableText("item.castleblocks.key.tooltip", positionString));
		}
	}
}