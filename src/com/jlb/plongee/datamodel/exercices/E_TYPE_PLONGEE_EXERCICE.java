package com.jlb.plongee.datamodel.exercices;

import java.util.ArrayList;
import java.util.List;

public enum E_TYPE_PLONGEE_EXERCICE {

	SIMPLE(0, "Simple"), REMONTEE_RAPIDE(1, "Remontée rapide"), INTERRUPTION_PALIER(2,
			"Interruption de palier"), REMONTEE_LENTE(3, "Remontée lente");

	private int mIndex;
	private String mLabel;

	E_TYPE_PLONGEE_EXERCICE(int index, String lbl) {
		this.mIndex = index;
		this.mLabel = lbl;
	}

	public int getIndex() {
		return mIndex;
	}

	public String getLabel() {
		return mLabel;
	}

	public static List<String> getNames() {
		List<String> result = new ArrayList<String>();

		for (int i = 0; i < 4; i++) {
			result.add(E_TYPE_PLONGEE_EXERCICE.values()[i].mLabel);
		}
		return result;
	}
}
