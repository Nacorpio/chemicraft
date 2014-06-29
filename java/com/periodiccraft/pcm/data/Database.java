package com.periodiccraft.pcm.data;

import java.util.ArrayList;
import java.util.List;

import com.periodiccraft.pcm.api.data.IColumn;
import com.periodiccraft.pcm.api.data.IDatabase;
import com.periodiccraft.pcm.api.data.IField;
import com.periodiccraft.pcm.api.data.ITable;

public class Database implements IDatabase {

	private String name;
	private List<ITable> tables = new ArrayList<ITable>();
	
	private int columnLimit = 1000;
	private int tableLimit = 20;
	
	public Database(String par1) {
		this.name = par1;
	}
	
	public final void setColumnLimit(int par1) {
		this.columnLimit = par1;
	}
	
	public final void setTableLimit(int par1) {
		this.tableLimit = par1;
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
	public int getTableLimit() {
		return tableLimit;
	}

	@Override
	public int getColumnLimit() {
		return columnLimit;
	}

	public int getColumnCount() {
		int result = 0;
		for (ITable var: tables) {
			result += var.getColumns().size();
		}
		return result;
	}
	
	@Override
	public void addColumn(ITable par1, String par2) {
		if (getColumnCount() + 1 < this.columnLimit) {
			if (!par1.hasColumn(par2))
				par1.addColumn(par2);
		}
	}

	@Override
	public void addColumn(ITable par1, String par2, List<IField> par3) {
		if (getColumnCount() + 1 < this.columnLimit) {
			IField[] var1 = new IField[]{};
			if (!par1.hasColumn(par2)) {
				par3.toArray(var1);
				par1.addColumn(par2).addFields(var1);
			}
		}		
	}

	@Override
	public void addColumn(ITable par1, String par2, IField... par3) {
		if (getColumnCount() + 1 < this.columnLimit) {
			if (!par1.hasColumn(par2)) {
				par1.addColumn(par2).addFields(par3);
			}
		}	
	}

	public boolean hasTable(String par1) {
		for (ITable var: tables) {
			if (var.getName().equalsIgnoreCase(par1))
				return true;
		}
		return false;
	}
	
	@Override
	public ITable addTable(String par1) {
		if (this.tables.size() + 1 < this.tableLimit) {
			if (!hasTable(par1)) {
				Table var1 = new Table(this, par1);
				tables.add(var1);
				return var1;
			}
			return null;
		}
		return null;
	}

	@Override
	public ITable addTable(String par1, List<IColumn> par2) {
		if (this.tables.size() + 1 < this.tableLimit) {
				if (!hasTable(par1)) {
					Table var1 = new Table(this, par1);
					for (IColumn var: par2) {
						var1.addColumn(var);
					}
					return var1;
				}
				return null;
		}
		return null;
	}

	@Override
	public ITable addTable(String par1, IColumn... par2) {
		if (this.tables.size() + 1 < this.tableLimit) {
			if (!hasTable(par1)) {
				Table var1 = new Table(this, par1);
				for (IColumn var: par2) {
					var1.addColumn(var);
				}
				return var1;
			}
			return null;
		}
		return null;
	}

	@Override
	public ITable getTable(String par1) {
		for (ITable var: tables) {
			if (var.getName().equalsIgnoreCase(par1))
				return var;
		}
		return null;
	}

	@Override
	public ITable getTable(int par1) {
		return tables.get(par1);
	}

	@Override
	public List<ITable> getTables() {
		return tables;
	}

}
