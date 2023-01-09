package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import com.jusipat.castleblocks.block.item.TrowelItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {

   public static final DeferredRegister<Item> ITEMS =
           DeferredRegister.create(ForgeRegistries.ITEMS, CastleBlocksMod.MOD_ID);

    public static final RegistryObject<Item> IRON_TROWEL = ITEMS.register("iron_trowel", () -> new TrowelItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS), 250));
    public static final RegistryObject<Item> DIAMOND_TROWEL = ITEMS.register("diamond_trowel", () -> new TrowelItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS), 1561));
    public static final RegistryObject<Item> GOLD_TROWEL = ITEMS.register("gold_trowel", () -> new TrowelItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS), 32));
    public static final RegistryObject<Item> NETHERITE_TROWEL = ITEMS.register("netherite_trowel", () -> new TrowelItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS), 2031));


   public static void register(IEventBus eventBus) {
       ITEMS.register(eventBus);
   }
}