package com.periodiccraft.pcm.api.electricity.node;

import com.periodiccraft.pcm.api.electricity.data.IEnergyPacket;
import com.periodiccraft.pcm.api.electricity.data.IEnergyUnit;

public interface ISender extends IElectric {

	void send(int metadata, String data, IEnergyUnit unit);
	
	void send(IEnergyPacket packet);
	
}
