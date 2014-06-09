package com.periodiccraft.pcm.helper;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public final class ChatUtil {

	public static class StringHandler {
		public static String dark_black = "\u00a70";
		public static String dark_blue = "\u00a71";
		public static String dark_green = "\u00a72";
		public static String dark_cyan = "\u00a73";
		public static String dark_red = "\u00a74";
		public static String dark_purple = "\u00a75";
		public static String dark_yellow = "\u00a76";
	        public static String gray = "\u00a77";
		public static String dark_gray = "\u00a78";
		public static String blue = "\u00a79";
		public static String green = "\u00a7A";
		public static String cyan = "\u00a7B";
		public static String red = "\u00a7C";
		public static String purple = "\u00a7D";
		public static String yellow = "\u00a7E";
	        public static String white = "\u00a7F";
	}
	
	public static final void sendChatMessage(String par2) {
		Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(createEIChatComponent(TooltipUtil.tooltipFormat(par2)));
	}
	
	private static IChatComponent createEIChatComponent(String string) {
		ChatComponentText EIComponent = new ChatComponentText(string);
		return EIComponent;
	}
	
}
