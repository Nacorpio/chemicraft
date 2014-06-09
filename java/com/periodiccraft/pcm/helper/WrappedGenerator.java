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

	public static class GenerationProperty {
		
		private Block blockType;
		
		private int maxHeight = 64;
		private int blocksPerVein = 7;
		private int veinsPerChunk = 10;
		
		private boolean overworld = true;
		private boolean nether = false;
		private boolean end = false;
		
		private boolean enabled = true;
	
		public GenerationProperty(Block par1, int par2, int par3, int par4) {
			this.blockType = par1;
			this.maxHeight = par2;
			this.blocksPerVein = par3;
			this.veinsPerChunk = par4;
		}
		
		public final void setOverworld(boolean par1) {
			this.overworld = par1;
		}
		
		public final void setNether(boolean par1) {
			this.nether = par1;
		}
		
		public final void setEnd(boolean par1) {
			this.end = par1;
		}
		
		public final boolean isEnabled() {
			return this.enabled;
		}
		
		public final Block getBlockType() {
			return this.blockType;
		}
		
		public final int getMaxHeight() {
			return this.maxHeight;
		}
		
		public final int getBlocksPerVein() {
			return this.blocksPerVein;
		}
		
		public final int getVeinsPerChunk() {
			return this.veinsPerChunk;
		}
		
	}
	
	private Map<String, GenerationProperty> generations = new HashMap<String, GenerationProperty>();
	
	public WrappedGenerator(int par1, GenerationProperty... par2) {
		GameRegistry.registerWorldGenerator(this, par1);
		for (GenerationProperty var: par2) {
			generations.put(var.getBlockType().getUnlocalizedName(), var);
		}
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		for (GenerationProperty var: this.generations.values()) {
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
			}
		}
	}

	private void generateInEnd(GenerationProperty par1, World world, Random random, int x, int z) {
		for(int k = 0; k < par1.getVeinsPerChunk(); k++) {
			int chunkX = x + random.nextInt(16);
			int chunkY = random.nextInt(par1.getMaxHeight());
			int chunkZ = z + random.nextInt(16);
			
			(new WorldGenMinable(par1.getBlockType(), par1.getBlocksPerVein())).generate(world, random, chunkX, chunkY, chunkZ);
			
		}
	}
	
	private void generateInOverworld(GenerationProperty par1, World world, Random random, int x, int z) {
		for(int k = 0; k < par1.getVeinsPerChunk(); k++) {
			int chunkX = x + random.nextInt(16);
			int chunkY = random.nextInt(par1.getMaxHeight());
			int chunkZ = z + random.nextInt(16);
			
			(new WorldGenMinable(par1.getBlockType(), par1.getBlocksPerVein())).generate(world, random, chunkX, chunkY, chunkZ);
			
		}
	}
	
	private void generateInNether(GenerationProperty par1, World world, Random random, int x, int z) {
		for(int k = 0; k < par1.getVeinsPerChunk(); k++) {
			int chunkX = x + random.nextInt(16);
			int chunkY = random.nextInt(par1.getMaxHeight());
			int chunkZ = z + random.nextInt(16);
			
			(new WorldGenMinable(par1.getBlockType(), par1.getBlocksPerVein())).generate(world, random, chunkX, chunkY, chunkZ);
			
		}
	}
	
}
