package com.periodiccraft.pcm.core.element;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.periodiccraft.pcm.core.registry.SubstanceRegistry;

public class Compound {

	private Stack<Atom>[] atoms;
	
	private int id;
	
	private String name;
	private String formula;
	private String objectAssoc;
	
	public Compound(int par1, String par2, Stack<Atom>... par4) {
		
		this.id = par1;
		this.name = par2;
		this.atoms = par4;
		
		for (Stack<Atom> var: atoms) {
			formula += var.getType().getSubstance().getSymbol() + var.getCount();
		}
		
		SubstanceRegistry.addCompound(par1, this);
		
	}
	
	public final Compound setObjectAssociation(Block par1) {
		this.objectAssoc = par1.getUnlocalizedName();
		return this;
	}
	
	public final Compound setObjectAssociation(Item par1) {
		this.objectAssoc = par1.getUnlocalizedName();
		return this;
	}
	
	public final Compound setObjectAssociation(ItemStack par1) {
		this.objectAssoc = par1.getUnlocalizedName();
		return this;
	}
	
	public final Compound setObjectAssociation(String par1) {
		this.objectAssoc = par1;
		return this;
	}
	
	public final String getObjectAssociation() {
		return this.objectAssoc;
	}
	
	public final int getCompoundId() {
		return this.id;
	}
	
	public final String getName() {
		return this.name;
	}
	
	public final String getFormula() {
		return this.formula;
	}
	
	public final Stack<Atom>[] getElements() {
		return this.atoms;
	}
	
	public final boolean containsElement(String par1) {
		for (Stack<Atom> var: atoms) {
			if (var.getType().getSubstance().getName().equalsIgnoreCase(par1)) {
				return true;
			}
		}
		return false;
	}
	
	public final float getAtomicWeight() {
		float total = 0;
		for (Stack<Atom> var: atoms) {
			total += var.getType().getSubstance().getAtomicWeight();
		}
		return total;
	}
	
}
