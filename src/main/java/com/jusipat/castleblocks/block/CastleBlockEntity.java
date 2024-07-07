package com.jusipat.castleblocks.block;

import com.jusipat.castleblocks.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;

import java.util.UUID;

public class CastleBlockEntity extends BlockEntity {
	private UUID owner;
	private String ownerName;

	public CastleBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(ModBlocks.CASTLE_BLOCK_ENTITY, blockPos, blockState);
	}

	public void setOwner(PlayerEntity player) {
		owner = player.getUuid();
		ownerName = String.valueOf(player.getName());
		markDirty();
	}

	public boolean isOwner(UUID playerId) {
		if (owner == null) return false;
		return owner.equals(playerId);
	}

	public String getOwnerName() {
		return (ownerName == null || ownerName.isEmpty()) ? "Unknown" : ownerName;
	}

	@Override
	protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
		super.readNbt(nbt, registryLookup);
		owner = nbt.getUuid("owner");
		ownerName = nbt.getString("ownerName");
	}

	@Override
	protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
		super.writeNbt(nbt, registryLookup);
		if (owner != null)
			nbt.putUuid("owner", owner);
		if (ownerName != null)
			nbt.putString("ownerName", ownerName);
	}

	@Override
	public Packet<ClientPlayPacketListener> toUpdatePacket() {
		return BlockEntityUpdateS2CPacket.create(this);
	}

	@Override
	public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
		return super.toInitialChunkDataNbt(registryLookup);
	}
}
