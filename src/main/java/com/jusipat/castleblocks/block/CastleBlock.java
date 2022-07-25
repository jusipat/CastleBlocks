package com.jusipat.castleblocks.block;

import com.jusipat.castleblocks.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CastleBlock extends Block implements BlockEntityType.BlockEntitySupplier {
    public CastleBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity create(BlockPos pos, BlockState state) {
        return new CastleBlockEntity(BlockEntityType<CastleBlockEntity>, pos, state);
    }
}
