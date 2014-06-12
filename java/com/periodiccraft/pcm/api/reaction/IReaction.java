package com.periodiccraft.pcm.api.reaction;

import com.periodiccraft.pcm.core.element.Molecule;

public interface IReaction {
	
	public boolean canReact(Molecule[] par1, Molecule[] par2);
	public String getName();
	public EnumReactionType getType();
	public int getRequiredEnergyLevel();
	public int getEnergyOutcome();
	public Molecule[] react();
}
