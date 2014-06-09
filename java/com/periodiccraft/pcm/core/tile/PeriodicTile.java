package com.periodiccraft.pcm.core.tile;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.periodiccraft.pcm.helper.ChatUtil;
import com.periodiccraft.pcm.helper.WorldPosition;

public class PeriodicTile extends TileEntity {

	private World world;
	private WorldPosition position;
	
	public PeriodicTile(World par1, int par2) {
		this.world = par1;
	}
	
	public final void setPosition(WorldPosition par1) {
		this.position = par1;
	}
	
	/**
	 * Returns the {@link #Block} of this tile.
	 * @return the block.
	 */
	public final Block getBlock() {
		return position.getBlock();
	}
	
	/**
	 * Returns the {@link #World} of this tile.
	 * @return the world.
	 */
	public final World getWorld() {
		return this.world;
	}
	
	/**
	 * Returns the {@link #WorldPosition} of this tile.
	 * @return the position.
	 */
	public final WorldPosition getPosition() {
		return this.position;
	}
	
}
