package com.periodiccraft.pcm.core.element;

public class Compound {

	private Substance[] elements;
	
	private int id;
	
	private String name;
	private String formula;
	
	private float atomicWeight;
	
	public final int getCompoundId() {
		return this.id;
	}
	
	public final String getName() {
		return this.name;
	}
	
	public final String getFormula() {
		return this.formula;
	}
	
	public final boolean containsElement(String par1) {
		for (Substance var: elements) {
			if (var.getName().equalsIgnoreCase(par1)) {
				return true;
			}
		}
		return false;
	}
	
	public final float getAtomicWeight() {
		float total = 0;
		for (Substance var: elements) {
			total += var.getAtomicWeight();
		}
		return total;
	}
	
}
