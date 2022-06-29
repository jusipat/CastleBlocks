package com.jusipat.castleblocks.block;

import com.jusipat.castleblocks.item.KeyItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtIntArray;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.security.Key;
import java.util.Objects;


public class CastleDoorBlock extends DoorBlock implements BlockEntityProvider {

	public CastleDoorBlock(Settings settings) {
		super(settings);
	}

	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new CastleDoorEntity(pos, state);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		BlockPos entityPos = pos;
		if (state.get(HALF) == DoubleBlockHalf.UPPER) {
			entityPos = pos.down();
		}

		if (world.getBlockEntity(entityPos) instanceof CastleDoorEntity blockEntity) {

			ItemStack keyStack = player.getStackInHand(hand);

			if (!(keyStack.getItem() instanceof KeyItem)) {
				Text alertText = Text.translatable("item.castleblocks.door.alert");
				player.sendMessage(alertText, true);
				if (!world.isClient)
					world.playSound(null, pos, SoundEvents.ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR, SoundCategory.BLOCKS, 1f, 1f);
				return ActionResult.SUCCESS;
			}

			NbtCompound nbt = keyStack.getOrCreateNbt();

			if (nbt.contains("doorid")) {
				if (Objects.equals(nbt.getUuid("doorid"), blockEntity.doorId)) {
					return super.onUse(state, world, pos, player, hand, hit);
				}
				if (nbt.getUuid("doorid") != blockEntity.doorId) {
					Text denyText = Text.translatable("item.castleblocks.door.rejected");
					player.sendMessage(denyText, true);
					if (!world.isClient)
						world.playSound(null, pos, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 1f, 1f);
					return ActionResult.SUCCESS;
				}

			} else {
				nbt.putUuid("doorid", blockEntity.doorId);
				nbt.putIntArray("door_location", new int[]{pos.getX(), pos.getY(), pos.getZ()});
				Text registeredText = Text.translatable("item.castleblocks.door.owner.registered");
				player.sendMessage(registeredText, true);
			}

		}
		return ActionResult.SUCCESS;
	}

	@Override
	public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
		// Ignores redstone updates
	}
}
