package com.periodiccraft.pcm.api.energy;

public interface IMachine extends IElectricStorage {

	void setInputRequired(float par1);
	
	float getInputRequired();
	
}
