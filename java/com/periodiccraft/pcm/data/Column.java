package com.periodiccraft.pcm.data;

import java.util.ArrayList;
import java.util.List;

import com.periodiccraft.pcm.api.data.EnumColumnType;
import com.periodiccraft.pcm.api.data.IColumn;
import com.periodiccraft.pcm.api.data.IField;
import com.periodiccraft.pcm.api.data.ITable;

public class Column implements IColumn {

	private String name;
	private EnumColumnType type = EnumColumnType.STRING;
	private List<IField> fields = new ArrayList<IField>();
	
	private ITable parent;
	
	public Column(ITable par, String par1, EnumColumnType par2) {
		if (par1.length() > 0 && !par1.isEmpty() && par2 != null) {
			this.parent = par;
			this.name = par1;
			this.type = par2;
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
	public EnumColumnType getType() {
		return type;
	}

	@Override
	public IField addField(IField par1) {
		fields.add(par1);
		return par1;
	}
	
	@Override
	public IField[] addFields(IField... par1) {
		for (IField var: par1) {
			fields.add(var);
		}
		return par1;
	}

	@Override
	public IField getData(int par1) {
		return fields.get(par1);
	}

	@Override
	public List<IField> getData() {
		return fields;
	}

	@Override
	public ITable getParentTable() {
		return parent;
	}

}
