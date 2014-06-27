package com.periodiccraft.pcm.core.element;

import com.periodiccraft.pcm.helper.ChatUtil;
import com.periodiccraft.pcm.research.ResearchRegistry;

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
}
