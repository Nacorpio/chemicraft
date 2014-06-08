package com.periodiccraft.pcm.core.registry;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;

import com.periodiccraft.pcm.core.element.Substance;

public final class ResearchRegistry {

	public static class Research {
		
		private int progress = 0;
		private Substance substance;

		private EntityPlayer linkedPlayer;
		
		public Research(Substance par1, EntityPlayer par2) {
			this.substance = par1;
			this.linkedPlayer = par2;
		}
		
		public final void decrement(int par1) {
			if (progress - par1 >= 0) {
				progress -= par1;
			}
		}
		
		public final void decrement() {
			decrement(1);
		}
		
		public final void increment(int par1) {
			if (progress + par1 <= 100) {
				progress += par1;
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
		
		public final Substance getSubstance() {
			return this.substance;
		}
		
		public final boolean isComplete() {
			return this.progress == 100;
		}
		
	}
	
	public static final Map<Integer, Research> researches = new HashMap<Integer, Research>();
	
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
	
	public static final int getProgress(int par1) {
		return getResearch(par1).getProgress();
	}
	
	public static final boolean isComplete(int par1) {
		return getResearch(par1).isComplete();
	}
	
}
