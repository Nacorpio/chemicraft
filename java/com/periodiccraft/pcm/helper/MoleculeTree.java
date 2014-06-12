package com.periodiccraft.pcm.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.periodiccraft.pcm.core.element.Atom;
import com.periodiccraft.pcm.core.element.IMolecule;
import com.periodiccraft.pcm.core.element.SimpleMolecule;

public class MoleculeTree
{	
	private MoleculeNode root;
	private int amount;
	
	public MoleculeTree(Atom rootData, int amount) 
	{
		root = new MoleculeNode(0, rootData, null);
		this.amount = amount;
	}
	
	public MoleculeTree(String... structure)
	{
		root = null;
	}
	
	public SimpleMolecule convertToSimpleMolecule()
	{
		return new SimpleMolecule(1, getAtoms(getRoot()));
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
		return (Atom[]) list.toArray();
	}
	
	private void getAtomsRaw(MoleculeNode node, List<Atom> list)
	{
		if(node.isLeaf()) list.add(node.getValue());
		else for(MoleculeNode n2 : node.children) getAtomsRaw(n2, list);
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
	}
}
