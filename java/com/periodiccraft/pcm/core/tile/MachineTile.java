package com.periodiccraft.pcm.core.tile;

import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.periodiccraft.pcm.api.energy.IElectricStorage;
import com.periodiccraft.pcm.api.energy.IMachine;
import com.periodiccraft.pcm.helper.ChatUtil;

public class MachineTile extends TileBasicEnergyStorage implements IMachine {
	
	private float inputRequired = 20;
	
	public MachineTile(World par1, int par2) {
		super(par1, par2, true, false);
		this.setEnergy(0);
	}

	@Override
	public void outputEnergy(ForgeDirection par1, float par2) {}

	@Override
	public void setInputRequired(float par1) {
		this.inputRequired = par1;
	}

	@Override
	public float getInputRequired() {
		return this.inputRequired;
	}
	
}
