package com.periodiccraft.pcm.data;

import com.periodiccraft.pcm.api.data.IColumn;
import com.periodiccraft.pcm.api.data.IRow;
import com.periodiccraft.pcm.api.data.IDatabase;
import com.periodiccraft.pcm.api.data.IField;
import com.periodiccraft.pcm.api.data.ISerializable;
import com.periodiccraft.pcm.api.data.ITable;

public class Row implements IRow, ISerializable {

	private ITable parentTable;
	private IDatabase parentDatabase;
	
	private int index;
	
	public Row(ITable par1, int par2) {
		this.parentTable = par1;
		this.parentDatabase = par1.getDatabaseParent();
		this.index = par2;
	}
	
	/**
	 * Returns the index of this row in the table.
	 * @return the index.
	 */
	public int getIndex() {
		return index;
	}
	
	@Override
	public ITable getParentTable() {
		return parentTable;
	}

	@Override
	public IDatabase getParentDatabase() {
		return parentDatabase;
	}

	@Override
	public IField[] getFields() {
		IField[] var1 = new IField[] {};
		for (int i = 0; i < parentTable.getColumns().size(); i++) {
			IColumn var2 = parentTable.getColumn(i);
			var1[i] = var2.getData(index);
		}
		return var1;
	}

	@Override
	public String getSerializedString() {
		return "";
	}

}
