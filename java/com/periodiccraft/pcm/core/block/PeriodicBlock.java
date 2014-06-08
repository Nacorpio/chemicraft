package com.periodiccraft.pcm.core.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.periodiccraft.pcm.core.tile.PeriodicTile;

public class PeriodicBlock extends BlockContainer {

	protected PeriodicBlock(String par1, Material p_i45386_1_) {
		super(p_i45386_1_);
		this.setBlockName(par1);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new PeriodicTile(var1, var2);
	}

}
