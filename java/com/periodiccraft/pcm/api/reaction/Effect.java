package com.periodiccraft.pcm.api.reaction;

import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.Potion;


public class Effect implements IEffect {

	private String name;
	private int potionID;
	
	public Effect(String par1, int par2) {
		this.name = par1;
		this.potionID = par2;
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

}


