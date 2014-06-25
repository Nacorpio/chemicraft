package com.periodiccraft.pcm.api.reaction;

import com.periodiccraft.pcm.core.element.IMolecule;
import com.periodiccraft.pcm.core.element.MoleculeStack;

public class ReactionRecipe implements IReactionRecipe {

	private MoleculeStack input1;
	private MoleculeStack input2;
	
	private MoleculeStack[] output;
	
	public ReactionRecipe(MoleculeStack par1, MoleculeStack par2, MoleculeStack... par3) {
		this.input1 = par1;
		this.input2 = par2;
		this.output = par3;
	}
	
	@Override
	public MoleculeStack getInputOne() {
		return this.input1;
	}

	@Override
	public MoleculeStack getInputTwo() {
		return this.input2;
	}

	@Override
	public MoleculeStack[] getOutcome() {
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
