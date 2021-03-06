package com.periodiccraft.pcm.core.element;

import com.periodiccraft.pcm.helper.BiomeTemperature;
import com.periodiccraft.pcm.helper.MoleculeTree;

public class OrganicMolecule implements ICompound
{
	MoleculeTree moleculeTree;
	private float temperature = BiomeTemperature.getDefaultTemperature();
	private int count;
	private String name;
	private double pH;
	
	public OrganicMolecule(int count, String name, String... structure) 
	{
		moleculeTree = new MoleculeTree(structure);
		this.count = count;
		this.name = name;
	}

	@Override
	public boolean isCompound() {
		return true;
	}

	@Override
	public Element getFirstElement() {
		return moleculeTree.getRoot().getValue();
	}

	@Override
	public Element[] getElements() {
		return moleculeTree.getElements(moleculeTree.getRoot());
	}

	@Override
	public void setTemperature(float par1) {
		temperature = par1;
	}

	@Override
	public float getTemperature() {
		return temperature;
	}

	@Override
	public ICompound setCount(int par1) {
		this.count = par1;
		return this;
	}

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public String getFormula() {
		return moleculeTree.convertToSimpleMolecule().getFormula();
	}

	@Override
	public String getObfuscatedFormula() {
		return moleculeTree.convertToSimpleMolecule().getObfuscatedFormula();
	}

	@Override
	public boolean hasName() {
		return true;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String toString() 
	{
		return "OrganicMolecule[name=\"" + getName() + "\"" + ", structure=\"" + moleculeTree.getRoot().toString() + "\"]";
	}
	
	@Override
	public double setPHLevel(double par1) {
		return par1;
	}

}
