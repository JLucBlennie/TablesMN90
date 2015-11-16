/**
 * 
 */
package com.jlb.plongee.application;

import java.util.Locale;
import java.util.ResourceBundle;

import com.jlb.plongee.ihm.impl.MN90Ctrl;
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

	public static ILogger logger = LoggerFactory.createLogger("MN90", "mn90.log");
	public static final ResourceBundle TABLES_MN90_PROPERTIES = ResourceBundle.getBundle("resources/messages",
			Locale.getDefault());

	public static void main(String[] args) {
		launch(args);
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
		MN90Ctrl tablesMN90Ctrl = new MN90Ctrl();

		Scene scene = new Scene(tablesMN90Ctrl.getView(), 500, 400);
		scene.getStylesheets().add("resources/stylesheet.css");

		primaryStage.setTitle(TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.titre"));
		if (!TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.decoration").equalsIgnoreCase("true"))
			primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
