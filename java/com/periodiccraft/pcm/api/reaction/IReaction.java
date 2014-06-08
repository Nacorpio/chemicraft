package com.periodiccraft.pcm.api.reaction;

import com.periodiccraft.pcm.core.element.SubstanceStack;

public interface IReaction {
	
	public boolean canReact(SubstanceStack[] input);
	public String getName();
	public EnumReactionType getType();
	public int getRequiredEnergyLevel();
	public int getEnergyOutcome();
	public SubstanceStack[] react();
}
