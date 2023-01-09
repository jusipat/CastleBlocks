package com.jusipat.castleblocks.block;

import com.jusipat.castleblocks.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.UUID;

public class CastleBlockEntity extends BlockEntity {
    private UUID owner;
    private String ownerName;

    public CastleBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.CASTLE_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    public void setOwner(Player player) {
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
    public void load(CompoundTag nbt) {
        super.load(nbt);
        owner = nbt.getUUID("owner");
        ownerName = nbt.getString("ownerName");
    }
    @Override
    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        if (owner != null)
            nbt.putUUID("owner", owner);
        if (ownerName != null)
            nbt.putString("ownerName", ownerName);
        }

}
