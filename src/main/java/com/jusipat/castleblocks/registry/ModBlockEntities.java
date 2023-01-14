package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import com.jusipat.castleblocks.block.CastleBlockEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<TileEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, CastleBlocksMod.MOD_ID);

    public static final RegistryObject<TileEntityType<CastleBlockEntity>> CASTLE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("castle_block_entity", () ->
                    TileEntityType.Builder.of(CastleBlockEntity::new,
                            ModBlocks.CASTLE_BRICKS.get().build(null));

    public static final RegistryObject<TileEntityType<NovaSignTileEntity>> SIGN = REGISTRY.register("sign", () ->
            TileEntityType.Builder.of(NovaSignTileEntity::new, NovaBlocks.WHITE_OAK_SIGN.get(), ModBlocks.CASTLE_BRICKS.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
