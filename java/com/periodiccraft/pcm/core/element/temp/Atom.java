package com.periodiccraft.pcm.core.element.temp;

public class Atom {

	public static enum PHASE {
		
		GAS("Gas"),
		LIQUID("Liquid"),
		SOLID("Solid"),
		PLASMA("Plasma");
		
		private String text;
		
		PHASE(String par1) {
			this.text = par1;
		}
		
		public final String getText() {
			return this.text;
		}
		
	}
	
	private int atomicNumber;
	private float atomicWeight;
	
	private float boilingPoint;
	private float meltingPoint;
	private float heatOfVaporization;
	private float density;
	
	private PHASE phase;
	
	public Atom(int par1, float par2, float par3, float par4, float par5, float par6, PHASE par7) {
		this.atomicNumber = par1;
		this.atomicWeight = par2;
		this.boilingPoint = par3;
		this.meltingPoint = par4;
		this.heatOfVaporization = par5;
		this.density = par6;
		this.phase = par7;
	}
	
	public int getAtomicNumber() {
		return atomicNumber;
	}
	
	public float getAtomicWeight() {
		return atomicWeight;
	}
	
	public float getBoilingPoint() {
		return boilingPoint;
	}
	
	public float getMeltingPoint() {
		return meltingPoint;
	}
	
	public float getHeatOfVaporization() {
		return heatOfVaporization;
	}
	
	public float getDensity() {
		return density;
	}
	
	public PHASE getPhase() {
		return phase;
	}
	
}
