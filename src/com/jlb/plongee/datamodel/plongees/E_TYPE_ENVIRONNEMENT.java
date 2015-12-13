package com.jlb.plongee.datamodel.plongees;

public enum E_TYPE_ENVIRONNEMENT {

	EPAVE(0, "Epave"), TOMBANT(1, "Tombant"), ROCHES(2, "Roches"), SABLE(3, "Sable"), PATATE_CORAIL(4,
			"Patates de Corail");

	private int mIndex;
	private String mName;

	E_TYPE_ENVIRONNEMENT(int index, String name) {
		this.mIndex = index;
		this.mName = name;
	}

	public int getIndex() {
		return mIndex;
	}

	public void setIndex(int index) {
		this.mIndex = index;
	}

	public String getName() {
		return mName;
	}
}
