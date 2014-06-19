package com.periodiccraft.pcm;

import java.awt.event.KeyAdapter;

import org.lwjgl.input.Keyboard;

import com.periodiccraft.pcm.core.element.Element;
import com.periodiccraft.pcm.core.element.IMolecule;
import com.periodiccraft.pcm.core.element.MoleculeStack;
import com.periodiccraft.pcm.core.item.PeriodicItem;
import com.periodiccraft.pcm.core.registry.SubstanceRegistry;
import com.periodiccraft.pcm.helper.ChatUtil;
import com.periodiccraft.pcm.helper.ChatUtil.Colors;
import com.periodiccraft.pcm.helper.ChemUtil;
import com.periodiccraft.pcm.research.ResearchRegistry;

import net.java.games.input.Component.Identifier.Key;
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
		MoleculeStack m = SubstanceRegistry.getCompoundBinding(event.itemStack);
		if(m == null) return;
		//TODO Possibly also apply research to the molecule's name.
		event.toolTip.add(m.getMass() + "g of");
		event.toolTip.add(Colors.italic + m.getIMolecule().getName());
		event.toolTip.add(Colors.green + "(" + m.getIMolecule().getObfuscatedFormula() + ")");
	}
	
}
