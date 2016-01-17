package com.jlb.plongee.datamodel.exercices;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.datamodel.plongees.PlongeeExercice;
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
		// Definition des type de fils
		mAuthorizedChildrenClass.add(PlongeeExercice.class);

		// Definition des attributs
		StringAttribute attrName = new StringAttribute(ATTRIBUTE_NAME, nom);
		mAttributes.add(attrName);
		IntegerAttribute attrType = new IntegerAttribute(ATTRIBUTE_TYPE, type.getIndex());
		mAttributes.add(attrType);
	}

	public void addPlongee(PlongeeExercice plongee) {
		if ((getChildrenOfType(PlongeeExercice.class.getName()).size() <= 1 && (E_TYPE_EXERCICE
				.values()[(int) getAttribute(ATTRIBUTE_TYPE).getValue()] == E_TYPE_EXERCICE.CONSECUTIVE
				|| E_TYPE_EXERCICE
						.values()[(int) getAttribute(ATTRIBUTE_TYPE).getValue()] == E_TYPE_EXERCICE.SUCCESSIVE))
				|| (getChildrenOfType(PlongeeExercice.class.getName()).size() == 0 && E_TYPE_EXERCICE
						.values()[(int) getAttribute(ATTRIBUTE_TYPE).getValue()] == E_TYPE_EXERCICE.SIMPLE)) {
			if (!mChildren.contains(plongee)) {
				MN90.getLogger().debug(this, "Ajout de la plongee " + plongee);
				plongee.setParent(this);
				mChildren.add(plongee);
			}
		} else {
			MN90.getLogger().debug(this,
					"Il y a deja " + getChildrenOfType(PlongeeExercice.class.getName()).size()
							+ " Plongees dans l'exercice de type "
							+ E_TYPE_EXERCICE.values()[(int) getAttribute(ATTRIBUTE_TYPE).getValue()]);
		}
	}

	@Override
	public String toString() {
		return (String) getAttribute(ATTRIBUTE_NAME).getValue();
	}
}
