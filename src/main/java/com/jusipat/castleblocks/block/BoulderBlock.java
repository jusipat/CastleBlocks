package com.jusipat.castleblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BoulderBlock extends FallingBlock {
    public BoulderBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onLand(Level level, BlockPos blockPos, BlockState fallingState, BlockState stateInPos, FallingBlockEntity fallingBlockEntity) {
        super.onLand(level, blockPos, fallingState, stateInPos, fallingBlockEntity);
        if (!level.isClientSide)
            level.playSound(null, blockPos, SoundEvents.POINTED_DRIPSTONE_LAND, SoundSource.BLOCKS, 1f, 1f);
    }

    @Override
    protected void falling(FallingBlockEntity entity) {
        entity.setHurtsEntities(4.0f, 40);
    }
}
