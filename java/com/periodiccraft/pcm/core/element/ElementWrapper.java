package com.periodiccraft.pcm.core.element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ElementWrapper {
	
	private ArrayList<Element> isotopes = new ArrayList<>();
	private Element baseElement;
	
	public ElementWrapper(Element e) {
		this.baseElement = e;
	}
	
	public Element getBaseElement() {
		return baseElement;
	}
	
	public List<Element> getIsotopes() {
		return Collections.unmodifiableList(isotopes);
	}
	
	public boolean isIsotope(Element e) {
		return isotopes.contains(e);
	}
	
	public boolean containsElement(Element e) {
		return baseElement.equals(e) || isotopes.contains(e);
	}
	
	public boolean isBaseElement(Element e) {
		return baseElement.equals(e);
	}
	
	public void addIsotope(Element e) {
		if(e.getAtomicNumber() == baseElement.getAtomicNumber()) {
			isotopes.add(e);
		}
		else throw new IllegalArgumentException("Isotopes happen to have the same atomic number!");
	}
}
