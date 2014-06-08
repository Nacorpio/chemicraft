package com.periodiccraft.pcm.core.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.periodiccraft.pcm.helper.Position;

public class PeriodicElectricBlock extends PeriodicBlock {

	protected PeriodicElectricBlock(String par1, Material p_i45386_1_) {
		super(par1, p_i45386_1_);
	}

	@Override
	public void onNeighborBlockChange(World par1, int par2, int par3, int par4, Block par5) {
		
		Position var1 = new Position(par2, par3, par4);
		
		for (ForgeDirection var: ForgeDirection.values()) {
			
			Position var2 = var1.getPosition(var);
			
			if (par1.getBlock(var2.getX(), var2.getY(), var2.getZ()) != Blocks.air) {
				
				TileEntity varTile1 = par1.getTileEntity(var2.getX(), var2.getY(), var2.getZ());
				
				
			}
			
		}
		
	}

}
