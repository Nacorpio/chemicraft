package com.periodiccraft.pcm;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

import com.periodiccraft.pcm.core.block.BlockMachine;
import com.periodiccraft.pcm.core.block.ores.OreCobalt;
import com.periodiccraft.pcm.core.block.ores.OreCopper;
import com.periodiccraft.pcm.core.block.ores.OreNickel;
import com.periodiccraft.pcm.core.block.ores.OreTitanium;
import com.periodiccraft.pcm.core.block.ores.OreZinc;
import com.periodiccraft.pcm.core.element.Substance;
import com.periodiccraft.pcm.core.guiblocks.LQClass;
import com.periodiccraft.pcm.core.guiblocks.TileEntityLQ;
import com.periodiccraft.pcm.core.registry.SubstanceRegistry;
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

    //ores
    public static Block oreTitanium;
    public static Block oreCobalt;
    public static Block oreNickel;
    public static Block oreCopper;
    public static Block oreZinc;

    public static Block blockMachine;
    
    @Instance(MODID)
	public static PeriodicCraft instance;
    public static final int guiIDLQ = 8;
    
    
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	
    	LQ_Idle = new LQClass(false).setBlockName("LQIdle").setCreativeTab(CreativeTabs.tabBlock).setHardness(3.5F);
    	LQ_Active = new LQClass(true).setBlockName("LQActive").setCreativeTab(CreativeTabs.tabBlock).setHardness(3.5F).setLightLevel(0.625F);

    	//Ores
    	oreTitanium = new OreTitanium().setBlockName("oreTitanium").setCreativeTab(CreativeTabs.tabBlock).setHardness(4.5F).setBlockTextureName(PeriodicCraft.MODID + ":oreTitanium");
    	oreCobalt = new OreCobalt().setBlockName("oreCobalt").setCreativeTab(CreativeTabs.tabBlock).setHardness(4.5F).setBlockTextureName(PeriodicCraft.MODID + ":oreCobalt");
    	oreNickel = new OreNickel().setBlockName("oreNickel").setCreativeTab(CreativeTabs.tabBlock).setHardness(4.0F).setBlockTextureName(PeriodicCraft.MODID + ":oreNickel");
    	oreCopper = new OreCopper().setBlockName("oreCopper").setCreativeTab(CreativeTabs.tabBlock).setHardness(3.5F).setBlockTextureName(PeriodicCraft.MODID + ":oreCopper");
    	oreZinc = new OreZinc().setBlockName("oreZinc").setCreativeTab(CreativeTabs.tabBlock).setHardness(3.0F).setBlockTextureName(PeriodicCraft.MODID + ":oreZinc");
    	
    	//Ores
    	GameRegistry.registerBlock(oreTitanium, oreTitanium.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(oreCobalt, oreCobalt.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(oreNickel, oreNickel.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(oreCopper, oreCopper.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(oreZinc, oreZinc.getUnlocalizedName().substring(5));
   	
    	blockMachine = new BlockMachine().setBlockName("blockMachine").setCreativeTab(CreativeTabs.tabBlock).setHardness(5.0F).setStepSound(Block.soundTypeStone);

    	GameRegistry.registerBlock(LQ_Idle, LQ_Idle.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(LQ_Active, LQ_Active.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(blockMachine, blockMachine.getUnlocalizedName().substring(5));
    
    	GameRegistry.registerTileEntity(TileEntityLQ.class, "tileLQ");
    	GameRegistry.registerTileEntity(TileBasicEnergyStorage.class, "tileBEnergyStorage");


    }
    	    	 
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
 	
    	//Substances
    	new Substance(22, "Titanium", "Ti", "Silver", 47.867F, 3287.0F, 1668.0F, 223.80F, Substance.CATEGORY.TRANSITION_METALS /* STATE -> */, Substance.STATE.SOLID);
    	new Substance(27, "Cobalt", "Co", "Metallic Gray", 58.933F, 2927.0F, 1495.0F, 198.520F, Substance.CATEGORY.TRANSITION_METALS, Substance.STATE.SOLID);
    	new Substance(28, "Nickel", "Ni", "Gray Gold" , 58.693F, 2730.0F, 1455.0F, 199.570F, Substance.CATEGORY.TRANSITION_METALS, Substance.STATE.SOLID);
    	new Substance(29, "Copper", "Cu", "Red Orangy", 63.546F, 2562.0F, 1084.62F, 158.180F, Substance.CATEGORY.TRANSITION_METALS, Substance.STATE.SOLID);
    	new Substance(30, "Zinc", "Zn", "Silvery Greyish White", 65.380F, 907.0F, 419.530F, 60.555F, Substance.CATEGORY.TRANSITION_AND_POST_TRANSISTION_METALS, Substance.STATE.SOLID);
    	
    	//Maybe Compounds?
    	
    }
    
}
 
 