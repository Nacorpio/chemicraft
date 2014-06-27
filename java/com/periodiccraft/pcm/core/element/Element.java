package com.periodiccraft.pcm.core.element;

import net.minecraft.client.Minecraft;

import com.periodiccraft.pcm.core.registry.SubstanceRegistry;
import com.periodiccraft.pcm.helper.ChatUtil;
import com.periodiccraft.pcm.research.ResearchRegistry;
import com.periodiccraft.pcm.research.ResearchRegistry.Research;

public class Element implements Cloneable {

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
	
	protected final int baseElectrons;
	protected final int baseNeutrons;
	protected final int baseProtons;
	
	protected int electrons;
	protected int neutrons;
	protected int protons;
	
	protected float boilingPoint;
	protected float meltingPoint;
	protected float heatOfVaporization;
	protected float density;
	protected float weight;
	
	protected int amount = 1;
	
	private STATE state;
	private int pH;
	
	
	public Element(String name, int atomicNumber, String symbol, int color, CATEGORY category, int electrons, int neutrons, int protons, float boilingPoint, float meltingPoint, float heatOfVaporization, float density, float weight, STATE state) 
	{	
		this.atomicNumber = atomicNumber;
		this.name = name;
		this.symbol = symbol;
		this.color = color;
		this.category = category;

		this.baseElectrons = electrons;
		this.baseNeutrons = neutrons;
		this.baseProtons = protons;
		
		this.protons = electrons;
		this.neutrons = neutrons;
		this.protons = protons;
		
		this.boilingPoint = boilingPoint;
		this.meltingPoint = meltingPoint;
		this.heatOfVaporization = heatOfVaporization;
		this.density = density;
		
		this.weight = weight;
		this.state = state;	
		
		ICompound m = new Molecule(1, this);
		
		SubstanceRegistry.addElement(this);
		ResearchRegistry.addResearch(atomicNumber, new Research(this, Minecraft.getMinecraft().thePlayer));
		//TODO How much of it now?	
		SubstanceRegistry.addItem("element" + this.name, m, 1000F);
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
	
	public final STATE getState(float temperature) {

		//return (((temperature < this.meltingPoint && temperature < this.boilingPoint) ? (temperature < this.heatOfVaporization ? STATE.SOLID : STATE.GAS) : STATE.LIQUID));
		
		if(temperature < this.meltingPoint && temperature < this.boilingPoint) { 
			return STATE.SOLID;		
			
		}else if(temperature > this.boilingPoint && temperature < this.boilingPoint){
			return STATE.LIQUID;
			
		}else{
			return STATE.GAS;					
		}
		
		//TODO What is the default temperature? don't we have to add that to specify temperature?
		//TODO Add A System when cooked, it changes temperature, same as freezing. Maybe a machine? "Freezer" Lol.
			
		
		//return(((temperature < this.meltingPoint && temperature < this.boilingPoint) ? STATE.SOLID : STATE.LIQUID));		

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
	
	public final boolean equals(Object par1) {
		if (par1 instanceof Element) {
			Element var1 = (Element) par1;
			return var1.getNeutrons() == this.neutrons &&
				   var1.getElectrons() == this.electrons &&
				   var1.getProtons() == this.protons;
		} 
		return par1.equals(this);
	}
	
	@Override
	public int hashCode() {
		return protons * electrons * neutrons;
	}

	public Element setAmount(int amount)
	{
		this.amount = amount;
		return this;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public final boolean isPositive() {
		return protons > electrons;
	}
	
	public final boolean isNegative() {
		return electrons > protons;
	}
	
	public int getCharge() {
		return protons - electrons;
	}
	
	public void setCharge(int charge) {
		electrons = baseElectrons;
		electrons -= charge;
		if(electrons < 0) throw new IllegalArgumentException("The number of electrons has to be > 0!");
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
	
	@Override
	public Element clone() {
		try {
			return (Element)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean hasPh(boolean b) {
		if(this.state == STATE.SOLID || this.state == STATE.PLASMA) {
			return false;
		}else{
			return true;
		}
	}
	
	public int setPHLevel(int pH) {
		this.pH = pH;
		return this.pH;
	}
	
}

	

