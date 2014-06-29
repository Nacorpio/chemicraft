package com.periodiccraft.pcm.core.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.periodiccraft.pcm.PeriodicCraft;
import com.periodiccraft.pcm.PeriodicTabs;
import com.periodiccraft.pcm.core.element.Element;
import com.periodiccraft.pcm.core.element.ICompound;
import com.periodiccraft.pcm.core.registry.SubstanceRegistry;
import com.periodiccraft.pcm.helper.BiomeTemperature;
import com.periodiccraft.pcm.helper.ChatUtil;
import com.periodiccraft.pcm.research.ResearchRegistry;
import com.periodiccraft.pcm.research.ResearchRegistry.Research;

public class PeriodicElementItem extends PeriodicItem {

	private ICompound substance;

	

	public PeriodicElementItem(String par1, ICompound substance) {
		
		super(par1);
		this.setCreativeTab(PeriodicCraft.tabPeriodic);	
	
		if (!SubstanceRegistry.isCompoundBound(this.getUnlocalizedName())) {
			SubstanceRegistry.bindCompound(this.getUnlocalizedName(), substance, 1000F);
		}
		
		this.substance = substance;

	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		
		ICompound var1 = SubstanceRegistry.getCompoundBinding(getUnlocalizedName()).getIMolecule();
		if(!var1.isCompound())
		{
			Element e = var1.getFirstElement();
			if (ResearchRegistry.hasResearch(e.getAtomicNumber())) {
				Research r = ResearchRegistry.getResearch(e.getAtomicNumber()); 
				par3List.add("Research: " + ChatUtil.Colors.green + (r.isComplete() ? "Complete" : r.getProgress() + "/100"));
			}	
				

			
			par3List.add("Symbol: " + ChatUtil.Colors.green + e.getSymbol());
			par3List.add("State: " + ChatUtil.Colors.green + e.getState(BiomeTemperature.getDefaultTemperature()).getText());
			par3List.add("Tier: " + e.getTier().getColor() + e.getTier().getText());
			
			//New Findings
			
			if(ResearchRegistry.getResearch(e.getAtomicNumber()).getProgress() >= 20) {
				par3List.add("Density: " + ChatUtil.Colors.cyan + e.getDensity());
			}
				
			if(ResearchRegistry.getResearch(e.getAtomicNumber()).getProgress() >= 50) {
				par3List.add("Atomic Weight: " + ChatUtil.Colors.blue + e.getWeight());
			}
			
			//Ph Levels
			//Research 0 for Testing
			if(e.hasPh() == true && ResearchRegistry.getResearch(e.getPhLevel()).getProgress() == 0 && e.getPhLevel() >= 7.00) {
				par3List.add("PH: " + ChatUtil.Colors.dark_green + e.getPhLevel());
			}else if(e.hasPh() == true && ResearchRegistry.getResearch(e.getPhLevel()).getProgress() == 0 && e.getPhLevel() <= 5.00){
				par3List.add("PH: " + ChatUtil.Colors.dark_red + e.getPhLevel());
			}else{
				par3List.add("PH: " + ChatUtil.Colors.dark_blue + e.getPhLevel());
			}
			
		}	
	}
}



