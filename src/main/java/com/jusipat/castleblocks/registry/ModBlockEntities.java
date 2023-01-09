package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import com.jusipat.castleblocks.block.CastleBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, CastleBlocksMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<CastleBlockEntity>> CASTLE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("castle_block_entity", () ->
                    BlockEntityType.Builder.of(CastleBlockEntity::new,
                            ModBlocks.CASTLE_BRICKS.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
