package com.periodiccraft.pcm.core.block.ores;

import com.periodiccraft.pcm.PeriodicCraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class PeriodicOre extends Block {

	public PeriodicOre(String par1, float par2) {
		super(Material.rock);
		this.setBlockName(par1);
		this.setHardness(par2);
		this.setBlockTextureName(PeriodicCraft.MODID + ":" + this.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(this, getUnlocalizedName().substring(5));
	}

}
