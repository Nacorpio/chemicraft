package com.periodiccraft.pcm.api.data;

public interface IRow {

	/**
	 * Returns the table that owns the fields and columns.
	 * @return the parent table.
	 */
	ITable getParentTable();
	
	/**
	 * Returns the database that owns all the data.
	 * @return the parent database.
	 */
	IDatabase getParentDatabase();
	
	/**
	 * Returns the fields in this datafield.
	 * @return the fields.
	 */
	IField[] getFields();
	
}
