package com.periodiccraft.pcm.core.element;

import com.periodiccraft.pcm.core.element.Element.STATE;

public class pH {
	
	private double pH;
	private STATE state;
	
	public boolean hasPh() {
		if(this.state == STATE.SOLID || this.state == STATE.PLASMA) {
			return false;
		} else {
			return true;
			}
	}
		
	
	public boolean isHarmful() {
		if(pH >= 2.81 || pH <= 7.21) {
			return true;
		}else{
			return false;
		}
	}
	
	public double getPhLevel() {
		return pH;
	}
	
}


