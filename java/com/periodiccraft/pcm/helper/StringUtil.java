package com.periodiccraft.pcm.helper;

import com.sun.xml.internal.ws.util.StringUtils;

public final class StringUtil {

	public static String getBetween(String raw, String str1, String str2) {
		
		String result = "";
		
		int str1Index = raw.indexOf(str1) + str1.length() - 1;
		int str2Index = raw.indexOf(str2) - 1;
		
		return raw.substring(str1Index, str2Index);
		
	}
	
	public static String getLongestString(String[] par1) {
		String result = "";
		int longest = 0;
		for (int i = 0; i < par1.length; i++) {
			String var1 = par1[i];
			if (var1.length() > longest) {
				result = var1;
				longest = var1.length();
				continue;
			} else if (var1.length() == longest) {
				result = var1;
				longest = var1.length();
			}
		}
		return result;
	}
	
	public static String[] getStringsLongerThan(String[] par1, int par2) {
		String[] result = new String[]{};
		int latestLong = 0;
		for (int i = 0; i < par1.length; i++) {
			String var1 = par1[i];
			if (var1.length() > par2) {
				latestLong = var1.length();
				result[result.length] = var1;
			}
		}
		return result;
	}
	
	public static String[] getStringsShorterThan(String[] par1, int par2) {
		String[] result = new String[]{};
		int latestShort = 0;
		for (int i = 0; i < par1.length; i++) {
			String var1 = par1[i];
			if (var1.length() < par2) {
				latestShort = var1.length();
				result[result.length] = var1;
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
			} else if (var1.length() == shortest) {
				result = var1;
				shortest = var1.length();
			}
		}
		return result;
	}
	
}
