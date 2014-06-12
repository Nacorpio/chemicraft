package com.periodiccraft.pcm;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import com.periodiccraft.pcm.core.block.ores.PeriodicOre;
import com.periodiccraft.pcm.core.element.Atom;
import com.periodiccraft.pcm.core.element.Compound;
import com.periodiccraft.pcm.core.element.Stack;
import com.periodiccraft.pcm.core.element.Substance;
import com.periodiccraft.pcm.core.fluids.BlockMercuryFluid;
import com.periodiccraft.pcm.core.guiblocks.LQClass;
import com.periodiccraft.pcm.core.guiblocks.TileEntityLQ;
import com.periodiccraft.pcm.core.item.PeriodicElementItemUnknown;
import com.periodiccraft.pcm.core.item.PeriodicItem;
import com.periodiccraft.pcm.core.oregens.OreGenClass;
import com.periodiccraft.pcm.core.registry.SubstanceRegistry;
import com.periodiccraft.pcm.creativetabs.TabPeriodic;
import com.periodiccraft.pcm.creativetabs.TabPeriodicIcon;
import com.periodiccraft.pcm.helper.WrappedGenerator;
import com.periodiccraft.pcm.helper.WrappedGenerator.Instruction;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod
	(	
	modid = PeriodicCraft.MODID,
	version = PeriodicCraft.VERSION
	)


public class PeriodicCraft {

	public static final String MODID = "pcm";
	public static final String VERSION = "0.0.0.0.1";

	// Machines
	public static Block LQ_Idle;
	public static Block LQ_Active;

	// Items
	public static Item bookOfResearch;

	// Fluids
	public Fluid mercury = new Fluid("mercury");
	
	
	// Ores
	public static PeriodicOre oreLithium;
	public static PeriodicOre oreBoron;
	public static PeriodicOre oreCarbon;
	public static PeriodicOre oreBeryllium;
	public static PeriodicOre oreTitanium;
	public static PeriodicOre oreVanadium;
	public static PeriodicOre oreChromium;
	public static PeriodicOre oreMangenese;
	public static PeriodicOre oreCobalt;
	public static PeriodicOre oreNickel;
	public static PeriodicOre oreCopper;
	public static PeriodicOre oreZinc;
	



	// Generation
	public static OreGenClass OreGen = new OreGenClass();
	public static WrappedGenerator generator;

	// CreativeTab(s)
	public static Item tabPeriodicIcon;

	// Other
	public static PeriodicElementItemUnknown unknownShard;
	public static PeriodicElementItemUnknown unknownIngot;
	
	public static CreativeTabs tabPeriodic = new TabPeriodic(
			CreativeTabs.getNextID(), "tabPeriodic");
	public static CreativeTabs tabResearch = new TabPeriodic(
			CreativeTabs.getNextID(), "tabResearch") {

		@Override
		public Item getTabIconItem() {
			return PeriodicCraft.bookOfResearch;
		}

	};

	// Liquids

	// Instance
	@Instance(MODID)
	public static PeriodicCraft instance;
	public static final int guiIDLQ = 8;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		// Okay okay that name is already taken I apologize.
		com.periodiccraft.pcm.EventHandler.instance = new com.periodiccraft.pcm.EventHandler();
		
		// Machines
		LQ_Idle = new LQClass(false).setBlockName("LQIdle")
				.setCreativeTab(CreativeTabs.tabBlock).setHardness(3.5F);
		LQ_Active = new LQClass(true).setBlockName("LQActive")
				.setCreativeTab(CreativeTabs.tabBlock).setHardness(3.5F)
				.setLightLevel(0.625F);

		// Ores
		oreTitanium = new PeriodicOre("oreTitanium", 5.0F);
		oreVanadium = new PeriodicOre("oreVanadium", 4.0F);
		oreChromium = new PeriodicOre("oreChromium", 3.5F);
		oreMangenese = new PeriodicOre("oreMangenese", 4.0F);
		oreCobalt = new PeriodicOre("oreCobalt", 4.5F);
		oreNickel = new PeriodicOre("oreNickel", 4.0F);
		oreCopper = new PeriodicOre("oreCopper", 3.5F);
		oreZinc = new PeriodicOre("oreZinc", 3.0F);
		oreLithium = new PeriodicOre("oreLithium", 4.0F);
		oreBoron = new PeriodicOre("oreBoron", 3.5F);
		oreCarbon = new PeriodicOre("oreCarbon", 4.5F);
		oreBeryllium = new PeriodicOre("Beryllium", 3.5F);

		
		
		
		// Items
		bookOfResearch = new PeriodicItem("bookOfResearch")
				.setCreativeTab(tabResearch);
		
