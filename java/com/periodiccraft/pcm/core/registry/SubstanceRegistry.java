package com.periodiccraft.pcm.core.registry;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.periodiccraft.pcm.core.element.Substance;

public final class SubstanceRegistry {

	public static final Map<Integer, Substance> substances = new HashMap<Integer, Substance>();
	
	public static final void addSubstance(Substance par1) {
		addSubstance(substances.size() + 1, par1);
	}
	
	public static final void addSubstance(int par1, Substance par2) {
		if (!hasSubstance(par1)) {
			substances.put(par1, par2);
		}
	}
	
	public static final Substance getSubstance(int par1) {
		return substances.get(par1);
	}
	
	public static final Substance getSubstance(String par1) {
		for (Substance var: getSubstances()) {
			if (var.getSymbol().equalsIgnoreCase(par1)) 
				return var;
		}
		return null;
	}
	
	public static final int getCount() {
		return substances.size();
	}
	
	public static final boolean hasSubstance(int par1) {
		return substances.containsKey(par1);
	}
	
	public static final Collection<Substance> getSubstances() {
		return substances.values();
	}
	
}
