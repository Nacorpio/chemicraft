package com.periodiccraft.pcm.core.element;

public class SubstanceStack {

	private Substance substance;
	private float temperature;
	private int count;
	
	public SubstanceStack(Substance par1, int par2) {
		this.substance = par1;
		this.count = par2;
	}
	
	public final Substance getSubstance() {
		return this.substance;
	}
	
	public final void setCount(int par1) {
		this.count = par1;
	}
	
	public final void setTemperature(float par1) {
		this.temperature = par1;
	}
	
	public final float getTemperature() {
		return this.temperature;
	}
	
	public final int getCount() {
		return this.count;
	}
	
}
