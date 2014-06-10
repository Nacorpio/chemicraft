package com.periodiccraft.pcm.api.reaction;

import com.periodiccraft.pcm.core.element.Atom;
import com.periodiccraft.pcm.core.element.Stack;
import com.periodiccraft.pcm.core.element.Substance;

public class ReactionRecipe implements IReactionRecipe {

	private Stack<Atom>[] input1;
	private Stack<Atom>[] input2;
	
	private Stack<Atom>[] output;
	
	public ReactionRecipe(Stack<Atom>[] par1, Stack<Atom>[] par2, Stack<Atom>... par3) {
		this.input1 = par1;
		this.input2 = par2;
		this.output = par3;
	}
	
	@Override
	public Stack<Atom>[] getInputOne() {
		return this.input1;
	}

	
	
	@Override
	public Stack<Atom>[] getInputTwo() {
		return this.input2;
	}

	@Override
	public Stack<Atom>[] getProduct() {
		return this.output;
	}

}
