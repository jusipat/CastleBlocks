package com.jusipat.castleblocks.block;

import com.jusipat.castleblocks.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

import java.util.UUID;

public class CastleDoorEntity extends BlockEntity {

	public final String doorId;

	public CastleDoorEntity(BlockPos pos, BlockState state) {
		super(ModBlocks.DOOR_BLOCK_ENTITY, pos, state);
		doorId = UUID.randomUUID().toString();
	}

}
