package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CastleBlocksMod.MOD_ID);

    //CREATIVE_MODE_TABS is a DeferredRegister<CreativeModeTab>
    public static final Supplier<CreativeModeTab> CASTLEBLOCKS_TAB = CREATIVE_MODE_TAB.register("castleblocks_tab", () -> CreativeModeTab.builder()
            //Set the title of the tab. Don't forget to add a translation!
            .title(Component.translatable("creativetab.castleblocks"))
            //Set the icon of the tab.
            .icon(() -> new ItemStack(ModItems.DIAMOND_TROWEL.get()))
            //Add your items to the tab.
            .displayItems((params, output) -> {
                output.accept(ModItems.IRON_TROWEL);
                output.accept(ModItems.GOLD_TROWEL);
                output.accept(ModItems.DIAMOND_TROWEL);
                output.accept(ModItems.NETHERITE_TROWEL);
                output.accept(ModBlocks.ANDESITE_CASTLE_BRICKS);
                output.accept(ModBlocks.BLACKSTONE_CASTLE_BRICKS);
                output.accept(ModBlocks.BRICK_CASTLE_BRICKS);
                output.accept(ModBlocks.CASTLE_BRICKS);
                output.accept(ModBlocks.DEEPSLATE_CASTLE_BRICKS);
                output.accept(ModBlocks.END_STONE_CASTLE_BRICKS);
                output.accept(ModBlocks.GRANITE_CASTLE_BRICKS.get());
                output.accept(ModBlocks.DIORITE_CASTLE_BRICKS.get());
                output.accept(ModBlocks.PURPUR_CASTLE_BRICKS.get());
                output.accept(ModBlocks.SANDSTONE_CASTLE_BRICKS.get());
                output.accept(ModBlocks.NETHER_CASTLE_BRICKS.get());
                output.accept(ModBlocks.PRISMARINE_CASTLE_BRICKS.get());
                output.accept(ModBlocks.RED_SANDSTONE_CASTLE_BRICKS.get());
                output.accept(ModBlocks.BOULDER.get());
            })
            .build()
    );
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}