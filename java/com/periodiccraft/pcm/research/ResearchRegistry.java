package com.periodiccraft.pcm.research;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;

import com.periodiccraft.pcm.core.element.ICompound;
import com.periodiccraft.pcm.core.element.Element;

public final class ResearchRegistry {

	public static class Research {
		
		private boolean unlocked = false;
		
		private int progress = 0;
		private Element substance;

		private EntityPlayer linkedPlayer;
		
		public Research(Element par1, EntityPlayer par2) {
			this.substance = par1;
			this.linkedPlayer = par2;
		}
		
		public final void setUnlocked(boolean par1) {
			this.unlocked = par1;
		}
		
		public final boolean isUnlocked() {
			return this.unlocked;
		}
		
		public final void decrement(int par1) {
			if (isUnlocked()) {
				if (progress - par1 >= 0) {
					progress -= par1;
				}
			}	
		}
		
		public final void decrement() {
			decrement(1);
		}
		
		public final void increment(int par1) {
			if (isUnlocked()) {
				if (progress + par1 <= 100) {
					progress += par1;
				}

			}		
		}
		
		public final void increment() {
			increment(1);
		}
		
		public final int getProgress() {
			return this.progress;
		}
		
		public final EntityPlayer getLinkedPlayer() {
			return this.linkedPlayer;
		}
		
		public final Element getSubstance() {
			return this.substance;
		}
		
		public final boolean isComplete() {
			return this.progress == 100;
		}
		
	}
	
	public static final Map<Integer, Research> researches = new HashMap<Integer, Research>();
	
	public static final void addResearch(Element par1, Research par2) {
		addResearch(par1.getAtomicNumber(), par2);
	}
	
	public static final void addResearch(int par1, Research par2) {
		if (!hasResearch(par1)) {
			researches.put(par1, par2);
		}
	}
	
	public static final Research getResearch(int par1) {
		return researches.get(par1);
	}
	
	public static final boolean hasResearch(int par1) {
		return researches.containsKey(par1);
	}
	
	//NOTE I had a SubstanceResearchClient that contained all the Substances that were researched by the given player.
	//NOTE I'll leave it like that for now. Think of how Thaumcraft does all of it's research.
	public static boolean hasResearched(int par1, String player) 
	{
		return researches.containsKey(par1);
	}
	
	//NOTE Player bound.
	public static boolean hasResearched(ICompound IMolecule, String player)
	{
		for(Element e : IMolecule.getElements())
		{
			if(!hasResearch(e.getAtomicNumber())) return false;
		}
		return true;
	}
	
	public static final int getProgress(int par1) {
		return getResearch(par1).getProgress();
	}
	
	public static final boolean isComplete(int par1) {
		return getResearch(par1).isComplete();
	}
	
}
