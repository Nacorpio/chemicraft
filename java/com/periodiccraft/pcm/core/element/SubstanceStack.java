package com.periodiccraft.pcm.core.element;

public class SubstanceStack {
	
	private ICompound molecule;
	private float mass;
	
	public SubstanceStack(float mass, ICompound molecule) {
		this.mass = mass;
		this.molecule = molecule;
	}
	
	public void setMass(float mass) {
		this.mass = mass;
	}
	
	public float getMass() {
		return mass;
	}
	
	public ICompound getIMolecule() {
		return molecule;
	}
	
	public final boolean equals(Object par1) {
		if (par1 == null) return false;
		if (par1 instanceof SubstanceStack) {
			SubstanceStack var1 = (SubstanceStack) par1;
			return var1.getIMolecule().getName().equals(molecule.getName()) &&
				   var1.getIMolecule().getCount() == molecule.getCount() &&
				   var1.getIMolecule().getFirstElement().equals(molecule.getFirstElement()) &&
				   var1.getIMolecule().getFormula().equals(molecule.getFormula());
		}
		return par1.equals(this);
	}
	
}
