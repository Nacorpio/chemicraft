package com.periodiccraft.pcm.helper;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class WorldPosition extends Position {

	private World world;
	
	public WorldPosition(World par1, int par2, int par3, int par4) {
		super(par2, par3, par4);
		this.world = par1;
	}

	/**
	 * Returns the TileEntity in the given direction at the given amount of hops.
	 * @param par1 the direction of the TileEntity to return.
	 * @param par2 the amount of hops.
	 * @return the TileEntity in the given direction, the given amount of hops away.
	 */
	public final TileEntity getTileEntity(ForgeDirection par1, int par2) {
		Position var1 = this.getPosition(par1, par2);
		return world.getTileEntity(var1.getX(), var1.getY(), var1.getZ());
	}
	
	/**
	 * Returns the TileEntity one hop away in the given direction.
	 * @param par1 the direction of the TileEntity to return.
	 * @return the TileEntity in the given direction, one hop away.
	 */
	public final TileEntity getTileEntity(ForgeDirection par1) {
		return getTileEntity(par1, 1);
	}
	
	/**
	 * Returns the TileEntity (if one exists), at the current position.
	 * @return the TileEntity at the current position.
	 */
	public final TileEntity getTileEntity() {
		return world.getTileEntity(this.getX(), this.getY(), this.getZ());
	}
	
	/**
	 * Returns an array of every TileEntity in each direction.
	 * @return an array of TileEntities.
	 */
	public final TileEntity[] getTileEntities() {
		TileEntity[] var1 = new TileEntity[6];
		for (int i = 0; i < ForgeDirection.values().length - 1; i++) {
			var1[i] = getTileEntity(ForgeDirection.values()[i]);
		}
		return var1;
	}
	
	/**
	 * Returns the Block in the given direction at the given amount of hops away.
	 * @param par1 the direction of the Block to return.
	 * @param par2 the amount of hops.
	 * @return Block in the given direction, the given amount of hops away.
	 */
	public final Block getBlock(ForgeDirection par1, int par2) {
		Position var1 = this.getPosition(par1, par2);
		return world.getBlock(var1.getX(), var1.getY(), var1.getZ());
	}
	
	/**
	 * Returns the Block in the given direction, one hop away.
	 * @param par1 the direction of the Block to return.
	 * @return the Block in the given direction, one hop away. 
	 */
	public final Block getBlock(ForgeDirection par1) {
		return getBlock(par1, 1);
	}
	
	/**
	 * Returns the Block (if one exists), at the current position.
	 * @return the Block at the current position.
	 */
	public final Block getBlock() {
		return world.getBlock(this.getX(), this.getY(), this.getZ());
	}
	
	/**
	 * Returns an array of every Block in each direction.
	 * @return an array of Blocks.
	 */
	public final Block[] getBlocks() {
		Block[] var1 = new Block[6];
		for (int i = 0; i < ForgeDirection.values().length - 1; i++) {
			var1[i] = getBlock(ForgeDirection.values()[i]);
		}
		return var1;
	}
	
}
