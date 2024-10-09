package com.jusipat.castleblocks.block;

import com.jusipat.castleblocks.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
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
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);
        owner = pTag.getUUID("owner");
        ownerName = pTag.getString("ownerName");
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.saveAdditional(pTag, pRegistries);
        if (owner != null)
            pTag.putUUID("owner", owner);
        if (ownerName != null)
            pTag.putString("ownerName", ownerName);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        CompoundTag pTag = super.getUpdateTag(pRegistries);
        saveAdditional(pTag, pRegistries);
        return pTag;
    }
}
