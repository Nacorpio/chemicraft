package com.periodiccraft.pcm.api.data;

import java.util.List;

public enum EnumColumnType {
	
	STRING("String", String.class),
	INTEGER("Integer", Integer.class),
	DOUBLE("Double", Double.class),
	FLOAT("Float", Float.class),
	LIST("List", List.class);
	
	private String name;
	private Class<?> clazz;
	
	EnumColumnType(String par1, Class<?> par2) {
		name = par1;
		clazz = par2;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Class<?> getProvider() {
		return this.clazz;
	}
	
}
