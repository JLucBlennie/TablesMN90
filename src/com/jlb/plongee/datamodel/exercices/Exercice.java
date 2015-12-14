package com.jlb.plongee.datamodel.exercices;

import com.jlb.tools.metamodel.Entity;
import com.jlb.tools.metamodel.attributes.impl.IntegerAttribute;
import com.jlb.tools.metamodel.attributes.impl.StringAttribute;

/**
 * Classe decrivant un Exercice de Table de plongee Elle contient des plongees
 * pour les exercices.
 * 
 * @author JLuc
 *
 */
public class Exercice extends Entity {
	public final static String ATTRIBUTE_NAME = "Nom";
	public final static String ATTRIBUTE_TYPE = "Type";

	static {
		// Definition des type de fils
		mAuthorizedChildrenClass.add(PlongeeExercice.class);
	}

	public Exercice(int id, String nom, E_TYPE_EXERCICE type) {
		this.mId = id;

		StringAttribute attrName = new StringAttribute(ATTRIBUTE_NAME, nom);
		mAttributes.add(attrName);
		IntegerAttribute attrType = new IntegerAttribute(ATTRIBUTE_TYPE, type.getIndex());
		mAttributes.add(attrType);
	}
}
