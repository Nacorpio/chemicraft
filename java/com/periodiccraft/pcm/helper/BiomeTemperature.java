package com.periodiccraft.pcm.helper;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.TempCategory;
import net.minecraftforge.common.util.ForgeDirection;

public class BiomeTemperature 
{
	public static float getDefaultTemperature()
	{
		return 20.0F;
	}
	
	public static float getTemperature(int biomeID)
	{	
		return BiomeGenBase.getBiome(biomeID).temperature;
	}
	
	public static float getRainfall(int biomeID) {
		return BiomeGenBase.getBiome(biomeID).getFloatRainfall();
	}
	
	public static TempCategory getTempCategory(int biomeID) {
		return getTempCategory(BiomeGenBase.getBiome(biomeID));
	}
	
	public static TempCategory getTempCategory(BiomeGenBase par1) {
		return par1.getTempCategory();
	}
	
	public static boolean canRain(WorldPosition par2) {
		return par2.getWorld().isRaining() && canSeeSky(par2);
	}
	
	public static boolean canSeeSky(WorldPosition par2) {
		return par2.getBlocks(ForgeDirection.UP, par2.getWorld().getActualHeight()).length == 0;
	}
	
	public static boolean isRaining(World par1) {
		return par1.isRaining();
	}

}
