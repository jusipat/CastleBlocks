package com.jusipat.castleblocks.block;

import com.jusipat.castleblocks.registry.ModBlocks;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;

import java.util.UUID;

public class CastleBlockEntity extends BlockEntity implements BlockEntityClientSerializable {
	private UUID owner;

	public CastleBlockEntity() {
		super(ModBlocks.CASTLE_BLOCK_ENTITY);
	}

	public void setOwner(UUID ownerId) {
		owner = ownerId;
		markDirty();
	}

	public boolean isOwner(UUID playerId) {
		System.out.println("IsOwner? " + owner);
		if (owner == null) return false;
		return owner.equals(playerId);
	}

	@Override
	public CompoundTag toTag(CompoundTag tag) {
		super.toTag(tag);
		if (owner != null)
			tag.putUuid("owner", owner);
		return tag;
	}

	@Override
	public void fromTag(BlockState state, CompoundTag tag) {
		System.out.println("FromTag");
		super.fromTag(state, tag);
		owner = tag.getUuid("owner");
	}

	@Override
	public void fromClientTag(CompoundTag compoundTag) {
		owner = compoundTag.getUuid("owner");
	}

	@Override
	public CompoundTag toClientTag(CompoundTag compoundTag) {
		return toTag(compoundTag);
	}
}
