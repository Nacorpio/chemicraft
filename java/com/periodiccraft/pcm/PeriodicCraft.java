package com.periodiccraft.pcm;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.periodiccraft.pcm.core.block.BlockDiskManager;
import com.periodiccraft.pcm.core.block.BlockMachine;
import com.periodiccraft.pcm.core.block.ores.OreChromium;
import com.periodiccraft.pcm.core.block.ores.OreCobalt;
import com.periodiccraft.pcm.core.block.ores.OreCopper;
import com.periodiccraft.pcm.core.block.ores.OreMangenese;
import com.periodiccraft.pcm.core.block.ores.OreNickel;
import com.periodiccraft.pcm.core.block.ores.OreTitanium;
import com.periodiccraft.pcm.core.block.ores.OreVanadium;
import com.periodiccraft.pcm.core.block.ores.OreZinc;
import com.periodiccraft.pcm.core.element.Substance;
import com.periodiccraft.pcm.core.guiblocks.LQClass;
import com.periodiccraft.pcm.core.guiblocks.TileEntityLQ;
import com.periodiccraft.pcm.core.oregens.OreGenClass;
import com.periodiccraft.pcm.core.tile.TileBasicEnergyStorage;
import com.periodiccraft.pcm.creativetabs.TabPeriodic;
import com.periodiccraft.pcm.creativetabs.TabPeriodicIcon;

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
 
    
    //Machines
    public static Block LQ_Idle;
    public static Block LQ_Active;

    //Ores
    public static Block oreTitanium;
    public static Block oreVanadium;
    public static Block oreChromium;
    public static Block oreMangenese;
    public static Block oreCobalt;
    public static Block oreNickel;
    public static Block oreCopper;
    public static Block oreZinc;

    
    //Generation
    public static OreGenClass OreGen = new OreGenClass();

    
    
    //CreativeTab(s)
    public static Item tabPeriodicIcon;
   	public static CreativeTabs tabPeriodic = new TabPeriodic(CreativeTabs.getNextID(), "tabPeriodic");
    
    //Energy?
    public static Block blockMachine;
    public static Block blockDiskManager; 
    
    //Instance
    @Instance(MODID)
	public static PeriodicCraft instance;
    public static final int guiIDLQ = 8;
    
    
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	

    	
    	//Machines
    	LQ_Idle = new LQClass(false).setBlockName("LQIdle").setCreativeTab(CreativeTabs.tabBlock).setHardness(3.5F);
    	LQ_Active = new LQClass(true).setBlockName("LQActive").setCreativeTab(CreativeTabs.tabBlock).setHardness(3.5F).setLightLevel(0.625F);
    	
    	
    	
    	//Ores
    	oreTitanium = new OreTitanium().setBlockName("oreTitanium").setCreativeTab(tabPeriodic).setHardness(5.0F).setBlockTextureName(PeriodicCraft.MODID + ":oreTitanium");
    	oreVanadium = new OreVanadium().setBlockName("oreVanadium").setCreativeTab(tabPeriodic).setHardness(4.0F).setBlockTextureName(PeriodicCraft.MODID + ":oreVanadium");
    	oreChromium = new OreChromium().setBlockName("oreChromium").setCreativeTab(tabPeriodic).setHardness(3.5F).setBlockTextureName(PeriodicCraft.MODID + ":oreChromium");
    	oreMangenese = new OreMangenese().setBlockName("oreMangenese").setCreativeTab(tabPeriodic).setHardness(4.0F).setBlockTextureName(PeriodicCraft.MODID + ":oreVanadium");
    	oreCobalt = new OreCobalt().setBlockName("oreCobalt").setCreativeTab(CreativeTabs.tabBlock).setHardness(4.5F).setBlockTextureName(PeriodicCraft.MODID + ":oreCobalt");
    	oreNickel = new OreNickel().setBlockName("oreNickel").setCreativeTab(CreativeTabs.tabBlock).setHardness(4.0F).setBlockTextureName(PeriodicCraft.MODID + ":oreNickel");
    	oreCopper = new OreCopper().setBlockName("oreCopper").setCreativeTab(CreativeTabs.tabBlock).setHardness(3.5F).setBlockTextureName(PeriodicCraft.MODID + ":oreCopper");
    	oreZinc = new OreZinc().setBlockName("oreZinc").setCreativeTab(CreativeTabs.tabBlock).setHardness(3.0F).setBlockTextureName(PeriodicCraft.MODID + ":oreZinc");
    	GameRegistry.registerBlock(oreTitanium, oreTitanium.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(oreVanadium, oreVanadium.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(oreChromium, oreChromium.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(oreMangenese, oreMangenese.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(oreCobalt, oreCobalt.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(oreNickel, oreNickel.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(oreCopper, oreCopper.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(oreZinc, oreZinc.getUnlocalizedName().substring(5));
    	
    	//Creative Tab(s)
    	tabPeriodicIcon = new TabPeriodicIcon().setUnlocalizedName("tabPeriodic");
    	GameRegistry.registerItem(tabPeriodicIcon, tabPeriodicIcon.getUnlocalizedName().substring(5));
    	
    	//Energy
    	blockMachine = new BlockMachine().setBlockName("blockMachine").setCreativeTab(CreativeTabs.tabBlock).setHardness(5.0F).setStepSound(Block.soundTypeStone);
    	blockDiskManager = new BlockDiskManager().setBlockName("blockDiskManager").setCreativeTab(CreativeTabs.tabBlock).setHardness(5.0F).setStepSound(Block.soundTypeStone);
    	
    	//Machines
    	GameRegistry.registerBlock(LQ_Idle, LQ_Idle.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(LQ_Active, LQ_Active.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(blockMachine, blockMachine.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(blockDiskManager, blockDiskManager.getUnlocalizedName().substring(5));
    	
    	//Tile Entities
    	GameRegistry.registerTileEntity(TileEntityLQ.class, "tileLQ");
    	GameRegistry.registerTileEntity(TileBasicEnergyStorage.class, "tileBEnergyStorage");

    	//Generation
    	
    	GameRegistry.registerWorldGenerator(OreGen, 0);
    	
    	
    	
    	
    }
    	    	 
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
 	
    	//Substances
    	new Substance(1, "Hydrogen", "H", "Colorless", 1.008F, -252.879F, -259.160F, 0.904F, Substance.CATEGORY.NON_METALS, Substance.STATE.GAS);
    	new Substance(2, "Helium", "He", "Colorless", 4.003F, -268.928F, -272.20F, 0.083F, Substance.CATEGORY.NOBLE_GASES, Substance.STATE.GAS);
    	new Substance(3, "Lithium", "Li", "Silvery White", 6.94F, 1330.50F, 180.50F, 136.0F, Substance.CATEGORY.ALKALI_METALS, Substance.STATE.SOLID);
    	new Substance(22, "Titanium", "Ti", "Silvery", 47.867F, 3287.0F, 1668.0F, 223.80F, Substance.CATEGORY.TRANSITION_METALS, Substance.STATE.SOLID);
    	new Substance(23, "Vanadium", "V", "Silverish", 50.942F, 3380.0F, 1890.0F, 233.794F, Substance.CATEGORY.TRANSITION_METALS, Substance.STATE.SOLID);
    	new Substance(24, "Chromium", "Cr", "Gray", 51.996F, 2670.0F, 1857.0F, 347.0F, Substance.CATEGORY.TRANSITION_METALS, Substance.STATE.SOLID);
    	new Substance(25, "Manganese", "Mn", "Silvery Gray", 54.940F, 1962.0F, 1245.0F, 221.0F, Substance.CATEGORY.TRANSITION_METALS, Substance.STATE.SOLID);   	
    	/* Iron(FE) */    	
    	new Substance(27, "Cobalt", "Co", "Metallic Gray", 58.933F, 2927.0F, 1495.0F, 198.520F, Substance.CATEGORY.TRANSITION_METALS, Substance.STATE.SOLID);
    	new Substance(28, "Nickel", "Ni", "Gray Gold" , 58.693F, 2730.0F, 1455.0F, 199.570F, Substance.CATEGORY.TRANSITION_METALS, Substance.STATE.SOLID);
    	new Substance(29, "Copper", "Cu", "Red Orangy", 63.546F, 2562.0F, 1084.62F, 158.180F, Substance.CATEGORY.TRANSITION_METALS, Substance.STATE.SOLID);
    	new Substance(30, "Zinc", "Zn", "Silvery Greyish White", 65.380F, 907.0F, 419.530F, 60.555F, Substance.CATEGORY.TRANSITION_AND_POST_TRANSISTION_METALS, Substance.STATE.SOLID);

    	
    	
    	//Maybe Compounds?
    	
    }
    
}
 
 