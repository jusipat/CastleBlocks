package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import com.jusipat.castleblocks.block.BoulderBlock;
import com.jusipat.castleblocks.block.CastleBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CastleBlocksMod.MOD_ID);
    private static final BlockBehaviour.Properties CB_BLOCK_SETTINGS = BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().strength(2.5f, 11.0f);

    public static final RegistryObject<Block> CASTLE_BRICKS = registerBlock("castle_bricks",
            () -> new CastleBlock(CB_BLOCK_SETTINGS));
    public static final RegistryObject<Block> ANDESITE_CASTLE_BRICKS = registerBlock("andesite_castle_bricks",
            () -> new CastleBlock(CB_BLOCK_SETTINGS));
    public static final RegistryObject<Block> DIORITE_CASTLE_BRICKS = registerBlock("diorite_castle_bricks",
            () -> new CastleBlock(CB_BLOCK_SETTINGS));
    public static final RegistryObject<Block> GRANITE_CASTLE_BRICKS = registerBlock("granite_castle_bricks",
            () -> new CastleBlock(CB_BLOCK_SETTINGS));
    public static final RegistryObject<Block> SANDSTONE_CASTLE_BRICKS = registerBlock("sandstone_castle_bricks",
            () -> new CastleBlock(CB_BLOCK_SETTINGS));
    public static final RegistryObject<Block> RED_SANDSTONE_CASTLE_BRICKS = registerBlock("red_sandstone_castle_bricks",
            () -> new CastleBlock(CB_BLOCK_SETTINGS));
    public static final RegistryObject<Block> BLACKSTONE_CASTLE_BRICKS = registerBlock("blackstone_castle_bricks",
            () -> new CastleBlock(CB_BLOCK_SETTINGS.sound(SoundType.GILDED_BLACKSTONE)));
    public static final RegistryObject<Block> NETHER_CASTLE_BRICKS = registerBlock("nether_castle_bricks",
            () -> new CastleBlock(CB_BLOCK_SETTINGS.sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> PURPUR_CASTLE_BRICKS = registerBlock("purpur_castle_bricks",
            () -> new CastleBlock(CB_BLOCK_SETTINGS));
    public static final RegistryObject<Block> BRICK_CASTLE_BRICKS = registerBlock("brick_castle_bricks",
            () -> new CastleBlock(CB_BLOCK_SETTINGS));
    public static final RegistryObject<Block> PRISMARINE_CASTLE_BRICKS = registerBlock("prismarine_castle_bricks",
            () -> new CastleBlock(CB_BLOCK_SETTINGS));
    public static final RegistryObject<Block> DEEPSLATE_CASTLE_BRICKS = registerBlock("deepslate_castle_bricks",
            () -> new CastleBlock(CB_BLOCK_SETTINGS.sound(SoundType.DEEPSLATE_BRICKS)));
    public static final RegistryObject<Block> END_STONE_CASTLE_BRICKS = registerBlock("end_stone_castle_bricks",
            () -> new CastleBlock(CB_BLOCK_SETTINGS));
    public static final RegistryObject<Block> BOULDER = registerBlock("boulder",
            () -> new BoulderBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.TUFF).strength(0.8F)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

