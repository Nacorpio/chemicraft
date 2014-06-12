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
	
	private int protons;
	private int neutrons;
	private int electrons;
	
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
	
	public boolean isPositive() {
		return protons > electrons;
	}
	
	public boolean isNegative() {
		return electrons > protons;
	}
	
	//
	
	protected void setAtomicNumber(int par1) {
		this.atomicNumber = par1;
	}
	
	public int getAtomicNumber() {
		return atomicNumber;
	}
	
	protected void setAtomicWeight(float par1) {
		this.atomicWeight = par1;
	}
	
	public float getAtomicWeight() {
		return atomicWeight;
	}
	
	protected void setBoilingPoint(float par1) {
		this.boilingPoint = par1;
	}
	
	public float getBoilingPoint() {
		return boilingPoint;
	}
	
	protected void setMeltingPoint(float par1) {
		this.meltingPoint = par1;
	}
	
	public float getMeltingPoint() {
		return meltingPoint;
	}
	
	protected void setHeatOfVaporization(float par1) {
		this.heatOfVaporization = par1;
	}
	
	public float getHeatOfVaporization() {
		return heatOfVaporization;
	}
	
	protected void setDensity(float par1) {
		this.density = par1;
	}
	
	public float getDensity() {
		return density;
	}
	
	protected void setPhase(PHASE par1) {
		this.phase = par1;
	}
	
	public PHASE getPhase() {
		return phase;
	}
	
}
