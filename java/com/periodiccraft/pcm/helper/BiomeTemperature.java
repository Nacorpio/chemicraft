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
	
	public static boolean isHighHumidity(World par1, int x, int z) {
		return par1.getBiomeGenForCoords(x, z).isHighHumidity();
	}
	
	public static boolean isHighHumidity(World par1, Position par2) {
		return isHighHumidity(par1, par2.getX(), par2.getZ());
	}
	
	public static boolean isHighHumidity(WorldPosition par1) {
		return isHighHumidity(par1.getWorld(), par1.getX(), par1.getZ());
	}
	
	public static float getTemperature(World par1, int x, int z) {
		return par1.getBiomeGenForCoords(x, z).temperature;
	}
	
	public static float getTemperature(WorldPosition par1) {
		return getTemperature(par1.getWorld(), par1);
	}
	
	public static float getTemperature(World par1, Position par2) {
		return par1.getBiomeGenForCoords(par2.getX(), par2.getZ()).temperature;
	}
	
	public static float getTemperature(BiomeGenBase par1) {
		return getTemperature(par1.biomeID);
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
	
	public static boolean canSnow(BiomeGenBase par1) {
		return par1.getEnableSnow();
	}
	
	public static boolean canSnow(World par1, Position par2) {
		return par1.getBiomeGenForCoords(par2.getX(), par2.getZ()).getEnableSnow();
	}
	
	public static boolean canSnow(WorldPosition par1) {
		return par1.getWorld().getBiomeGenForCoords(par1.getX(), par1.getX()).getEnableSnow();
	}
	
	public static boolean isTakingRain(World par1, Position par2) {
		return isTakingRain(new WorldPosition(par1, par2.getX(), par2.getY(), par2.getZ()));
	}
	
	public static boolean isTakingRain(WorldPosition par2) {
		return par2.getWorld().isRaining() && canSeeSky(par2);
	}
	
	public static boolean canSeeSky(World par1, Position par2) {
		return canSeeSky(new WorldPosition(par1, par2.getX(), par2.getY(), par2.getZ()));
	}
	
	public static boolean canSeeSky(World par1, int x, int y, int z) {
		return canSeeSky(new WorldPosition(par1, x, y, z));
	}
	
	public static boolean canSeeSky(WorldPosition par2) {
		return par2.getBlocks(ForgeDirection.UP, par2.getWorld().getActualHeight()).length == 0;
	}
	
	public static boolean isRaining(World par1) {
		return par1.isRaining();
	}

}
