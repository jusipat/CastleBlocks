package com.jusipat.castleblocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CastleBlock extends Block implements ITileEntityProvider {
	public CastleBlock(Material material) {
		super(material);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int data) {
		return new CastleBlockEntity();
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase placer, ItemStack stack) {
		super.onBlockPlacedBy(world, x, y, z, placer, stack);
		if (placer instanceof EntityPlayer) {
			TileEntity tileEntity = world.getTileEntity(x, y, z);

			if (tileEntity instanceof CastleBlockEntity) {
				((CastleBlockEntity) tileEntity).setOwner((EntityPlayer) placer);
			}
		}
	}

	@Override
	public float getPlayerRelativeBlockHardness(EntityPlayer player, World world, int x, int y, int z) {
		float ownerCoefficient = 0.01f;
		TileEntity tileEntity = world.getTileEntity(x, y, z);

		if (tileEntity instanceof CastleBlockEntity) {
			CastleBlockEntity castleBlockEntity = (CastleBlockEntity) tileEntity;
			if (castleBlockEntity.isOwner(player.getUniqueID())) {
				ownerCoefficient = 1f;
			}
		}
		return super.getPlayerRelativeBlockHardness(player, world, x, y, z) * ownerCoefficient;
	}
}
