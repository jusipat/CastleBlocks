package com.jusipat.castleblocks.event;

import com.jusipat.castleblocks.block.CastleBlockEntity;
import com.jusipat.castleblocks.config.Config;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

public class ModEvents {
    public static class ForgeEvents {
        @SubscribeEvent
        public static void onBlockBreak(PlayerEvent.BreakSpeed event) {
            Level level = event.getEntity().level();
            BlockEntity blockEntity = level.getBlockEntity(event.getPosition().get());

            if (blockEntity instanceof CastleBlockEntity castleBlockEntity && Config.pvpMode) {
                if (castleBlockEntity.isOwner(event.getEntity().getUUID())) {
                    event.setNewSpeed(event.getNewSpeed());
                } else {
                    event.setNewSpeed((float) (event.getNewSpeed() / Config.modifier));
                }
            }
        }

//        @SubscribeEvent
//        public static void onBannerInteract(PlayerInteractEvent.RightClickBlock event) {
//            Level level = event.getEntity().level();
//            BlockEntity blockEntity = level.getBlockEntity(event.getPos());
//
//            if (blockEntity instanceof BannerBlockEntity bannerBlockEntity) {
//                ItemStack itemStack = event.getItemStack();
//                if (itemStack.getItem() instanceof NameTagItem nameTagItem) {
//                    System.out.println(itemStack.getHoverName().getString());
//                }
//            }
//        }
    }
}
