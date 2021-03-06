package com.periodiccraft.pcm.core.registry;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.periodiccraft.pcm.util.MultiKeyHashMap;
import com.periodiccraft.pcm.util.MultiKeyMap;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.periodiccraft.pcm.core.element.Element;
import com.periodiccraft.pcm.core.element.ElementWrapper;
import com.periodiccraft.pcm.core.element.ICompound;
import com.periodiccraft.pcm.core.element.SubstanceStack;
import com.periodiccraft.pcm.core.item.PeriodicElementItem;
import com.periodiccraft.pcm.core.item.PeriodicItem;

public final class SubstanceRegistry {

	public static final MultiKeyMap<Integer, String, ElementWrapper> substances = new MultiKeyHashMap<Integer, String, ElementWrapper>();
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
	
	public static final void addElement(Element par1) {
		if (!hasSubstance(par1.getAtomicNumber())) {
			substances.put(par1.getAtomicNumber(), par1.getSymbol(), new ElementWrapper(par1));
		}
	}
	
	public static void addIsotope(Element base, Element par2) {
		if(hasSubstance(base.getAtomicNumber())) {
			substances.getByKey1(base.getAtomicNumber()).addIsotope(par2);
		}
		else throw new IllegalStateException("You have to register the base element first before you can add isotopes!");
	}
	
	public static List<Element> getIsotopes(Element e) {
		return substances.getByKey1(e.getAtomicNumber()).getIsotopes();
	}
	
	public static final Element getElement(int par1) {
		return substances.getByKey1(par1).getBaseElement().clone();
	}

	public static final Element getElement(String par1) {
		for (ElementWrapper var : getElements()) {
			if (var.getBaseElement().getName().equalsIgnoreCase(par1))
				return var.getBaseElement().clone();
		}
		return null;
	}
	
	public static final Element getElementBySymbol(String par1) {
		return substances.getByKey2(par1).getBaseElement().clone();
	}
	
	public static final int getCount() {
		return substances.size();
	}
	
	public static final boolean hasSubstance(int par1) {
		return substances.containsKey1(par1);
	}
	
	public static final Collection<ElementWrapper> getElements() {
		return substances.values();
	}
	
}
