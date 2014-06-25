package com.periodiccraft.pcm.core.element;

public class MoleculeStack {
	
	private IMolecule molecule;
	private float mass;
	
	public MoleculeStack(float mass, IMolecule molecule) {
		this.mass = mass;
		this.molecule = molecule;
	}
	
	public void setMass(float mass) {
		this.mass = mass;
	}
	
	public float getMass() {
		return mass;
	}
	
	public IMolecule getIMolecule() {
		return molecule;
	}
	
	public final boolean equals(Object par1) {
		if (par1 == null) return false;
		if (par1 instanceof MoleculeStack) {
			MoleculeStack var1 = (MoleculeStack) par1;
			return var1.getIMolecule().getName().equals(molecule.getName()) &&
				   var1.getIMolecule().getCount() == molecule.getCount() &&
				   var1.getIMolecule().getFirstAtom().equals(molecule.getFirstAtom()) &&
				   var1.getIMolecule().getFormula().equals(molecule.getFormula());
		}
		return par1.equals(this);
	}
	
}
