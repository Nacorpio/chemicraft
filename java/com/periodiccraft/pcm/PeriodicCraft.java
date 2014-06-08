package com.periodiccraft.pcm;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

import com.periodiccraft.pcm.core.block.BlockMachine;
import com.periodiccraft.pcm.core.element.Substance;
import com.periodiccraft.pcm.core.guiblocks.LQClass;
import com.periodiccraft.pcm.core.guiblocks.TileEntityLQ;
import com.periodiccraft.pcm.core.tile.TileBasicEnergyStorage;

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
    
    public static Block blockMachine;
    
    @Instance(MODID)
	public static PeriodicCraft instance;
    public static final int guiIDLQ = 8;
    
    
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	
    	LQ_Idle = new LQClass(false).setBlockName("LQIdle").setCreativeTab(CreativeTabs.tabBlock).setHardness(3.5F);
    	LQ_Active = new LQClass(true).setBlockName("LQActive").setCreativeTab(CreativeTabs.tabBlock).setHardness(3.5F).setLightLevel(0.625F);
   	
    	blockMachine = new BlockMachine().setBlockName("blockMachine").setCreativeTab(CreativeTabs.tabBlock).setHardness(5.0F).setStepSound(Block.soundTypeStone);
    	
    	GameRegistry.registerBlock(LQ_Idle, LQ_Idle.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(LQ_Active, LQ_Active.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(blockMachine, blockMachine.getUnlocalizedName().substring(5));
    	
    	GameRegistry.registerTileEntity(TileEntityLQ.class, "tileLQ");
    	GameRegistry.registerTileEntity(TileBasicEnergyStorage.class, "tileBEnergyStorage");

    }
    	    	 
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    	new Substance(0, "Titanium", "Ti", "Silver", /* ATOMIC WEIGHT --> */ 47.867F, /* BOILING POINT --> */ 3287.0F, /* MELTING POINT --> */ 1668.0F, /* HEAT OF VAPORIZATION --> */ 223.80F, /* CATEGORY --> */ Substance.CATEGORY.TRANSITION_METALS);
    	
    }
    
}
 
 