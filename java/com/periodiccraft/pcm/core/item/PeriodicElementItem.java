package com.periodiccraft.pcm.core.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.periodiccraft.pcm.PeriodicTabs;
import com.periodiccraft.pcm.core.element.Substance;
import com.periodiccraft.pcm.core.registry.ResearchRegistry;
import com.periodiccraft.pcm.core.registry.ResearchRegistry.Research;
import com.periodiccraft.pcm.core.registry.SubstanceRegistry;
import com.periodiccraft.pcm.helper.ChatUtil;

public class PeriodicElementItem extends PeriodicItem {

	private Substance substance;
	
	public PeriodicElementItem(String par1) {
		super(par1);
		if (!SubstanceRegistry.isSubstanceBound(this.getUnlocalizedName())) {
			SubstanceRegistry.bindSubstance(this.getUnlocalizedName(), substance);
		}
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.substance = SubstanceRegistry.getSubstanceBinding(this);
	}
	
	@Override
	public final void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		Substance var1 = SubstanceRegistry.getSubstanceBinding(getUnlocalizedName());
		if (ResearchRegistry.hasResearch(var1.getSubstanceId())) {
			Research r = ResearchRegistry.getResearch(var1.getSubstanceId()); 
			par3List.add("Research: " + ChatUtil.StringHandler.green + (r.isComplete() ? "Complete" : r.getProgress() + "/100"));
		}	
		par3List.add("Symbol: " + ChatUtil.StringHandler.green + var1.getSymbol());
		par3List.add("Tier: " + var1.getTier().getColor() + var1.getTier().getText());
	}

}
