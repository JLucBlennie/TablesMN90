/**
 * 
 */
package com.jlb.plongee.application;

import com.jlb.plongee.datamodel.table.mn90.TablePlongee;
import com.jlb.plongee.datamodel.table.mn90.exception.PalierNonTrouveException;
import com.jlb.tools.logging.ILogger;
import com.jlb.tools.logging.LoggerFactory;

/**
 * Classe décrivant les table MN90
 * 
 * @author JLB
 *
 */
public class MN90 {

	public static ILogger logger = LoggerFactory.createLogger("MN90", "mn90.log");

	public static void main(String[] args) {
		MN90.launch();
	}

	public static void launch() {

		int profondeur = 76;
		int temps = 13;
		TablePlongee paliers = null;
		try {
			paliers = new TablePlongee(profondeur, temps);
		} catch (PalierNonTrouveException e) {
			MN90.logger.error(MN90.class, e.getMessage(), e);
			return;
		}
		int tpsP3M = paliers.getTpsP3M();
		int nbPaliers = paliers.getNbPaliers();
		System.out.println("Nb Paliers pour Prof = " + profondeur + " et Temps = " + temps + " => " + nbPaliers);
	}
}
