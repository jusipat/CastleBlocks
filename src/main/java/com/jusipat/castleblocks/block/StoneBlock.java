package com.jusipat.castleblocks.block;

import com.jusipat.castleblocks.item.TrowelItem;
import com.jusipat.castleblocks.registry.ModBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StoneBlock extends Block {

	public StoneBlock(Settings settings) {
		super(settings);

	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		ItemStack itemStack = player.getMainHandStack();
		if(itemStack.getItem().equals(TrowelItem.TROWEL)) {
			System.out.println("Debug");
		//	world.removeBlock(pos,true);
			world.setBlockState(pos, ModBlocks.CASTLE_BRICKS.getDefaultState());
		}
		return super.onUse(state, world, pos, player, hand, hit);
	}
}
