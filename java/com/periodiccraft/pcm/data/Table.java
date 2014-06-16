package com.periodiccraft.pcm.data;

import java.util.ArrayList;
import java.util.List;

import com.periodiccraft.pcm.api.data.EnumColumnType;
import com.periodiccraft.pcm.api.data.IColumn;
import com.periodiccraft.pcm.api.data.IDatabase;
import com.periodiccraft.pcm.api.data.ITable;

public class Table implements ITable {

	private String name;
	private IDatabase parent;
	private List<IColumn> columns = new ArrayList<IColumn>();
	
	public Table(IDatabase par, String par1) {
		if (par1.length() > 0 && !par1.isEmpty()) {
			this.parent = par;
			this.name = par1;
		}
	}
	
	@Override
	public String getSerializedString() {
		return "";
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public IColumn addColumn(String par1) {
		return addColumn(par1, EnumColumnType.STRING);
	}

	@Override
	public IColumn addColumn(String par1, EnumColumnType par2) {
		if (!hasColumn(par1)) {
			Column var1 = new Column(this, par1, par2);
			columns.add(var1);
			return var1;
		}
		return null;
	}

	@Override
	public boolean hasColumn(String par1) {
		for (IColumn var: columns) {
			if (var.getName().equalsIgnoreCase(par1))
				return true;
		}
		return false;
	}

	@Override
	public IColumn getColumn(String par1) {
		for (IColumn var: columns) {
			if (var.getName().equalsIgnoreCase(par1))
				return var;
		}
		return null;
	}

	@Override
	public IColumn getColumn(int par1) {
		return columns.get(par1);
	}

	@Override
	public List<IColumn> getColumns() {
		return columns;
	}

	@Override
	public IDatabase getDatabaseParent() {
		return parent;
	}

	@Override
	public IColumn addColumn(IColumn par1) {
		columns.add(par1);
		return par1;
	}

}
