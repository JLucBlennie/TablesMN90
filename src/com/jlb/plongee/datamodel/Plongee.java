package com.jlb.plongee.datamodel;

import com.jlb.plongee.datamodel.table.mn90.TablePlongee;
import com.jlb.plongee.datamodel.table.mn90.exception.PalierNonTrouveException;
import com.jlb.tools.metamodel.Entity;
import com.jlb.tools.metamodel.attributes.impl.IntegerAttribute;

public class Plongee extends Entity {

	public static final String ATTRIBUTE_PROFONDEUR = "profondeur";
	public static final String ATTRIBUTE_PROFONDEUR_UNIT = "m";
	public static final String ATTRIBUTE_TEMPS_PLONGEES = "tempsplongee";
	public static final String ATTRIBUTE_TEMPS_PLONGEE_UNIT = "min";
	private TablePlongee mTablePlongee;

	public Plongee(int id, int profondeur, int tempsPlongee) {
		this.mId = id;
		IntegerAttribute attrProfondeur = new IntegerAttribute(ATTRIBUTE_PROFONDEUR, profondeur,
				ATTRIBUTE_PROFONDEUR_UNIT);
		mAttributes.add(attrProfondeur);
		IntegerAttribute attrTempsPlongee = new IntegerAttribute(ATTRIBUTE_TEMPS_PLONGEES, tempsPlongee,
				ATTRIBUTE_TEMPS_PLONGEE_UNIT);
		mAttributes.add(attrTempsPlongee);
	}

	public void plonge() throws PalierNonTrouveException {
		mTablePlongee = new TablePlongee(getProfondeur(), getTempsPlongee());
	}

	public String getGPS() {
		return mTablePlongee.getGPS();
	}

	public int getNbPaliers() {
		return mTablePlongee.getNbPaliers();
	}

	public int getTpsPalier(int profPalier) {
		switch (profPalier) {
		case 3: // Palier 3m
			return mTablePlongee.getTpsP3M();
		case 6: // Palier 6m
			return mTablePlongee.getTpsP6M();
		case 9: // Palier 9m
			return mTablePlongee.getTpsP9M();
		case 12: // Palier 12m
			return mTablePlongee.getTpsP12M();
		case 15: // Palier 15m
			return mTablePlongee.getTpsP15M();
		default:
			return 0;
		}
	}

	public int getProfondeur() {
		return (int) getAttribute(ATTRIBUTE_PROFONDEUR).getValue();
	}

	public int getTempsPlongee() {
		return (int) getAttribute(ATTRIBUTE_TEMPS_PLONGEES).getValue();
	}

	@Override
	public String toString() {
		return "Plongee [" + getProfondeur() + " " + ATTRIBUTE_PROFONDEUR_UNIT + " ; " + getTempsPlongee() + " "
				+ ATTRIBUTE_TEMPS_PLONGEE_UNIT + "]";
	}
}
