package com.periodiccraft.pcm.core.tile;

import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.periodiccraft.pcm.api.energy.IElectric;
import com.periodiccraft.pcm.api.energy.IElectricStorage;

public class TileBasicEnergyStorage extends ElectricTile implements IElectric, IElectricStorage {

	private float energy = 0;
	private float capacity = 1000;
	
	public TileBasicEnergyStorage(World par1, int par2, boolean par3, boolean par4) {
		super(par1, par2, par3, par4);
		this.setEnergy(1000);
		this.setAllowInput(true);
	}

	@Override
	public float getEnergy() {
		return this.energy;
	}

	@Override
	public float getCapacity() {
		return this.capacity;
	}

	@Override
	public void setEnergy(float par1) {
		if (par1 <= capacity)
			this.energy = par1;
	}

	@Override
	public void incrementEnergy(float par1) {
		if (this.canIncrement(par1))
			this.energy += par1;
	}

	@Override
	public void decrementEnergy(float par1) {
		if (this.canDecrement(par1))
			this.energy -= par1;
	}

	@Override
	public void outputEnergy(ForgeDirection par1, float par2) {
		if (this.canConnectWith(par1)) {
			
			TileBasicEnergyStorage target = this.getElectricStorage(par1);
			
			if (target.getAllowInput() && this.getAllowOutput() && target.canIncrement(par2)) {
				
				decrementEnergy(par2);
				target.incrementEnergy(par2);
				
			}
			
		}
	}

	@Override
	public boolean canIncrement(float par1) {
		return (this.energy + par1 <= this.capacity);
	}

	@Override
	public boolean canDecrement(float par1) {
		return (this.energy - par1 >= 0);
	}

}
