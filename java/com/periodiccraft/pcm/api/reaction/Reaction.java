package com.periodiccraft.pcm.api.reaction;

import net.minecraft.entity.player.EntityPlayer;

import com.periodiccraft.pcm.core.element.SubstanceStack;
import com.periodiccraft.pcm.core.registry.ReactionRegistry;
import com.periodiccraft.pcm.helper.ChemUtil;

public class Reaction implements IReaction {

	private String name;
	
	private SubstanceStack input1;
	private SubstanceStack input2;
	
	private IEffect effect;
	private EnumReactionType type;
	
	public Reaction(String par1, SubstanceStack par2, SubstanceStack par3, EnumReactionType par4) {
		name = par1;
		input1 = par2;
		input2 = par3;
		type = par4;
	}
	
	public final SubstanceStack getInput1() {
		return this.input1;
	}
	
	public final SubstanceStack getInput2() {
		return this.input2;
	}
	
	@Override
	public boolean canReact(SubstanceStack par1, SubstanceStack par2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public EnumReactionType getType() {
		return this.type;
	}

	@Override
	public int getRequiredEnergyLevel() {
		return 0;
	}

	@Override
	public int getEnergyOutcome() {
		return 0;
	}

	@Override
	public SubstanceStack[] react(EntityPlayer par1) {
		if (ReactionRegistry.hasRecipe(input1, input2)) {
			ReactionRecipe var1 = ReactionRegistry.getRecipe(input1, input2);
			return var1.getOutcome();
		}
		return null;
	}

	public final String getFormula() {
		return ChemUtil.getFormula(input1.getIMolecule()) + " + " + ChemUtil.getFormula(input2.getIMolecule());
	}


	@Override
	public boolean canOxidize(boolean canOxidize) {
		// TODO Auto-generated method stub
		return false;
	}

	public final boolean equals(Object par1) {
		if (par1 == null) return false;
		if (par1 instanceof Reaction) {
			Reaction var1 = (Reaction) par1;
			return var1.getInput1().equals(this.input1) &&
				   var1.getInput2().equals(this.input2) &&
				   var1.getEnergyOutcome() == this.getEnergyOutcome() &&
				   var1.getRequiredEnergyLevel() == this.getRequiredEnergyLevel() &&
				   var1.getFormula().equals(this.getFormula());
		}
		return par1.equals(this);
	}
	
}
