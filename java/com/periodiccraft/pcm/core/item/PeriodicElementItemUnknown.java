package com.periodiccraft.pcm.core.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.periodiccraft.pcm.PeriodicCraft;

public class PeriodicElementItemUnknown extends PeriodicElementItem {

	public PeriodicElementItemUnknown(String par1) {
		//TODO Meh, that won't work
		super(par1, null);
		this.setCreativeTab(PeriodicCraft.tabPeriodic);
	}

	@Override
	public String getItemStackDisplayName(ItemStack par1ItemStack) {
		return "???";
	}
	
	@Override
	public final void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {

	}
		
	
}
