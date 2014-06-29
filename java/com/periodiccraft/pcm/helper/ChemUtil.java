package com.periodiccraft.pcm.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.periodiccraft.pcm.core.element.Element;
import com.periodiccraft.pcm.core.element.ICompound;
import com.periodiccraft.pcm.core.element.SubstanceStack;

public final class ChemUtil {
	
	public static final String SIMPLE_FORMULA = "([A-Z][a-z]?)(\\d*)";
	public static final String STRUCT_FORMULA = "([-=]?)([A-Z][a-z]?)+([-=]?)";
	
	public static final boolean isFormula(String formula) {
		return formula.matches(SIMPLE_FORMULA);		
	}
	
	public static final boolean isStructuralFormula(String par1) {
		return par1.matches(STRUCT_FORMULA);
	}
	
	public static final float kelvinToCelcius(float par1) {
		return par1 - 273.15F;
	}
	
	public static final float celciusToKelvin(float par1) {
		return par1 + 273.15F;
	}
	
	public static final String[] getStructuralDecompilation(String par1) {
		
		String[] result = new String[]{};
		
		Pattern var1 = Pattern.compile(STRUCT_FORMULA);
		Matcher var2 = var1.matcher(par1);
		
		while (var2.find()) {
			result[result.length] = var2.group();
		}
		
		return result;
		
	}
	
	public static final String[] getAtomsDecompilation(String formula) {
		
		String[] result = new String[]{};
		
		Pattern var1 = Pattern.compile(SIMPLE_FORMULA);
		Matcher var2 = var1.matcher(formula);
		
		while (var2.find()) {
			result[result.length] = var2.group();
		}
		
		return result;
		
	}
	
	// 1 character --> C
	// 2 characters --> Either Cu or C2
	// 3 characters --> Either Cu1 or C10
	
//	public static final Atom getAtomBySymbol(String par1) {
//		Atom result;
//		if (isFormula(par1) && par1.length() >= 1) {
//			
//			if (par1.length() == 2) {
//				
//				char firstChar = par1.charAt(0);
//				char scndChar = par1.charAt(1);
//				
//				if (Character.isAlphabetic(scndChar) && Character.isLowerCase(scndChar)) {
//					// Cu
//					
//				}
//				
//			}
//			
//		}
//	}
	
	public static final String getFormula(ICompound... par1) {
		String formula = "";
		int i = 0;
		for (ICompound var: par1) {
			i++;
			formula += var.getCount() + var.getFormula() + (i < par1.length ? " + " : "");
		}
		return formula;
	}

	public static final boolean stackContains(ICompound par1, Element par2) {
		Element[] elements = par1.getElements();
        for (Element element : elements) {
            if (element.equals(par2)) {
                return true;
            }
        }
		return false;
	}
	
	public static final boolean isStackArrayEqualTo(SubstanceStack[] par1, SubstanceStack[] par2) {
		boolean var1 = true;
		if (par1.length != par2.length) return false;
		for (int i = 0; i < par1.length; i++) {
			if (par1[i].equals(par2[i])) {
				continue;
			}
			var1 = false;
		}
		return var1;
	}
	
	public static final boolean isStackEqualTo(SubstanceStack par1, SubstanceStack par2) {
		return par1.equals(par2);
	}
	
}
