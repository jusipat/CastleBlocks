package com.jusipat.castleblocks.mixin;

import com.jusipat.castleblocks.custom.ModdedStrippedState;
import com.jusipat.castleblocks.registry.ModItems;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Oxidizable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(AxeItem.class)
public abstract class AxeItemMixin {


	@Inject(method = "useOnBlock", at = @At("HEAD"))
	protected ActionResult injectOnUseMethod(ItemUsageContext context, CallbackInfoReturnable info) {
		PlayerEntity playerEntity = context.getPlayer();
		World world = context.getWorld();
		BlockPos blockPos = context.getBlockPos();
		BlockState blockState = world.getBlockState(blockPos);
		Optional<BlockState> optional = ModdedStrippedState.getStrippedState(blockState);
		Optional<BlockState> optional2 = Oxidizable.getDecreasedOxidationState(blockState);
		Optional<BlockState> optional3 = Optional.ofNullable(HoneycombItem.WAXED_TO_UNWAXED_BLOCKS.get().get(blockState.getBlock())).map(block -> block.getStateWithProperties(blockState));
		ItemStack itemStack = context.getStack();
		Optional<BlockState> optional4 = Optional.empty();
		if (optional.isPresent()) {
			world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0f, 1.0f);
			if (playerEntity.getInventory().getEmptySlot() == -1) {
				playerEntity.dropStack(new ItemStack(ModItems.RESIN, 1));
			} else {
				playerEntity.giveItemStack(new ItemStack(ModItems.RESIN, 1));
			}
			optional4 = optional;
		} else if (optional2.isPresent()) {
			world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0f, 1.0f);
			world.syncWorldEvent(playerEntity, WorldEvents.BLOCK_SCRAPED, blockPos, 0);
			optional4 = optional2;
		} else if (optional3.isPresent()) {
			world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1.0f, 1.0f);
			world.syncWorldEvent(playerEntity, WorldEvents.WAX_REMOVED, blockPos, 0);
			optional4 = optional3;
		}
		if (optional4.isPresent()) {
			if (playerEntity instanceof ServerPlayerEntity) {
				Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity) playerEntity, blockPos, itemStack);
			}
			world.setBlockState(blockPos, optional4.get(), Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
			world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(playerEntity, optional4.get()));
			if (playerEntity != null) {
				itemStack.damage(1, playerEntity, p -> p.sendToolBreakStatus(context.getHand()));
			}
			return ActionResult.success(world.isClient);
		}
		return ActionResult.PASS;
	}

}