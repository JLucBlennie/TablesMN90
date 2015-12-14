package com.jlb.plongee.datamodel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.datamodel.exercices.Exercice;
import com.jlb.plongee.datamodel.logbook.LogBook;
import com.jlb.plongee.datamodel.logbook.PlongeeLogBook;
import com.jlb.plongee.datamodel.plongees.Plongee;
import com.jlb.plongee.datamodel.table.mn90.exception.PalierNonTrouveException;
import com.jlb.tools.csv.CSVReader;
import com.jlb.tools.metamodel.Entity;
import com.jlb.tools.metamodel.attributes.impl.StringAttribute;

/**
 * Classe decrivant un plongeur. Un plongeur a un carnet de plongees et aussi
 * des Exercices de Table de plongees
 * 
 * @author JLuc
 *
 */
public class Plongeur extends Entity {

	public static final String ATTRIBUTE_NAME = DICO_PROPERTIES.getString("datamodel.plongeur.attribut.name");

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

	public Plongeur() {
		super();
		// Definition des type de fils
		mAuthorizedChildrenClass.add(Exercice.class);
		mAuthorizedChildrenClass.add(LogBook.class);

		// Definition des Attributs
		StringAttribute attrName = new StringAttribute(ATTRIBUTE_NAME);
		mAttributes.add(attrName);
	}

	public Plongeur(int id, String nom) {
		this.mId = id;
		// Definition des type de fils
		mAuthorizedChildrenClass.add(Exercice.class);
		mAuthorizedChildrenClass.add(LogBook.class);

		// Definition des Attributs
		StringAttribute attrName = new StringAttribute(ATTRIBUTE_NAME, nom);
		mAttributes.add(attrName);

		// Ajout d'un seul carnet de plongees
		LogBook logBook = new LogBook(this.mId);
		logBook.setParent(this);
		mChildren.add(logBook);
	}

	public void plonge(int i) throws PalierNonTrouveException {
		Plongee plongee = (Plongee) getChildOfType(Plongee.class.getName(), i);
		MN90.getLogger().debug(this, "Calcul de " + plongee);
		plongee.plonge();
	}

	public void addExercice(Exercice exercice) {
		if (!mChildren.contains(exercice)) {
			exercice.setParent(this);
			mChildren.add(exercice);
		}
	}

	public void removeExercice(Exercice exercice) {
		if (mChildren.contains(exercice)) {
			mChildren.remove(exercice);
		}
	}

	public void addPlongeeToLogbook(PlongeeLogBook plongee) {
		LogBook logbook = (LogBook) getChildOfType(LogBook.class.getName(), 0);
		logbook.addPlongee(plongee);
	}

	public void removePlongeeFromLogbook(PlongeeLogBook plongee) {
		LogBook logbook = (LogBook) getChildOfType(LogBook.class.getName(), 0);
		logbook.removePlongee(plongee);
	}

	@Override
	public String toString() {
		return "Plongeur (" + this.mId + ") " + this.getAttribute(ATTRIBUTE_NAME).getValue() + " - nb Exercices "
				+ getChildrenOfType(Exercice.class.getName()).size();
	}
}
