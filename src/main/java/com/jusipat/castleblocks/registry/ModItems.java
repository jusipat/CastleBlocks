package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import com.jusipat.castleblocks.item.TrowelItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public final class ModItems {

   public static final DeferredRegister.Items ITEMS =
           DeferredRegister.createItems(CastleBlocksMod.MOD_ID);

    public static final DeferredItem<Item> IRON_TROWEL = ITEMS.register("iron_trowel", () -> new TrowelItem(new Item.Properties().durability(250)));
    public static final DeferredItem<Item> DIAMOND_TROWEL = ITEMS.register("diamond_trowel", () -> new TrowelItem(new Item.Properties().durability(1561)));
    public static final DeferredItem<Item> GOLD_TROWEL = ITEMS.register("gold_trowel", () -> new TrowelItem(new Item.Properties().durability(156)));
    public static final DeferredItem<Item> NETHERITE_TROWEL = ITEMS.register("netherite_trowel", () -> new TrowelItem(new Item.Properties().durability(2091)));


   public static void register(IEventBus eventBus) {
       ITEMS.register(eventBus);
   }
}