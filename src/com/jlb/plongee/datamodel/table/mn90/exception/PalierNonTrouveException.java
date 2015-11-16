package com.jlb.plongee.datamodel.table.mn90.exception;

public class PalierNonTrouveException extends Exception {

	public PalierNonTrouveException(int profondeur, int temps) {
		super("Palier non trouve dans la table pour Profondeur = " + profondeur + " et le temps = " + temps);
	}
}
