package com.jusipat.castleblocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CastleBlock extends Block {
	public CastleBlock(Material material) {
		super(material);
	}

//	@Override
//	public @Nullable BlockEntity createBlockEntity(BlockView world) {
//		return new CastleBlockEntity();
//	}
//
//	@Override
//	public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
//		super.onPlaced(world, pos, state, placer, itemStack);
//		if (placer instanceof PlayerEntity) {
//			BlockEntity blockEntity = world.getBlockEntity(pos);
//
//			if (blockEntity instanceof CastleBlockEntity) {
//				((CastleBlockEntity) blockEntity).setOwner((PlayerEntity) placer);
//			}
//		}
//	}
//
//	@Override
//	public float calcBlockBreakingDelta(BlockState state, PlayerEntity player, BlockView world, BlockPos pos) {
//		float ownerCoefficient = 0.01f;
//		BlockEntity blockEntity = world.getBlockEntity(pos);
//
//		if (blockEntity instanceof CastleBlockEntity) {
//			CastleBlockEntity castleBlockEntity = (CastleBlockEntity) blockEntity;
//			if (castleBlockEntity.isOwner(player.getUuid())) {
//				ownerCoefficient = 1f;
//			}
//		}
//
//		return super.calcBlockBreakingDelta(state, player, world, pos) * ownerCoefficient;
//	}
}
