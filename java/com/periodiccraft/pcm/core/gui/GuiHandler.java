package com.periodiccraft.pcm.core.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.periodiccraft.pcm.PeriodicCraft;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z); 
		
		if(entity != null) {
			switch(ID) {
			case PeriodicCraft.guiIDLQ:
				if(entity instanceof TileEntityLQ) {
					return new ContainerLQ(player.inventory, (TileEntityLQ) entity);
			}	
			return null;
		}
	}
		
		if(ID == PeriodicCraft.guiIDMolecularTable) {
			return ID == PeriodicCraft.guiIDMolecularTable && world.getBlock(x, y, z) == PeriodicCraft.MolecularTable ? new ContainerMolecularTable(player.inventory, world, x, y, z) : null;
			}
			
		    return null;
		    
	}
	
	
		


	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	 {
	 TileEntity entity = world.getTileEntity(x, y, z);
	 
	 if(entity != null)
	 {
	 switch(ID)
	 {
	 case PeriodicCraft.guiIDLQ:
		 if(entity instanceof TileEntityLQ)
	     {
	     return new ContainerLQ(player.inventory, (TileEntityLQ) entity);
	     }

	 return null;
	 }
}

	if(ID == PeriodicCraft.guiIDMolecularTable) {
		return ID == PeriodicCraft.guiIDMolecularTable && world.getBlock(x, y, z) == PeriodicCraft.MolecularTable ? new GuiMolecularTable(player.inventory, world, x, y, z) : null;
		}

		return null;

		}
	}
	
	
	