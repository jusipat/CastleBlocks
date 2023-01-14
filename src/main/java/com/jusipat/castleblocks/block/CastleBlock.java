package com.jusipat.castleblocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class CastleBlock extends Block implements ITileEntityProvider {


    public CastleBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void setPlacedBy(World world, BlockPos blockPos, BlockState blockState, LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(world, blockPos, blockState, placer, stack);
        if (placer instanceof LivingEntity) {
            TileEntity tileEntity = world.getBlockEntity(blockPos);

            if (tileEntity instanceof CastleBlockEntity)
                ((CastleBlockEntity) tileEntity).setOwner(placer);
        }
    }

    @Override
    public TileEntity newBlockEntity(IBlockReader blockReader) {
        return new CastleBlockEntity();
    }
}
