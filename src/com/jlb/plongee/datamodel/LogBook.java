package com.jlb.plongee.datamodel;

import java.util.List;

import com.jlb.plongee.datamodel.plongees.PlongeeLogBook;
import com.jlb.tools.metamodel.Entity;

/**
 * Classe decrivant un carnet de plongees Elle contient des plongees pour le
 * carnet avec plus d'attributs que la plongee pour Exercice de Table
 * 
 * @author JLuc
 *
 */
public class LogBook extends Entity {

	static {
		// Definition des type de fils
		mAuthorizedChildrenClass.add(PlongeeLogBook.class);
	}

	public LogBook(int id) {
		this.mId = id;

	}

	public void addPlongee(PlongeeLogBook plongee) {
		if (!mChildren.contains(plongee)) {
			plongee.setParent(this);
			mChildren.add(plongee);
		}
	}

	public void removePlongee(PlongeeLogBook plongee) {
		if (mChildren.contains(plongee)) {
			mChildren.remove(plongee);
		}
	}

	public int getNbPlongees() {
		return getChildrenOfType(PlongeeLogBook.class.getName()).size();
	}

	public List<Entity> getPlongees() {
		return getChildrenOfType(PlongeeLogBook.class.getName());
	}
}
