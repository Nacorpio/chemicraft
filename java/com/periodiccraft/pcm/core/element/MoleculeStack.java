package com.periodiccraft.pcm.core.element;

public class MoleculeStack {
	
	private Molecule molecule;
	private float mass;
	
	public MoleculeStack(float mass, Molecule molecule) {
		this.mass = mass;
		this.molecule = molecule;
	}
	
	public void setMass(float mass) {
		this.mass = mass;
	}
	
	public float getMass() {
		return mass;
	}
	
	public Molecule getMolecule() {
		return molecule;
	}
}
