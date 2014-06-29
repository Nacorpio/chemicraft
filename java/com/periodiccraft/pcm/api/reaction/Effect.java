package com.periodiccraft.pcm.api.reaction;

import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.Potion;


public class Effect implements IEffect {

	protected String name;
	protected IReaction reaction;
	protected Potion potionID;
	
	public Effect(String par1, IReaction par2, Potion par3) {
		this.name = par1;
		this.reaction = par2;
		this.potionID = par3;
	}
	
	@Override
	public String getName() {
		return name;
		
	}
	
	public int setEffect(int potionID) {
		return potionID;
	}																																			
	

	@Override
	public boolean isReaction() {
		return false;
	}

	@Override
	public void onEffect(IEffect par1, IReaction par2, EntityLiving par3, float par4, int par5) {}

	public final boolean equals(Object par1) {
		if (par1 == null) return false;
		if (par1 instanceof Effect) {
			Effect var1 = (Effect) par1;
			return var1.getName().equals(name);
		}
		return par1.equals(this);
	}
	
}


