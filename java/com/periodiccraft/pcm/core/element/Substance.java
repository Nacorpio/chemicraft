package com.periodiccraft.pcm.core.element;

import net.minecraft.client.Minecraft;

import com.periodiccraft.pcm.PeriodicCraft;
import com.periodiccraft.pcm.core.element.Substance.CATEGORY;
import com.periodiccraft.pcm.core.element.Substance.STATE;
import com.periodiccraft.pcm.core.registry.ResearchRegistry;
import com.periodiccraft.pcm.core.registry.ResearchRegistry.Research;
import com.periodiccraft.pcm.core.registry.SubstanceRegistry;
import com.periodiccraft.pcm.helper.ChatUtil;

public class Substance {

	public static enum CATEGORY {
		
		ALKALI_METALS("Alkali Metals"),
		ALKALINE_EARTH_METALS("Alkali Earth Metals"),
		METALOID("Metaloid"),
		TRANSITION_METALS("Transition Metals"),
		TRANSITION_AND_POST_TRANSISTION_METALS("Transition & Post Transition Metals"),
		POST_TRANSITION_METALS("Post Transition Metals"),
		LANTHANIDES("Lanthanides"),
		ACTINIDES("Actinides"),
		HALOGENS("Halogens"),
		NOBLE_GASES("Noble Gases"),
		NON_METALS("Non-metals"),
		SEMI_METALS("Semi-metals"),
		UNKNOWN("Unknown");
		
		private String text;
		
		CATEGORY(String par1) {
			this.text = par1;
		}
		
		public final String getText() {
			return this.text;
		}
		
	}
	
	public static enum STATE {
		
		GAS("Gas"),
		LIQUID("Liquid"),
		SOLID("Solid"),
		PLASMA("Plasma");
		
		private String text;
		
		STATE(String par1) {
			this.text = par1;
		}
		
		public final String getText() {
			return this.text;
		}
		
	}
	
	public static enum TIER {
		
		ONE("I", ChatUtil.StringHandler.cyan),
		TWO("II", ChatUtil.StringHandler.dark_cyan),
		THREE("III", ChatUtil.StringHandler.blue),
		FOUR("IV", ChatUtil.StringHandler.purple),
		FIVE("V", ChatUtil.StringHandler.red);
		
		private String text;
		private String color;
		
		TIER(String par1, String par2) {
			this.text = par1;
			this.color = par2;
		}
		
		public final String getText() {
			return this.text;
		}
		
		public final String getColor() {
			return this.color;
		}
		
	}
	
	private int atomicNumber;
	
	private String name;
	private String symbol;
	private String color;
	
	private float atomicWeight;
	
	private float temperature = 10.0F;
	
	private float boilingPoint;
	private float meltingPoint;
	private float heatOfVaporization;
	private float density;
	
	
	private Atom atom;
	
	private CATEGORY category;
	
	private TIER tier = TIER.ONE;
	private STATE defaultState;
	private STATE state;
	
	public Substance(int par, String par1, String par2, String par3, float par4, float par5, float par6, float par7, float par8, CATEGORY par9, STATE par10) {
		
		this.atomicNumber = par;
		this.name = par1;
		this.symbol = par2;
		this.color = par3;
		this.atomicWeight = par4;
		this.boilingPoint = par5;
		this.meltingPoint = par6;
		this.heatOfVaporization = par7;
		this.density = par8;
		this.category = par9;
		this.defaultState = par10;
		
		
		this.atom = new Atom(this.name, atomicNumber, ((int) Math.round(this.atomicWeight)) - this.atomicNumber, this.atomicWeight);
		
		SubstanceRegistry.addSubstance(par, this);
		ResearchRegistry.addResearch(atomicNumber, new Research(this, Minecraft.getMinecraft().thePlayer));
		SubstanceRegistry.bindSubstance(PeriodicCraft.MODID + ":item.element" + this.name, this);
		
		//if (par9.equals(STATE.SOLID) || par9.equals(STATE.GAS) || par9.equals(STATE.PLASMA)) {
			SubstanceRegistry.addItem("element" + this.name, this);
		//} else {
			// LIQUID
			// Add the liquid automatically, somehow.
		//}
		
	}
	
	

	public final Substance setTier(TIER par1) {
		this.tier = par1;
		return this;
	}
	
	public final TIER getTier() {
		return this.tier;
	}
	
	public final void setTemperature(float par1) {
		this.temperature = par1;
	}
	
	public final int getAtomicNumber() {
		return this.atomicNumber;
	}
	
	public final CATEGORY getCategory() {
		return this.category;
	}
	
	public final STATE getDefaultState() {
		return this.defaultState;
	}
	
	public final STATE getState() {
		return (((temperature >= this.meltingPoint && temperature < this.boilingPoint) ? STATE.SOLID : STATE.LIQUID));
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
	public final float getDensity() {
		return this.density;
	}
	
	public final float getHeatOfVaporization() {
		return this.heatOfVaporization;
	}
	
}
