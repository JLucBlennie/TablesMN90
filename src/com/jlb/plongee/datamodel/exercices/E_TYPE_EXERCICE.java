package com.jlb.plongee.datamodel.exercices;

public enum E_TYPE_EXERCICE {

	SIMPLE(0), CONSECUTIVE(1), SUCCESSIVE(2);

	private int mIndex;

	E_TYPE_EXERCICE(int index) {
		this.mIndex = index;
	}

	public int getIndex() {
		return mIndex;
	}
}
