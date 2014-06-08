package com.periodiccraft.pcm.core.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.periodiccraft.pcm.PeriodicCraft;
import com.periodiccraft.pcm.core.tile.PeriodicTile;

import cpw.mods.fml.common.registry.GameRegistry;

public class PeriodicBlock extends BlockContainer {

	protected PeriodicBlock(Material p_i45386_1_) {
		super(p_i45386_1_);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new PeriodicTile(var1, var2);
	}

}
