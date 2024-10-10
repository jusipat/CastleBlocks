package com.jusipat.castleblocks.event;

import com.jusipat.castleblocks.CastleBlocksMod;
import com.jusipat.castleblocks.block.CastleBlockEntity;
import com.jusipat.castleblocks.config.Config;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

@EventBusSubscriber(modid=CastleBlocksMod.MOD_ID)
public class ModEvents {
        @SubscribeEvent
        public static void onBlockBreak(PlayerEvent.BreakSpeed event) {
            Level level = event.getEntity().level();
            BlockEntity blockEntity = level.getBlockEntity(event.getPosition().get());
            // FIX LOGIC
            if (blockEntity instanceof CastleBlockEntity castleBlockEntity && Config.pvpMode) {
                if (!castleBlockEntity.isOwner(event.getEntity().getUUID())) {
                    event.setNewSpeed((float) (event.getNewSpeed() / Config.modifier)); // is not owner debuff
            } else {
                    event.setNewSpeed(event.getOriginalSpeed());
                }
        }
        if (blockEntity instanceof CastleBlockEntity castleBlockEntity && Config.siegeMode) {
            if (!castleBlockEntity.isOwner(event.getEntity().getUUID())) {
                event.setNewSpeed(-1); // unbreakable
            } else {
                event.setNewSpeed(event.getOriginalSpeed());
            }
        }
    }
}
