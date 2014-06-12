package com.periodiccraft.pcm.core.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.periodiccraft.pcm.PeriodicCraft;
import com.periodiccraft.pcm.PeriodicTabs;
import com.periodiccraft.pcm.core.element.Atom;
import com.periodiccraft.pcm.core.element.Element;
import com.periodiccraft.pcm.core.element.Molecule;
import com.periodiccraft.pcm.core.registry.ResearchRegistry;
import com.periodiccraft.pcm.core.registry.ResearchRegistry.Research;
import com.periodiccraft.pcm.core.registry.SubstanceRegistry;
import com.periodiccraft.pcm.helper.BiomeTeperature;
import com.periodiccraft.pcm.helper.ChatUtil;

public class PeriodicElementItem extends PeriodicItem {

	private Molecule substance;
	
	public PeriodicElementItem(String par1, Molecule substance) {
		
		super(par1);
		this.setCreativeTab(PeriodicCraft.tabPeriodic);	
		
		if (!SubstanceRegistry.isCompoundBound(this.getUnlocalizedName())) {
			SubstanceRegistry.bindCompound(this.getUnlocalizedName(), substance, 1000F);
		}
		
		this.substance = substance;

	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		
		Molecule var1 = SubstanceRegistry.getCompoundBinding(getUnlocalizedName()).getMolecule();
		if(!var1.isCompound() && var1.getFirstAtom() instanceof Element)
		{
			Element e = (Element)var1.getFirstAtom();
			if (ResearchRegistry.hasResearch(e.getAtomicNumber())) {
				Research r = ResearchRegistry.getResearch(e.getAtomicNumber()); 
				par3List.add("Research: " + ChatUtil.Colors.green + (r.isComplete() ? "Complete" : r.getProgress() + "/100"));
			}	
			
			
			par3List.add("Symbol: " + ChatUtil.Colors.green + e.getSymbol());
			par3List.add("State: " + ChatUtil.Colors.green + e.getState(BiomeTeperature.getDefaultTemperature()).getText());
			par3List.add("Tier: " + e.getTier().getColor() + e.getTier().getText());
			
			//New Findings
			
			if(ResearchRegistry.getResearch(e.getAtomicNumber()).getProgress() >= 20) {
				par3List.add("Density: " + ChatUtil.Colors.cyan + e.getDensity());
			}
			
			if(ResearchRegistry.getResearch(e.getAtomicNumber()).getProgress() == 50) {
				par3List.add("Boiling Point: " + ChatUtil.Colors.red + e.getBoilingPoint());
				par3List.add("Melting Point: " + ChatUtil.Colors.red + e.getMeltingPoint());
			}
			
			if(ResearchRegistry.getResearch(e.getAtomicNumber()).getProgress() == 50) {
				par3List.add("Boiling Point: " + ChatUtil.Colors.red + e.getBoilingPoint());
				par3List.add("Melting Point: " + ChatUtil.Colors.red + e.getMeltingPoint());
				
			if(ResearchRegistry.getResearch(e.getAtomicNumber()).getProgress() == 50) {
				par3List.add("Atomic Weight: " + ChatUtil.Colors.blue + e.getWeight());
				}
			}
		}	
	}
}


