package com.periodiccraft.pcm.core.element;

import com.periodiccraft.pcm.core.registry.SubstanceRegistry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class Atom {
	
	private String name;
	
	private int electrons;
	private int neutrons;
	private int protons;
	
	private float weight;
	
	public Atom(String par1, int par2, int par3, float par4) {
		this.name = par1;
		this.protons = par2;
		this.neutrons = par3;
		this.protons = electrons;
		this.weight = par4;
	}
	
	public final String getName() {
		return name;
	}
	
	public final Substance getSubstance() {
		return SubstanceRegistry.getSubstance(name);
	}
	
	public final boolean isPositive() {
		return protons > electrons;
	}
	
	public final boolean isNegative() {
		return electrons > protons;
	}
	
	public final int getElectrons() {
		return this.electrons;
	}
	
	public final int getNeutrons() {
		return this.neutrons;
	}
	
	public final int getProtons() {
		return this.protons;
	}
	
	public final float getWeight() {
		return this.weight;
	}
	
}
