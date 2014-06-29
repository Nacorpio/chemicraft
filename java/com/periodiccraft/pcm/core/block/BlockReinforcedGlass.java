package com.periodiccraft.pcm.core.block;

import com.periodiccraft.pcm.PeriodicCraft;

import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockReinforcedGlass extends BlockGlass {

	public BlockReinforcedGlass() {
		super(Material.glass, true);
	}

	@Override
	public final String getTextureName() {
		return PeriodicCraft.MODID + ":blockReinforcedGlass";
	}
}
