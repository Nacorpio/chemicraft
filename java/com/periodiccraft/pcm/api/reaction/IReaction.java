package com.periodiccraft.pcm.api.reaction;

import com.periodiccraft.pcm.core.element.IMolecule;

public interface IReaction {
	
	public boolean canReact(IMolecule[] par1, IMolecule[] par2);
	public String getName();
	public boolean canOxidize(boolean canOxidize);
	public EnumReactionType getType();
	public int getRequiredEnergyLevel();
	public int getEnergyOutcome();
	public IMolecule[] react();
}
