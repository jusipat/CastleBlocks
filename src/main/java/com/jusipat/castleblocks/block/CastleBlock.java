package com.jusipat.castleblocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CastleBlock extends Block implements BlockEntityProvider {
	public CastleBlock(Settings settings) {
		super(settings);
	}

	@Override
	public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
		super.onPlaced(world, pos, state, placer, itemStack);
		if (placer instanceof PlayerEntity) {
			BlockEntity blockEntity = world.getBlockEntity(pos);

			if (blockEntity instanceof CastleBlockEntity) {
				((CastleBlockEntity) blockEntity).setOwner((PlayerEntity) placer);
			}
		}
	}

	@Override
	public float calcBlockBreakingDelta(BlockState state, PlayerEntity player, BlockView world, BlockPos pos) {
		float ownerCoefficient = 0.01f;
		BlockEntity blockEntity = world.getBlockEntity(pos);

		if (blockEntity instanceof CastleBlockEntity castleBlockEntity) {
			if (castleBlockEntity.isOwner(player.getUuid())) {
				ownerCoefficient = 1f;
			}
		}

		return super.calcBlockBreakingDelta(state, player, world, pos) * ownerCoefficient;
	}

	@Nullable
	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new CastleBlockEntity(pos, state);
	}
}
