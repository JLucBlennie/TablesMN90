package com.jlb.plongee.datamodel.plongees;

public enum E_TYPE_THEME {

	EXERCICE(0, "Exercice"), EXPLORATION(1, "Exploration"), ORIENTATION(2, "Orientation");

	private int mIndex;
	private String mName;

	E_TYPE_THEME(int index, String name) {
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
