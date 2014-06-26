package com.periodiccraft.pcm.api.data.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.commons.lang3.CharSet;

import com.google.common.io.Files;

public final class JSONDebug {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner var1 = new Scanner(new File("C:\\Users\\Nacorpio\\Desktop\\elements.json"), "UTF-8");
		String var2 = "";
		while (var1.hasNextLine()) {
			var2 += var1.nextLine() + "\n";
		}
		new JSONElements(var2);
		var1.close();
	}

}
