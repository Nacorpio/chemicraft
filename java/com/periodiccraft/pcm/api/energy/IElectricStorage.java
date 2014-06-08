package com.periodiccraft.pcm.api.energy;

import net.minecraftforge.common.util.ForgeDirection;

public interface IElectricStorage {
	
	//
	
	float getEnergy();
	
	float getCapacity();
	
	//
	
	boolean canIncrement(float par1);
	
	boolean canDecrement(float par1);
	
	//
	
	void setEnergy(float par1);
	
	void incrementEnergy(float par1);
	
	void decrementEnergy(float par1);
	
	//
	
	void outputEnergy(ForgeDirection par1, float par2);
	
}
