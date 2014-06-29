package com.periodiccraft.pcm.core.element;

import com.periodiccraft.pcm.helper.BiomeTemperature;
import com.periodiccraft.pcm.helper.ChatUtil;
import com.periodiccraft.pcm.research.ResearchRegistry;

public class Molecule implements ICompound{

	private Element[] elements;
	
	private float temperature = BiomeTemperature.getDefaultTemperature();
	private int count;
	private String name;
	private String formula = "";
	private double pH;
	
	public Molecule(int count, Element... contents) {
		this.elements = contents;
		this.count = count;
		this.formula += count > 1 ? count : "";
		//TODO Add charge to the formula?
		for(Element e : contents) {
			formula += e.getSymbol();
			formula += e.getAmount() > 1 ? ChatUtil.getLowerValue(e.getAmount()) : "";
		}
	}
	
	public Molecule(int count, String name, Element... contents) {
		this(count, contents);
		this.name = name;
	}
	


	@Override
	public boolean isCompound() {
		return elements.length > 1;
	}
	
	@Override
	public Element getFirstElement() {
		return elements[0];
	}
	
	@Override
	public final Element[] getElements() {
		return this.elements;
	}
	
	@Override
	public final void setTemperature(float par1) {
		this.temperature = par1;
	}
	
	@Override
	public final float getTemperature() {
		return this.temperature;
	}
	
	@Override
	public final ICompound setCount(int par1) {
		this.count = par1;
		return this;
	}
	
	@Override
	public final int getCount() {
		return this.count;
	}

	@Override
	public String getFormula() {
		return formula;
	}
	
	@Override
	public String getObfuscatedFormula() {
		if(ResearchRegistry.hasResearched(this, null)) return getFormula();
		
		String formula = "";
		formula += count > 1 ? count : "";

		for(Element e : elements) {
			if(ResearchRegistry.hasResearched(e.getAtomicNumber(), null)) formula += e.getSymbol();
			else formula += "?";
			formula += e.getAmount() > 1 ? ChatUtil.getLowerValue(e.getAmount()) : "";
		}
		return formula;
	}
	
	@Override
	public boolean hasName() {
		return name != null;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public double setPHLevel(double Ph) {
		this.pH = Ph;
		return this.pH;
	}
}
