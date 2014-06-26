package com.periodiccraft.pcm.api.reaction;

import net.minecraft.entity.player.EntityPlayer;

import com.periodiccraft.pcm.core.element.SubstanceStack;

public interface IReaction {
	
	public boolean canReact(SubstanceStack par1, SubstanceStack par2);
	public String getName();
	public boolean canOxidize(boolean canOxidize);
	public EnumReactionType getType();
	public int getRequiredEnergyLevel();
	public int getEnergyOutcome();
	public SubstanceStack[] react(EntityPlayer par1);
	
}
