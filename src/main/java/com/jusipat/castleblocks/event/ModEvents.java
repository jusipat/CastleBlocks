package com.jusipat.castleblocks.event;

import com.jusipat.castleblocks.CastleBlocksMod;
import com.jusipat.castleblocks.block.CastleBlockEntity;
import com.jusipat.castleblocks.config.CommonConfigs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = CastleBlocksMod.MOD_ID)
    public static class ForgeEvents {

        @SubscribeEvent
        public static void onBlockBreak(PlayerEvent.BreakSpeed event) {
            World level = event.getPlayer().getCommandSenderWorld();
            TileEntity tileEntity = level.getBlockEntity(event.getPos());

            if (tileEntity instanceof CastleBlockEntity) {
                CastleBlockEntity castleBlockEntity = (CastleBlockEntity) tileEntity;
                if (castleBlockEntity.isOwner(event.getPlayer().getUUID()) || CommonConfigs.PVP_MODE.get()) {
                    event.setNewSpeed(3.0f);
                } else {
                    event.setNewSpeed(0.01f);
                }
            }
        }
    }
}
