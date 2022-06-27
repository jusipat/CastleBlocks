package com.jusipat.castleblocks.item;

import com.jusipat.castleblocks.block.CastleBlockEntity;
import com.jusipat.castleblocks.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrowelItem extends Item {
	public static final int MAX_USES = 128;
	private static final Map<Identifier, Identifier> blockMap = new HashMap<>();

	public TrowelItem(Settings settings) {
		super(settings.maxCount(1).maxDamage(MAX_USES));

		blockMap.put(Registry.BLOCK.getId(Blocks.STONE), Registry.BLOCK.getId(ModBlocks.CASTLE_BRICKS));
		blockMap.put(Registry.BLOCK.getId(Blocks.POLISHED_ANDESITE), Registry.BLOCK.getId(ModBlocks.ANDESITE_CASTLE_BRICKS));
		blockMap.put(Registry.BLOCK.getId(Blocks.POLISHED_DIORITE), Registry.BLOCK.getId(ModBlocks.DIORITE_CASTLE_BRICKS));
		blockMap.put(Registry.BLOCK.getId(Blocks.POLISHED_GRANITE), Registry.BLOCK.getId(ModBlocks.GRANITE_CASTLE_BRICKS));
		blockMap.put(Registry.BLOCK.getId(Blocks.CUT_SANDSTONE), Registry.BLOCK.getId(ModBlocks.SANDSTONE_CASTLE_BRICKS));
		blockMap.put(Registry.BLOCK.getId(Blocks.DEEPSLATE), Registry.BLOCK.getId(ModBlocks.DEEPSLATE_CASTLE_BRICKS));
		blockMap.put(Registry.BLOCK.getId(Blocks.POLISHED_BLACKSTONE), Registry.BLOCK.getId(ModBlocks.BLACKSTONE_CASTLE_BRICKS));
		blockMap.put(Registry.BLOCK.getId(Blocks.NETHER_BRICKS), Registry.BLOCK.getId(ModBlocks.NETHER_CASTLE_BRICKS));
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add(Text.translatable("item.castleblocks.trowel.tooltip"));
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		BlockPos blockPos = context.getBlockPos();
		World world = context.getWorld();
		BlockState blockState = world.getBlockState(blockPos);
		PlayerEntity player = context.getPlayer();

		if (player != null) {
			Identifier blockId = Registry.BLOCK.getId(blockState.getBlock());

			if (blockMap.containsKey(blockId)) {
				Block blockType = Registry.BLOCK.get(blockMap.get(blockId));
				world.setBlockState(blockPos, blockType.getDefaultState());

				CastleBlockEntity blockEntity = new CastleBlockEntity(blockPos, blockType.getDefaultState());
				blockEntity.setOwner(player);
				world.addBlockEntity(blockEntity);

				if (world.isClient())
					world.syncWorldEvent(player, 2001, blockPos, Block.getRawIdFromState(blockType.getDefaultState()));

				context.getStack().damage(1, player, playerEntity -> playerEntity.sendToolBreakStatus(context.getHand()));

				return ActionResult.SUCCESS;
			} else if (world.getBlockEntity(blockPos) instanceof CastleBlockEntity blockEntity) {
				Text ownerText =  Text.translatable("item.castleblocks.trowel.owner", blockEntity.getOwnerName());
				player.sendMessage(ownerText, true);
			}
		}

		return ActionResult.PASS;
	}
}
