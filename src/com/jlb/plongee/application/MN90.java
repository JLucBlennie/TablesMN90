/**
 * 
 */
package com.jlb.plongee.application;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.jlb.plongee.datamodel.MN90DataProcessorServices;
import com.jlb.plongee.datamodel.Plongeur;
import com.jlb.plongee.ihm.panels.MN90Ctrl;
import com.jlb.tools.logging.ILogger;
import com.jlb.tools.logging.LoggerFactory;
import com.jlb.tools.metamodel.DataProcessorServices;
import com.jlb.tools.metamodel.Entity;
import com.jlb.tools.metamodel.criterion.ICriterion;
import com.jlb.tools.metamodel.criterion.impl.AllCriterion;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
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

	public static final boolean AFFICHAGE_GRILLE = TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.affichage.grille")
			.equalsIgnoreCase("true") ? true : false;

	public static final String DATAMODEL_PACKAGE_NAME = "com.jlb.plongee.datamodel";

	public static void main(String[] args) {
		launch(args);
	}

	public static ILogger getLogger() {
		return mLogger;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Récupération des donnees de la base de donnees
		mLogger.debug(this, "Récupération des données de MN90 => "
				+ TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.db.filename"));
		DataProcessorServices dpServices = new MN90DataProcessorServices(
				TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.db.filename"));

		ICriterion<Entity> plongeursCriterion = new AllCriterion(new Plongeur().getTableName());
		List<Entity> plongeurs = dpServices.requestEntities(plongeursCriterion);

		primaryStage.initStyle(StageStyle.TRANSPARENT);
		mLogger.debug(this, "Création du Controleur de MN90");
		MN90Ctrl tablesMN90Ctrl = new MN90Ctrl(plongeurs);

		mLogger.debug(this, "Création de la Scene JavaFx à partir de la vue principale");
		Scene scene = new Scene(tablesMN90Ctrl.getView(), 1400, 800, Color.TRANSPARENT);
		mLogger.debug(this, "Chargement de la feuille de style "
				+ TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.css.principal"));
		scene.getStylesheets().add(TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.css.principal"));

		primaryStage.setTitle(TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.titre"));
		primaryStage.setScene(scene);

		mLogger.debug(this, "Affichage de l'IHM");
		primaryStage.show();
	}
}
