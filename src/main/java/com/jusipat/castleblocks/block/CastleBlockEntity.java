package com.jusipat.castleblocks.block;

import com.jusipat.castleblocks.registry.ModBlocks;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;

import java.util.UUID;

public class CastleBlockEntity extends BlockEntity implements BlockEntityClientSerializable {
	private UUID owner;
	private String ownerName;

	public CastleBlockEntity() {
		super(ModBlocks.CASTLE_BLOCK_ENTITY);
	}

	public void setOwner(PlayerEntity player) {
		owner = player.getUuid();
		ownerName = player.getEntityName();
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
	public CompoundTag toTag(CompoundTag tag) {
		super.toTag(tag);
		if (owner != null)
			tag.putUuid("owner", owner);
		if (ownerName != null)
			tag.putString("ownerName", ownerName);
		return tag;
	}

	@Override
	public void fromTag(BlockState state, CompoundTag tag) {
		super.fromTag(state, tag);
		owner = tag.getUuid("owner");
		ownerName = tag.getString("ownerName");
	}

	@Override
	public void fromClientTag(CompoundTag compoundTag) {
		owner = compoundTag.getUuid("owner");
		ownerName = compoundTag.getString("ownerName");
	}

	@Override
	public CompoundTag toClientTag(CompoundTag compoundTag) {
		return toTag(compoundTag);
	}
}
