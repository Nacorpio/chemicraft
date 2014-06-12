package com.periodiccraft.pcm;

import com.periodiccraft.pcm.core.element.Element;
import com.periodiccraft.pcm.core.element.Molecule;
import com.periodiccraft.pcm.core.item.PeriodicItem;
import com.periodiccraft.pcm.core.registry.ResearchRegistry;
import com.periodiccraft.pcm.core.registry.SubstanceRegistry;
import com.periodiccraft.pcm.helper.ChatUtil;
import com.periodiccraft.pcm.helper.ChatUtil.Colors;
import com.periodiccraft.pcm.helper.ChemUtil;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class EventHandler 
{
	public static EventHandler instance;
	
	EventHandler()
	{
		MinecraftForge.EVENT_BUS.register(this);
		FMLCommonHandler.instance().bus().register(this);
	}
	
	@SubscribeEvent
	public void onItemTooltip(ItemTooltipEvent event)
	{
		if(event.itemStack.getItem() instanceof PeriodicItem) return;
		Molecule m = SubstanceRegistry.getCompoundBinding(event.itemStack).getMolecule();
		if(m == null) return;
		event.toolTip.add(Colors.green + m.getObfuscatedFormula());
	}
}
