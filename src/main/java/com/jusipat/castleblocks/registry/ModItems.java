package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {

   public static final DeferredRegister<Item> ITEMS =
           DeferredRegister.create(ForgeRegistries.ITEMS, CastleBlocksMod.MOD_ID);

   public static void register(IEventBus eventBus) {
       ITEMS.register(eventBus);
   }
}