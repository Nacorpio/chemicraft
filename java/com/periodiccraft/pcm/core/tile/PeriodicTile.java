package com.periodiccraft.pcm.core.tile;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.periodiccraft.pcm.helper.Position;

public class PeriodicTile extends TileEntity {

	private World world;
	private Position position;
	
	public PeriodicTile(World par1, int par2) {
		this.world = par1;
		this.position = new Position(this.xCoord, this.yCoord, this.zCoord);
	}
	
	public final World getWorld() {
		return this.world;
	}
	
	public final Position getPosition() {
		return this.position;
	}
	
}
