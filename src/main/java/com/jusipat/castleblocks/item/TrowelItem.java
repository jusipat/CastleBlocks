package com.jusipat.castleblocks.item;

import net.minecraft.item.Item;

public class TrowelItem extends Item {
	public static final int MAX_USES = 128;
//	private static final Map<Identifier, Identifier> blockMap = new HashMap<>();

	public TrowelItem() {
		super();

//		blockMap.put(Registry.BLOCK.getId(Blocks.STONE), Registry.BLOCK.getId(ModBlocks.CASTLE_BRICKS));
//		blockMap.put(Registry.BLOCK.getId(Blocks.POLISHED_ANDESITE), Registry.BLOCK.getId(ModBlocks.ANDESITE_CASTLE_BRICKS));
//		blockMap.put(Registry.BLOCK.getId(Blocks.POLISHED_DIORITE), Registry.BLOCK.getId(ModBlocks.DIORITE_CASTLE_BRICKS));
//		blockMap.put(Registry.BLOCK.getId(Blocks.POLISHED_GRANITE), Registry.BLOCK.getId(ModBlocks.GRANITE_CASTLE_BRICKS));
//		blockMap.put(Registry.BLOCK.getId(Blocks.CUT_SANDSTONE), Registry.BLOCK.getId(ModBlocks.SANDSTONE_CASTLE_BRICKS));
	}
//
//	@Override
//	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
//		tooltip.add(new TranslatableText("item.castleblocks.trowel.tooltip"));
//	}
//
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
