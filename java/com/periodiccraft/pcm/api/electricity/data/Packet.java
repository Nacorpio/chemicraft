package com.periodiccraft.pcm.api.electricity.data;

public class Packet implements IEnergyPacket {

	static enum META {

		ERROR(-1),
		DATA(0),
		REQUESTED(2);
		
		private int data;
		META(int par1) {
			data = par1;
		}
		
		public static META byData(int par1) {
			for (META var: values()) {
				if (var.data == par1)
					return var;
			}
			return null;
		}
		
		public final int getData() {
			return data;
		}
		
	}
	
	private int metadata;
	private String data;
	private IEnergyUnit type;
	
	public Packet(int par1, String par2, IEnergyUnit par3) {
		this.metadata = par1;
		this.data = par2;
		this.type = par3;
	}
	
	@Override
	public int getMetadata() {
		return metadata;
	}

	@Override
	public String getData() {
		return data;
	}

	@Override
	public IEnergyUnit getType() {
		return type;
	}

}
