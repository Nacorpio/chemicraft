package com.periodiccraft.pcm.research;

public class Research {

	/**
	 * A unique identifier for this research.
	 */
	private int identifier;
	
	/**
	 * The category of this research.
	 */
	private String category;
	
	/**
	 *  An Integer array containing the identifiers of the researches you have to complete to complete this research.
	 */
	private int[] parents;
	
	/**
	 * An Integer array containing the identifiers of the researches that will be completed automatically when this research
	 * has been completed.
	 */
	private int[] siblings;
	
	/**
	 * A hidden research can only be discovered by exploring an element and its structure further. An example of this is looking
	 * at it in a microscope. That will give you an estimate size, and sometimes other elements.
	 */
	private boolean isHidden;
	
	/**
	 * This will automatically unlock on the start of the game for all players joining.
	 */
	private boolean isAutoUnlock;
	
	public Research(int id, String category) {
		this.identifier = id;
		this.category = category;
	}
	
	public int getIdentifier() {
		return identifier;
	}
	
	public String getCategory() {
		return category;
	}
	
	public Research setHidden() {
		isHidden = true;
		return this;
	}
	
	public Research setAutoUnlock() {
		isAutoUnlock = true;
		return this;
	}
	
	public boolean isHidden() {
		return true;
		
	}
	
	public final boolean equals(Object par1) {
		if (par1 == null) return false;
		if (par1 instanceof Research) {
			Research var1 = (Research) par1;
			return var1.getCategory().equals(this.getCategory()) &&
				   var1.getIdentifier() == identifier;
		}
		return par1.equals(this);
	}
	
}
