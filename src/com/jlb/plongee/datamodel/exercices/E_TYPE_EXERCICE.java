package com.jlb.plongee.datamodel.exercices;

public enum E_TYPE_EXERCICE {

	UNE_PLONGEE(0), DEUX_PLONGEES(1);

	private int mIndex;

	E_TYPE_EXERCICE(int index) {
		this.mIndex = index;
	}

	public int getIndex() {
		return mIndex;
	}
}
