package com.periodiccraft.pcm.core.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.periodiccraft.pcm.api.energy.IElectric;
import com.periodiccraft.pcm.api.energy.IElectricStorage;
import com.periodiccraft.pcm.core.tile.ElectricTile;
import com.periodiccraft.pcm.core.tile.TileBasicEnergyStorage;
import com.periodiccraft.pcm.helper.ChatUtil;
import com.periodiccraft.pcm.helper.Position;

public class PeriodicElectricBlock extends PeriodicBlock {

	protected PeriodicElectricBlock(Material p_i45386_1_) {
		super(p_i45386_1_);
	}

	
	
	public boolean onBlockActivated(World par1, int par2, int par3, int par4, EntityPlayer par5, int par6, float par7, float par8, float par9) {

		if (!par1.isRemote) {
			
			Position var1 = new Position(par2, par3, par4);
			TileEntity var2 = par1.getTileEntity(var1.getX(), var1.getY(), var1.getZ());
			
			if (var2 instanceof IElectric && var2 instanceof IElectricStorage) {
				
				TileBasicEnergyStorage var3 = (TileBasicEnergyStorage) var2;
				var3.onElectricActivated(par1, par5);
				
			}
			
			return true;
			
		}
		
		return false;
		
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World par1, int par2, int par3, int par4, int par5) {
		
		Position var1 = new Position(par2, par3, par4);
		
		for (int i = 0; i < ForgeDirection.values().length - 1; i++) {		
			
			ForgeDirection var = ForgeDirection.values()[i];
			
			Position var2 = var1.getPosition(var);		
			TileEntity varTile1 = par1.getTileEntity(var2.getX(), var2.getY(), var2.getZ());
				
			if (varTile1 instanceof IElectric) {
				
				ElectricTile tile = (ElectricTile) par1.getTileEntity(par2, par3, par4);
				ElectricTile eTile = (ElectricTile) varTile1;
				
				eTile.onElectricNeighborDestroyed(var.getOpposite(), tile);
					
			}	
			
		}
		
	}
	
	/*@Override
	public void onBlockAdded(World par1, int par2, int par3, int par4) {
		
		Position var1 = new Position(par2, par3, par4);
		
		for (int i = 0; i < ForgeDirection.values().length - 1; i++) {
			
			ForgeDirection var = ForgeDirection.values()[i];
			
			Position var2 = var1.getPosition(var);	
			TileEntity varTile1 = par1.getTileEntity(var2.getX(), var2.getY(), var2.getZ());
				
			if (varTile1 instanceof IElectric) {
					
				ElectricTile tile = (ElectricTile) par1.getTileEntity(par2, par3, par4);
				ElectricTile eTile = (ElectricTile) varTile1;
					
				ChatUtil.sendChatMessage(ChatUtil.StringHandler.green + "Found an electric block. (" + var.name() + ")");
				
				eTile.onElectricNeighborAdded(var.getOpposite(), tile);
					
			}	
			
		}
		
	}*/
	
	@Override
	public void onNeighborBlockChange(World par1, int par2, int par3, int par4, Block par5) {
		
	}

}
