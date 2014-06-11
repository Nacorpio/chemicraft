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
	
	public Element(String name, String symbol, int color, CATEGORY category, int atomicNmbr, float atomicWght, float boilingPoint, float meltingPoint, float heatOfVap, float density, PHASE phase, TIER tier) {
		super(atomicNmbr, atomicWght, boilingPoint, meltingPoint, heatOfVap, density, phase);
		this.name = name;
		this.symbol = symbol;
		this.color = color;
		this.category = category;
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
