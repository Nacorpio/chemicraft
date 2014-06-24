package com.periodiccraft.pcm.helper;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeTemperature 
{
	public static float getDefaultTemperature()
	{
		return 20F;
	}
	
	public static float getTemperature(int biomeID)
	{
		return BiomeGenBase.getBiome(biomeID).temperature;
	}
}
