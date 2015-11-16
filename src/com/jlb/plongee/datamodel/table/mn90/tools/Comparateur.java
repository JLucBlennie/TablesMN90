package com.jlb.plongee.datamodel.table.mn90.tools;

import java.util.Comparator;

import com.jlb.plongee.datamodel.table.mn90.LignePalierGPS;

public class Comparateur implements Comparator<LignePalierGPS> {

	public Comparateur() {
	}

	@Override
	public int compare(LignePalierGPS o1, LignePalierGPS o2) {

		int j = o1.getProfondeur();
		int t = o2.getProfondeur();

		if (j == t) {
			int tpsPlongee1 = o1.getTempsPlongee();
			int tpsPlongee2 = o2.getTempsPlongee();
			// j et t n'on pas boug�, donc sera toujour vrai if(j==t) plutot
			// faire cela
			return new Integer(tpsPlongee1).compareTo(new Integer(tpsPlongee2));
		}

		//
		return new Integer(j).compareTo(new Integer(t));
	}
}
