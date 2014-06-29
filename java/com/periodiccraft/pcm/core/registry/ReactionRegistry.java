package com.periodiccraft.pcm.core.registry;

import java.util.Collection;
import java.util.HashMap;

import com.periodiccraft.pcm.api.reaction.ReactionRecipe;
import com.periodiccraft.pcm.core.element.SubstanceStack;

public class ReactionRegistry {
	
	private static HashMap<String, ReactionRecipe> recipes = new HashMap<String, ReactionRecipe>();
	
	public static final void register(String par1, ReactionRecipe par2) {
		recipes.put(par1, par2);
	}
	
	public static final ReactionRecipe getRecipe(SubstanceStack par1, SubstanceStack par2) {
		for (ReactionRecipe var: getRecipes()) {
			if (var.getInputOne().equals(par1) && var.getInputTwo().equals(par2)) {
				return var;
			}
		}
		return null;
	}
	
	public static final ReactionRecipe getRecipe(String par1) {
		return recipes.get(par1);
	}
	
	public static final boolean hasRecipe(SubstanceStack par1, SubstanceStack par2) {
		for (ReactionRecipe var: getRecipes()) {
			if (var.getInputOne().equals(par1) && var.getInputTwo().equals(par2)) {
				return true;
			}
		}
		return false;
	}
	
	public static final boolean hasRecipe(String par1) {
		return recipes.containsKey(par1);
	}
	
	public static final Collection<ReactionRecipe> getRecipes() {
		return recipes.values();
	}
	
}
