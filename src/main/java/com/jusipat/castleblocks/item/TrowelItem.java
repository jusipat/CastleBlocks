package com.jusipat.castleblocks.item;

import com.jusipat.castleblocks.block.CastleBlockEntity;
import com.jusipat.castleblocks.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void appendHoverText(ItemStack stack, @Nullable World world , List<ITextComponent> textComponents, ITooltipFlag tooltipFlag) {
        textComponents.add(new TranslationTextComponent("item.castleblocks.trowel.tooltip"));
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        BlockPos blockPos = context.getClickedPos();
        World level = context.getLevel();
        PlayerEntity player = context.getPlayer();
        BlockState blockState = level.getBlockState(blockPos);

        if (player != null) {

            ResourceLocation blockId = blockState.getBlock().getRegistryName();

            if (blockMap.containsKey(blockId)) {
                Block blockType = Registry.BLOCK.get(blockMap.get(blockId));
                level.setBlock(blockPos, blockType.defaultBlockState(), 3);

                CastleBlockEntity blockEntity = new CastleBlockEntity();
                blockEntity.setOwner(player);
                level.setBlockEntity(blockPos, blockEntity);

                if (level.isClientSide) {
                    level.levelEvent(player, 1, blockPos, Block.getId(blockState));
                }

                context.getItemInHand().hurtAndBreak(1, player, (entity) -> {
                    entity.broadcastBreakEvent(player.getUsedItemHand());
                });

                return ActionResultType.SUCCESS;


            } else if (level.getBlockEntity(blockPos) instanceof CastleBlockEntity && !level.isClientSide) {
                CastleBlockEntity blockEntity = (CastleBlockEntity)level.getBlockEntity(blockPos);
                TranslationTextComponent ownerText = new TranslationTextComponent("item.castleblocks.trowel.owner", blockEntity.getOwnerName()); // FIXME: why is this out of scope?
                player.sendMessage(ownerText, player.getUUID());
            }
        }

        return ActionResultType.PASS;
    }
}