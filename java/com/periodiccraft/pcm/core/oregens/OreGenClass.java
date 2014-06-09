package com.periodiccraft.pcm.core.oregens;

import java.util.Random;

import com.periodiccraft.pcm.PeriodicCraft;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class OreGenClass implements IWorldGenerator 
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		switch(world.provider.dimensionId) {
			case -1:
				generateInNether(world, random, chunkX * 16, chunkZ * 16);
				break;
			case 0:
				generateInOverworld(world, random, chunkX * 16, chunkZ * 16);
				break;
			case 1:
				generateInEnd(world, random, chunkX * 16, chunkZ * 16);
				break;
		}
		
	}

	private void generateInEnd(World world, Random random, int x, int z) {
		
	}

	private void generateInOverworld(World world, Random random, int x, int z) {
		for(int k = 0; k < 25; k++) {
			int chunkX = x + random.nextInt(16);
			int chunkY = random.nextInt(50);
			int chunkZ = z + random.nextInt(16);
			
			(new WorldGenMinable(PeriodicCraft.oreTitanium, 10)).generate(world, random, chunkX, chunkY, chunkZ);
			
		}
		
		for(int k = 0; k < 30; k++) {
			int chunkX = x + random.nextInt(16);
			int chunkY = random.nextInt(100);
			int chunkZ = z + random.nextInt(16);
			
			(new WorldGenMinable(PeriodicCraft.oreVanadium, 10)).generate(world, random, chunkX, chunkY, chunkZ);
		}
		for(int k = 0; k < 35; k++) {
			int chunkX = x + random.nextInt(16);
			int chunkY = random.nextInt(90);
			int chunkZ = z + random.nextInt(16);
			
			(new WorldGenMinable(PeriodicCraft.oreChromium, 10)).generate(world, random, chunkX, chunkY, chunkZ);
		}
		for(int k = 0; k < 20; k++) {
			int chunkX = x + random.nextInt(16);
			int chunkY = random.nextInt(60);
			int chunkZ = z + random.nextInt(16);

			(new WorldGenMinable(PeriodicCraft.oreMangenese, 10)).generate(world, random, chunkX, chunkY, chunkZ);
		}
		for(int k = 0; k < 10; k++) {
			int chunkX = x + random.nextInt(16);
			int chunkY = random.nextInt(20);
			int chunkZ = z + random.nextInt(16);
			
			(new WorldGenMinable(PeriodicCraft.oreCobalt, 10)).generate(world, random, chunkX, chunkY, chunkZ);
		}
	}

	private void generateInNether(World world, Random random, int x, int z) {
		
	}

}
