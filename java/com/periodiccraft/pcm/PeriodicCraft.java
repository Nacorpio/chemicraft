// TODO Please use NOTES
// NOTE Way too much NOTES in here... And comments.
//Put TODO and Notifications Here.

/*
* 
* NOTE Setting all Colorless Material to White for now.
* 
* TODO Redo the Substances.
* TODO Redo the Compounds.
* NOTE that every Compound(IMolecule) is 1kg. TODO maybe we should describe that when we are initializing it?
* TODO Figure out which dungeon spawn works
*/
		

package com.periodiccraft.pcm;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.fluids.Fluid;

import com.periodiccraft.pcm.core.block.ores.PeriodicOre;
import com.periodiccraft.pcm.core.element.Element;
import com.periodiccraft.pcm.core.element.IMolecule;
import com.periodiccraft.pcm.core.element.OrganicMolecule;
import com.periodiccraft.pcm.core.element.SimpleMolecule;
import com.periodiccraft.pcm.core.guiblocks.LQClass;
import com.periodiccraft.pcm.core.guiblocks.TileEntityLQ;
import com.periodiccraft.pcm.core.item.PeriodicElementItemUnknown;
import com.periodiccraft.pcm.core.item.PeriodicItem;
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

@Mod(modid = PeriodicCraft.MODID, version = PeriodicCraft.VERSION)
public class PeriodicCraft {

	public static final String MODID = "pcm";
	public static final String VERSION = "0.0.0.0.1";
	//Just a Commit Test..............

	// Machines and Stuff
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
	public static PeriodicOre oreManganese;
	public static PeriodicOre oreCobalt;
	public static PeriodicOre oreNickel;
	public static PeriodicOre oreCopper;
	public static PeriodicOre oreZinc;

	// Generation
	public static WrappedGenerator generator;

	// CreativeTab(s)
	public static Item tabPeriodicIcon;

	// Other
	public static PeriodicElementItemUnknown unknownShard;
	public static PeriodicElementItemUnknown unknownIngot;
	public static PeriodicElementItemUnknown unknownGas;

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
		oreManganese = new PeriodicOre("oreManganese", 4.0F);
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

