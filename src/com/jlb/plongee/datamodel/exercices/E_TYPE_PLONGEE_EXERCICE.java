package com.jlb.plongee.datamodel.exercices;

public enum E_TYPE_PLONGEE_EXERCICE {

	SIMPLE(0), REMONTEE_RAPIDE(1), INTERRUPTION_PALIER(2), REMONTEE_LENTE(3), CONSECUTIVES(4), SUCCESSIVES(5);

	private int mIndex;

	E_TYPE_PLONGEE_EXERCICE(int index) {
		this.mIndex = index;
	}

	public int getIndex() {
		return mIndex;
	}
}
