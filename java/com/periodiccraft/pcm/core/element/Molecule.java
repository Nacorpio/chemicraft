package com.periodiccraft.pcm.core.element;

import java.util.TreeMap;

import com.periodiccraft.pcm.helper.BiomeTemperature;
import com.periodiccraft.pcm.helper.ChatUtil;
import com.periodiccraft.pcm.research.ResearchRegistry;

public class Molecule implements ICompound{

	private Atom[] atoms;
	
	private float temperature = BiomeTemperature.getDefaultTemperature();
	private int count;
	private String name;
	private String formula = "";
	
	
	public Molecule(int count, Atom... contents) {
		this.atoms = contents;
		this.count = count;
		this.formula += count > 1 ? count : "";
		//NOTE The only case where an Atom is not an Element is when it is an Isotope or Ion. Somehow we have to compare it to the elements that were already registered to check which one. For now it's just "?"
		//TODO Add charge to the formula?
		for(Atom a : contents) {
			if(a instanceof Element) {
				formula += ((Element)a).getSymbol();
			}
			else formula += "?";
			formula += a.getAmount() > 1 ? ChatUtil.getLowerValue(a.getAmount()) : "";
		}
	}
	
	public Molecule(int count, String name, Atom... contents) {
		this(count, contents);
		this.name = name;
	}
	
	@Override
	public boolean isCompound() {
		return atoms.length > 1;
	}
	
	@Override
	public Atom getFirstAtom() {
		return atoms[0];
	}
	
	@Override
	public final Atom[] getAtoms() {
		return this.atoms;
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

		for(Atom a : atoms) {
			if(a instanceof Element && ResearchRegistry.hasResearched(((Element)a).getAtomicNumber(), null)) {
				formula += ((Element)a).getSymbol();
			}
			else formula += "?";
			formula += a.getAmount() > 1 ? ChatUtil.getLowerValue(a.getAmount()) : "";
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
}
