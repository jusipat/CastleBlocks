package com.jusipat.castleblocks.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import java.util.UUID;

public class CastleBlockEntity extends TileEntity {
	private UUID owner;
	private String ownerName;

	public void setOwner(EntityPlayer player) {
		owner = player.getPersistentID();
		ownerName = player.getDisplayName();
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
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		if (owner != null) tag.setString("owner", owner.toString());
		if (ownerName != null) tag.setString("ownerName", ownerName);
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		owner = UUID.fromString(tag.getString("owner"));
		ownerName = tag.getString("ownerName");
	}
}
