package com.periodiccraft.pcm.helper;

import com.periodiccraft.pcm.core.element.Atom;
import com.periodiccraft.pcm.core.element.Stack;
import com.periodiccraft.pcm.core.element.Substance;

public final class ChemUtil {

	public static final boolean isCompound(Stack<Atom>[] par1) {
		if (par1.length == 1) {
			// Only one or more of the SAME element.
			return true;
		}
		return false;
	}
	
	public static final String getFormula(Stack<Atom>[] par1) {
		String formula = "";
		for (Stack<Atom> var: par1) {
			formula += var.getType().getSubstance().getSymbol() + var.getCount();
		}
		return formula;
	}

	public static final boolean stackContains(Stack<Atom>[] par1, Atom[] par2) {
		for (int i = 0; i < par1.length; i++) {
			if (par1[i].getType().getName().equals(par2[i].getName())) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static final boolean stackContains(Stack<Atom>[] par1, Atom par2) {
		for (Stack<Atom> var: par1) {
			if (var.getType().getName().equals(par2.getName())) {
				return true;
			}
		}
		return false;
	}
	
	public static final boolean stackContains(Stack<Atom>[] par1, Substance par2) {
		for (Stack<Atom> var: par1) {
			if (var.getType().getSubstance().getName().equals(par2.getName())) {
				return true;
			}
		}
		return false;
	}
	
	public static final boolean isStackArrayEqualTo(Stack<Atom>[] par1, Stack<Atom>[] par2) {
		for (int i = 0; i < par1.length; i++) {
			if (isStackEqualTo(par1[i], par2[i])) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static final boolean isStackEqualTo(Stack<Atom> par1, Stack<Atom> par2) {
		return (par1.getType().getName().equals(par2.getType().getName())) && par1.getCount() == par2.getCount();
	}
	
}
