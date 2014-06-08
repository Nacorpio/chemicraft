package com.periodiccraft.pcm.core.tile;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.periodiccraft.pcm.api.energy.IElectric;
import com.periodiccraft.pcm.helper.Position;

public class ElectricTile extends PeriodicTile implements IElectric {
	
	private boolean allowInput;
	private boolean allowOutput;
	
	public ElectricTile(World par1, int par2, boolean par3, boolean par4) {
		
		super(par1, par2);
		
		this.allowInput = par3;
		this.allowOutput = par4;
		
	}

	@Override
	public boolean getAllowInput() {
		return this.allowInput;
	}

	@Override
	public boolean getAllowOutput() {
		return this.allowOutput;
	}

	@Override
	public ElectricTile getElectricTile(ForgeDirection par1) {
		
		Position var1 = getPosition().getPosition(par1);
		TileEntity var2 = getWorld().getTileEntity(var1.getX(), var1.getY(), var1.getZ());
		
		return (var2 instanceof IElectric ? (ElectricTile) var2 : null);
		
	}
	
}
