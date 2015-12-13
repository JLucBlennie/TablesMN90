package com.jlb.plongee.datamodel.plongees;

import com.jlb.plongee.datamodel.exercices.E_TYPE_PLONGEE_EXERCICE;
import com.jlb.tools.metamodel.attributes.impl.IntegerAttribute;

public class PlongeeExercice extends Plongee {

	public static final String ATTRIBUT_TYPE = "Type";

	public PlongeeExercice(int id, String name, int profondeur, int tempsPlongee, E_TYPE_PLONGEE_EXERCICE type) {
		super(id, name, profondeur, tempsPlongee);
		IntegerAttribute attrType = new IntegerAttribute(ATTRIBUT_TYPE, type.getIndex());
		mAttributes.add(attrType);
	}

}
