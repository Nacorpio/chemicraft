package com.periodiccraft.pcm.core.element;

import net.minecraft.client.Minecraft;

import com.periodiccraft.pcm.PeriodicCraft;
import com.periodiccraft.pcm.core.element.Element.CATEGORY;
import com.periodiccraft.pcm.core.element.Element.STATE;
import com.periodiccraft.pcm.core.registry.ResearchRegistry;
import com.periodiccraft.pcm.core.registry.ResearchRegistry.Research;
import com.periodiccraft.pcm.core.registry.SubstanceRegistry;
import com.periodiccraft.pcm.helper.ChatUtil;

public class Element extends Atom{

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
		
		ONE("I", ChatUtil.Colors.cyan),
		TWO("II", ChatUtil.Colors.dark_cyan),
		THREE("III", ChatUtil.Colors.blue),
		FOUR("IV", ChatUtil.Colors.purple),
		FIVE("V", ChatUtil.Colors.red);
		
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
	private int color;
	
	private CATEGORY category;	
	private TIER tier = TIER.ONE;
	
	public Element(String name, int atomicNumber, String symbol, int color, CATEGORY category, int electrons, int neutrons, int protons, float boilingPoint, float meltingPoint, float heatOfVaporization, float density, float weight, STATE state) 
	{	
		super(electrons, neutrons, protons, boilingPoint, meltingPoint, heatOfVaporization, density, weight, state);
		
		this.atomicNumber = atomicNumber;
		this.name = name;
		this.symbol = symbol;
		this.color = color;
		this.category = category;


		IMolecule m = new SimpleMolecule(1, this);
		
		SubstanceRegistry.addSubstance(atomicNumber, this);
		ResearchRegistry.addResearch(atomicNumber, new Research(this, Minecraft.getMinecraft().thePlayer));
		
		//if (par9.equals(STATE.SOLID) || par9.equals(STATE.GAS) || par9.equals(STATE.PLASMA)) {
		//TODO How much of it now?	
		SubstanceRegistry.addItem("element" + this.name, m, 1000F);
		//} else {
			// LIQUID
			// Add the liquid automatically, somehow.
		//}	
	}
	
	
	@Override
	public String toString()
	{		
		return getSymbol();
	}

	public final Element setTier(TIER par1) {
		this.tier = par1;
		return this;
	}
	
	public final TIER getTier() {
		return this.tier;
	}
	
	public final int getAtomicNumber() {
		return this.atomicNumber;
	}
	
	public final CATEGORY getCategory() {
		return this.category;
	}
	
	//TODO Carbon is no Liquid.
	public final STATE getState(float temperature) {
		return (((temperature < this.meltingPoint && temperature < this.boilingPoint) ? STATE.SOLID : STATE.LIQUID));
	}
	
	public final String getName() {
		return this.name;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final int getColor() {
		return this.color;
	}

	public final float getBoilingPoint() {
		return this.boilingPoint;
	}
	
	public final float getMeltingPoint() {
		return this.meltingPoint;
	}

	public final float getDensity() {
		return this.density;
	}
	
	public final float getHeatOfVaporization() {
		return this.heatOfVaporization;
	}
	
}
