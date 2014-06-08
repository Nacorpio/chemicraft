package com.periodiccraft.pcm.api.energy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import com.periodiccraft.pcm.core.tile.ElectricTile;

public interface IElectric {

	/**
	 * Returns whether the electrical object allows input of energy.
	 * @return whether the object allows input.
	 */
	boolean getAllowInput();
	
	/**
	 * Returns whether the electrical object allows output of energy.
	 * @return whether the object allows output.
	 */
	boolean getAllowOutput();
	
	/**
	 * Returns how many connections there are to this electrical object.
	 * @return the amount of connections.
	 */
	int getConnections();
	
	/**
	 * Attempts to get an electrical object from the specified direction.<br>
	 * The object must implement the interface {@link #IElectric} to be 
	 * considered an electrical object.
	 * @param par1 the direction to get the electrical object from.
	 * @return the electrical object ({@link #TileEntity}).
	 */
	TileEntity getElectricTile(ForgeDirection par1);
	
	/**
	 * Returns whether this electrical object can be connected with the
	 * electrical object to the specified direction. If possible, the
	 * two objects can start interacting with each other and then share
	 * energy and much more.
	 * @param par1 the direction to check.
	 * @return whether the operation is possible.
	 */
	boolean canConnectWith(ForgeDirection par1);
	
	/**
	 * Occurs when an electrical neighbor has been added.
	 * @param par1 the direction of the new neighbor.
	 * @param par2 the new electrical neighbor-tile.
	 */
	void onElectricNeighborAdded(ForgeDirection par1, ElectricTile par2);
	
	void onElectricNeighborDestroyed(ForgeDirection par1, ElectricTile par3);
	
}