package com.periodiccraft.pcm.api.reaction;

import com.periodiccraft.pcm.core.element.Molecule;

public interface IReactionRecipe {

	Molecule[] getInputOne();
	
	Molecule[] getInputTwo();
	
	Molecule[] getProduct();
	
}
