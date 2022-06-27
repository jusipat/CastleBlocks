package com.jusipat.castleblocks.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class CastleDoorBlock extends DoorBlock {
	public CastleDoorBlock(Settings settings) {
		super(settings);
	}

	private int getOpenSoundEventId() {
		return this.material == Material.METAL ? 1005 : 1006;
	}
	private int getCloseSoundEventId() {
		return this.material == Material.METAL ? 1011 : 1012;
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (this.material == Material.METAL) {
			return ActionResult.PASS;
		} else {
			state = (BlockState)state.cycle(OPEN);
			world.setBlockState(pos, state, 10);
			world.syncWorldEvent(player, (Boolean)state.get(OPEN) ? this.getOpenSoundEventId() : this.getCloseSoundEventId(), pos, 0);
			world.emitGameEvent(player, this.isOpen(state) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
			return ActionResult.success(world.isClient);
		}
	}
}
