package com.jusipat.castleblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class CastleBlock extends BaseEntityBlock implements BlockEntityType.BlockEntitySupplier {
    public CastleBlock(Properties properties) {
        super(properties);
    }

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, @Nullable LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(level, blockPos, blockState, placer, stack);
        if (placer instanceof Player) {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);

            if (blockEntity instanceof CastleBlockEntity)
                ((CastleBlockEntity) blockEntity).setOwner((Player) placer);
        }
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        BlockEntity blockEntity = level.getBlockEntity(pos);

        if (blockEntity instanceof CastleBlockEntity castleBlockEntity)
            if(castleBlockEntity.isOwner(player.getUUID()))
                if(!castleBlockEntity.isOwner(player.getUUID())) {
                    return false;
                }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        return super.use(blockState, level, blockPos, player, hand, blockHitResult);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CastleBlockEntity(blockPos, blockState);
    }

    @Override
    public BlockEntity create(BlockPos blockPos, BlockState blockState) {
        return null;
    }
}
