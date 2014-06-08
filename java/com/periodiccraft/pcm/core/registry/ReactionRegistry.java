package com.periodiccraft.pcm.core.registry;

import java.util.ArrayList;
import java.util.HashMap;

import com.periodiccraft.pcm.api.reaction.IReaction;

public class ReactionRegistry {
	
	private static HashMap<String, IReaction> reactions = new HashMap<String, IReaction>();
	
	public static void register(String name, IReaction reaction) {
		reactions.put(name, reaction);
	}
}
