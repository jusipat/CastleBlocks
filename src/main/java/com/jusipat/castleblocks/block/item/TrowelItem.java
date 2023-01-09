package com.jusipat.castleblocks.block.item;

import com.google.common.collect.ImmutableMap;
import com.jusipat.castleblocks.block.CastleBlockEntity;
import com.jusipat.castleblocks.registry.ModBlocks;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class TrowelItem extends Item {

    protected static final Map<Block, Block> TROWELABLE = (new ImmutableMap.Builder<Block, Block>()).put(Blocks.STONE, ModBlocks.CASTLE_BRICKS.get()).put(Blocks.POLISHED_ANDESITE, ModBlocks.ANDESITE_CASTLE_BRICKS.get()).put(Blocks.POLISHED_DIORITE, ModBlocks.DIORITE_CASTLE_BRICKS.get()).put(Blocks.POLISHED_GRANITE, ModBlocks.GRANITE_CASTLE_BRICKS.get()).put(Blocks.SMOOTH_SANDSTONE, ModBlocks.SANDSTONE_CASTLE_BRICKS.get()).put(Blocks.SMOOTH_RED_SANDSTONE, ModBlocks.RED_SANDSTONE_CASTLE_BRICKS.get()).put(Blocks.DEEPSLATE, ModBlocks.DEEPSLATE_CASTLE_BRICKS.get()).put(Blocks.POLISHED_BLACKSTONE, ModBlocks.BLACKSTONE_CASTLE_BRICKS.get()).put(Blocks.NETHER_BRICKS, ModBlocks.NETHER_CASTLE_BRICKS.get()).put(Blocks.PURPUR_BLOCK, ModBlocks.PURPUR_CASTLE_BRICKS.get()).put(Blocks.PRISMARINE_BRICKS, ModBlocks.PRISMARINE_CASTLE_BRICKS.get()).put(Blocks.END_STONE_BRICKS, ModBlocks.END_STONE_CASTLE_BRICKS.get()).put(Blocks.BRICKS, ModBlocks.BRICK_CASTLE_BRICKS.get()).build();

    public TrowelItem(Properties properties, int maxUses) {
        super(properties.stacksTo(1).durability(maxUses));
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level pLevel, List<Component> pTooltipComponent, TooltipFlag pIsAdvanced) {
        pTooltipComponent.add(new TranslatableComponent("item.castleblocks.trowel.tooltip"));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos blockPos = context.getClickedPos();
        Level level = context.getLevel();
        Player player = context.getPlayer();
        BlockState blockState = level.getBlockState(blockPos);

        if (player != null) {
            if (blockState.getBlock() == Blocks.STONE) { // TODO - implement hashmap
                level.setBlock(blockPos, ModBlocks.CASTLE_BRICKS.get().defaultBlockState(), 3);

                CastleBlockEntity blockEntity = new CastleBlockEntity(blockPos, ModBlocks.CASTLE_BRICKS.get().defaultBlockState());
                blockEntity.setOwner(player);
                level.setBlockEntity(blockEntity);

                    context.getItemInHand().hurtAndBreak(1, player, (entity) -> {
                        entity.broadcastBreakEvent(player.getUsedItemHand());
                    });

                    if (level.isClientSide) {
                        level.levelEvent(player, LevelEvent.PARTICLES_DESTROY_BLOCK, blockPos, Block.getId(blockState));
                    }

                return InteractionResult.SUCCESS;
            } else if (level.getBlockEntity(blockPos) instanceof CastleBlockEntity blockEntity && !level.isClientSide) {
                TranslatableComponent ownerText = new TranslatableComponent("item.castleblocks.trowel.owner", blockEntity.getOwnerName());
                player.sendMessage(ownerText, Util.NIL_UUID);
            }
        }

        return InteractionResult.PASS;
    }
}