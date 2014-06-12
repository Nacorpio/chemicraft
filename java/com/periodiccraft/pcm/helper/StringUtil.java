package com.periodiccraft.pcm.helper;

public final class StringUtil {

	public static String getLongestString(String[] par1) {
		String result = "";
		int longest = 0;
		for (int i = 0; i < par1.length; i++) {
			String var1 = par1[i];
			if (var1.length() > longest) {
				result = var1;
				longest = var1.length();
				continue;
			}
		}
		return result;
	}
	
	public static String getShortestString(String[] par1) {
		String result = "";
		int shortest = Integer.MAX_VALUE;
		for (int i = 0; i < par1.length; i++) {
			String var1 = par1[i];
			if (var1.length() < shortest) {
				result = var1;
				shortest = var1.length();
				continue;
			}
		}
		return result;
	}
	
}
