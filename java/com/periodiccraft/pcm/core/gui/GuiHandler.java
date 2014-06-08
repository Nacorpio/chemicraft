package com.periodiccraft.pcm.core.gui;

import com.periodiccraft.pcm.PeriodicCraft;
import com.periodiccraft.pcm.core.guiblocks.TileEntityLQ;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null)
			switch(ID) {
			case PeriodicCraft.guiIDLQ:
				if(entity instanceof TileEntityLQ) {
					return new ContainerLQ(player.inventory, (TileEntityLQ) entity);
				}
	
			}
			return null;
}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null)
			switch(ID) {
			case PeriodicCraft.guiIDLQ:
				if(entity instanceof TileEntityLQ) {
					return new ContainerLQ(player.inventory, (TileEntityLQ) entity);
				}
	
			}
			return null;
	}
}
