package com.jusipat.castleblocks.item;

import com.jusipat.castleblocks.CastleBlocksMod;
import com.jusipat.castleblocks.block.CastleBlockEntity;
import com.jusipat.castleblocks.registry.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.List;

public class TrowelItem extends Item {
	public TrowelItem(Settings settings) {
		super(settings);
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add(new TranslatableText("item.castleblocks.trowel.tooltip"));
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		BlockPos blockPos = context.getBlockPos();
		World world = context.getWorld();
		BlockState blockState = world.getBlockState(blockPos);
		PlayerEntity player = context.getPlayer();

		if (player != null) {
			boolean isStone = Registry.BLOCK.getId(blockState.getBlock()).equals(Registry.BLOCK.getId(Blocks.STONE));
			if (isStone) {
				world.setBlockState(blockPos, ModBlocks.CASTLE_BRICKS.getDefaultState());

				CastleBlockEntity blockEntity = new CastleBlockEntity();
				blockEntity.setOwner(player.getUuid());
				world.setBlockEntity(blockPos, blockEntity);

				return ActionResult.SUCCESS;
			}
		}

		return ActionResult.PASS;
	}
}
