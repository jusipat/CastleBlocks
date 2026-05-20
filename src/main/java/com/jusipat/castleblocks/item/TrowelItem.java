package com.jusipat.castleblocks.item;

import com.jusipat.castleblocks.block.CastleBlockEntity;
import com.jusipat.castleblocks.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
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
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrowelItem extends Item {

    private static final Map<ResourceKey<LootTable>, ResourceLocation> blockMap = new HashMap<>();

    public TrowelItem(Properties properties) {
        super(properties);

        blockMap.put(Blocks.STONE.getLootTable(), ModBlocks.CASTLE_BRICKS.getId());
        blockMap.put(Blocks.POLISHED_ANDESITE.getLootTable(), ModBlocks.ANDESITE_CASTLE_BRICKS.getId());
        blockMap.put(Blocks.POLISHED_DIORITE.getLootTable(), ModBlocks.DIORITE_CASTLE_BRICKS.getId());
        blockMap.put(Blocks.POLISHED_GRANITE.getLootTable(), ModBlocks.GRANITE_CASTLE_BRICKS.getId());
        blockMap.put(Blocks.SMOOTH_SANDSTONE.getLootTable(), ModBlocks.SANDSTONE_CASTLE_BRICKS.getId());
        blockMap.put(Blocks.SMOOTH_RED_SANDSTONE.getLootTable(), ModBlocks.RED_SANDSTONE_CASTLE_BRICKS.getId());
        blockMap.put(Blocks.DEEPSLATE.getLootTable(), ModBlocks.DEEPSLATE_CASTLE_BRICKS.getId());
        blockMap.put(Blocks.POLISHED_BLACKSTONE.getLootTable(), ModBlocks.BLACKSTONE_CASTLE_BRICKS.getId());
        blockMap.put(Blocks.NETHER_BRICKS.getLootTable(), ModBlocks.NETHER_CASTLE_BRICKS.getId());
        blockMap.put(Blocks.BRICKS.getLootTable(), ModBlocks.BRICK_CASTLE_BRICKS.getId());
        blockMap.put(Blocks.PURPUR_BLOCK.getLootTable(), ModBlocks.PURPUR_CASTLE_BRICKS.getId());
        blockMap.put(Blocks.PRISMARINE_BRICKS.getLootTable(), ModBlocks.PRISMARINE_CASTLE_BRICKS.getId());
        blockMap.put(Blocks.END_STONE_BRICKS.getLootTable(), ModBlocks.END_STONE_CASTLE_BRICKS.getId());
    }


    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("item.castleblocks.trowel.tooltip"));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos blockPos = context.getClickedPos();
        Level level = context.getLevel();
        Player player = context.getPlayer();
        BlockState blockState = level.getBlockState(blockPos);

        if (player != null) {

            ResourceKey<LootTable> blockId = blockState.getBlock().getLootTable();

            if (blockMap.containsKey(blockId)) {
                Block blockType = BuiltInRegistries.BLOCK.get(blockMap.get(blockId));
                level.setBlock(blockPos, blockType.defaultBlockState(), 3);

                CastleBlockEntity blockEntity = new CastleBlockEntity(blockPos, blockType.defaultBlockState());
                blockEntity.setOwner(player);
                level.setBlockEntity(blockEntity);

                    if (level.isClientSide) {
                        level.levelEvent(player, LevelEvent.PARTICLES_DESTROY_BLOCK, blockPos, Block.getId(blockState));
                    }
                    context.getItemInHand().hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
//                context.getItemInHand().hurtAndBreak(1, player, (entity) -> {
//                    entity.broadcastBreakEvent(player.getUsedItemHand());
//                });

                return InteractionResult.SUCCESS;
            } else if (level.getBlockEntity(blockPos) instanceof CastleBlockEntity blockEntity && !level.isClientSide) {
                player.displayClientMessage(Component.translatable("item.castleblocks.trowel.owner", blockEntity.getOwnerName()), true);
            }
        }

        return InteractionResult.PASS;
    }
}