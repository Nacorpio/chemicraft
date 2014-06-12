package com.periodiccraft.pcm.core.item;

import java.util.List;

import com.periodiccraft.pcm.PeriodicCraft;
import com.periodiccraft.pcm.helper.ChatUtil;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class PeriodicElementItemUnknown extends PeriodicElementItem {

	public PeriodicElementItemUnknown(String par1) {
		super(par1);
		this.setCreativeTab(PeriodicCraft.tabPeriodic);
	}

	@Override
	public final void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		
		if (par3List.size() > 0) {
			par3List.clear();
		}
		
		par3List.add(ChatUtil.Colors.gray + "???");
		par3List.add(ChatUtil.Colors.bold + "I Know Nothing About This.");
		
	}
		
	
}
