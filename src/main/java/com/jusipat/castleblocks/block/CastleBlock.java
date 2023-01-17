package com.jusipat.castleblocks.block;

import com.jusipat.castleblocks.registry.ModBlockEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class CastleBlock extends Block  {


    public CastleBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void setPlacedBy(World world, BlockPos blockPos, BlockState blockState, LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(world, blockPos, blockState, placer, stack);
        if (placer instanceof PlayerEntity) {
            TileEntity tileEntity = world.getBlockEntity(blockPos);

            if (tileEntity instanceof CastleBlockEntity)
                ((CastleBlockEntity) tileEntity).setOwner((PlayerEntity) placer);
        }
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModBlockEntities.CASTLE_BLOCK_ENTITY.get().create();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
}
