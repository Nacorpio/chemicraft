package com.periodiccraft.pcm.helper;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.periodiccraft.pcm.core.element.Element;
import com.periodiccraft.pcm.core.element.Molecule;
import com.periodiccraft.pcm.core.registry.SubstanceRegistry;

public class MoleculeTree
{	
	private MoleculeNode root;
	private int amount;
	private int width;
	private int height;
	
	public MoleculeTree(Element rootData, int amount, int x, int y) 
	{
		root = new MoleculeNode(0, rootData, null, x, y);
		this.amount = amount;
	}
	
	//TODO When dealing with Elements that are longer then just 1 letter, it should automatically insert whitespaces to push the matrix in place.
	public MoleculeTree(String... structure)
	{	
		ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();
		for(String s : structure)
		{
			ArrayList<String> list2 = new ArrayList<String>();
			Pattern p = Pattern.compile("([\\(][A-Z][a-z]*([1-9]+[+-])[\\)])|([A-Z][a-z]*([1-9]+[+-])?)|[=\\-#\\s]");
			Matcher m = p.matcher(s);
			while(m.find())
			{
				String sub = m.group();
				list2.add(sub.replaceAll("[\\(\\)]", ""));
				for(int i = 0; i < sub.length() - 1; i++)
				{
					list2.add(" ");
				}
			}
			matrix.add(list2);
		}
		
		this.width = matrix.get(0).size();
		this.height = matrix.size();
		
		String firstAtom = null;
		
		int x = 0, y = 0;	
		out: for(y = 0; y < height; y++)
		{
			for(x = 0; x < width; x++)
			{
				String el = matrix.get(y).get(x);
				if(isElement(el))
				{
					firstAtom = el;
					break out;
				}
			}
		}

		Element atom = getElement(firstAtom);
		root = new MoleculeNode(0, atom, null, x, y);
		ArrayList<Point> list = new ArrayList<Point>();
		list.add(new Point(x, y));
		structureTree(x, y, list, matrix, root);
	}
	
	private boolean isElement(String e)
	{
		return e.matches("([A-Z][a-z]*([1-9]+[+-])?)");
	}
	
	private Element getElement(String e)
	{
		int charge = 0;
		if(e.endsWith("+") || e.endsWith("-"))
		{
			Matcher matcher = Pattern.compile("[1-9]").matcher(e);
			matcher.find();
			String sub = e.substring(matcher.start(), e.length() - 1);
			charge = Integer.parseInt(sub) * (e.endsWith("-") ? -1 : 1);
		}
		Element atom = SubstanceRegistry.getElementBySymbol(e.replaceAll("[1-9+-]", ""));
		atom.setCharge(charge);
		return atom;
	}
	
	private boolean isValid(int x, int y, ArrayList<ArrayList<String>> matrix)
	{
		if(x >= 0 && y >= 0 && x < matrix.get(0).size() && y < matrix.size())
		{
			return true;
		}
		return false;
	}

	private void structureTreePayload(int x, int y, int xChange, int yChange, ArrayList<Point> list, ArrayList<ArrayList<String>> matrix, MoleculeNode parent)
	{
		String cur;
		if(isValid(x, y, matrix) && !list.contains(new Point(x, y)))
		{
			cur = matrix.get(y).get(x);
			if(cur.matches("[=\\-#]"))
			{
				int binding = cur.matches("[\\-]") ? 1 : cur.matches("[=]") ? 2 : cur.matches("[#]") ? 3 : 0;
				Point p = followBind(x, y, xChange, yChange, matrix);
				if(isValid(p.x, p.y, matrix))
				{
					cur = matrix.get(p.y).get(p.x);			
					MoleculeNode leaf = new MoleculeNode(binding, getElement(cur), parent, p.x, p.y);
					parent.addLeaf(leaf);
					if(!list.contains(p)) 
					{
						list.add(p);
						structureTree(p.x, p.y, list, matrix, leaf);
					}
				}
			}
		}
	}
	
	private void structureTree(int x, int y, ArrayList<Point> list, ArrayList<ArrayList<String>> matrix, MoleculeNode parent)
	{
		structureTreePayload(x - 1, y, -1, 0, list, matrix, parent);
		structureTreePayload(x + 1, y, 1, 0, list, matrix, parent);
		structureTreePayload(x, y - 1, 0, -1, list, matrix, parent);
		structureTreePayload(x, y + 1, 0, 1, list, matrix, parent);	
	}
	
	private Point followBind(int x, int y, int xChange, int yChange, ArrayList<ArrayList<String>> matrix)
	{
		String cur = matrix.get(y).get(x);
		while(!isElement(cur))
		{
			x += xChange;
			y += yChange;
			cur = matrix.get(y).get(x);
		}
		return new Point(x, y);
	}
	
	public Molecule convertToSimpleMolecule()
	{
		return new Molecule(1, getElements(getRoot()));
	}

	public Element[] getElements(MoleculeNode node)
	{
		ArrayList<Element> list = new ArrayList<Element>();
		getElementsRaw(node, list);
		HashMap<Element, Integer> map = new HashMap<Element, Integer>();
		
		for(Element e : list)
		{
			Integer i = map.get(e);
			if(i == null) i = 1;
			else i++;
			map.put(e, i);
		}

		list.clear();
		for(Element a : map.keySet())
		{
			Integer amount = map.get(a);
			list.add(a.clone().setAmount(amount));
		}
		return list.toArray(new Element[list.size()]);
	}
	
	private void getElementsRaw(MoleculeNode node, List<Element> list)
	{
		list.add(node.getValue());
		for(MoleculeNode n2 : node.children) getElementsRaw(n2, list);
	}
	
	public MoleculeNode getRoot()
	{
		return root;
	}
	
	public static class MoleculeNode
	{
		private Element data;
	    private MoleculeNode parent;
	    private List<MoleculeNode> children;
	    private int binding;
	    //TODO (Vic): Could use those for rendering.
	    private int xCoord;
	    private int yCoord;
	    
		public MoleculeNode(int binding, Element e, MoleculeNode parent, int x, int y)
	    {
			children = new ArrayList<MoleculeNode>();
			this.data = e;
			this.parent = parent;
			this.binding = binding;
			this.xCoord = x;
			this.yCoord = y;
	    }
		
		public boolean isLeaf()
		{
			return children.size() == 0;
		}
		
		public void setValue(Element e)
		{
			this.data = e;
		}
		
		public Element getValue()
		{
			return data;
		}
		
		public int getBinding()
		{
			return binding;
		}
		
		public void addLeaf(MoleculeNode node)
		{
			children.add(node);
		}
		
		public MoleculeNode getLeafAt(int id)
		{
			return children.get(id);
		}
		
		public List<MoleculeNode> getChildren()
		{
			return children;
		}

		@Override
		public String toString()
		{
			String out = binding == 1 ? "-" : binding == 2 ? "=" : binding == 3 ? "#" : "";
			out += data.toString();
			if(!isLeaf())
			{
				out += "(" + getChildren().size() + "):[";
				Iterator<MoleculeNode> iterator = getChildren().iterator();
				while(iterator.hasNext())
				{
					out += iterator.next().toString() + (iterator.hasNext() ? ", " : "");
				}
				out += "]";
			}
			return out;
		}
	}
}
