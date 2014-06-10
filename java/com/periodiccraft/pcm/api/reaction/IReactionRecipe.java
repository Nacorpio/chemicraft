package com.periodiccraft.pcm.api.reaction;

import com.periodiccraft.pcm.core.element.Atom;
import com.periodiccraft.pcm.core.element.Stack;

public interface IReactionRecipe {

	Stack<Atom>[] getInputOne();
	
	Stack<Atom>[] getInputTwo();
	
	Stack<Atom>[] getProduct();
	
}
