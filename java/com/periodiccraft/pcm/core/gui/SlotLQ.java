package com.periodiccraft.pcm.core.gui;

import com.periodiccraft.pcm.core.guiblocks.TileEntityLQ;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class SlotLQ extends Slot {

	public SlotLQ(EntityPlayer player, IInventory iiInventory, int i, int j, int k) {
		super(iiInventory, i, j, k);
	}


}