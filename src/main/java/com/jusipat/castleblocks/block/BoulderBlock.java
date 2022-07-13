package com.jusipat.castleblocks.block;

import net.minecraft.block.FallingBlock;
import net.minecraft.entity.FallingBlockEntity;

public class BoulderBlock extends FallingBlock {
    public BoulderBlock(Settings settings) {
        super(settings);
    }

    protected void configureFallingBlockEntity(FallingBlockEntity entity) {
        entity.setHurtEntities(4.0F, 40);
    }
}
