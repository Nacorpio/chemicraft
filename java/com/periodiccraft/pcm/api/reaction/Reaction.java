package com.periodiccraft.pcm.api.reaction;

import com.periodiccraft.pcm.core.element.Atom;
import com.periodiccraft.pcm.core.element.Stack;
import com.periodiccraft.pcm.helper.ChemUtil;

public class Reaction implements IReaction {

	private Stack<Atom>[] input1;
	private Stack<Atom>[] input2;
	
	private Stack<Atom>[] output;
	private EnumReactionType type;
	
	public Reaction(Stack<Atom>[] par1, Stack<Atom>[] par2, Stack<Atom>[] par3, EnumReactionType par4) {
		this.input1 = par1;
		this.input2 = par2;
		this.output = par3;
		this.type = par4;
	}
	
	public final Stack<Atom>[] getInput1() {
		return this.input1;
	}
	
	public final Stack<Atom>[] getInput2() {
		return this.input2;
	}
	
	public final Stack<Atom>[] getOutput() {
		return this.output;
	}
	
	@Override
	public boolean canReact(Stack<Atom>[] par1, Stack<Atom>[] par2) {
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
	public Stack<Atom>[] react() {
		// TODO Auto-generated method stub
		return null;
	}

	public final String getFormula() {
		return ChemUtil.getFormula(input1) + " + " + ChemUtil.getFormula(input2) + " -> " + ChemUtil.getFormula(output);
	}
	
}
