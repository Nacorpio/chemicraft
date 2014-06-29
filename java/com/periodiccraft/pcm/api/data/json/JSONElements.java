package com.periodiccraft.pcm.api.data.json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONElements {
	
	List<Entry<String, JsonElement>> entries = new ArrayList<Entry<>>();
	
	public JSONElements(String par1) {
		
		System.out.println(par1);
		
		JsonParser var1 = new JsonParser();
		JsonElement var2 = var1.parse(par1);	
		JsonObject varObj1 = var2.getAsJsonObject();
		
		for (int i = 0; i < varObj1.entrySet().size(); i++) {
			Entry<String, JsonElement> var = (Entry<String, JsonElement>) varObj1.entrySet().toArray()[i];
			JsonObject varObject1 = var.getValue().getAsJsonObject();
			System.out.println(varObject1.get("symbol"));
		}

	}
	
	public final List<Entry<String, JsonElement>> getElements() {
		return entries;
	}
	
}
