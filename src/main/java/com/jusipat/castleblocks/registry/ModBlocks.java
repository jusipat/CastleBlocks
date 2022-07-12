package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModBlocks {
    private ModBlocks() {}
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CastleBlocksMod.MOD_ID);
    private static final BlockBehaviour.Properties CB_BLOCK_SETTINGS = BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.5f,8.0f);

    public static final RegistryObject CASTLE_BRICKS = BLOCKS.register("castle_bricks", () -> new Block(CB_BLOCK_SETTINGS));
}
