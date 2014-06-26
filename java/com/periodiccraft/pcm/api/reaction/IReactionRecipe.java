package com.periodiccraft.pcm.api.reaction;

import com.periodiccraft.pcm.core.element.SubstanceStack;

public interface IReactionRecipe {

	SubstanceStack getInputOne();
	
	SubstanceStack getInputTwo();
	
	SubstanceStack[] getOutcome();
	
	
}
