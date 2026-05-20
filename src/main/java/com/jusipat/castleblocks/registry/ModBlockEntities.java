package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import com.jusipat.castleblocks.block.CastleBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, CastleBlocksMod.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CastleBlockEntity>> CASTLE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("castle_block_entity", () ->
                    BlockEntityType.Builder.of(CastleBlockEntity::new,
                            ModBlocks.CASTLE_BRICKS.get(),
                            ModBlocks.ANDESITE_CASTLE_BRICKS.get(),
                            ModBlocks.BRICK_CASTLE_BRICKS.get(),
                            ModBlocks.BLACKSTONE_CASTLE_BRICKS.get(),
                            ModBlocks.DEEPSLATE_CASTLE_BRICKS.get(),
                            ModBlocks.DIORITE_CASTLE_BRICKS.get(),
                            ModBlocks.END_STONE_CASTLE_BRICKS.get(),
                            ModBlocks.GRANITE_CASTLE_BRICKS.get(),
                            ModBlocks.NETHER_CASTLE_BRICKS.get(),
                            ModBlocks.PRISMARINE_CASTLE_BRICKS.get(),
                            ModBlocks.PURPUR_CASTLE_BRICKS.get(),
                            ModBlocks.RED_SANDSTONE_CASTLE_BRICKS.get(),
                            ModBlocks.SANDSTONE_CASTLE_BRICKS.get()
                            ).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
