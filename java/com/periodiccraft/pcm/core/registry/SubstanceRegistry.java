package com.periodiccraft.pcm.core.registry;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.periodiccraft.pcm.PeriodicCraft;
import com.periodiccraft.pcm.core.element.Element;
import com.periodiccraft.pcm.core.element.Molecule;
import com.periodiccraft.pcm.core.element.MoleculeStack;
import com.periodiccraft.pcm.core.item.PeriodicElementItem;
import com.periodiccraft.pcm.core.item.PeriodicItem;

import cpw.mods.fml.common.registry.GameRegistry;

public final class SubstanceRegistry {

	public static final Map<Integer, Element> substances = new HashMap<Integer, Element>();
	public static final Map<Integer, Molecule> compounds = new HashMap<Integer, Molecule>();
	
	public static final Map<String, MoleculeStack> compound_bindings = new HashMap<String, MoleculeStack>();
	
	public static final void addItem(String par1, Molecule par2, float mass) {
		if (par1.length() > 0 && !par1.isEmpty()) {
			PeriodicItem var1 = new PeriodicElementItem(par1, par2);
			bindCompound(par1, par2, mass);
		}
	}
	
	//
	public static final void bindCompound(String par1, Molecule par2, float mass) {
		compound_bindings.put(par1, new MoleculeStack(mass, par2));
	}

	public static MoleculeStack getCompoundBinding(String par1) {
		return compound_bindings.get(par1);
	}
	
	public static MoleculeStack getCompoundBinding(ItemStack par1) {
		return getCompoundBinding(par1.getUnlocalizedName());
	}
	
	public static MoleculeStack getCompoundBinding(Item par1) {
		return getCompoundBinding(par1.getUnlocalizedName());
	}
	
	public static MoleculeStack getCompoundBinding(Block par1) {
		return getCompoundBinding(par1.getUnlocalizedName());
	}
	
	public static final boolean isCompoundBound(String par1) {
		return compound_bindings.containsKey(par1);
	}
	
	//
	
	public static final void addCompound(Molecule par1) {
		addCompound(substances.size() + 1, par1);
	}
	
	public static final void addCompound(int par1, Molecule par2) {
		if (!hasCompound(par1)) {
			compounds.put(par1, par2);
		}
	}
	
	public static final Molecule getCompound(int par1) {
		return compounds.get(par1);
	}
	
	public static final Molecule getCompound(String par1) {
		for (Molecule var: compounds.values()) {
			if (var.getName().equals(par1)) {
				return var;
			}
		}
		return null;
	}
	
	public static final boolean hasCompound(int par1) {
		return compounds.containsKey(par1);
	}
	
	//
	
	public static final void addSubstance(Element par1) {
		addSubstance(substances.size() + 1, par1);
	}
	
	public static final void addSubstance(int par1, Element par2) {
		if (!hasSubstance(par1)) {
			substances.put(par1, par2);
		}
	}
	
	public static final Element getSubstance(int par1) {
		return (Element) substances.get(par1).clone();
	}
	
	public static final Element getSubstance(String par1) {
		for (Element var: getSubstances()) {
			if (var.getName().equalsIgnoreCase(par1)) 
				return (Element) var.clone();
		}
		return null;
	}
	
	//
	
	public static final int getCount() {
		return substances.size();
	}
	
	public static final boolean hasSubstance(int par1) {
		return substances.containsKey(par1);
	}
	
	public static final Collection<Element> getSubstances() {
		return substances.values();
	}
	
}
