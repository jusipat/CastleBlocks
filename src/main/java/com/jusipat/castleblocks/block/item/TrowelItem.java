package com.jusipat.castleblocks.block.item;

import com.jusipat.castleblocks.block.CastleBlockEntity;
import com.jusipat.castleblocks.registry.ModBlocks;
import net.minecraft.Util;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.item.Item;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ResourceLocation;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class TrowelItem extends Item {

    private static final Map<ResourceLocation, ResourceLocation> blockMap = new HashMap<>();

    public TrowelItem(Item.Properties properties, int maxUses) {
        super(properties.stacksTo(1).durability(maxUses));

        blockMap.put(Blocks.STONE.getRegistryName(), ModBlocks.CASTLE_BRICKS.get().getRegistryName());
        blockMap.put(Blocks.POLISHED_ANDESITE.getRegistryName(), ModBlocks.ANDESITE_CASTLE_BRICKS.get().getRegistryName());
        blockMap.put(Blocks.POLISHED_DIORITE.getRegistryName(), ModBlocks.DIORITE_CASTLE_BRICKS.get().getRegistryName());
        blockMap.put(Blocks.POLISHED_GRANITE.getRegistryName(), ModBlocks.GRANITE_CASTLE_BRICKS.get().getRegistryName());
        blockMap.put(Blocks.SMOOTH_SANDSTONE.getRegistryName(), ModBlocks.SANDSTONE_CASTLE_BRICKS.get().getRegistryName());
        blockMap.put(Blocks.SMOOTH_RED_SANDSTONE.getRegistryName(), ModBlocks.RED_SANDSTONE_CASTLE_BRICKS.get().getRegistryName());
        blockMap.put(Blocks.POLISHED_BLACKSTONE.getRegistryName(), ModBlocks.BLACKSTONE_CASTLE_BRICKS.get().getRegistryName());
        blockMap.put(Blocks.NETHER_BRICKS.getRegistryName(), ModBlocks.NETHER_CASTLE_BRICKS.get().getRegistryName());
        blockMap.put(Blocks.BRICKS.getRegistryName(), ModBlocks.BRICK_CASTLE_BRICKS.get().getRegistryName());
        blockMap.put(Blocks.PURPUR_BLOCK.getRegistryName(), ModBlocks.PURPUR_CASTLE_BRICKS.get().getRegistryName());
        blockMap.put(Blocks.PRISMARINE_BRICKS.getRegistryName(), ModBlocks.PRISMARINE_CASTLE_BRICKS.get().getRegistryName());
        blockMap.put(Blocks.END_STONE_BRICKS.getRegistryName(), ModBlocks.END_STONE_CASTLE_BRICKS.get().getRegistryName());
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

            ResourceLocation blockId = blockState.getBlock().getRegistryName();

            if (blockMap.containsKey(blockId)) {
                Block blockType = Registry.BLOCK.get(blockMap.get(blockId));
                level.setBlock(blockPos, blockType.defaultBlockState(), 3);

                CastleBlockEntity blockEntity = new CastleBlockEntity(blockPos, blockType.defaultBlockState());
                blockEntity.setOwner(player);
                level.setBlockEntity(blockEntity);

                    if (level.isClientSide) {
                        level.levelEvent(player, LevelEvent.PARTICLES_DESTROY_BLOCK, blockPos, Block.getId(blockState));
                    }

                context.getItemInHand().hurtAndBreak(1, player, (entity) -> {
                    entity.broadcastBreakEvent(player.getUsedItemHand());
                });

                return InteractionResult.SUCCESS;
            } else if (level.getBlockEntity(blockPos) instanceof CastleBlockEntity blockEntity && !level.isClientSide) {
                TranslatableComponent ownerText = new TranslatableComponent("item.castleblocks.trowel.owner", blockEntity.getOwnerName());
                player.sendMessage(ownerText, Util.NIL_UUID);
            }
        }

        return InteractionResult.PASS;
    }
}