		unknownShard = new PeriodicElementItemUnknown("unknownShard");
		unknownIngot = new PeriodicElementItemUnknown("unknownIngot");

		// Creative Tab(s)
		tabPeriodicIcon = new TabPeriodicIcon()
				.setUnlocalizedName("tabPeriodic");
		GameRegistry.registerItem(tabPeriodicIcon, tabPeriodicIcon
				.getUnlocalizedName().substring(5));

		// Fluids

		
			
		
		// Machines
		GameRegistry.registerBlock(LQ_Idle, LQ_Idle.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerBlock(LQ_Active, LQ_Active.getUnlocalizedName()
				.substring(5));

		// Tile Entities
		GameRegistry.registerTileEntity(TileEntityLQ.class, "tileLQ");

		// Generation
		{
			generator = new WrappedGenerator(
					0,
					// new Instruction(block, max_height, blocks_per_vein,
					// veins_per_chunk)
					new Instruction(oreLithium, 64, 5, 7).setOverworld(true),
					new Instruction(oreBoron, 64, 5, 7).setOverworld(true),
					new Instruction(oreCarbon, 64, 5, 7).setOverworld(true),
					new Instruction(oreBeryllium, 64, 5, 7).setOverworld(true),
					new Instruction(oreTitanium, 64, 5, 7).setOverworld(true),
					new Instruction(oreVanadium, 64, 5, 7).setOverworld(true),
					new Instruction(oreChromium, 64, 5, 7).setOverworld(true),
					new Instruction(oreMangenese, 64, 5, 7).setOverworld(true),
					new Instruction(oreCobalt, 64, 5, 7).setOverworld(true),
					new Instruction(oreNickel, 64, 5, 7).setOverworld(true),
					new Instruction(oreCopper, 64, 5, 7).setOverworld(true),
					new Instruction(oreZinc, 64, 5, 7).setOverworld(true));
		}

		// GameRegistry.registerWorldGenerator(OreGen, 0);

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

		// Substances

		new Substance(1, "Hydrogen", "H", "Colorless", 1.008F, -252.879F,
				-259.160F, 0.904F, 0.08988F, Substance.CATEGORY.NON_METALS,
				Substance.STATE.GAS);
		new Substance(2, "Helium", "He", "Colorless", 4.003F, -268.928F,
				-272.20F, 0.083F, 0.1786F, Substance.CATEGORY.NOBLE_GASES,
				Substance.STATE.GAS);
		new Substance(3, "Lithium", "Li", "Silvery White", 6.94F, 1330.50F,
				180.50F, 136.0F, 0.534F, Substance.CATEGORY.ALKALI_METALS,
				Substance.STATE.SOLID);
		new Substance(4, "Beryllium", "Be", "White Gray", 9.0120F, 2970.0F,
				1287.0F, 292.0F, 1.85F,
				Substance.CATEGORY.ALKALINE_EARTH_METALS, Substance.STATE.SOLID);
		new Substance(5, "Boron", "B", "Black Brown", 10.81F, 3927.0F, 2076.0F,
				508.0F, 2.08F, Substance.CATEGORY.METALOID,
				Substance.STATE.SOLID);
		new Substance(6, "Carbon", "C", "Black", 12.011F, 4827.0F, 3550.0F,
				117.0F, 2.00F, Substance.CATEGORY.NON_METALS,
				Substance.STATE.SOLID);
		new Substance(7, "Nitrogen", "Ni", "Colorless", 14.007F, -195.795F,
				210.0F, 5.56F, 1.251F, Substance.CATEGORY.NON_METALS,
				Substance.STATE.GAS);
		new Substance(8, "Oxygen", "O", "Colorless", 15.999F, -182.962F,
				-218.79F, 6.82F, 1.429F, Substance.CATEGORY.NON_METALS,
				Substance.STATE.GAS);
		new Substance(9, "Fluorine", "F", "Bright Yellow", 18.998F, -188.11F,
				-219.67F, 6.51F, 1.696F, Substance.CATEGORY.NON_METALS,
				Substance.STATE.GAS);
		new Substance(10, "Neon", "Ne", "Colorless", 20.180F, -246.046F,
				-248.59F, 1.71F, 0.9002F, Substance.CATEGORY.NOBLE_GASES,
				Substance.STATE.GAS);
		new Substance(11, "Sodium", "Na", "Silvery White Metallic", 22.989F,
				882.940F, 97.794F, 97.42F, 0.968F,
				Substance.CATEGORY.ALKALI_METALS, Substance.STATE.SOLID);
		new Substance(12, "Magnesium", "Mg", "Shiny Gray", 24.305F, 1091F,
				650F, 128.0F, 1.738F, Substance.CATEGORY.ALKALINE_EARTH_METALS,
				Substance.STATE.SOLID);
		
		//---
		
		new Substance(14, "Silicon", "Si", "Shiny Gray", 28.085F, 3265.0F,
				1414.0F, 383.0F, 2.329F, Substance.CATEGORY.METALOID,
				Substance.STATE.SOLID);

		new Substance(18, "Argon", "Ar", "Colorless", 39.948F, -185.34F,
				-189.34F, 6.53F, 1.784F, Substance.CATEGORY.NOBLE_GASES,
				Substance.STATE.GAS);
		new Substance(22, "Titanium", "Ti", "Silvery", 47.867F, 3287.0F,
				1668.0F, 223.80F, 4.506F, Substance.CATEGORY.TRANSITION_METALS,
				Substance.STATE.SOLID);
		new Substance(23, "Vanadium", "V", "Silverish", 50.942F, 3380.0F,
				1890.0F, 233.794F, 6.0F, Substance.CATEGORY.TRANSITION_METALS,
				Substance.STATE.SOLID);
		new Substance(24, "Chromium", "Cr", "Gray", 51.996F, 2670.0F, 1857.0F,
				347.0F, 7.19F, Substance.CATEGORY.TRANSITION_METALS,
				Substance.STATE.SOLID);
		new Substance(25, "Manganese", "Mn", "Silvery Gray", 54.940F, 1962.0F,
				1245.0F, 221.0F, 7.21F, Substance.CATEGORY.TRANSITION_METALS,
				Substance.STATE.SOLID);
		
		
		/*
		 *  Iron(FE) 
		 * 
		 */
		new Substance(27, "Cobalt", "Co", "Metallic Gray", 58.933F, 2927.0F,
				1495.0F, 198.520F, 8.90F, Substance.CATEGORY.TRANSITION_METALS,
				Substance.STATE.SOLID);
		new Substance(28, "Nickel", "Ni", "Gray Gold", 58.693F, 2730.0F,
				1455.0F, 199.570F, 8.908F, Substance.CATEGORY.TRANSITION_METALS,
				Substance.STATE.SOLID);
		new Substance(29, "Copper", "Cu", "Red Orangy", 63.546F, 2562.0F,
				1084.62F, 158.180F, 8.96F ,Substance.CATEGORY.TRANSITION_METALS,
				Substance.STATE.SOLID);
		new Substance(30, "Zinc", "Zn", "Silvery Greyish White", 65.380F,
				907.0F, 419.530F, 60.555F, 7.14F,
				Substance.CATEGORY.TRANSITION_AND_POST_TRANSISTION_METALS,
				Substance.STATE.SOLID);
		new Substance(80, "Mercury", "Hg", "Gray", 13.534F, 200.592F, 356.73F,
				-38.8290F, 59.11F, Substance.CATEGORY.TRANSITION_METALS,
				Substance.STATE.LIQUID);

		//Compounds
		
		Compound quartz = new Compound(1, "Quartz", new Stack<Atom>(SubstanceRegistry.getSubstance("Silicon").getAtom(), 1), new Stack<Atom>(SubstanceRegistry.getSubstance("Oxygen").getAtom(), 2));
		SubstanceRegistry.bindCompound(Items.quartz.getUnlocalizedName(), quartz);
		Compound diamond = new Compound(2, "Diamond", new Stack<Atom>(SubstanceRegistry.getSubstance("Carbon").getAtom(), 8));
		SubstanceRegistry.bindCompound(Items.diamond.getUnlocalizedName(), diamond);
		
		//Dungeon Spawns?
	    WeightedRandomChestContent[] field_111189_a = new WeightedRandomChestContent[] {new WeightedRandomChestContent(unknownShard, 0, 5, 10, 10)};

	}

}
