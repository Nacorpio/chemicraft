package com.periodiccraft.pcm.helper;

import com.periodiccraft.pcm.core.element.Atom;
import com.periodiccraft.pcm.core.element.Stack;

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
	
}
