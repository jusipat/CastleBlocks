package com.jusipat.castleblocks.item;

import com.jusipat.castleblocks.block.CastleBlockEntity;
import com.jusipat.castleblocks.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrowelItem extends Item {
	public static final int MAX_USES = 128;
	private static final Map<Block, Block> blockMap = new HashMap<>();

	public TrowelItem() {
		blockMap.put(Blocks.stone, ModBlocks.CASTLE_BRICKS);
		blockMap.put(Blocks.sandstone, ModBlocks.SANDSTONE_CASTLE_BRICKS);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean p_77624_4_) {
		// TODO: Add translated text
		lines.add("§3Right click on stone to turn to CastleBricks!");
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
		if (player != null) {
			Block block = world.getBlock(x, y, z);
			TileEntity tileEntity = world.getTileEntity(x, y, z);

			if (blockMap.containsKey(block)) {
				world.setBlock(x, y, z, blockMap.get(block));

				CastleBlockEntity castleTile = new CastleBlockEntity();
				castleTile.setOwner(player);
				world.setTileEntity(x, y, z, castleTile);

				stack.damageItem(1, player);

				return true;
			} else if (tileEntity instanceof CastleBlockEntity && !world.isRemote) {
				CastleBlockEntity castleBlockEntity = (CastleBlockEntity) tileEntity;
				player.addChatComponentMessage(new ChatComponentTranslation("item.trowel.owner", castleBlockEntity.getOwnerName()));
			}
		}

		return false;
	}
}
