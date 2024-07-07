package com.jusipat.castleblocks.item;

import com.jusipat.castleblocks.block.CastleBlockEntity;
import com.jusipat.castleblocks.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrowelItem extends Item {
	private static final Map<Identifier, Identifier> blockMap = new HashMap<>();

	public TrowelItem(Settings settings, int maxUses) {
		super(settings.maxCount(1).maxDamage(maxUses));

		blockMap.put(Registries.BLOCK.getId(Blocks.STONE), Registries.BLOCK.getId(ModBlocks.CASTLE_BRICKS));
		blockMap.put(Registries.BLOCK.getId(Blocks.POLISHED_ANDESITE), Registries.BLOCK.getId(ModBlocks.ANDESITE_CASTLE_BRICKS));
		blockMap.put(Registries.BLOCK.getId(Blocks.POLISHED_DIORITE), Registries.BLOCK.getId(ModBlocks.DIORITE_CASTLE_BRICKS));
		blockMap.put(Registries.BLOCK.getId(Blocks.POLISHED_GRANITE), Registries.BLOCK.getId(ModBlocks.GRANITE_CASTLE_BRICKS));
		blockMap.put(Registries.BLOCK.getId(Blocks.SMOOTH_SANDSTONE), Registries.BLOCK.getId(ModBlocks.SANDSTONE_CASTLE_BRICKS));
		blockMap.put(Registries.BLOCK.getId(Blocks.SMOOTH_RED_SANDSTONE), Registries.BLOCK.getId(ModBlocks.RED_SANDSTONE_CASTLE_BRICKS));
		blockMap.put(Registries.BLOCK.getId(Blocks.DEEPSLATE), Registries.BLOCK.getId(ModBlocks.DEEPSLATE_CASTLE_BRICKS));
		blockMap.put(Registries.BLOCK.getId(Blocks.POLISHED_BLACKSTONE), Registries.BLOCK.getId(ModBlocks.BLACKSTONE_CASTLE_BRICKS));
		blockMap.put(Registries.BLOCK.getId(Blocks.NETHER_BRICKS), Registries.BLOCK.getId(ModBlocks.NETHER_CASTLE_BRICKS));
		blockMap.put(Registries.BLOCK.getId(Blocks.BRICKS), Registries.BLOCK.getId(ModBlocks.BRICK_CASTLE_BRICKS));
		blockMap.put(Registries.BLOCK.getId(Blocks.PURPUR_BLOCK), Registries.BLOCK.getId(ModBlocks.PURPUR_CASTLE_BRICKS));
		blockMap.put(Registries.BLOCK.getId(Blocks.PRISMARINE_BRICKS), Registries.BLOCK.getId(ModBlocks.PRISMARINE_CASTLE_BRICKS));
		blockMap.put(Registries.BLOCK.getId(Blocks.END_STONE_BRICKS), Registries.BLOCK.getId(ModBlocks.END_STONE_CASTLE_BRICKS));
	}

	@Override
	public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
		tooltip.add(Text.translatable("item.castleblocks.trowel.tooltip"));
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		BlockPos blockPos = context.getBlockPos();
		World world = context.getWorld();
		BlockState blockState = world.getBlockState(blockPos);
		PlayerEntity player = context.getPlayer();

		if (player != null) {
			Identifier blockId = Registries.BLOCK.getId(blockState.getBlock());

			if (blockMap.containsKey(blockId)) {
				Block blockType = Registries.BLOCK.get(blockMap.get(blockId));
				world.setBlockState(blockPos, blockType.getDefaultState());

				CastleBlockEntity blockEntity = new CastleBlockEntity(blockPos, blockType.getDefaultState());
				blockEntity.setOwner(player);
				world.addBlockEntity(blockEntity);

				if (world.isClient())
					world.syncWorldEvent(player, WorldEvents.BLOCK_BROKEN, blockPos, Block.getRawIdFromState(blockType.getDefaultState()));

				context.getStack().damage(1, player, EquipmentSlot.MAINHAND);

				return ActionResult.SUCCESS;
			} else if (world.getBlockEntity(blockPos) instanceof CastleBlockEntity blockEntity) {
				Text ownerText = Text.translatable("item.castleblocks.trowel.owner", blockEntity.getOwnerName());
				player.sendMessage(ownerText, true);
			}
		}

		return ActionResult.PASS;
	}
}
