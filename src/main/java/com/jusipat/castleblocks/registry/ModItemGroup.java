package com.jusipat.castleblocks.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.DIAMOND_TROWEL))
            .displayName(Text.translatable("itemGroup.castleblocks.items")).entries((displayContext, entries) -> {
                entries.add(ModItems.IRON_TROWEL);
                entries.add(ModItems.GOLD_TROWEL);
                entries.add(ModItems.DIAMOND_TROWEL);
                entries.add(ModItems.NETHERITE_TROWEL);
                entries.add(ModItems.CASTLE_BRICKS);
                entries.add(ModItems.ANDESITE_CASTLE_BRICKS);
                entries.add(ModItems.DIORITE_CASTLE_BRICKS);
                entries.add(ModItems.GRANITE_CASTLE_BRICKS);
                entries.add(ModItems.SANDSTONE_CASTLE_BRICKS);
                entries.add(ModItems.RED_SANDSTONE_CASTLE_BRICKS);
                entries.add(ModItems.DEEPSLATE_CASTLE_BRICKS);
                entries.add(ModItems.BLACKSTONE_CASTLE_BRICKS);
                entries.add(ModItems.NETHER_CASTLE_BRICKS);
                entries.add(ModItems.END_STONE_CASTLE_BRICKS);
                entries.add(ModItems.PURPUR_CASTLE_BRICKS);
                entries.add(ModItems.PRISMARINE_CASTLE_BRICKS);
                entries.add(ModItems.BRICK_CASTLE_BRICKS);
                entries.add(ModItems.PITCH_BUCKET);
                entries.add(ModItems.PITCH_CANDLE);
                entries.add(ModItems.TREE_TAP);
                entries.add(ModItems.RESIN);
                entries.add(ModItems.CASTLE_DOOR);
                entries.add(ModItems.KEY);
                entries.add(ModItems.BOULDER_BLOCK);
            } )
            .build();

    public static void registerItemGroup() {
        Registry.register(Registries.ITEM_GROUP, new Identifier("castleblocks", "castleblocks_group"), ITEM_GROUP);
    }
}
