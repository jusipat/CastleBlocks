package com.jusipat.castleblocks.item;

import com.jusipat.castleblocks.block.CastleBlockEntity;
import com.jusipat.castleblocks.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class TrowelItem extends Item {
	public static final int MAX_USES = 128;
	private static final Map<Block, Block> blockMap = new HashMap<>();

	public TrowelItem() {
		super();

		blockMap.put(Blocks.stone, ModBlocks.CASTLE_BRICKS);
		blockMap.put(Blocks.sandstone, ModBlocks.SANDSTONE_CASTLE_BRICKS);
	}
	//	@Override
//	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
//		tooltip.add(new TranslatableText("item.castleblocks.trowel.tooltip"));
//	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
		if (player != null) {
			Block block = world.getBlock(x, y, z);
			TileEntity tileEntity = world.getTileEntity(x, y, z);

			if (blockMap.containsKey(block)) {
				Block blockType = blockMap.get(block);
				world.setBlock(x, y, z, blockType);
				stack.damageItem(1, player);

				return true;
			} else if (tileEntity instanceof CastleBlockEntity) {
				CastleBlockEntity castleBlockEntity = (CastleBlockEntity) tileEntity;
				player.addChatComponentMessage(new ChatComponentTranslation("item.trowel.owner", castleBlockEntity.getOwnerName()));
			}
		}

		return false;
	}


//	@Override
//	public ActionResult useOnBlock(ItemUsageContext context) {
//		BlockPos blockPos = context.getBlockPos();
//		World world = context.getWorld();
//		BlockState blockState = world.getBlockState(blockPos);
//		PlayerEntity player = context.getPlayer();
//
//		if (player != null) {
//			Identifier blockId = Registry.BLOCK.getId(blockState.getBlock());
//
//			if (blockMap.containsKey(blockId)) {
//				Block blockType = Registry.BLOCK.get(blockMap.get(blockId));
//				world.setBlockState(blockPos, blockType.getDefaultState());
//
//				CastleBlockEntity blockEntity = new CastleBlockEntity();
//				blockEntity.setOwner(player);
//				world.setBlockEntity(blockPos, blockEntity);
//
//				if (world.isClient())
//					world.syncWorldEvent(player, 2001, blockPos, Block.getRawIdFromState(blockType.getDefaultState()));
//
//				context.getStack().damage(1, player, playerEntity -> playerEntity.sendToolBreakStatus(context.getHand()));
//
//				return ActionResult.SUCCESS;
//			} else if (world.getBlockEntity(blockPos) instanceof CastleBlockEntity) {
//				CastleBlockEntity blockEntity = (CastleBlockEntity) world.getBlockEntity(blockPos);
//				if (blockEntity != null) {
//					Text ownerText = new TranslatableText("item.castleblocks.trowel.owner", blockEntity.getOwnerName());
//					player.sendMessage(ownerText, true);
//				}
//			}
//		}
//
//		return ActionResult.PASS;
//	}
}
