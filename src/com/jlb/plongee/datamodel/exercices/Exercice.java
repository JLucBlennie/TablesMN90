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
	public final static String ATTRIBUTE_NAME = DICO_PROPERTIES.getString("datamodel.exercice.attribut.name");
	public final static String ATTRIBUTE_TYPE = DICO_PROPERTIES.getString("datamodel.exercice.attribut.type");

	public Exercice() {
		super();
		// Definition des type de fils
		mAuthorizedChildrenClass.add(PlongeeExercice.class);

		// Definition des attributs
		StringAttribute attrName = new StringAttribute(ATTRIBUTE_NAME);
		mAttributes.add(attrName);
		IntegerAttribute attrType = new IntegerAttribute(ATTRIBUTE_TYPE);
		mAttributes.add(attrType);
	}

	public Exercice(int id, String nom, E_TYPE_EXERCICE type) {
		this.mId = id;

		// Definition des attributs
		StringAttribute attrName = new StringAttribute(ATTRIBUTE_NAME, nom);
		mAttributes.add(attrName);
		IntegerAttribute attrType = new IntegerAttribute(ATTRIBUTE_TYPE, type.getIndex());
		mAttributes.add(attrType);
	}
}
