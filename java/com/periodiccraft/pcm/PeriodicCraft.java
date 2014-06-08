package com.periodiccraft.pcm;

import com.periodiccraft.pcm.core.element.Substance;
import com.periodiccraft.pcm.core.guiblocks.LQClass;
import com.periodiccraft.pcm.core.guiblocks.TileEntityLQ;
import com.periodiccraft.pcm.core.registry.SubstanceRegistry;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = PeriodicCraft.MODID, version = PeriodicCraft.VERSION)

public class PeriodicCraft {
	
    public static final String MODID = "pcm";
    public static final String VERSION = "0.0.0.0.1";
 
    
    
    public static Block LQ_Idle;
    public static Block LQ_Active;
    
    
    @Instance(MODID)
	public static PeriodicCraft instance;
    public static final int guiIDLQ = 8;
    
    
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	
    	LQ_Idle = new LQClass(false).setBlockName("LQIdle").setCreativeTab(CreativeTabs.tabBlock).setHardness(3.5F);
    	LQ_Active = new LQClass(true).setBlockName("LQActive").setCreativeTab(CreativeTabs.tabBlock).setHardness(3.5F).setLightLevel(0.625F);
   
    	
    	GameRegistry.registerBlock(LQ_Idle, LQ_Idle.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(LQ_Active, LQ_Active.getUnlocalizedName().substring(5));
    	
    	GameRegistry.registerTileEntity(TileEntityLQ.class, "LQ");
    	
    	SubstanceRegistry.getSubstance(0).getSymbol();
    }
    	    	 
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    	new Substance(0, "Titanium", "Ti", "Silver", /* ATOMIC WEIGHT --> */ 47.867F, /* BOILING POINT --> */ 3287.0F, /* MELTING POINT --> */ 1668.0F, /* HEAT OF VAPORIZATION --> */ 223.80F, /* CATEGORY --> */ Substance.CATEGORY.TRANSITION_METALS);
    	new Substance(27, "Cobalt", "Co", "Metallic Gray", 58.933F, 2927.0F, 1495.0F, 198.520F, Substance.CATEGORY.TRANSITION_METALS);
    	new Substance(28, "Nickel", "Ni", "Gray Gold" , 58.693F, 2730.0F, 1455.0F, 199.570F, Substance.CATEGORY.TRANSITION_METALS);
    	new Substance(29, "Copper", "Cu", "Metallic Gray", 63.546F, 2562.0F, 1084.62F, 158.180F, Substance.CATEGORY.TRANSITION_METALS);
    	new Substance(30, "Zinc", "Zn", "Metallic Gray", 65.380F, 907.0F, 419.530F, 60.555F, Substance.CATEGORY.TRANSITION_AND_POST_TRANSISTION_METALS);
    	
    }
    
}
 
 