package com.periodiccraft.pcm.core.registry;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.periodiccraft.pcm.PeriodicCraft;
import com.periodiccraft.pcm.core.element.Element;
import com.periodiccraft.pcm.core.element.ICompound;
import com.periodiccraft.pcm.core.element.SubstanceStack;
import com.periodiccraft.pcm.core.item.PeriodicElementItem;
import com.periodiccraft.pcm.core.item.PeriodicItem;

import cpw.mods.fml.common.registry.GameRegistry;

public final class SubstanceRegistry {

	public static final Map<Integer, Element> substances = new HashMap<Integer, Element>();
	public static final Map<Integer, ICompound> compounds = new HashMap<Integer, ICompound>();
	
	public static final Map<String, SubstanceStack> compound_bindings = new HashMap<String, SubstanceStack>();
	
	public static final void addItem(String par1, ICompound par2, float mass) {
		if (par1.length() > 0 && !par1.isEmpty()) {
			PeriodicItem var1 = new PeriodicElementItem(par1, par2);
			bindCompound(par1, par2, mass);
		}
	}
	
	//
	public static final void bindCompound(String par1, ICompound par2, float mass) {
		compound_bindings.put(par1, new SubstanceStack(mass, par2));
	}

	public static SubstanceStack getCompoundBinding(String par1) {
		return compound_bindings.get(par1);
	}
	
	public static SubstanceStack getCompoundBinding(ItemStack par1) {
		return getCompoundBinding(par1.getUnlocalizedName());
	}
	
	public static SubstanceStack getCompoundBinding(Item par1) {
		return getCompoundBinding(par1.getUnlocalizedName());
	}
	
	public static SubstanceStack getCompoundBinding(Block par1) {
		return getCompoundBinding(par1.getUnlocalizedName());
	}
	
	public static final boolean isCompoundBound(String par1) {
		return compound_bindings.containsKey(par1);
	}
	
	//
	
	public static final void addCompound(ICompound par1) {
		addCompound(substances.size() + 1, par1);
	}
	
	public static final void addCompound(int par1, ICompound par2) {
		if (!hasCompound(par1)) {
			compounds.put(par1, par2);
		}
	}
	
	public static final ICompound getCompound(int par1) {
		return compounds.get(par1);
	}
	
	public static final ICompound getCompound(String par1) {
		for (ICompound var: compounds.values()) {
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
	
	//TODO Maybe we should do something like a multiKeyMap so we don't have to loop all the elements.
	public static final Element getSubstanceBySymbol(String par1) {
		for (Element var: getSubstances()) {
			if (var.getSymbol().equalsIgnoreCase(par1)) 
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
