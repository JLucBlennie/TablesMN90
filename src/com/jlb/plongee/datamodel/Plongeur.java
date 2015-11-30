package com.jlb.plongee.datamodel;

import java.util.List;

import com.jlb.plongee.datamodel.table.mn90.TablePlongee;
import com.jlb.plongee.datamodel.table.mn90.exception.PalierNonTrouveException;
import com.jlb.tools.metamodel.Entity;
import com.jlb.tools.metamodel.attributes.impl.IntegerAttribute;
import com.jlb.tools.metamodel.attributes.impl.StringAttribute;

public class Plongeur extends Entity {

	private List<Compartiment> mCompartiments;
	private List<Plongee> mPlongees;
	private TablePlongee mTable;

	public Plongeur(int id, String nom) {
		StringAttribute attrName = new StringAttribute("Nom", nom);
		mAttributes.add(attrName);
		IntegerAttribute attrId = new IntegerAttribute("ID", id);
		mAttributes.add(attrId);
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
