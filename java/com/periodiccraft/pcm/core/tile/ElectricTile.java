package com.periodiccraft.pcm.core.tile;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.periodiccraft.pcm.api.energy.IElectric;
import com.periodiccraft.pcm.helper.Position;

public class ElectricTile extends PeriodicTile implements IElectric {
	
	private boolean allowInput;
	private boolean allowOutput;
	
	private int connections = 0;
	
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

	public final boolean canConnect() {
		for (int i = 0; i < ForgeDirection.values().length - 1; i++) {
			if (canConnectWith(ForgeDirection.values()[i])) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean canConnectWith(ForgeDirection par1) {	
		return getPosition().getTileEntity(par1) instanceof IElectric;
	}

	@Override
	public int getConnections() {
		return this.connections;
	}

	@Override
	public void onElectricNeighborAdded(ForgeDirection par1, ElectricTile par2) {}
	
	@Override
	public void onElectricNeighborDestroyed(ForgeDirection par1, ElectricTile par3) {}

	@Override
	public void onElectricActivated(World par1, EntityPlayer par2) {}

	@Override
	public void addConnection() {
		this.connections++;
	}
	
}
