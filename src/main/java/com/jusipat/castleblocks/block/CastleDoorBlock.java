package com.jusipat.castleblocks.block;

import com.jusipat.castleblocks.item.KeyItem;
import com.jusipat.castleblocks.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Objects;

import com.jusipat.castleblocks.registry.ModItems;


public class CastleDoorBlock extends DoorBlock implements BlockEntityProvider {

	public CastleDoorBlock(Settings settings) {
		super(settings);
	}

	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new CastleDoorEntity(pos, state);
	}

	@Override
	public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
		super.onPlaced(world, pos, state, placer, itemStack);
		if (placer instanceof PlayerEntity) {
			ItemStack gennedKey = new ItemStack(ModItems.KEY, 1);

			if (world.getBlockEntity(pos) instanceof CastleDoorEntity blockEntity) {
				NbtCompound keynbt = gennedKey.getOrCreateNbt();
				keynbt.putUuid("doorid", blockEntity.doorId);
				keynbt.putIntArray("door_location", new int[]{pos.getX(), pos.getY(), pos.getZ()});
			}
			((PlayerEntity) placer).giveItemStack(gennedKey);
		}
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
				TranslatableText text
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

	@Override
	public float calcBlockBreakingDelta(BlockState state, PlayerEntity player, BlockView world, BlockPos pos) {
		return super.calcBlockBreakingDelta(state, player, world, pos) * 0.1f;
	}
}
