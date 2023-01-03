package com.jusipat.castleblocks.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BoulderBlock extends FallingBlock {
    public BoulderBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onLanding(World world, BlockPos pos, BlockState fallingBlockState, BlockState currentStateInPos, FallingBlockEntity fallingBlockEntity) {
        super.onLanding(world, pos, fallingBlockState, currentStateInPos, fallingBlockEntity);
        if (!world.isClient)
            world.playSound(null, pos, SoundEvents.BLOCK_POINTED_DRIPSTONE_LAND, SoundCategory.BLOCKS, 1f, 1f);
    }

    protected void configureFallingBlockEntity(FallingBlockEntity entity) {
        entity.setHurtEntities(4.0F, 40);
    }
}
