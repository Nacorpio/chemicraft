package com.periodiccraft.pcm.core.element;

public class SubstanceStack extends Substance {

	private int count;
	
	public SubstanceStack(int count, float temperature, int par, String par1, String par2, String par3,
			float par4, float par5, float par6, float par7, CATEGORY par8) {
		super(par, par1, par2, par3, par4, par5, par6, par7, par8);
		this.count = count;
		this.setTemperature(temperature);
	}
	
	public final void setCount(int par1) {
		this.count = par1;
	}
	
	public final int getCount() {
		return this.count;
	}
	
}
