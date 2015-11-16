package com.jlb.plongee.datamodel;

import com.jlb.plongee.datamodel.table.mn90.LignePalierGPS;

public class Plongee {

	private int mProfondeur;
	private int mTempsPlongee;
	private LignePalierGPS mTablePlongee;

	public int getProfondeur() {
		return mProfondeur;
	}

	public int getTempsPlongee() {
		return mTempsPlongee;
	}
}
