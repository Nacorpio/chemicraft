package com.periodiccraft.pcm.helper;

import com.periodiccraft.pcm.api.energy.IElectricStorage;

public class TooltipUtil {
	
	public static final String tooltipFormat(String par1) {
		return par1.replace("\\gr", ChatUtil.StringHandler.green).replace("\\r", ChatUtil.StringHandler.red);
	}
	
	public static final String getEnergyLevel(IElectricStorage par1) {
		return tooltipFormat("\\gr" + (par1.getEnergy() > 0 ? "\\gr" + par1.getEnergy() : "\\r" + par1.getEnergy()) + "/\\gr" + par1.getCapacity());
	}
	
}
