package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {
    private ModItems() {
    }

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CastleBlocksMod.MOD_ID);

    // Block Items

    public static final RegistryObject<BlockItem> CASTLE_BRICK_ITEM = ITEMS.register("castle_bricks",
            () -> new BlockItem((Block) ModBlocks.CASTLE_BRICKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
}