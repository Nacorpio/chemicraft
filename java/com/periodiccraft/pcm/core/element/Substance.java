package com.periodiccraft.pcm.core.element;

import net.minecraft.client.Minecraft;

import com.periodiccraft.pcm.core.registry.ResearchRegistry;
import com.periodiccraft.pcm.core.registry.ResearchRegistry.Research;
import com.periodiccraft.pcm.core.registry.SubstanceRegistry;

public class Substance {

	public static enum CATEGORY {
		ALKALI_METALS,
		ALKALINE_EARTH_METALS,
		TRANSITION_METALS,
		POST_TRANSITION_METALS,
		LANTHANIDES,
		ACTINIDES,
		HALOGENS,
		NOBLE_GASES,
		NON_METALS,
		SEMI_METALS,
		UNKNOWN;
	}
	
	public static enum STATE {
		GAS,
		LIQUID,
		SOLID,
		PLASMA;
	}
	
	private int id;
	
	private String name;
	private String symbol;
	private String color;
	
	private float atomicWeight;
	
	private float temperature = 10.0F;
	
	private float boilingPoint;
	private float meltingPoint;
	private float heatOfVaporization;
	
	private CATEGORY category;
	private STATE state;
	
	public Substance(int par, String par1, String par2, String par3, float par4, float par5, float par6, float par7, CATEGORY par8) {
		
		this.id = par;
		this.name = par1;
		this.symbol = par2;
		this.color = par3;
		this.atomicWeight = par4;
		this.boilingPoint = par5;
		this.meltingPoint = par6;
		this.heatOfVaporization = par7;
		this.category = par8;
		
		SubstanceRegistry.addSubstance(this);
		ResearchRegistry.addResearch(this.id, new Research<Substance>(Minecraft.getMinecraft().thePlayer));
		
	}
	
	public final void setTemperature(float par1) {
		this.temperature = par1;
	}
	
	public final int getSubstanceId() {
		return this.id;
	}
	
	public final CATEGORY getCategory() {
		return this.category;
	}
	
	public final STATE getState() {
		return (((temperature >= this.meltingPoint && temperature < this.boilingPoint) ? (temperature < this.meltingPoint ? STATE.SOLID : STATE.LIQUID) : STATE.LIQUID));
	}
	
	public final String getName() {
		return this.name;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final String getColor() {
		return this.color;
	}
	
	public final float getAtomicWeight() {
		return this.atomicWeight;
	}
	
	public final float getBoilingPoint() {
		return this.boilingPoint;
	}
	
	public final float getMeltingPoint() {
		return this.meltingPoint;
	}
	
	public final float getTemperature() {
		return this.temperature;
	}
	
	public final float getHeatOfVaporization() {
		return this.heatOfVaporization;
	}
	
}
