package com.jusipat.castleblocks.fluid;

import com.jusipat.castleblocks.registry.ModBlocks;
import com.jusipat.castleblocks.registry.ModFluids;
import com.jusipat.castleblocks.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.Random;

public abstract class PitchFluid extends FlowableFluid {

	public Fluid getFlowing() {
		return ModFluids.PITCH_FLOWING;
	}

	public Fluid getStill() {
		return ModFluids.PITCH_STILL;
	}

	public Item getBucketItem() {
		return ModItems.PITCH_BUCKET;
	}

	public void randomDisplayTick(World world, BlockPos pos, FluidState state, Random random) {
		if (!state.isStill() && !(Boolean)state.get(FALLING)) {
			if (random.nextInt(64) == 0) {
				world.playSound((double)pos.getX() + 0.5D,
						(double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D,
						SoundEvents.BLOCK_HONEY_BLOCK_SLIDE, SoundCategory.BLOCKS,
						random.nextFloat() * 0.25F + 0.75F, random.nextFloat() + 0.5F,
						false);
			}
		} else if (random.nextInt(10) == 0) {
			world.addParticle(ParticleTypes.UNDERWATER, (double)pos.getX() + random.nextDouble(),
					(double)pos.getY() + random.nextDouble(),
					(double)pos.getZ() + random.nextDouble(),
					0.0D, 0.0D, 0.0D);
		}

	}

	@Nullable
	public ParticleEffect getParticle() {
		return ParticleTypes.DRIPPING_WATER;
	}

	protected boolean isInfinite() {
		return false;
	}

	protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
		BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
		Block.dropStacks(state, world, pos, blockEntity);
	}

	public int getFlowSpeed(WorldView world) {
		return 2;
	}

	public BlockState toBlockState(FluidState state) {
		return ModBlocks.PITCH_FLUID_BLOCK.getDefaultState().with(FluidBlock.LEVEL, getBlockStateLevel(state));
	}

	public boolean matchesType(Fluid fluid) {
		return fluid == ModFluids.PITCH_STILL || fluid == ModFluids.PITCH_FLOWING;
	}

	public int getLevelDecreasePerBlock(WorldView world) {
		return 3;
	}

	public int getTickRate(WorldView world) {
		return 2;
	}

	public boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
		return direction == Direction.DOWN && !fluid.isIn(FluidTags.WATER);
	}

	protected float getBlastResistance() {
		return 100.0F;
	}

	public Optional<SoundEvent> getBucketFillSound() {
		return Optional.of(SoundEvents.ITEM_BUCKET_FILL);
	}

	public static class Flowing extends PitchFluid {

		protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
			super.appendProperties(builder);
			builder.add(LEVEL);
		}

		@Override
		protected boolean isInfinite(World world) {
			return false;
		}

		public int getLevel(FluidState state) {
			return state.get(LEVEL);
		}

		public boolean isStill(FluidState state) {
			return false;
		}
	}

	public static class Still extends PitchFluid {

		@Override
		protected boolean isInfinite(World world) {
			return false;
		}

		public int getLevel(FluidState state) {
			return 8;
		}

		public boolean isStill(FluidState state) {
			return true;
		}
	}
}