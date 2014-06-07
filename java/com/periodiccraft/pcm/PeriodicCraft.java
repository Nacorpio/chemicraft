package com.periodiccraft.pcm;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = PeriodicCraft.MODID, version = PeriodicCraft.VERSION)

public class PeriodicCraft {
	
    public static final String MODID = "pcm";
    public static final String VERSION = "0.0.1";


 
    public static Block LQ_Idle;
    public static Block LQ_Active;
    
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) 
    {
    	LQ_Idle = new LQClass(false).setBlockName("LQIdle").setCreativeTab(CreativeTabs.tabBlock).setHardness(3.5F);
    	LQ_Active = new LQClass(true).setBlockName("LQActive").setCreativeTab(CreativeTabs.tabBlock).setHardness(3.5F).setLightLevel(0.625F);
    	
    	GameRegistry.registerBlock(LQ_Idle, LQ_Idle.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(LQ_Active, LQ_Active.getUnlocalizedName().substring(5));
    }
    	    	

    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    	{
    	
    	}
    }
}
 
 