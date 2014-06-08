package com.periodiccraft.pcm.api.reaction;

import java.util.ArrayList;
import java.util.HashMap;

public class ReactionRegistry {
	
	private static HashMap<String, IReaction> reactions = new HashMap<String, IReaction>();
	
	public static void register(String name, IReaction reaction) {
		reactions.put(name, reaction);
	}
}
