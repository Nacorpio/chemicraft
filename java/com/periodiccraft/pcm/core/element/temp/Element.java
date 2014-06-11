package com.periodiccraft.pcm.core.element.temp;

import com.periodiccraft.pcm.helper.ChatUtil;

public class Element extends Atom {

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
	
	public static enum TIER {
		
		ONE(1, "I", ChatUtil.Colors.cyan),
		TWO(2, "II", ChatUtil.Colors.dark_cyan),
		THREE(3, "III", ChatUtil.Colors.blue),
		FOUR(4, "IV", ChatUtil.Colors.purple),
		FIVE(5, "V", ChatUtil.Colors.red);
		
		private int value;
		private String text;
		private String color;
		
		TIER(int par, String par1, String par2) {
			this.value = par;
			this.text = par1;
			this.color = par2;
		}
		
		public final int getValue() {
			return this.value;
		}
		
		public final String getText() {
			return this.text;
		}
		
		public final String getColor() {
			return this.color;
		}
		
	}
	
	private String name;
	private String symbol;
	private int color = 0x000000;
	
	private CATEGORY category;
	private TIER tier = TIER.ONE;
	
	public Element(Atom par, String par1, String par2, int par3, CATEGORY par4, TIER par5) {
		this(par, par1, par2, par3, par4);
		this.tier = par5;
	}
	
	public Element(Atom par, String par1, String par2, int par3, CATEGORY par4) {
		super(par.getAtomicNumber(), par.getAtomicWeight(), par.getBoilingPoint(), par.getMeltingPoint(), par.getHeatOfVaporization(), par.getDensity(), par.getPhase());
		this.name = par1;
		this.symbol = par2;
		this.color = par3;
		this.category = par4;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public int getColor() {
		return color;
	}
	
	public CATEGORY getCategory() {
		return category;
	}
	
}
