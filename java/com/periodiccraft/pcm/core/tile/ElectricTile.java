package com.periodiccraft.pcm.core.tile;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.periodiccraft.pcm.api.energy.IElectric;
import com.periodiccraft.pcm.api.energy.IElectricStorage;
import com.periodiccraft.pcm.helper.ChatUtil;
import com.periodiccraft.pcm.helper.Position;

public class ElectricTile extends PeriodicTile implements IElectric {
	
	private boolean allowInput;
	private boolean allowOutput;
	
	public ElectricTile(World par1, int par2, boolean par3, boolean par4) {
		
		super(par1, par2);
		
		this.allowInput = par3;
		this.allowOutput = par4;
		
	}

	public final void setAllowInput(boolean par1) {
		this.allowInput = par1;
	}
	
	public final void setAllowOutput(boolean par1) {
		this.allowOutput = par1;
	}
	
	@Override
	public final boolean getAllowInput() {
		return this.allowInput;
	}

	@Override
	public final boolean getAllowOutput() {
		return this.allowOutput;
	}

	@Override
	public ElectricTile getElectricTile(ForgeDirection par1) {
		
		Position var1 = getPosition().getPosition(par1);
		TileEntity var2 = getWorld().getTileEntity(var1.getX(), var1.getY(), var1.getZ());
		
		return (var2 instanceof IElectric ? (ElectricTile) var2 : null);
		
	}
	
	public TileBasicEnergyStorage getElectricStorage(ForgeDirection par1) {
		return (TileBasicEnergyStorage) getElectricTile(par1);
	}
	
	@Override
	public boolean canConnectWith(ForgeDirection par1) {
		
		Position var1 = getPosition().getPosition(par1);
		TileEntity var2 = getWorld().getTileEntity(var1.getX(), var1.getY(), var1.getZ());
		
		return (var2 instanceof IElectric ? true : false);
		
	}

	@Override
	public int getConnections() {
		int result = 0;
		for (ForgeDirection var: ForgeDirection.values()) {
			if (canConnectWith(var)) result++;
		}
		return result;
	}

	@Override
	public void onElectricNeighborAdded(ForgeDirection par1, ElectricTile par2) {
		TileBasicEnergyStorage var1 = (TileBasicEnergyStorage) par2;
		var1.setEnergy(1000);
		ChatUtil.sendChatMessage(ChatUtil.StringHandler.green + "An electrical neighbor was added. " + (par2 instanceof IElectricStorage ? "(Energy: " + var1.getEnergy() + "/" + var1.getCapacity() + ")" : "(Not a storage)"));
	}

	@Override
	public void onElectricNeighborDestroyed(ForgeDirection par1, ElectricTile par3) {}
	
}
