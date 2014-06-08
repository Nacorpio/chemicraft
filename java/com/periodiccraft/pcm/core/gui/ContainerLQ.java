package com.periodiccraft.pcm.core.gui;

import com.periodiccraft.pcm.core.guiblocks.TileEntityLQ;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class ContainerLQ extends Container {

	private TileEntityLQ LQ;
	private int dualCookTime;
	private int dualPower;
	private int lastItemBurnTime;
	
	public ContainerLQ(InventoryPlayer invPlayer, TileEntityLQ teLQ) {
		dualCookTime = 0;
		dualPower = 0;
		lastItemBurnTime = 0;
		
		LQ = teLQ;
		
		this.addSlotToContainer(new Slot(teLQ, 0, 61, 18));
		this.addSlotToContainer(new Slot(teLQ, 1, 61, 42));
		this.addSlotToContainer(new Slot(teLQ, 2, 10, 54));
		this.addSlotToContainer(new SlotLQ(invPlayer.player, teLQ, 3, 152, 35));
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
			
		}
		for(int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return LQ.isUseableByPlayer(player);
	}

}
