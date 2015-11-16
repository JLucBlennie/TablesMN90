/**
 * 
 */
package com.jlb.plongee.datamodel.table.mn90;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.datamodel.table.mn90.exception.PalierNonTrouveException;
import com.jlb.plongee.datamodel.table.mn90.tools.Comparateur;
import com.jlb.tools.csv.CSVReader;

/**
 * Classe gerant les paliers
 * 
 * @author JLB
 *
 */
public class TablePlongee {
	private static final String FILENAME = "resources/mn90/tablePaliers.mn90";
	/**
	 * Vitesse de remontee jusqu'au premier palier en m/min
	 */
	private static final double VITESSE_REMONTEE = 15;
	/**
	 * Vitesse de remontee entre les paliers en m/min
	 */
	private static final double VITESSE_ENTRE_PALIERS = 6;

	private static List<LignePalierGPS> mLignes = new ArrayList<LignePalierGPS>();

	static {
		// Chargement du fichiers de resources mn90/tablePaliers.mn90
		try {
			List<String[]> lignesCSV = CSVReader.readFile(new File(FILENAME));
			for (String[] ligneCSV : lignesCSV) {
				int profondeur = Integer.parseInt(ligneCSV[0]);
				int tempsPlongee = Integer.parseInt(ligneCSV[1]);
				int tpsP3M = ligneCSV[6].isEmpty() ? 0 : Integer.parseInt(ligneCSV[6]);
				int tpsP6M = ligneCSV[5].isEmpty() ? 0 : Integer.parseInt(ligneCSV[5]);
				int tpsP9M = ligneCSV[4].isEmpty() ? 0 : Integer.parseInt(ligneCSV[4]);
				int tpsP12M = ligneCSV[3].isEmpty() ? 0 : Integer.parseInt(ligneCSV[3]);
				int tpsP15M = ligneCSV[2].isEmpty() ? 0 : Integer.parseInt(ligneCSV[2]);
				String GPS = ligneCSV[7];
				LignePalierGPS ligne = new LignePalierGPS(profondeur, tempsPlongee, tpsP3M, tpsP6M, tpsP9M, tpsP12M,
						tpsP15M, GPS);
				mLignes.add(ligne);
			}
		} catch (IOException e) {
			MN90.logger.error(TablePlongee.class, "Probleme durant la lecture du fichier " + FILENAME, e);
		}
		MN90.logger.debug(TablePlongee.class, "Avant Tri : " + mLignes);
		Collections.sort(mLignes, new Comparateur());
		MN90.logger.debug(TablePlongee.class, "Apres Tri : " + mLignes);
	}

	private LignePalierGPS mLigne;
	private int mProfondeurReelle;
	private int mTempsReel;

	public TablePlongee(int profondeur, int temps) throws PalierNonTrouveException {
		mProfondeurReelle = profondeur;
		mTempsReel = temps;
		mLigne = getLigne(profondeur, temps);
		if (mLigne == null)
			throw new PalierNonTrouveException(profondeur, temps);
	}

	private LignePalierGPS getLigne(int profondeur, int temps) {
		LignePalierGPS ligneCourante = null;

		for (LignePalierGPS ligne : mLignes) {
			if (ligne.getProfondeur() >= profondeur && ligne.getTempsPlongee() >= temps) {
				ligneCourante = ligne;
				break;
			}
		}

		MN90.logger.debug(this, "Ligne courante (" + profondeur + "," + temps + ") : " + ligneCourante);
		return ligneCourante;
	}

	public LignePalierGPS getPalierDTRGPS() {
		return mLigne;
	}

	public int getTpsP3M() {
		return mLigne.getTpsP3M();
	}

	public int getTpsP6M() {
		return mLigne.getTpsP6M();
	}

	public int getTpsP9M() {
		return mLigne.getTpsP9M();
	}

	public int getTpsP12M() {
		return mLigne.getTpsP12M();
	}

	public int getTpsP15M() {
		return mLigne.getTpsP15M();
	}

	public int getNbPaliers() {
		int nbPaliers = 0;
		if (getTpsP3M() > 0) {
			nbPaliers++;
			if (getTpsP6M() > 0) {
				nbPaliers++;
				if (getTpsP9M() > 0) {
					nbPaliers++;
					if (getTpsP12M() > 0) {
						nbPaliers++;
						if (getTpsP15M() > 0)
							nbPaliers++;
					}
				}
			}
		}

		return nbPaliers;
	}

	public String getGPS() {
		return mLigne.getGPS();
	}

	public int getDTR() {
		double dtr = 0;
		int profondeurPremierPalier = 0;
		if (getTpsP15M() > 0)
			profondeurPremierPalier = 15;
		else if (getTpsP12M() > 0)
			profondeurPremierPalier = 12;
		else if (getTpsP9M() > 0)
			profondeurPremierPalier = 9;
		else if (getTpsP6M() > 0)
			profondeurPremierPalier = 6;
		else if (getTpsP3M() > 0)
			profondeurPremierPalier = 3;

		double tpsRemonteePremierPalier = (mLigne.getProfondeur() - profondeurPremierPalier) / VITESSE_REMONTEE;

		dtr = tpsRemonteePremierPalier + getTpsP3M() + (getTpsP3M() > 0 ? 3 / VITESSE_ENTRE_PALIERS : 0) + getTpsP6M()
				+ (getTpsP6M() > 0 ? 3 / VITESSE_ENTRE_PALIERS : 0) + getTpsP9M()
				+ (getTpsP9M() > 0 ? 3 / VITESSE_ENTRE_PALIERS : 0) + getTpsP12M()
				+ (getTpsP12M() > 0 ? 3 / VITESSE_ENTRE_PALIERS : 0) + getTpsP15M()
				+ (getTpsP15M() > 0 ? 3 / VITESSE_ENTRE_PALIERS : 0);

		return (int) Math.ceil(dtr);
	}

	@Override
	public String toString() {
		return "Plongee " + mProfondeurReelle + " m - " + mTempsReel + " min";
	}
}
