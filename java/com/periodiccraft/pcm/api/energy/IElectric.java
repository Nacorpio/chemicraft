package com.periodiccraft.pcm.api.energy;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public interface IElectric {

	boolean getAllowInput();
	
	boolean getAllowOutput();
	
	TileEntity getElectricTile(ForgeDirection par1);
	
}
