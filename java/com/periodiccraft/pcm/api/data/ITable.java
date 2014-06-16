package com.periodiccraft.pcm.api.data;

import java.util.List;

public interface ITable extends ISerializable {
	
	// Properties \\
	
	/**
	 * Returns the name of the table.
	 * @return the name.
	 */
	String getName();
	
	/**
	 * Returns the parent database of this table.
	 * @return the parent database.
	 */
	IDatabase getDatabaseParent();
	
	// Columns \\
	
	IColumn addColumn(IColumn par1);
	
	/**
	 * Add a new column with the specified name.
	 * @param par1 the name.
	 * @return returns the column for convenience.
	 */
	IColumn addColumn(String par1);
	
	/**
	 * Add a new column with the specified name and type of data.
	 * @param par1 the name.
	 * @param par2 the type of data.
	 * @return returns the column for convenience.
	 */
	IColumn addColumn(String par1, EnumColumnType par2);
	
	/**
	 * Returns whether the table has a column with the specified name.
	 * @param par1 the name.
	 * @return whether the column exists.
	 */
	boolean hasColumn(String par1);
	
	/**
	 * Returns the column with the specified name.
	 * @param par1 the name of the column.
	 * @return the column.
	 */
	IColumn getColumn(String par1);
	
	/**
	 * Returns the column at the specified index.
	 * @param par1 the index.
	 * @return the column.
	 */
	IColumn getColumn(int par1);
	
	/**
	 * Returns all the columns of the Table.
	 * @return the columns.
	 */
	List<IColumn> getColumns();
	
}
