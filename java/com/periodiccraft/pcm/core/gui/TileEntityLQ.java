package com.periodiccraft.pcm.core.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityLQ extends TileEntity implements IInventory {

	private ItemStack slots[];
	
	public int dualPower;
	public int dualCookTime;
	
	private String customName;
	
	public TileEntityLQ(World par1, int par2) {
		slots = new ItemStack[4];
	}
	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 4;
	}
	@Override
	public ItemStack getStackInSlot(int var1) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ItemStack decrStackSize(int var1, int var2) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setInventorySlotContents(int var1, ItemStack var2) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.customName : "container.LQ";
	}
	
	@Override
	public boolean hasCustomInventoryName() {
		return this.customName != null && this.customName.length() > 0;
		
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 0;
	}
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		if(worldObj.getTileEntity(xCoord, yCoord, zCoord) != this) {
			return false;
	}else{
		
		return player.getDistanceSq((double)xCoord, (double)yCoord, (double)zCoord) <= 64;
	}
}
		
		
		
	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		// TODO Auto-generated method stub
		return false;
	}


	}
