package com.periodiccraft.pcm.api.electricity.network;

import java.util.List;

import com.periodiccraft.pcm.api.electricity.data.IEnergyUnit;
import com.periodiccraft.pcm.api.electricity.node.INode;

public interface INetwork {

	/**
	 * Returns the name of the player that owns this network.<br>
	 * The ownership can be transferred from the owner that created the network.
	 * @return the name of the owner.
	 */
	String getOwner();
	
	/**
	 * Returns the amount of nodes that this network consists of.
	 * @return the count.
	 */
	int getCount();

	/**
	 * Returns the frequency of this network.<br>
	 * This will be used for nodes to connect.
	 * @return the frequency.
	 */
	String getFrequency();
	
	/**
	 * Add a new node with the specified identifier.
	 * @param par1 the identifier of the new node.
	 * @param par2 the node to add.
	 */
	void add(String par1, INode par2);
	
	/**
	 * Returns the node with the specified name.
	 * @param par1 the name of the node.
	 * @return the node.
	 */
	INode get(String par1);
	
	/**
	 * Remove the node with the specified name.
	 * @param par1 the name of the node.
	 */
	void remove(String par1);
	
	/**
	 * Returns the nodes connected to this network.<br>
	 * A node represents every electrical device on the network.
	 * @return the nodes of the network.
	 */
	List<INode> getNodes();
	
	//
	
	/**
	 * Returns the units that accept energy within this network.<br>
	 * All the nodes will only accept the units specified in here.
	 * @return the energy units to accept.
	 */
	List<IEnergyUnit> getUnits();
	
}
