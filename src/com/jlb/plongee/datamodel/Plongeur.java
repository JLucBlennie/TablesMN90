package com.jlb.plongee.datamodel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.datamodel.table.mn90.exception.PalierNonTrouveException;
import com.jlb.tools.csv.CSVReader;
import com.jlb.tools.metamodel.Entity;
import com.jlb.tools.metamodel.attributes.impl.StringAttribute;

public class Plongeur extends Entity {

	public static final String ATTRIBUTE_NAME = "Nom";

	private static final String COMPARTIMENT_FILENAME = "resources/mn90/compartiments.mn90";
	private static List<Compartiment> mCompartiments = new ArrayList<Compartiment>();

	static {
		// Chargement du fichiers de resources mn90/compartiments.mn90
		try {
			List<String[]> lignesCSV = CSVReader.readFile(new File(COMPARTIMENT_FILENAME));
			for (String[] ligneCSV : lignesCSV) {
				int periode = Integer.parseInt(ligneCSV[0]);
				double sc = Double.parseDouble(ligneCSV[1]);
				Compartiment comp = new Compartiment(periode, sc);
				mCompartiments.add(comp);
			}
		} catch (IOException e) {
			MN90.getLogger().error(Plongeur.class, "Probleme durant la lecture du fichier " + COMPARTIMENT_FILENAME, e);
		}
	}

	public Plongeur(int id, String nom) {
		this.mId = id;
		StringAttribute attrName = new StringAttribute(ATTRIBUTE_NAME, nom);
		mAttributes.add(attrName);
	}

	public void plonge(int i) throws PalierNonTrouveException {
		Plongee plongee = (Plongee) getChildOfType(Plongee.class.getName(), i);
		MN90.getLogger().debug(this, "Calcul de " + plongee);
		plongee.plonge();
	}

	public void ajouterPlongee(Plongee plongee) {
		if (!mChildren.contains(plongee)) {
			plongee.setParent(this);
			mChildren.add(plongee);
		}
	}

	public void supprimerPlongee(Plongee plongee) {
		if (mChildren.contains(plongee)) {
			mChildren.remove(plongee);
		}
	}

	@Override
	public String toString() {
		return "Plongeur (" + this.mId + ") " + this.getAttribute(ATTRIBUTE_NAME).getValue() + " - nb Plongees "
				+ getChildrenOfType(Plongee.class.getName()).size();
	}
}
