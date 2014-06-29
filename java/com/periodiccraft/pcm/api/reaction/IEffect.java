package com.periodiccraft.pcm.api.reaction;

import net.minecraft.entity.EntityLiving;

public interface IEffect {

	/**
	 * Returns the name of the effect.
	 * @return the name.
	 */
	String getName();
	
	/**
	 * Returns whether the effect is caused by a reaction.
	 * @return true/false.
	 */
	boolean isReaction();
	
	/**
	 * Calls what the effect does to the entity.
	 * @param par1 the effect that occurs.
	 * @param par2 the reaction that causes the effect
	 * @param par3 the entity that the effect affects.
	 * @param par4 the multiplier/strength of the effect.<br>
	 * This parameter is optional, and doesn't have to be used.
	 * @param par5 the amount of ticks to run this effect for.<br>
	 * This will be divided into seconds within the game.
	 * 
	 */
	void onEffect(IEffect par1, IReaction par2, EntityLiving par3, float par4, int par5);

	
	/***
	 * 
	 * @param potionID is what potion is used.
	 * @return
	 */
	
	int setEffect(int potionID);
	

	
}
