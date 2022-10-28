package com.jusipat.castleblocks.item;

import com.jusipat.castleblocks.registry.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.Random;


public class TreeTapItem extends Item {


    public TreeTapItem(Settings settings, int maxUses) {
        super(settings.maxCount(1).maxDamage(maxUses));


    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        Random rand = new Random();
        int maxN = 3;
        int n = rand.nextInt(maxN) + 1;

        BlockPos blockPos = context.getBlockPos();
        World world = context.getWorld();
        BlockState blockState = world.getBlockState(blockPos);
        PlayerEntity player = context.getPlayer();

        ItemStack stack = new ItemStack(ModItems.RESIN, n);

        if (player != null) {
            Identifier blockId = Registry.BLOCK.getId(blockState.getBlock());
            if (!world.isClient) { // TODO: for the love of god this is a bad way to do this.
                if (blockId.equals(Registry.BLOCK.getId(Blocks.OAK_LOG))) {
                    TreeTapInteraction(world, blockPos, context, player, stack);
                    world.setBlockState(blockPos, Blocks.STRIPPED_OAK_LOG.getDefaultState());

                } else if (blockId.equals(Registry.BLOCK.getId(Blocks.ACACIA_LOG))) {
                    TreeTapInteraction(world, blockPos, context, player, stack);
                    world.setBlockState(blockPos, Blocks.STRIPPED_ACACIA_LOG.getDefaultState());

                } else if (blockId.equals(Registry.BLOCK.getId(Blocks.SPRUCE_LOG))) {
                    TreeTapInteraction(world, blockPos, context, player, stack);
                    world.setBlockState(blockPos, Blocks.STRIPPED_SPRUCE_LOG.getDefaultState());

                } else if (blockId.equals(Registry.BLOCK.getId(Blocks.BIRCH_LOG))) {
                    TreeTapInteraction(world, blockPos, context, player, stack);
                    world.setBlockState(blockPos, Blocks.STRIPPED_BIRCH_LOG.getDefaultState());

                } else if (blockId.equals(Registry.BLOCK.getId(Blocks.MANGROVE_LOG))) {
                    TreeTapInteraction(world, blockPos, context, player, stack);
                    world.setBlockState(blockPos, Blocks.STRIPPED_MANGROVE_LOG.getDefaultState());

                } else if (blockId.equals(Registry.BLOCK.getId(Blocks.DARK_OAK_LOG))) {
                    TreeTapInteraction(world, blockPos, context, player, stack);
                    world.setBlockState(blockPos, Blocks.STRIPPED_DARK_OAK_LOG.getDefaultState());

                } else if (blockId.equals(Registry.BLOCK.getId(Blocks.JUNGLE_LOG))) {
                    TreeTapInteraction(world, blockPos, context, player, stack);
                    world.setBlockState(blockPos, Blocks.STRIPPED_JUNGLE_LOG.getDefaultState());
                } else {
                    return ActionResult.PASS;
                }
                return ActionResult.SUCCESS;
            }
        }

        return ActionResult.PASS;
    }

    public ActionResult TreeTapInteraction(World world, BlockPos blockPos, ItemUsageContext context, PlayerEntity player, ItemStack stack) {
        world.playSound(null, blockPos, SoundEvents.BLOCK_SLIME_BLOCK_HIT, SoundCategory.BLOCKS, .5f, 1f);
        world.playSound(null, blockPos, SoundEvents.BLOCK_BEEHIVE_SHEAR, SoundCategory.BLOCKS, .5f, 1f);
        context.getStack().damage(1, player, playerEntity -> playerEntity.sendToolBreakStatus(context.getHand()));
        world.breakBlock(blockPos, false);


        if (player.getInventory().getEmptySlot() == -1) {
            player.dropStack(stack);
        } else {
            if (!player.isCreative())
                player.giveItemStack(stack);
        }
        return ActionResult.SUCCESS;
    }

}
