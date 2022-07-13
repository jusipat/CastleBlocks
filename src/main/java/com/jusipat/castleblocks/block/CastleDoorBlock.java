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
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Objects;
import java.util.logging.Logger;


public class CastleDoorBlock extends DoorBlock implements BlockEntityProvider {

    public CastleDoorBlock(Settings settings) {
        super(settings);
    }

    boolean redstoneInput;
    float keyIteratorFloat;
    int keyPopulation;


    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        boolean bl = world.isReceivingRedstonePower(pos) || world.isReceivingRedstonePower(pos.offset(state.get(HALF) == DoubleBlockHalf.LOWER ? Direction.UP : Direction.DOWN));
        if (bl)
            redstoneInput = true;
        else
            redstoneInput = false;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CastleDoorEntity(pos, state);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        keyIteratorFloat = 1.0f;
        keyPopulation = 0;
        if (placer instanceof PlayerEntity player) {
            ItemStack gennedKey = new ItemStack(ModItems.KEY, 1);

            if (world.getBlockEntity(pos) instanceof CastleDoorEntity blockEntity) {
                NbtCompound keynbt = gennedKey.getOrCreateNbt();
                keynbt.putUuid("doorid", blockEntity.doorId);
                keynbt.putIntArray("door_location", new int[]{pos.getX(), pos.getY(), pos.getZ()});
                if (player.getInventory().getEmptySlot() == -1) {
                    placer.dropStack(gennedKey);
                    keyPopulation++;
                }
            }
            player.giveItemStack(gennedKey);
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
                Text alertText = Text.translatable("item.castleblocks.door.alert");
                player.sendMessage(alertText, true);
                if (!world.isClient)
                    world.playSound(null, pos, SoundEvents.ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR, SoundCategory.BLOCKS, 1f, 1f);
                return ActionResult.SUCCESS;
            }

            NbtCompound nbt = keyStack.getOrCreateNbt();

            if (nbt.contains("doorid")) {
                if (Objects.equals(nbt.getUuid("doorid"), blockEntity.doorId) && (!redstoneInput)) {
                    return super.onUse(state, world, pos, player, hand, hit);
                }
                if (Objects.equals(nbt.getUuid("doorid"), blockEntity.doorId) && (redstoneInput)) {
                    keyIteratorFloat += 0.5f;
                    if (keyIteratorFloat > 10)
                        keyIteratorFloat = 1;
                    player.sendMessage(Text.translatable("item.castleblocks.door.iterator", (int) keyIteratorFloat), true);
                    return ActionResult.SUCCESS;

                }
                if (nbt.getUuid("doorid") != blockEntity.doorId) {
                    Text denyText = Text.translatable("item.castleblocks.door.rejected");
                    player.sendMessage(denyText, true);
                    if (!world.isClient)
                        world.playSound(null, pos, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 1f, 1f);
                    return ActionResult.SUCCESS;
                }

            } else {
                if (keyStack.getItem() instanceof KeyItem) {
                    if (!(keyPopulation > (int) keyIteratorFloat)) {
                        keyPopulation++;
                        nbt.putUuid("doorid", blockEntity.doorId);
                        nbt.putIntArray("door_location", new int[]{pos.getX(), pos.getY(), pos.getZ()});
                        Text registeredText = Text.translatable("item.castleblocks.door.owner.registered");
                        player.sendMessage(registeredText, true);
                    }
                }
            }
        }
        return ActionResult.SUCCESS;
    }


    @Override
    public float calcBlockBreakingDelta(BlockState state, PlayerEntity player, BlockView world, BlockPos pos) {
        return super.calcBlockBreakingDelta(state, player, world, pos) * 0.1f;
    }
}
