package com.periodiccraft.pcm.helper;

import com.periodiccraft.pcm.core.element.Atom;
import com.periodiccraft.pcm.core.element.Molecule;
import com.periodiccraft.pcm.core.element.Element;

public final class ChemUtil {

	public static final boolean isCompound(Molecule[] par1) {
		if (par1.length == 1) {
			// Only one or more of the SAME element.
			return true;
		}
		return false;
	}
	
	public static final String getFormula(Molecule[] par1) {
		String formula = "";
		int i = 0;
		for (Molecule var: par1) {
			i++;
			formula += var.getCount() + var.getFormula() + (i < par1.length ? " + " : "");
		}
		return formula;
	}

	public static final boolean stackContains(Molecule par1, Atom par2) {
		Atom[] atoms = par1.getAtoms();
		for (int i = 0; i < atoms.length; i++) {
			if (atoms[i].equals(par2)) {
				return true;
			} 
		}
		return false;
	}
	
	public static final boolean isStackArrayEqualTo(Molecule[] par1, Molecule[] par2) {
		for (int i = 0; i < par1.length; i++) {
			if (isStackEqualTo(par1[i], par2[i])) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static final boolean isStackEqualTo(Molecule par1, Molecule par2) {
		return par1.equals(par2);
	}
	
}
