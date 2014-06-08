package com.periodiccraft.pcm;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class PeriodicTabs {

	public static final CreativeTabs tabBlocks = new CreativeTabs("Periodic Blocks") {

		@Override
		public Item getTabIconItem() {
			// TODO Auto-generated method stub
			return null;
		}
		
	};
	
	public static final CreativeTabs tabItems = new CreativeTabs("Periodic Items") {

		@Override
		public Item getTabIconItem() {
			return Items.feather;
		}
		
	};
	
	public static final CreativeTabs tabMachines = new CreativeTabs("Periodic Machines") {

		@Override
		public Item getTabIconItem() {
			// TODO Auto-generated method stub
			return null;
		}
		
	};
	
}
