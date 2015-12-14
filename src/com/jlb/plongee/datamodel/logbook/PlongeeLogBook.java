package com.jlb.plongee.datamodel.logbook;

import java.util.List;

import com.jlb.plongee.datamodel.plongees.Plongee;
import com.jlb.tools.metamodel.Entity;
import com.jlb.tools.metamodel.attributes.impl.IntegerAttribute;
import com.jlb.tools.metamodel.attributes.impl.StringAttribute;

/**
 * Classe decrivant une plongee pour le carnet de plongees Elle contient des
 * participants, la temperature, le type de plongee, un commentaire, ...
 * 
 * @author JLuc
 *
 */
public class PlongeeLogBook extends Plongee {

	public static final String ATTRIBUT_THEME = "Theme";
	public static final String ATTRIBUT_ENVIRONNEMENT = "Environnement";
	public static final String ATTRIBUT_LIEU = "Lieu";
	public static final String ATTRIBUT_COMMENT = "Commentaire";

	static {
		// Definition des type de fils
		mAuthorizedChildrenClass.add(Participant.class);
	}

	public PlongeeLogBook(int id, String name, int profondeur, int tempsPlongee, E_TYPE_THEME typeTheme,
			E_TYPE_ENVIRONNEMENT typeEnvironnement, E_TYPE_LIEU typeLieu) {
		super(id, name, profondeur, tempsPlongee);

		IntegerAttribute attrTheme = new IntegerAttribute(ATTRIBUT_THEME, typeTheme.getIndex());
		mAttributes.add(attrTheme);

		IntegerAttribute attrEnv = new IntegerAttribute(ATTRIBUT_ENVIRONNEMENT, typeEnvironnement.getIndex());
		mAttributes.add(attrEnv);

		IntegerAttribute attrLieu = new IntegerAttribute(ATTRIBUT_LIEU, typeLieu.getIndex());
		mAttributes.add(attrLieu);

		StringAttribute attrComment = new StringAttribute(ATTRIBUT_COMMENT, "");
		mAttributes.add(attrComment);
	}

	public void addComment(String comment) {
		getAttribute(ATTRIBUT_COMMENT).setValue(comment);
	}

	public void addParticipant(Participant participant) {
		if (!mChildren.contains(participant)) {
			participant.setParent(this);
			mChildren.add(participant);
		}
	}

	public List<Entity> getParticipants() {
		return getChildrenOfType(Participant.class.getName());
	}
}
