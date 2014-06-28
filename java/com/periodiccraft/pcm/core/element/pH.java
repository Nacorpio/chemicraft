package com.periodiccraft.pcm.core.element;

public class pH {
	
	
 /*
  * Make sure you remember what pH stands for. Potential of Hydrogen.
  * TODO We should add Ph to the research.
  * 
  */

	private double pHlevel; //0-8.1

	
	public boolean isHarmful() {
		if(pHlevel >= 6.81 || pHlevel <= 6.81) {
			return true;
		}else{
			return false;
		}
	}
		
}
	
	
