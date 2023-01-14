package com.jusipat.castleblocks.block;

import com.jusipat.castleblocks.registry.ModBlockEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nullable;
import java.util.Properties;

public class CastleBlock extends Block implements ITileEntityProvider {


    public CastleBlock(TileEntityType<?> tileEntityType) {
        super(tileEntityType);
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

    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader blockReader) {
        return new CastleBlockEntity();
    }
}
