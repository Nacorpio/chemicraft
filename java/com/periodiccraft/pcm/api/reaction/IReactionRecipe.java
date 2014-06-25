package com.periodiccraft.pcm.api.reaction;

import com.periodiccraft.pcm.core.element.MoleculeStack;

public interface IReactionRecipe {

	MoleculeStack getInputOne();
	
	MoleculeStack getInputTwo();
	
	MoleculeStack[] getOutcome();
	
	
}
