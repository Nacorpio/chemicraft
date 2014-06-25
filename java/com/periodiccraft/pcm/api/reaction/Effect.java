package com.periodiccraft.pcm.api.reaction;

import net.minecraft.entity.EntityLiving;


public class Effect implements IEffect {

	private String name;
	
	
	public Effect(String par1) {
		this.name = par1;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isReaction() {
		return false;
	}

	@Override
	public void onEffect(IEffect par1, IReaction par2, EntityLiving par3, float par4, int par5) {}

}
