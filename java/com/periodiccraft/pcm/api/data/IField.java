package com.periodiccraft.pcm.api.data;

public interface IField extends ISerializable {

	/**
	 * Returns the index of the field.
	 * @return the index.
	 */
	int getIndex();
	
	/**
	 * Set the data of this field.
	 * @param par1 the data.
	 */
	void setData(Object par1);
	
	/**
	 * Returns the data of this field.
	 * @return the data.
	 */
	Object getData();
	
	/**
	 * Returns the size of this data.
	 * @return the size.
	 */
	float getSize();
	
	/**
	 * Returns the name of the parent column.
	 * @return the name.
	 */
	String getColumnName();
	
	/**
	 * Returns the type of data the parent column accepts.
	 * @return the type of data.
	 */
	EnumColumnType getColumnType();
	
	
	// Parents \\
	
	/**
	 * Returns the parent database of this field.
	 * @return the parent database.
	 */
	IDatabase getParentDatabase();
	
	/**
	 * Returns the parent table of this field.
	 * @return the parent table.
	 */
	ITable getParentTable();
	
	/**
	 * Returns the parent column of this field.
	 * @return the parent column.
	 */
	IColumn getParentColumn();
	
}
