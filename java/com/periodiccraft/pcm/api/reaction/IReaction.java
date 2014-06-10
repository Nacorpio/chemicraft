package com.periodiccraft.pcm.api.reaction;

import com.periodiccraft.pcm.core.element.Atom;
import com.periodiccraft.pcm.core.element.Stack;
import com.periodiccraft.pcm.core.element.SubstanceStack;

public interface IReaction {
	
	public boolean canReact(Stack<Atom>[] par1, Stack<Atom>[] par2);
	public String getName();
	public EnumReactionType getType();
	public int getRequiredEnergyLevel();
	public int getEnergyOutcome();
	public Stack<Atom>[] react();
}
