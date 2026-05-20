package com.jusipat.castleblocks.plugin;

import com.jusipat.castleblocks.block.CastleBlockEntity;
import com.jusipat.castleblocks.registry.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

public enum CastleBricksComponentProvider implements IBlockComponentProvider {
    INSTANCE;

    @Override
    public void appendTooltip(
            ITooltip tooltip,
            BlockAccessor accessor,
            IPluginConfig config
    ) {
        if (accessor.getBlockEntity() instanceof CastleBlockEntity cb) {
            tooltip.add(Component.translatable("item.castleblocks.trowel.owner", cb.getOwnerName()));
        }
    }

    @Override
    public ResourceLocation getUid() {
        return ModBlocks.CASTLE_BRICKS.getId();
    }
}
