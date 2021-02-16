package com.jusipat.castleblocks.registry;

import com.jusipat.castleblocks.CastleBlocksMod;
import com.jusipat.castleblocks.block.CastleBlock;
import com.jusipat.castleblocks.block.CastleBlockEntity;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
	public static final Block CASTLE_BRICKS = new CastleBlock(Material.rock).setHardness(6.0f).setResistance(8.0f).setBlockName("castle_bricks").setBlockTextureName("castleblocks:castle_bricks").setCreativeTab(CastleBlocksMod.CASTLEBLOCKS_TAB);
	public static final Block SANDSTONE_CASTLE_BRICKS = new CastleBlock(Material.rock).setHardness(6.0f).setResistance(8.0f).setBlockName("sandstone_castle_bricks").setBlockTextureName("castleblocks:sandstone_castle_bricks").setCreativeTab(CastleBlocksMod.CASTLEBLOCKS_TAB);

	public static void registerBlocks() {
		GameRegistry.registerBlock(CASTLE_BRICKS, "castle_bricks");
		GameRegistry.registerBlock(SANDSTONE_CASTLE_BRICKS, "sandstone_castle_bricks");

		GameRegistry.registerTileEntity(CastleBlockEntity.class, "castle_bricks");
	}
}
