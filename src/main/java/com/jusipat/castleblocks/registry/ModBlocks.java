package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import com.jusipat.castleblocks.block.CastleBlock;
import com.jusipat.castleblocks.block.CastleBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Collections;

public class ModBlocks {
	public static final Block CASTLE_BRICKS = new CastleBlock(FabricBlockSettings.of(Material.STONE).strength(6.0f, 8.0f));
	public static final BlockEntityType<CastleBlockEntity> CASTLE_BLOCK_ENTITY = new BlockEntityType<>(CastleBlockEntity::new, Collections.singleton(CASTLE_BRICKS), null);

	public static void registerBlocks() {
		Registry.register(Registry.BLOCK, new Identifier(CastleBlocksMod.MOD_ID, "castle_bricks"), CASTLE_BRICKS);
		Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(CastleBlocksMod.MOD_ID, "castle_bricks"), CASTLE_BLOCK_ENTITY);
	}
}
