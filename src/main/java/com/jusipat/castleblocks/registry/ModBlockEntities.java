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
                    BlockEntityType.Builder.of(CastleBlockEntity::new, ModBlocks.CASTLE_BRICKS.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
