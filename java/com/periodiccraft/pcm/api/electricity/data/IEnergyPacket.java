package com.periodiccraft.pcm.api.electricity.data;

public interface IEnergyPacket {

	/**
	 * Returns an integer consisting of additional data.<br>
	 * This can for example recognize errors and other types of data.
	 * @return the metadata.
	 */
	int getMetadata();
	
	/**
	 * Returns the data of this packet. This will be serialized before<br>
	 * sent to the recipient node. The data will then be deserialized.
	 * @return the data of this packet.
	 */
	String getData();
	
	/**
	 * Returns the unit of this packet. The packet can only be sent to nodes<br>
	 * which allow the receiving data from this unit. 
	 * @return the unit.
	 */
	IEnergyUnit getType();
	
}
