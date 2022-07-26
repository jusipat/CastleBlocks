package com.jusipat.castleblocks.item;

import com.jusipat.castleblocks.registry.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.Random;


public class TreeTapItem extends Item {

    public TreeTapItem(Settings settings, int maxUses) {
        super(settings);


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

            if (blockId.equals(Registry.BLOCK.getId(Blocks.STRIPPED_BIRCH_LOG)) || blockId.equals(Blocks.STRIPPED_ACACIA_LOG) || blockId.equals(Blocks.STRIPPED_JUNGLE_LOG)
                    || blockId.equals(Blocks.STRIPPED_DARK_OAK_LOG) || blockId.equals(Blocks.STRIPPED_SPRUCE_LOG) || blockId.equals(Blocks.STRIPPED_MANGROVE_LOG) || blockId.equals(Blocks.STRIPPED_OAK_LOG)) {

                context.getStack().damage(1, player, playerEntity -> playerEntity.sendToolBreakStatus(context.getHand()));

                if (player.getInventory().getEmptySlot() == -1) {
                    player.dropStack(stack);
                } else {
                    player.giveItemStack(stack);
                }

            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
}
