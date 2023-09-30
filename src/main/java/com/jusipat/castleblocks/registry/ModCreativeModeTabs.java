package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CastleBlocksMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CASTLEBLOCKS_TAB = CREATIVE_MODE_TABS.register("castleblocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.DIAMOND_TROWEL.get()))
                    .title(Component.translatable("creativetab.castleblocks"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.IRON_TROWEL.get());
                        output.accept(ModItems.GOLD_TROWEL.get());
                        output.accept(ModItems.DIAMOND_TROWEL.get());
                        output.accept(ModItems.NETHERITE_TROWEL.get());

                        output.accept(ModBlocks.ANDESITE_CASTLE_BRICKS.get());
                        output.accept(ModBlocks.BLACKSTONE_CASTLE_BRICKS.get());
                        output.accept(ModBlocks.BRICK_CASTLE_BRICKS.get());
                        output.accept(ModBlocks.CASTLE_BRICKS.get());
                        output.accept(ModBlocks.DEEPSLATE_CASTLE_BRICKS.get());
                        output.accept(ModBlocks.END_STONE_CASTLE_BRICKS.get());
                        output.accept(ModBlocks.GRANITE_CASTLE_BRICKS.get());
                        output.accept(ModBlocks.DIORITE_CASTLE_BRICKS.get());
                        output.accept(ModBlocks.PURPUR_CASTLE_BRICKS.get());
                        output.accept(ModBlocks.SANDSTONE_CASTLE_BRICKS.get());
                        output.accept(ModBlocks.NETHER_CASTLE_BRICKS.get());
                        output.accept(ModBlocks.PRISMARINE_CASTLE_BRICKS.get());
                        output.accept(ModBlocks.RED_SANDSTONE_CASTLE_BRICKS.get());

                        output.accept(ModBlocks.BOULDER.get());

                    })
                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}