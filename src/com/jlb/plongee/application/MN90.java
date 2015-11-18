/**
 * 
 */
package com.jlb.plongee.application;

import java.util.Locale;
import java.util.ResourceBundle;

import com.jlb.plongee.ihm.panels.MN90Ctrl;
import com.jlb.tools.logging.ILogger;
import com.jlb.tools.logging.LoggerFactory;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Classe décrivant les table MN90
 * 
 * @author JLB
 *
 */
public class MN90 extends Application {

	public static final ResourceBundle TABLES_MN90_PROPERTIES = ResourceBundle.getBundle("resources/messages",
			Locale.getDefault());
	private static ILogger mLogger = LoggerFactory.createLogger(
			TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.log.nom"),
			TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.log.fichier"));

	public static void main(String[] args) {
		launch(args);
	}

	public static ILogger getLogger() {
		return mLogger;
	}

	// public static void launch() {
	//
	// int profondeur = 76;
	// int temps = 13;
	// TablePlongee paliers = null;
	// try {
	// paliers = new TablePlongee(profondeur, temps);
	// } catch (PalierNonTrouveException e) {
	// MN90.logger.error(MN90.class, e.getMessage(), e);
	// return;
	// }
	// int tpsP3M = paliers.getTpsP3M();
	// int nbPaliers = paliers.getNbPaliers();
	// System.out.println("Nb Paliers pour Prof = " + profondeur + " et Temps =
	// " + temps + " => " + nbPaliers);
	// }

	@Override
	public void start(Stage primaryStage) throws Exception {
		mLogger.debug(this, "Création du Controleur de MN90");
		MN90Ctrl tablesMN90Ctrl = new MN90Ctrl();

		mLogger.debug(this, "Création de la Scene JavaFx à partir de la vue principale");
		Scene scene = new Scene(tablesMN90Ctrl.getView(), 1600, 800);
		mLogger.debug(this, "Chargement de la feuille de style "
				+ TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.css.principal"));
		scene.getStylesheets().add(TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.css.principal"));

		primaryStage.setTitle(TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.titre"));
		if (!TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.decoration").equalsIgnoreCase("true"))
			primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(scene);

		mLogger.debug(this, "Affichage de l'IHM");
		primaryStage.show();
	}
}
