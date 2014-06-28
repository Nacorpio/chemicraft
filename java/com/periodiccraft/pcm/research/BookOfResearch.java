package com.periodiccraft.pcm.research;

import com.periodiccraft.pcm.PeriodicCraft;
import com.periodiccraft.pcm.core.gui.TileEntityLQ;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BookOfResearch extends Item {

	public BookOfResearch() {
		this.setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
	        par3EntityPlayer.displayGUIBook(par1ItemStack);
	        return par1ItemStack;
	}
	
}
