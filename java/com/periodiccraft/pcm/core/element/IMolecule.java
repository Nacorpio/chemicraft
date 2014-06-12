package com.periodiccraft.pcm.core.element;

import com.periodiccraft.pcm.core.registry.ResearchRegistry;
import com.periodiccraft.pcm.helper.ChatUtil;

public interface IMolecule {
	
	public boolean isCompound();

	public Atom getFirstAtom();
	
	public Atom[] getAtoms();
	
	public void setTemperature(float par1);
	
	public float getTemperature();
	
	public IMolecule setCount(int par1);
	
	public int getCount();

	public String getFormula();
	
	public String getObfuscatedFormula();

	public boolean hasName();
	
	public String getName();
}
