package com.periodiccraft.pcm.api.reaction;

import com.periodiccraft.pcm.core.element.ICompound;
import com.periodiccraft.pcm.core.element.SubstanceStack;

public class ReactionRecipe implements IReactionRecipe {

	private SubstanceStack input1;
	private SubstanceStack input2;
	
	private SubstanceStack[] output;
	
	public ReactionRecipe(SubstanceStack par1, SubstanceStack par2, SubstanceStack... par3) {
		this.input1 = par1;
		this.input2 = par2;
		this.output = par3;
	}
	
	@Override
	public SubstanceStack getInputOne() {
		return this.input1;
	}

	@Override
	public SubstanceStack getInputTwo() {
		return this.input2;
	}

	@Override
	public SubstanceStack[] getOutcome() {
		return this.output;
	}
	
	public final boolean equals(Object par1) {
		if (par1 == null) return false;
		if (par1 instanceof ReactionRecipe) {
			ReactionRecipe var1 = (ReactionRecipe) par1;
			return var1.getInputOne().equals(input1) &&
				   var1.getInputTwo().equals(input2);
		}
		return par1.equals(this);
	}
	
}
