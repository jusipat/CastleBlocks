package com.jusipat.castleblocks.block;

import com.jusipat.castleblocks.item.KeyItem;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;


public class CastleDoorBlock extends DoorBlock implements BlockEntityProvider {

	public CastleDoorBlock(Settings settings) {
		super(settings);
	}

	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new CastleBlockEntity(pos, state);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

		if (world.getBlockEntity(pos) instanceof CastleDoorEntity blockEntity) {
			ItemStack keyStack = player.getStackInHand(hand);
			if (!(keyStack.getItem() instanceof KeyItem)) {
				System.out.println("Not allowed in!");
				return ActionResult.PASS;
			}
			if (keyStack.getNbt().contains("doorid")) { // Checks if holding key
				if (Objects.equals(keyStack.getNbt().getString("doorid"), blockEntity.doorId)) { // Checks if key id matches
					return super.onUse(state, world, pos, player, hand, hit);
				}
				Text ownerText = Text.translatable("item.castleblocks.door.owner");
				player.sendMessage(ownerText, true);

			} else {
				keyStack.getNbt().putString("doorid", blockEntity.doorId);
				Text alertText = Text.translatable("item.castleblocks.door.owner.registered");
				player.sendMessage(alertText, true);

			}

		}
		return ActionResult.SUCCESS;
	}
}
