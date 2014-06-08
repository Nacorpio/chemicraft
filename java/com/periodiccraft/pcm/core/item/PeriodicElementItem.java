package com.periodiccraft.pcm.core.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.periodiccraft.pcm.core.element.Substance;
import com.periodiccraft.pcm.core.registry.SubstanceRegistry;

public class PeriodicElementItem extends PeriodicItem {

	private Substance substance;
	
	public PeriodicElementItem(String par1) {
		super(par1);
		this.substance = SubstanceRegistry.getSubstanceBinding(this);
	}
	
	@Override
	public final void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if (par1ItemStack != null && par2EntityPlayer != null) {
			par3List.add(substance.getSymbol());
		}
	}

}
