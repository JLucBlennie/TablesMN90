package com.jlb.plongee.datamodel;

import java.util.List;

import com.jlb.plongee.datamodel.table.mn90.TablePlongee;
import com.jlb.plongee.datamodel.table.mn90.exception.PalierNonTrouveException;

public class Plongeur {

	private List<Compartiment> mCompartiments;
	private List<Plongee> mPlongees;
	private TablePlongee mTable;
	private String mNom;

	public void Plongeur(String nom) {
		mNom = nom;

		// Initialisation des compartiments
	}

	public void plonge(int i) throws PalierNonTrouveException {
		Plongee plongee = mPlongees.get(i);
		mTable = new TablePlongee(plongee.getProfondeur(), plongee.getTempsPlongee());

	}

	public void ajouterPlongee(Plongee plongee) {
		if (!mPlongees.contains(plongee))
			mPlongees.add(plongee);
	}
}