		// Unknown items
		unknownShard = new PeriodicElementItemUnknown("unknownShard");
		unknownIngot = new PeriodicElementItemUnknown("unknownIngot");
		unknownGas = new PeriodicElementItemUnknown("unknownGas");

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
			generator = new WrappedGenerator(0,
					// new Instruction(block, max_height, blocks_per_vein, veins_per_chunk)
					
					new Instruction(oreLithium, 64, 5, 7).setOverworld(true),
					new Instruction(oreBoron, 64, 5, 7).setOverworld(true),
					new Instruction(oreCarbon, 64, 5, 7).setOverworld(true),
					new Instruction(oreBeryllium, 64, 5, 7).setOverworld(true),
					new Instruction(oreTitanium, 64, 5, 7).setOverworld(true),
					new Instruction(oreVanadium, 64, 5, 7).setOverworld(true),
					new Instruction(oreChromium, 64, 5, 7).setOverworld(true),
					new Instruction(oreManganese, 64, 5, 7).setOverworld(true),
					new Instruction(oreCobalt, 64, 5, 7).setOverworld(true),
					new Instruction(oreNickel, 64, 5, 7).setOverworld(true),
					new Instruction(oreCopper, 64, 5, 7).setOverworld(true),
					new Instruction(oreZinc, 64, 5, 7).setOverworld(true));
		}

		

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

		// Substances

		new Element("Hydrogen", 1, "H", 0xFFFFFF, Element.CATEGORY.NON_METALS,
				1, 0, 1, 1.008F, -252.879F, -259.160F, 0.904F, 0.08988F,
				Element.STATE.GAS);

		new Element("Helium", 2, "He", 0xFFFFFF, Element.CATEGORY.NOBLE_GASES,
				2, 2, 2, -268.928F, -272.20F, 0.083F, 0.1786F, 4.003F,
				Element.STATE.GAS);

		new Element("Lithium", 3, "Li", 0xCCCCCC,
				Element.CATEGORY.ALKALI_METALS, 3, 4, 3, 1330.50F, 180.50F,
				136.0F, 0.534F, 6.94F, Element.STATE.SOLID);

		new Element("Beryllium", 4, "Be", 0xCCCCCC,
				Element.CATEGORY.ALKALINE_EARTH_METALS, 4, 5, 4, 2970.0F,
				1287.0F, 292.0F, 1.85F, 9.012F, Element.STATE.SOLID);

		new Element("Boron", 5, "B", 0x383838, Element.CATEGORY.METALOID, 5, 6, 5, 3927.0F, 2076.0F,
				508.0F, 2.08F, 10.81F, Element.STATE.SOLID);

		new Element("Carbon", 6, "C", 0x000000, Element.CATEGORY.NON_METALS, 6,
				6, 6, 4827.0F, 3550.0F, 117.0F, 2.00F, 12.011F,
				Element.STATE.SOLID);
		
		new Element("Nitrogen", 7, "N", 0xFFFFFF, Element.CATEGORY.NON_METALS,
				7, 7, 7, -195.795F, -209.0F, 5.560F, 14.007F, 1.2510F,
				Element.STATE.GAS);

		new Element("Oxygen", 8, "O", 0xFFFFFF, Element.CATEGORY.NON_METALS, 8,
				8, 8, -182.962F, -218.79F, 6.82F, 1.429F, 15.999F,
				Element.STATE.GAS);

		new Element("Fluorine", 9, "F", 0xCCFF00, Element.CATEGORY.HALOGENS,
				10, 9, 5, -188.11F, -219.67F, 6.51F, 1.696F, 18.998F,
				Element.STATE.GAS);

		new Element("Neon", 10, "Ne", 0xFFFFFF, Element.CATEGORY.NOBLE_GASES,
				7, 7, 7, -246.046F, -248.59F, 1.71F, 0.9002F, 20.180F,
				Element.STATE.GAS);

		new Element("Sodium", 11, "Na", 0xCCCCCC,
				Element.CATEGORY.ALKALI_METALS, 11, 12, 11, 882.940F, 97.794F,
				97.42F, 0.968F, 22.989F, Element.STATE.SOLID);

		new Element("Magnesium", 12, "Mg", 0xCCCCCC,
				Element.CATEGORY.ALKALINE_EARTH_METALS, 12, 12, 12, 1091F,
				650F, 128.0F, 1.738F, 24.305F, Element.STATE.SOLID);

		

		
		/*
		 * 
		 * //---
		 * 
		 * new Element(14, "Silicon", "Si", "Shiny Gray", 28.085F, 3265.0F,
		 * 1414.0F, 383.0F, 2.329F, Element.CATEGORY.METALOID,
		 * Element.STATE.SOLID);
		 * 
		 * new Substance(18, "Argon", "Ar", "Colorless", 39.948F, -185.34F,
		 * -189.34F, 6.53F, 1.784F, Substance.CATEGORY.NOBLE_GASES,
		 * Substance.STATE.GAS); new Substance(22, "Titanium", "Ti", "Silvery",
		 * 47.867F, 3287.0F, 1668.0F, 223.80F, 4.506F,
		 * Substance.CATEGORY.TRANSITION_METALS, Substance.STATE.SOLID); new
		 * Substance(23, "Vanadium", "V", "Silverish", 50.942F, 3380.0F,
		 * 1890.0F, 233.794F, 6.0F, Substance.CATEGORY.TRANSITION_METALS,
		 * Substance.STATE.SOLID); new Substance(24, "Chromium", "Cr", "Gray",
		 * 51.996F, 2670.0F, 1857.0F, 347.0F, 7.19F,
		 * Substance.CATEGORY.TRANSITION_METALS, Substance.STATE.SOLID); new
		 * Substance(25, "Manganese", "Mn", "Silvery Gray", 54.940F, 1962.0F,
		 * 1245.0F, 221.0F, 7.21F, Substance.CATEGORY.TRANSITION_METALS,
		 * Substance.STATE.SOLID);
		 * 
		 * new Substance(27, "Cobalt", "Co", "Metallic Gray", 58.933F, 2927.0F,
		 * 1495.0F, 198.520F, 8.90F, Substance.CATEGORY.TRANSITION_METALS,
		 * Substance.STATE.SOLID); new Substance(28, "Nickel", "Ni",
		 * "Gray Gold", 58.693F, 2730.0F, 1455.0F, 199.570F, 8.908F,
		 * Substance.CATEGORY.TRANSITION_METALS, Substance.STATE.SOLID); new
		 * Substance(29, "Copper", "Cu", "Red Orangy", 63.546F, 2562.0F,
		 * 1084.62F, 158.180F, 8.96F ,Substance.CATEGORY.TRANSITION_METALS,
		 * Substance.STATE.SOLID); new Substance(30, "Zinc", "Zn",
		 * "Silvery Greyish White", 65.380F,
		 */

		// NOTE Just for testing - The substances should be somewhere, getting
		// them from the SubstanceRegistry is impractical. Note that you have to
		// .clone() them to create new instances.

		/*
		 * Compound quartz = new Compound(1, "Quartz", new
		 * Stack<Atom>(SubstanceRegistry.getSubstance("Silicon").getAtom(), 1),
		 * new Stack<Atom>(SubstanceRegistry.getSubstance("Oxygen").getAtom(),
		 * 2));
		 * SubstanceRegistry.bindCompound(Items.quartz.getUnlocalizedName(),
		 * quartz);
		 */


		IMolecule diamond = new SimpleMolecule(2, "Diamond", SubstanceRegistry
				.getSubstance("Carbon").setAmount(8));
		SubstanceRegistry.bindCompound(Items.diamond.getUnlocalizedName(),
				diamond, 1000F);

		IMolecule methane = new OrganicMolecule(1, "Methane", "  H  ", "  -  ",
				"H-C-H", "  -  ", "  H  ");

		IMolecule ethanol = new OrganicMolecule(1, "Ethanol", "  H H    ",
				"  - -    ", "H-C-C-O-H", "  - -    ", "  H H    ");

		IMolecule ethene = new OrganicMolecule(1, "Ethene", "  H H  ",
				"  - -  ", "H-C=C-H", "  - -  ", "  H H  ");

		IMolecule glucose = new OrganicMolecule(1, "Glucose",
				"  H  H  H  H  H H  ", "  -  -  -  -  - -  ",
				"H-C--C--C--C--C-C=O", "  -  -  -  -  -    ",
				"  O  O  O  O  O    ", "  -  -  -  -  -    ",
				"  H  H  H  H  H    ");

		IMolecule cocaine = new OrganicMolecule(1, "Cocaine",
				"             H          ", "             -          ",
				"           H-C-H        ", "             -          ",
				"  H     H  O=C          ", "  -     -    -          ",
				"H-C-N---C----C-H        ", "  - -   -    -          ",
				"  H - H-C-H  -          ", "    -   -    -          ",
				"  H-C---C-H  -   H-C=C-H", "    -   -    -     - -  ",
				"    -   H    -   H-C C-H", "    -        -     = =  ",
				"  H-C--------C-O-C-C-C  ", "    -        -   =   -  ",
				"    H        H   O   H  ");

		/*
		 * NOTE Maybe something like this? We would need a pre-parser for that.
		 * Is the syntax understandable? IMolecule glucose = new
		 * OrganicMolecule(1, "Glucose", "          H   ", "          -   ",
		 * "H-5*(-$R1-)C=O", "$R1=","H","-","C","-","O","-","H", ";" );
		 */

		System.out.println(ethanol);
		System.out.println(methane);
		System.out.println(ethene);
		System.out.println(glucose);
		System.out.println(cocaine);

		SubstanceRegistry.bindCompound(Items.sugar.getUnlocalizedName(),
				glucose, 50F);


		/*
		 * Compound quartz = new Compound(1, "Quartz", new
		 * Stack<Atom>(SubstanceRegistry.getSubstance("Silicon").getAtom(), 1),
		 * new Stack<Atom>(SubstanceRegistry.getSubstance("Oxygen").getAtom(),
		 * 2));
		 * SubstanceRegistry.bindCompound(Items.quartz.getUnlocalizedName(),
		 * quartz);
		 * 
		 * Compound diamond = new Compound(2, "Diamond", new
		 * Stack<Atom>(SubstanceRegistry.getSubstance("Carbon").getAtom(), 8));
		 * 
		 * Compound coal = new Compound(3, "Coal", new
		 * Stack<Atom>(SubstanceRegistry.getSubstance("Carbon").getAtom(), 2),
		 * new Stack<Atom>(SubstanceRegistry.getSubstance("Hydrogen").getAtom(),
		 * 1), new
		 * Stack<Atom>(SubstanceRegistry.getSubstance("Nitrogen").getAtom(),
		 * 1)); SubstanceRegistry.bindCompound(Items.coal.getUnlocalizedName(),
		 * coal);
		 * 
		 * Compound sugar = new Compound(4, "Sugar", new
		 * Stack<Atom>(SubstanceRegistry.getSubstance("Carbon").getAtom(), 12),
		 * new Stack<Atom>(SubstanceRegistry.getSubstance("Hydrogen").getAtom(),
		 * 22), new
		 * Stack<Atom>(SubstanceRegistry.getSubstance("Oxygen").getAtom(), 11));
		 * SubstanceRegistry.bindCompound(Items.sugar.getUnlocalizedName(),
		 * sugar);
		 * 
		 * Compound water = new Compound(5, "Water", new
		 * Stack<Atom>(SubstanceRegistry.getSubstance("Hydrogen").getAtom(), 2),
		 * new Stack<Atom>(SubstanceRegistry.getSubstance("Oxygen").getAtom(),
		 * 1)); //Should this be bucket water or block water?
		 * SubstanceRegistry.bindCompound(Blocks.water.getUnlocalizedName(),
		 * water);
		 * 
		 * Compound wheat = new Compound(6, "Wheat", new
		 * Stack<Atom>(SubstanceRegistry.getSubstance("Carbon").getAtom(), 6),
		 * new Stack<Atom>(SubstanceRegistry.getSubstance("Hydrogen").getAtom(),
		 * 10), new
		 * Stack<Atom>(SubstanceRegistry.getSubstance("Oxygen").getAtom(), 5));
		 * SubstanceRegistry.bindCompound(Items.wheat.getUnlocalizedName(),
		 * wheat);
		 */

		/*
		 * Dungeon Spawns? WeightedRandomChestContent[] field_111189_a = new
		 * WeightedRandomChestContent[] {new
		 * WeightedRandomChestContent(unknownShard, 0, 5, 10, 10)};
		 */


		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(
				new WeightedRandomChestContent(new ItemStack(unknownShard), 1,
						10, 5));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(
				new WeightedRandomChestContent(new ItemStack(unknownIngot), 1,
						10, 5));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(
				new WeightedRandomChestContent(new ItemStack(unknownGas), 1,
						10, 5));

	}

}

