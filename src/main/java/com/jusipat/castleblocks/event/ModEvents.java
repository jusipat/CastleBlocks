package com.jusipat.castleblocks.event;

import com.jusipat.castleblocks.CastleBlocksMod;
import com.jusipat.castleblocks.block.CastleBlockEntity;
import com.jusipat.castleblocks.config.CommonConfigs;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = CastleBlocksMod.MOD_ID)
    public static class ForgeEvents {

        @SubscribeEvent
        public static void onBlockBreak(PlayerEvent.BreakSpeed event) {
            Level level = event.getPlayer().getLevel();
            BlockEntity blockEntity = level.getBlockEntity(event.getPos());

            if (blockEntity instanceof CastleBlockEntity castleBlockEntity && CommonConfigs.PVP_MODE.get()) {
                if (castleBlockEntity.isOwner(event.getEntity().getUUID())) {
                    event.setNewSpeed(event.getNewSpeed() / 0.5F);
                } else {
                    event.setNewSpeed(event.getNewSpeed() / CommonConfigs.MODIFIER.get().floatValue());
                }
            }
        }
    }
}