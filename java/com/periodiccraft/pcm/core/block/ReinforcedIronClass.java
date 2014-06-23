package com.periodiccraft.pcm.core.block;

import java.util.Random;

import com.periodiccraft.pcm.PeriodicCraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class ReinforcedIronClass extends Block{

	public ReinforcedIronClass() {
		super(Material.iron);
		this.setBlockTextureName(PeriodicCraft.MODID + ":ReinforcedIron");
	}
	
	@SideOnly(Side.CLIENT)
	public Block getBlockDropped(int i, Random random, int fortuneLevel) {
		return Blocks.air;
	}
	
	
		
	
	
	
}
