package com.periodiccraft.pcm.core.element;

public interface ICompound {
	
	public boolean isCompound();

	public Element getFirstElement();
	
	public Element[] getElements();
	
	public void setTemperature(float par1);
	
	public float getTemperature();
	
	public ICompound setCount(int par1);
	
	public int getCount();

	public String getFormula();
	
	public String getObfuscatedFormula();

	public boolean hasName();
	
	public String getName();
	
	public double setPHLevel(double par1);

}

