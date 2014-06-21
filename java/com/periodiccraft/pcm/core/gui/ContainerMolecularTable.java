package com.periodiccraft.pcm.core.gui;

import com.periodiccraft.pcm.PeriodicCraft;
import com.periodiccraft.pcm.core.crafting.MolecularCraftingManager;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerMolecularTable extends Container {

	public InventoryCrafting craftMatrix;
	public IInventory craftResult;
	public World worldObj;
	public int posX;
	public int posY;
	public int posZ;
	
	
	public ContainerMolecularTable(InventoryPlayer invPlayer, World world, int z, int y, int x) {
		craftMatrix = new InventoryCrafting(this, 6, 6);
		craftResult = new InventoryCraftResult();
		worldObj = world;
		posX = x;
		posY = y;
		posZ = z;
		
		this.addSlotToContainer(new SlotCrafting(invPlayer.player, craftMatrix, craftResult, 0, 124, 35));
		
		for(int i = 0; i < 5; i++) {
			for(int k = 0; k < 5; k++) {
				this.addSlotToContainer(new Slot(craftMatrix, k + i * 5, 4 + k * 18, 3 + i * 18));
				
				
				
			}
		}
		
		for(int i = 0; i < 5; i++) {
			for(int k = 0; k < 9; k++) {
				this.addSlotToContainer(new Slot(invPlayer, k + i * 9 + 9, 8 + k * 18, 94 + i * 18));
			}
		}
		
		for(int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 148));
		}
	
		onCraftMatrixChanged(craftMatrix);
	}
	
	public void onCraftMatrixChanged(IInventory inventory) {
		//craftResult.setInventorySlotContents(0, MolecularCraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
	}
	
	
	
	
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		if(worldObj.getBlock(posX, posY, posZ) != PeriodicCraft.MolecularTable) {
			return false;		
		}else{
			return player.getDistanceSq((double)posX + 0.5D, (double)posY + 0.5D, (double)posZ + 0.5D) <= 64.0D;
		}
	}
	
    public void onContainerClosed(EntityPlayer par1EntityPlayer)
    {
        super.onContainerClosed(par1EntityPlayer);

        if (!this.worldObj.isRemote)
        {
            for (int i = 0; i < 9; ++i)
            {
                ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

                if (itemstack != null)
                {
                    par1EntityPlayer.dropPlayerItemWithRandomChoice(itemstack, false);
                }
            }
        }
    }
	
	
	
	
	
	
    public ItemStack transferStackInSlot(EntityPlayer entity, int i)
    
    {
    	
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(i);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (i == 0)
            {
                if (!this.mergeItemStack(itemstack1, 10, 46, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (i >= 10 && i < 37)
            {
                if (!this.mergeItemStack(itemstack1, 37, 46, false))
                {
                    return null;
                }
            }
            else if (i >= 37 && i < 46)
            {
                if (!this.mergeItemStack(itemstack1, 10, 37, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 10, 46, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(entity, itemstack1);
        }

        return itemstack;
    }
	

}
