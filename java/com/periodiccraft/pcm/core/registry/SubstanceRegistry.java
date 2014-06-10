package com.periodiccraft.pcm.core.registry;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.periodiccraft.pcm.PeriodicCraft;
import com.periodiccraft.pcm.core.element.Compound;
import com.periodiccraft.pcm.core.element.Substance;
import com.periodiccraft.pcm.core.item.PeriodicElementItem;
import com.periodiccraft.pcm.core.item.PeriodicItem;

import cpw.mods.fml.common.registry.GameRegistry;

public final class SubstanceRegistry {

	public static final Map<Integer, Substance> substances = new HashMap<Integer, Substance>();
	public static final Map<Integer, Compound> compounds = new HashMap<Integer, Compound>();
	public static final Map<String, Substance> substance_bindings = new HashMap<String, Substance>();
	
	public static final void addItem(String par1, Substance par2) {
		if (par1.length() > 0 && !par1.isEmpty()) {
			PeriodicElementItem var1 = new PeriodicElementItem(par1);
			bindSubstance(var1.getUnlocalizedName(), par2);	
		}
	}
	
	public static final void addItem(String par1, Compound par2) {
		if (par1.length() > 0 && !par1.isEmpty()) {
			PeriodicItem var1 = new PeriodicItem(par1);
			par2.setObjectAssociation(var1);
		}
	}
	
	//
	
	public static final void bindSubstance(String par1, Substance par2) {
		substance_bindings.put(par1, par2);
	}
	
	public static final Substance getSubstanceBinding(String par1) {
		return substance_bindings.get(par1);
	}
	
	public static final Substance getSubstanceBinding(ItemStack par1) {
		return getSubstanceBinding(par1.getUnlocalizedName());
	}
	
	public static final Substance getSubstanceBinding(Item par1) {
		return getSubstanceBinding(par1.getUnlocalizedName());
	}
	
	public static final Substance getSubstanceBinding(Block par1) {
		return getSubstanceBinding(par1.getUnlocalizedName());
	}
	
	public static final boolean isSubstanceBound(String par1) {
		return substance_bindings.containsKey(par1);
	}
	
	//
	
	public static final void addCompound(Compound par1) {
		addCompound(substances.size() + 1, par1);
	}
	
	public static final void addCompound(int par1, Compound par2) {
		if (!hasCompound(par1)) {
			compounds.put(par1, par2);
		}
	}
	
	public static final Compound getCompound(int par1) {
		return compounds.get(par1);
	}
	
	public static final Compound getCompound(String par1) {
		for (Compound var: compounds.values()) {
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
			if (var.getName().equalsIgnoreCase(par1)) 
				return var;
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
	
	public static final Collection<Substance> getSubstances() {
		return substances.values();
	}
	
}
