package com.periodiccraft.pcm.api.reaction;

import com.periodiccraft.pcm.core.element.Atom;
import com.periodiccraft.pcm.core.element.Molecule;
import com.periodiccraft.pcm.core.registry.ReactionRegistry;
import com.periodiccraft.pcm.helper.ChemUtil;

public class Reaction implements IReaction {

	private Molecule[] input1;
	private Molecule[] input2;
	
	private EnumReactionType type;
	
	public Reaction(Molecule[] par1, Molecule[] par2, EnumReactionType par3) {
		input1 = par1;
		input2 = par2;
		type = par3;
	}
	
	public final Molecule[] getInput1() {
		return this.input1;
	}
	
	public final Molecule[] getInput2() {
		return this.input2;
	}
	
	@Override
	public boolean canReact(Molecule[] par1, Molecule[] par2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnumReactionType getType() {
		return this.type;
	}

	@Override
	public int getRequiredEnergyLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEnergyOutcome() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Molecule[] react() {
		if (ReactionRegistry.hasRecipe(input1, input2)) {
			ReactionRecipe var1 = ReactionRegistry.getRecipe(input1, input2);
			return var1.getProduct();
		}
		return null;
	}

	public final String getFormula() {
		return ChemUtil.getFormula(input1) + " + " + ChemUtil.getFormula(input2);
	}
	
}
