package com.periodiccraft.pcm.helper;

public class TooltipUtil {
	
	public static final String tooltipFormat(String par1) {
		return par1.replace("\\gr", ChatUtil.Colors.green).replace("\\r", ChatUtil.Colors.red);
	}
	
}
