package com.jlb.plongee.datamodel.logbook;

public enum E_TYPE_LIEU {

	MER(0, "Mer"), CARRIERE(1, "Carrière"), LAC(2, "Lac");

	private int mIndex;
	private String mName;

	E_TYPE_LIEU(int index, String name) {
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
