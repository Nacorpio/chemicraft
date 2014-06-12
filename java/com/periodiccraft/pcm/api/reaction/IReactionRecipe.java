package com.periodiccraft.pcm.api.reaction;

import com.periodiccraft.pcm.core.element.IMolecule;

public interface IReactionRecipe {

	IMolecule[] getInputOne();
	
	IMolecule[] getInputTwo();
	
	IMolecule[] getProduct();
	
}
