package com.jusipat.castleblocks.block;

import com.jusipat.castleblocks.registry.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;
import java.util.UUID;


public class CastleBlockEntity extends TileEntity {
    private UUID owner;
    private String ownerName;

    public CastleBlockEntity(TileEntityType<?> tileEntityType) {
        super(tileEntityType);
    }
    public CastleBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.CASTLE_BLOCK_ENTITY.get());
    }


    public void setOwner(PlayerEntity player) {
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
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        owner = nbt.getUUID("owner");
        ownerName = nbt.getString("ownerName");
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        if (owner != null)
            nbt.putUUID("owner", owner);
        if (ownerName != null)
            nbt.putString("ownerName", ownerName);
        return nbt;
    }

    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return super.getUpdatePacket();
    }

    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT nbt = super.getUpdateTag();
        save(nbt);
        return nbt;
    }

    @Override
    public void handleUpdateTag(BlockState state, CompoundNBT tag) {
        super.handleUpdateTag(state, tag);
    }
}
