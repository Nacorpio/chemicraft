package com.periodiccraft.pcm.core.tile;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.periodiccraft.pcm.api.energy.IElectric;
import com.periodiccraft.pcm.api.energy.IMachine;
import com.periodiccraft.pcm.helper.ChatUtil;

public class TileDiskManager extends MachineTile implements IElectric, IMachine {

	public TileDiskManager(World par1, int par2) {
		super(par1, par2);
		this.setInputRequired(20);
	}

	@Override
	public final void onElectricNeighborAdded(ForgeDirection par1, ElectricTile par2) {
		// What's going to happen when an electrical neighbor is added.
	}
	
	@Override
	public final void onElectricActivated(World par1, EntityPlayer par2) {
		ChatUtil.sendChatMessage("Electric: \\gr" + getPosition().getElectricTileEntities().length);
	}
	
}
