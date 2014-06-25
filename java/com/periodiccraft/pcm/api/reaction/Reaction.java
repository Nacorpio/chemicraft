package com.periodiccraft.pcm.api.reaction;

import com.periodiccraft.pcm.core.element.Atom;
import com.periodiccraft.pcm.core.element.Element;
import com.periodiccraft.pcm.core.element.IMolecule;
import com.periodiccraft.pcm.core.registry.ReactionRegistry;
import com.periodiccraft.pcm.helper.ChemUtil;

public class Reaction implements IReaction {

	private IMolecule[] input1;
	private IMolecule[] input2;
	
	private EnumReactionType type;
	private Reaction deadlyReaction;
	
	public Reaction(IMolecule[] par1, IMolecule[] par2, EnumReactionType par3) {
		input1 = par1;
		input2 = par2;
		type = par3;
	}
	
	public final IMolecule[] getInput1() {
		return this.input1;
	}
	
	public final IMolecule[] getInput2() {
		return this.input2;
	}
	
	@Override
	public boolean canReact(IMolecule[] par1, IMolecule[] par2) {
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
	public IMolecule[] react() {
		if (ReactionRegistry.hasRecipe(input1, input2)) {
			ReactionRecipe var1 = ReactionRegistry.getRecipe(input1, input2);
			return var1.getOutcome();
		}
		return null;
	}

	public final String getFormula() {
		return ChemUtil.getFormula(input1) + " + " + ChemUtil.getFormula(input2);
	}


	@Override
	public boolean canOxidize(boolean canOxidize) {
		// TODO Auto-generated method stub
		return false;
	}

}
