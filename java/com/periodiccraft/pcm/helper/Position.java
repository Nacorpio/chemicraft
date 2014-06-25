package com.periodiccraft.pcm.helper;

import net.minecraftforge.common.util.ForgeDirection;

public class Position {

	private int x, y, z;
	
	public Position(int par1, int par2, int par3) {
		this.x = par1;
		this.y = par2;
		this.z = par3;
	}
	
	/**
	 * Returns the position of the specified {@link #ForgeDirection}.
	 * @param par1 the {@link #ForgeDirection}.
	 * @return the new position.
	 */
	public Position getPosition(ForgeDirection par1) {
		if (!par1.equals(ForgeDirection.UNKNOWN)) {
			return getPosition(par1, 1);
		}
		return null;
	}
	
	/**
	 * Returns the position of the specified {@link #ForgeDirection} when hopping the specified amount of steps.
	 * Use this when you want to specify the amount of steps to hop, otherwise just use the other getPosition(ForgeDirection) method.
	 * @param par1 the {@link #ForgeDirection}.
	 * @param par2 the amount of steps to hop in the specified direction.
	 * @return the new position.
	 */
	public Position getPosition(ForgeDirection par1, int par2) {
		switch (par1) {
		case UP:
			return new Position(x, y + par2, z);
		case DOWN:
			return new Position(x, y - par2, z);
		case SOUTH:
			return new Position(x, y, z - par2);
		case NORTH: 
			return new Position(x, y, z + par2);
		case WEST:
			return new Position(x - par2, y, z);
		case EAST:
			return new Position(x + par2, y, z);
		default:
			return null;
		}
	}
	
	/**
	 * Hop the specified amount of steps using the local coordinates.<br>
	 * This will not give you a new position, but will modify the local coordinates.
	 * @param par1 the direction to hop in.
	 * @param par2 the amount of steps to hop.
	 */
	public final void hop(ForgeDirection par1, int par2) {
		Position var1 = getPosition(par1, par2);
		this.x = var1.getX();
		this.y = var1.getY();
		this.z = var1.getZ();
	}
	
	/**
	 * Returns the X-coordinate of the position.
	 * @return the X-coordinate.
	 */
	public final int getX() {
		return this.x;
	}
	
	/**
	 * Returns the Y-coordinate of the position.
	 * @return the Y-coordinate.
	 */
	public final int getY() {
		return this.y;
	}
	
	/**
	 * Returns the Z-coordinate of the position.
	 * @return the Z-coordinate.
	 */
	public final int getZ() {
		return this.z;
	}
	
	public final String toString() {
		return "[" + x + ", " + y + ", " + z + "]";
	}
	
	public boolean equals(Object par1) {
		if (par1 == null) return false;
		if (par1 instanceof Position) {
			Position var1 = (Position) par1;
			return var1.getX() == x &&
				   var1.getY() == y &&
				   var1.getZ() == z;
		}
		return par1.equals(this);
	}
	
}
