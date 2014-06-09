package com.periodiccraft.pcm.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.periodiccraft.pcm.PeriodicCraft;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class WrappedGenerator implements IWorldGenerator {

	public static class Instruction {
		
		private Block blockType;
		
		private int maxHeight = 64;
		private int blocksPerVein = 7;
		private int veinsPerChunk = 10;
		
		private int[] dimensions = new int[] {};
		
		private boolean overworld = true;
		private boolean nether = false;
		private boolean end = false;
		
		private boolean enabled = true;
	
		/**
		 * Create a new generation instructions for the generator.
		 * @param par1 the block type to use when generating.
		 * @param par2 the maximum height the blocks will appear on (64 is surface).
		 * @param par3 the maximum amount of blocks that can be generated in a vein.
		 * @param par4 the amount of veins to generate in each chunk.
		 */
		public Instruction(Block par1, int par2, int par3, int par4) {
			this.blockType = par1;
			this.maxHeight = par2;
			this.blocksPerVein = par3;
			this.veinsPerChunk = par4;
		}
		
		public final void setEnabled(boolean par1) {
			this.enabled = par1;
		}
		
		public final int[] getDimensions() {
			return this.dimensions;
		}
		
		public final Instruction setDimensions(int[] par1) {
			this.dimensions = par1;
			return this;
		}
		
		/**
		 * Allow the block to generate in the overworld (0).
		 * @param par1 true/false.
		 * @return the property for structuring convenience.
		 */
		public final Instruction setOverworld(boolean par1) {
			this.overworld = par1;
			return this;
		}
		
		/**
		 * Allow the block to generate in the nether (-1).
		 * @param par1 true/false.
		 * @return the property for structuring convenience.
		 */
		public final Instruction setNether(boolean par1) {
			this.nether = par1;
			return this;
		}
		
		/**
		 * Allow the block to generate in the nether (1).
		 * @param par1 true/false.
		 * @return the property for structuring convenience.
		 */
		public final Instruction setEnd(boolean par1) {
			this.end = par1;
			return this;
		}
		
		/**
		 * Whether this generator instruction is enabled.
		 * @return if the instruction is enabled.
		 */
		public final boolean isEnabled() {
			return this.enabled;
		}
		
		/**
		 * Returns the block type to use when generating.
		 * @return the block type.
		 */
		public final Block getBlockType() {
			return this.blockType;
		}
		
		/**
		 * The maximum height that the block can be generated on.
		 * @return the max height.
		 */
		public final int getMaxHeight() {
			return this.maxHeight;
		}
		
		/**
		 * The maximum amount of blocks that can be generated in every vein.
		 * @return the amount of blocks per vein.
		 */
		public final int getBlocksPerVein() {
			return this.blocksPerVein;
		}
		
		/**
		 * The amount of veins to generate in each chunk.
		 * @return the amount of veins per chunk.
		 */
		public final int getVeinsPerChunk() {
			return this.veinsPerChunk;
		}
		
	}
	
	private Map<String, Instruction> generations = new HashMap<String, Instruction>();
	
	public WrappedGenerator(int par1, Instruction... par2) {
		GameRegistry.registerWorldGenerator(this, par1);
		for (Instruction var: par2) {
			if (var.getBlocksPerVein() > 0 && var.getVeinsPerChunk() > 0 && var.getMaxHeight() > 0)
				generations.put(var.getBlockType().getUnlocalizedName(), var);
		}
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		for (Instruction var: this.generations.values()) {
			int var1 = world.provider.dimensionId;
			if (var1 == -1) {
				if (var.nether) {	
					generateInNether(var, world, random, chunkX * 16, chunkZ * 16);
				}
			} else if (var1 == 0) {
				if (var.overworld) {
					generateInOverworld(var, world, random, chunkX * 16, chunkZ * 16);
				}
			} else if (var1 == 1) {
				if (var.end) {
					generateInEnd(var, world, random, chunkX * 16, chunkZ * 16);
				}
			} else {
				for (int v: var.getDimensions()) {
					if (var1 == v)
						this.generateInDimension(var, world, random, chunkX * 16, chunkZ * 16);
				}
			}
		}
	}

	private void generateInDimension(Instruction par1, World world, Random random, int x, int z) {
		for(int k = 0; k < par1.getVeinsPerChunk(); k++) {
			int chunkX = x + random.nextInt(16);
			int chunkY = random.nextInt(par1.getMaxHeight());
			int chunkZ = z + random.nextInt(16);
			
			(new WorldGenMinable(par1.getBlockType(), par1.getBlocksPerVein())).generate(world, random, chunkX, chunkY, chunkZ);
			
		}
	}
	
	private void generateInEnd(Instruction par1, World world, Random random, int x, int z) {
		for(int k = 0; k < par1.getVeinsPerChunk(); k++) {
			int chunkX = x + random.nextInt(16);
			int chunkY = random.nextInt(par1.getMaxHeight());
			int chunkZ = z + random.nextInt(16);
			
			(new WorldGenMinable(par1.getBlockType(), par1.getBlocksPerVein())).generate(world, random, chunkX, chunkY, chunkZ);
			
		}
	}
	
	private void generateInOverworld(Instruction par1, World world, Random random, int x, int z) {
		for(int k = 0; k < par1.getVeinsPerChunk(); k++) {
			int chunkX = x + random.nextInt(16);
			int chunkY = random.nextInt(par1.getMaxHeight());
			int chunkZ = z + random.nextInt(16);
			
			(new WorldGenMinable(par1.getBlockType(), par1.getBlocksPerVein())).generate(world, random, chunkX, chunkY, chunkZ);
			
		}
	}
	
	private void generateInNether(Instruction par1, World world, Random random, int x, int z) {
		for(int k = 0; k < par1.getVeinsPerChunk(); k++) {
			int chunkX = x + random.nextInt(16);
			int chunkY = random.nextInt(par1.getMaxHeight());
			int chunkZ = z + random.nextInt(16);
			
			(new WorldGenMinable(par1.getBlockType(), par1.getBlocksPerVein())).generate(world, random, chunkX, chunkY, chunkZ);
			
		}
	}
	
}
