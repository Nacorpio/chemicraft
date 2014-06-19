package com.periodiccraft.pcm.api.data;

import java.util.List;

public interface IDatabase extends ISerializable {

	// Properties \\
	
		String getName();
	
		
		// - Limits
		
			int getTableLimit();
			
			int getColumnLimit();
	
	
	// Columns \\
	
		/**
		 * Add a column in the specified table with the specified name.<br>
		 * The type can not be specified here as of now.
		 * @param par1 the table.
		 * @param par2 the name.
		 */
		void addColumn(ITable par1, String par2);
		
		/**
		 * Add a column in the specified table with the specified name and fields.<br>
		 * The type can not be specified here as of now.
		 * @param par1 the table.
		 * @param par2 the name.
		 * @param par3 the fields.
		 */
		void addColumn(ITable par1, String par2, List<IField> par3);
		
		/**
		 * Add a column in the specified table witht the specified name and fields.<br>
		 * The type can not be specified here as of now.
		 * @param par1 the table.
		 * @param par2 the name.
		 * @param par3 the fields.
		 */
		void addColumn(ITable par1, String par2, IField... par3);
	
	
	// Tables \\
	
		/**
		 * Add a new table with the specified name.
		 * @param par1 the name.
		 */
		ITable addTable(String par1);
		
		/**
		 * Add a new table with the specified name and columns.
		 * @param par1 the name.
		 * @param par2 the columns.
		 */
		ITable addTable(String par1, List<IColumn> par2);
		
		/**
		 * Add a new table with the specified name and columns.
		 * @param par1 the name.
		 * @param par2 the columns.
		 */
		ITable addTable(String par1, IColumn... par2);
		
		
		/**
		 * Returns the table with the specified name.
		 * @param par1 the name.
		 * @return the table.
		 */
		ITable getTable(String par1);
		
		/**
		 * Returns the table at the specified index.
		 * @param par1 the index.
		 * @return the table.
		 */
		ITable getTable(int par1);
		
		/**
		 * Returns all the tables
		 * @return
		 */
		List<ITable> getTables();
	
}
