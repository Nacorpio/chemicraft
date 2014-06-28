package com.periodiccraft.pcm;

import com.periodiccraft.pcm.core.element.SubstanceStack;
import com.periodiccraft.pcm.core.item.PeriodicItem;
import com.periodiccraft.pcm.core.registry.SubstanceRegistry;
import com.periodiccraft.pcm.helper.ChatUtil.Colors;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

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
		SubstanceStack m = SubstanceRegistry.getCompoundBinding(event.itemStack);
		if(m == null) return;
		//TODO Possibly also apply research to the molecule's name.
		event.toolTip.add(m.getMass() + "g of");
		event.toolTip.add(Colors.italic + m.getIMolecule().getName());
		event.toolTip.add(Colors.green + "(" + m.getIMolecule().getObfuscatedFormula() + ")");
	}
	
}
