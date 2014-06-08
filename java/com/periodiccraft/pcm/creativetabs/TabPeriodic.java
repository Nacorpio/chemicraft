package com.periodiccraft.pcm.creativetabs;

import com.periodiccraft.pcm.PeriodicCraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabPeriodic extends CreativeTabs {

	public TabPeriodic(int i, String string) {
		super(i, string);
	}

	@Override
	public Item getTabIconItem() {
		return PeriodicCraft.tabPeriodicIcon;
	}

}
