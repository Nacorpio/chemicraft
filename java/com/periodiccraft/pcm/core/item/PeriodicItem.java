package com.periodiccraft.pcm.core.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.periodiccraft.pcm.PeriodicCraft;

import cpw.mods.fml.common.registry.GameRegistry;

public class PeriodicItem extends Item {

	public PeriodicItem(String par1) {
		
		this.setUnlocalizedName(par1);
		this.setTextureName(PeriodicCraft.MODID + ":" + this.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(this, par1);
		
	}
	
}
