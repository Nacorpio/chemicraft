package com.periodiccraft.pcm.helper;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.directory.InvalidAttributesException;

import com.periodiccraft.pcm.core.element.Atom;
import com.periodiccraft.pcm.core.element.Element;
import com.periodiccraft.pcm.core.element.ICompound;
import com.periodiccraft.pcm.core.element.Molecule;
import com.periodiccraft.pcm.core.registry.SubstanceRegistry;

public class MoleculeTree
{	
	private MoleculeNode root;
	private int amount;
	
	public MoleculeTree(Atom rootData, int amount) 
	{
		root = new MoleculeNode(0, rootData, null);
		this.amount = amount;
	}
	
	//TODO When dealing with Elements that are longer then just 1 letter, it should automatically insert whitespaces to push the matrix in place.
	public MoleculeTree(String... structure)
	{	
		ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();
		for(String s : structure)
		{
			ArrayList<String> list2 = new ArrayList<String>();
			Pattern p = Pattern.compile("([A-Z][a-z]*)|[=\\-#\\s]");
			Matcher m = p.matcher(s);
			while(m.find())
			{
				String sub = m.group();
				list2.add(sub);
			}
			matrix.add(list2);
		}
		
		int width = matrix.get(0).size();
		int height = matrix.size();
		
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

		Atom atom = SubstanceRegistry.getSubstanceBySymbol(firstAtom);
		root = new MoleculeNode(0, atom, null);
		ArrayList<Point> list = new ArrayList<Point>();
		list.add(new Point(x, y));
		structureTree(x, y, list, matrix, root);
	}
	
	private boolean isElement(String e)
	{
		return e.matches("([A-Z][a-z]*)");
	}
	
	private boolean isValid(int x, int y, ArrayList<Point> list, ArrayList<ArrayList<String>> matrix)
	{
		if(x >= 0 && y >= 0 && x < matrix.get(0).size() && y < matrix.size())
		{
			return !list.contains(new Point(x, y));
		}
		return false;
	}
	
	private void structureTree(int x, int y, ArrayList<Point> list, ArrayList<ArrayList<String>> matrix, MoleculeNode parent)
	{
		int x2, y2;
		String cur;
		
		x2 = x - 1; y2 = y;
		if(isValid(x2, y2, list, matrix))
		{
			cur = matrix.get(y2).get(x2);
			if(cur.matches("[=\\-#]"))
			{
				int binding = cur.matches("[\\-]") ? 1 : cur.matches("[=]") ? 2 : cur.matches("[#]") ? 3 : 0;
				Point p = followBind(x2, y2, -1, 0, matrix);
				if(isValid(p.x, p.y, list, matrix))
				{
					cur = matrix.get(p.y).get(p.x);
					list.add(p);
					MoleculeNode leaf = new MoleculeNode(binding, SubstanceRegistry.getSubstanceBySymbol(cur), parent);
					parent.addLeaf(leaf);
					structureTree(p.x, p.y, list, matrix, leaf);
				}
			}
		}
		
		x2 = x + 1; y2 = y;
		if(isValid(x2, y2, list, matrix))
		{
			cur = matrix.get(y2).get(x2);
			if(cur.matches("[=\\-#]"))
			{
				int binding = cur.matches("[\\-]") ? 1 : cur.matches("[=]") ? 2 : cur.matches("[#]") ? 3 : 0;
				Point p = followBind(x2, y2, 1, 0, matrix);
				if(isValid(p.x, p.y, list, matrix))
				{
					cur = matrix.get(p.y).get(p.x);
					list.add(p);
					MoleculeNode leaf = new MoleculeNode(binding, SubstanceRegistry.getSubstanceBySymbol(cur), parent);
					parent.addLeaf(leaf);
					structureTree(p.x, p.y, list, matrix, leaf);
				}
			}
		}
		
		x2 = x; y2 = y + 1;
		if(isValid(x2, y2, list, matrix))
		{
			cur = matrix.get(y2).get(x2);
			if(cur.matches("[=\\-#]"))
			{
				int binding = cur.matches("[\\-]") ? 1 : cur.matches("[=]") ? 2 : cur.matches("[#]") ? 3 : 0;
				Point p = followBind(x2, y2, 0, 1, matrix);
				if(isValid(p.x, p.y, list, matrix))
				{
					cur = matrix.get(p.y).get(p.x);
					list.add(p);
					MoleculeNode leaf = new MoleculeNode(binding, SubstanceRegistry.getSubstanceBySymbol(cur), parent);
					parent.addLeaf(leaf);
					structureTree(p.x, p.y, list, matrix, leaf);
				}
			}
		}
		
		x2 = x; y2 = y - 1;
		if(isValid(x2, y2, list, matrix))
		{
			cur = matrix.get(y2).get(x2);
			if(cur.matches("[=\\-#]"))
			{
				int binding = cur.matches("[\\-]") ? 1 : cur.matches("[=]") ? 2 : cur.matches("[#]") ? 3 : 0;
				Point p = followBind(x2, y2, 0, -1, matrix);
				if(isValid(p.x, p.y, list, matrix))
				{
					cur = matrix.get(p.y).get(p.x);
					list.add(p);
					MoleculeNode leaf = new MoleculeNode(binding, SubstanceRegistry.getSubstanceBySymbol(cur), parent);
					parent.addLeaf(leaf);
					structureTree(p.x, p.y, list, matrix, leaf);
				}
			}
		}
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
		return new Molecule(1, getAtoms(getRoot()));
	}

	public Atom[] getAtoms(MoleculeNode node)
	{
		ArrayList<Atom> list = new ArrayList<Atom>();
		getAtomsRaw(node, list);
		HashMap<Atom, Integer> map = new HashMap<Atom, Integer>();
		
		for(Atom a : list)
		{
			Integer i = map.get(a);
			if(i == null) i = 1;
			else i++;
			map.put(a, i);
		}

		list.clear();
		for(Atom a : map.keySet())
		{
			Integer amount = map.get(a);
			list.add(a.clone().setAmount(amount));
		}
		return list.toArray(new Atom[list.size()]);
	}
	
	private void getAtomsRaw(MoleculeNode node, List<Atom> list)
	{
		list.add(node.getValue());
		for(MoleculeNode n2 : node.children) getAtomsRaw(n2, list);
	}
	
	public MoleculeNode getRoot()
	{
		return root;
	}
	
	public static class MoleculeNode
	{
		private Atom data;
	    private MoleculeNode parent;
	    private List<MoleculeNode> children;
	    private int binding;
	    
		public MoleculeNode(int binding, Atom m, MoleculeNode parent)
	    {
			children = new ArrayList<MoleculeNode>();
			this.data = m;
			this.parent = parent;
			this.binding = binding;
	    }
		
		public boolean isLeaf()
		{
			return children.size() == 0;
		}
		
		public void setValue(Atom m)
		{
			this.data = m;
		}
		
		public Atom getValue()
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
