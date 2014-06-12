package com.periodiccraft.pcm.api.reaction;

import com.periodiccraft.pcm.core.element.Molecule;
import com.periodiccraft.pcm.core.element.Element;

public class ReactionRecipe implements IReactionRecipe {

	private Molecule[] input1;
	private Molecule[] input2;
	
	private Molecule[] output;
	
	public ReactionRecipe(Molecule[] par1, Molecule[] par2, Molecule... par3) {
		this.input1 = par1;
		this.input2 = par2;
		this.output = par3;
	}
	
	@Override
	public Molecule[] getInputOne() {
		return this.input1;
	}

	
	
	@Override
	public Molecule[] getInputTwo() {
		return this.input2;
	}

	@Override
	public Molecule[] getProduct() {
		return this.output;
	}

}
