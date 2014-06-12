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
}
