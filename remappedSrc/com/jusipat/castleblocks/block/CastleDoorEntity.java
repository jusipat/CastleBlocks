package com.jusipat.castleblocks.block;

import com.jusipat.castleblocks.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;

import java.util.UUID;

public class CastleDoorEntity extends BlockEntity {

	public UUID doorId;

	public CastleDoorEntity(BlockPos pos, BlockState state) {
		super(ModBlocks.DOOR_BLOCK_ENTITY, pos, state);
		doorId = UUID.randomUUID();
	}

	@Override
	public void readNbt(NbtCompound nbt) {
		super.readNbt(nbt);
		doorId = nbt.getUuid("doorid");
	}

	@Override
	protected void writeNbt(NbtCompound nbt) {
		super.writeNbt(nbt);
			nbt.putUuid("doorid", doorId);
	}

	@Override
	public Packet<ClientPlayPacketListener> toUpdatePacket() {
		return BlockEntityUpdateS2CPacket.create(this);
	}

	@Override
	public NbtCompound toInitialChunkDataNbt() {
		return createNbt();
	}
}
