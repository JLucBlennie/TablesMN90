package com.jlb.plongee.datamodel.logbook;

import com.jlb.tools.metamodel.Entity;
import com.jlb.tools.metamodel.attributes.impl.IntegerAttribute;
import com.jlb.tools.metamodel.attributes.impl.StringAttribute;

public class Participant extends Entity {

	public static final String ATTRIBUT_NAME = "Nom";
	public static final String ATTRIBUT_NIVEAU = "Niveau";

	public Participant(int id, String name, E_NIVEAU niveau) {
		this.mId = id;

		StringAttribute attrName = new StringAttribute(ATTRIBUT_NAME, name);
		mAttributes.add(attrName);

		IntegerAttribute attrNiveau = new IntegerAttribute(ATTRIBUT_NIVEAU, niveau.getIndex());
		mAttributes.add(attrNiveau);
	}

	@Override
	public String toString() {
		return getAttribute(ATTRIBUT_NAME).getValue() + " - "
				+ E_NIVEAU.values()[(int) getAttribute(ATTRIBUT_NIVEAU).getValue()];
	}
}
