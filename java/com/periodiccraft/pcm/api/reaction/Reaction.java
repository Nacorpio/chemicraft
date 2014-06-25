package com.periodiccraft.pcm.api.reaction;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;

import com.periodiccraft.pcm.core.element.MoleculeStack;
import com.periodiccraft.pcm.core.registry.ReactionRegistry;
import com.periodiccraft.pcm.helper.ChemUtil;

public class Reaction implements IReaction {

	private MoleculeStack input1;
	private MoleculeStack input2;
	
	private IEffect effect;
	private EnumReactionType type;
	
	public Reaction(MoleculeStack par1, MoleculeStack par2, EnumReactionType par3) {
		input1 = par1;
		input2 = par2;
		type = par3;
	}
	
	public final MoleculeStack getInput1() {
		return this.input1;
	}
	
	public final MoleculeStack getInput2() {
		return this.input2;
	}
	
	@Override
	public boolean canReact(MoleculeStack par1, MoleculeStack par2) {
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
	public MoleculeStack[] react(EntityPlayer par1) {
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

}
