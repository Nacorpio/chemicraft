package com.periodiccraft.pcm.core.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.periodiccraft.pcm.core.tile.PeriodicTile;
import com.periodiccraft.pcm.helper.ChatUtil;
import com.periodiccraft.pcm.helper.WorldPosition;

public class PeriodicBlock extends BlockContainer {

	protected PeriodicBlock(Material p_i45386_1_) {
		super(p_i45386_1_);
	}

	@Override
	public void onBlockAdded(World par1, int par2, int par3, int par4) {
		TileEntity var1 = par1.getTileEntity(par2, par3, par4);
		if (var1 instanceof PeriodicTile) {
			((PeriodicTile) var1).setPosition(new WorldPosition(par1, par2, par3, par4));
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new PeriodicTile(var1, var2);
	}

}
