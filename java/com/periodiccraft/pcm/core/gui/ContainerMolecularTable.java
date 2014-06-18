package com.periodiccraft.pcm.core.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.world.World;

public class ContainerMolecularTable extends Container {

	public InventoryCrafting craftInv;
	public IInventory craftResult;
	public World worldObj;
	public int posX;
	public int posY;
	public int posZ;
	
	
	public ContainerMolecularTable(InventoryPlayer invPlayer, World world, int z, int y, int x) {
		craftInv = new InventoryCrafting(this, 6, 6);
		craftResult = new InventoryCraftResult();
		worldObj = world;
		posX = x;
		posY = y;
		posZ = z;
	}
	
	
	
	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return false;
	}

}
