package com.periodiccraft.pcm.api.electricity.node;

import java.util.List;

import com.periodiccraft.pcm.api.electricity.data.IEnergyUnit;

public interface IElectric extends INode {

	// Identification
	
	/**
	 * Returns a unique identifier for this node.<br>
	 * This will be used by a network to identify the node.
	 * @return the identifier.
	 */
	String getIdentifier();
	
	/**
	 * Returns the unique hash used within energy packets when sent.<br>
	 * The recipient side will identify a node by using this hash.
	 * @return the unique hash.
	 */
	long getUniqueHash();
	
	/**
	 * Returns the frequency of the network this node is currently connected to.<br>
	 * If this returns null, it means that it isn't connected to a network.
	 * @return the frequency.
	 */
	String getFrequency();	
	
	/**
	 * Returns the energy units that this node accept as energy.<br>
	 * These values are automatically inherited from the network.
	 * @return the energy units.
	 */
	List<IEnergyUnit> getUnits();
	
}
