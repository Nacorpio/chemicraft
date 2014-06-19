package com.periodiccraft.pcm.api.data;

import java.util.List;

public interface IColumn extends ISerializable {

	/**
	 * Returns the name of the column.
	 * @return the name.
	 */
	String getName();
	
	/**
	 * Returns the type of data stored in this column.
	 * @return the type of data.
	 */
	EnumColumnType getType();
	
	/**
	 * Returns the parent table of this column.
	 * @return the parent table.
	 */
	ITable getParentTable();
	
	/**
	 * Adds a new field to the column.
	 * @param par1 the field.
	 * @return the new field for convenience.
	 */
	IField addField(IField par1);
	
	/**
	 * Adds the specified fields to the column.
	 * @param par1 the fields.
	 * @return the new fields for convenience.
	 */
	IField[] addFields(IField... par1);
	
	/**
	 * Returns the field at the specified column index.
	 * @param par1 the index.
	 * @return the field.
	 */
	IField getData(int par1);
	
	/**
	 * Returns a list containing all the fields in this column.
	 * @return a list of all fields.
	 */
	List<IField> getData();
	
}
