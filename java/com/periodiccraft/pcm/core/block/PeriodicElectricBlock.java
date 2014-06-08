package com.periodiccraft.pcm.core.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.periodiccraft.pcm.api.energy.IElectric;
import com.periodiccraft.pcm.core.tile.ElectricTile;
import com.periodiccraft.pcm.helper.Position;

public class PeriodicElectricBlock extends PeriodicBlock {

	protected PeriodicElectricBlock(String par1, Material p_i45386_1_) {
		super(par1, p_i45386_1_);
	}

	@Override
	public void onBlockDestroyedByPlayer(World par1, int par2, int par3, int par4, int par5) {
		
		Position var1 = new Position(par2, par3, par4);
		
		for (ForgeDirection var: ForgeDirection.values()) {		
			
			Position var2 = var1.getPosition(var);	
			
			if (par1.getBlock(var2.getX(), var2.getY(), var2.getZ()) != Blocks.air) {
				
				TileEntity varTile1 = par1.getTileEntity(var2.getX(), var2.getY(), var2.getZ());
				
				if (varTile1 instanceof IElectric) {
					
					ElectricTile tile = (ElectricTile) par1.getTileEntity(par2, par3, par4);
					ElectricTile eTile = (ElectricTile) varTile1;
					
					eTile.onElectricNeighborDestroyed(var.getOpposite(), tile);
					
				}
				
			}	
			
		}
		
	}
	
	@Override
	public void onBlockAdded(World par1, int par2, int par3, int par4) {
		
		Position var1 = new Position(par2, par3, par4);
		
		for (ForgeDirection var: ForgeDirection.values()) {		
			
			Position var2 = var1.getPosition(var);	
			
			if (par1.getBlock(var2.getX(), var2.getY(), var2.getZ()) != Blocks.air) {
				
				TileEntity varTile1 = par1.getTileEntity(var2.getX(), var2.getY(), var2.getZ());
				
				if (varTile1 instanceof IElectric) {
					
					ElectricTile tile = (ElectricTile) par1.getTileEntity(par2, par3, par4);
					ElectricTile eTile = (ElectricTile) varTile1;
					
					eTile.onElectricNeighborAdded(var.getOpposite(), tile);
					
				}
				
			}	
			
		}
		
	}
	
	@Override
	public void onNeighborBlockChange(World par1, int par2, int par3, int par4, Block par5) {
		
	}

}
