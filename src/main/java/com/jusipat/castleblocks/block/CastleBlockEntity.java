package com.jusipat.castleblocks.block;

import com.jusipat.castleblocks.registry.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;

import java.util.UUID;


public class CastleBlockEntity extends TileEntity {
    private UUID owner;
    private String ownerName;

    public CastleBlockEntity() {
        super(ModBlockEntities.CASTLE_BLOCK_ENTITY.get());
    }

    public void setOwner(LivingEntity player) {
        owner = player.getUUID();
        ownerName = player.getScoreboardName();

    }

    public boolean isOwner(UUID playerId) {
        if (owner == null) return false;
        return owner.equals(playerId);
    }

    public String getOwnerName() {
        return (ownerName == null || ownerName.isEmpty()) ? "Unknown" : ownerName;
    }

    @Override
    public void load(BlockState blockState, CompoundNBT nbt) {
        super.load(this.getBlockState(), nbt);
        owner = nbt.getUUID("owner");
        ownerName = nbt.getString("ownerName");
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        if (owner != null)
            nbt.putUUID("owner", owner);
        if (ownerName != null)
            nbt.putString("ownerName", ownerName);
        return super.save(nbt);
    }

    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT nbt = super.getUpdateTag();
        save(nbt);
        return nbt;
    }
}
