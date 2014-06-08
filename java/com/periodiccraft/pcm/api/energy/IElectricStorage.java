package com.periodiccraft.pcm.api.energy;

public interface IElectricStorage {
	
	//
	
	float getEnergy();
	
	float getCapacity();
	
	//
	
	void set(float par1);
	
	void increment(float par1);
	
	void decrement(float par1);
	
	//
	
}
