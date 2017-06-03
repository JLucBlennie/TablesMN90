/**
 * 
 */
package com.jlb.plongee.application;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
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
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

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

	public static int WINDOW_WIDTH = 1250;
	public static int WINDOW_HEIGHT = 650;

	private static RandomAccessFile mRandomAccessFile;
	private static FileLock mFileLock;
	private static File mLockFile = new File("flag");

	public static final String DATAMODEL_PACKAGE_NAME = "com.jlb.plongee.datamodel";

	public static void main(String[] args) {
		launch(args);
	}

	public static ILogger getLogger() {
		return mLogger;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		mLogger.debug(this, "Verification qu'il n'y a pas d'autres instances deja lancer.");
		mLockFile = new File("flag");
		mRandomAccessFile = new RandomAccessFile(mLockFile, "rw");
		mFileLock = mRandomAccessFile.getChannel().tryLock();

		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
				try {
					releaseLock();
					mLogger.info(this, "Fermeture...");
				} catch (Exception ex) {
					mLogger.error(this, "Erreur lors du relachement du lock", ex);
				}

			}
		});

		if (mFileLock == null) {
			mLogger.info(this, "Une instance existe deja ...");
			Platform.exit();
		} else {

			// Récupération des donnees de la base de donnees
			mLogger.debug(this, "Récupération des données de MN90 => "
					+ TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.db.filename"));
			DataProcessorServices dpServices = new MN90DataProcessorServices(
					TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.db.filename"), mLogger);

			ICriterion<Entity> plongeursCriterion = new AllCriterion(new Plongeur().getTableName());
			List<Entity> plongeurs = dpServices.requestEntities(plongeursCriterion);

			primaryStage.initStyle(StageStyle.DECORATED);
			// primaryStage.setFullScreen(true);
			// primaryStage.setFullScreenExitHint("");
			mLogger.debug(this, "Création du Controleur de MN90");
			MN90Ctrl tablesMN90Ctrl = new MN90Ctrl(dpServices, plongeurs);

			mLogger.debug(this, "Création de la Scene JavaFx à partir de la vue principale");
			Scene scene = new Scene(tablesMN90Ctrl.getView(), WINDOW_WIDTH, WINDOW_HEIGHT, Color.TRANSPARENT);
			mLogger.debug(this, "Chargement de la feuille de style "
					+ TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.css.principal"));
			scene.getStylesheets().add(TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.css.principal"));

			primaryStage.setTitle(TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.titre"));
			primaryStage.setScene(scene);
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

				@Override
				public void handle(WindowEvent event) {
					tablesMN90Ctrl.exit();
				}

			});
		}
		mLogger.debug(this, "Affichage de l'IHM");
		primaryStage.show();
	}

	public static void releaseLock() {
		try {
			mFileLock.release();
			mRandomAccessFile.close();
			mLockFile.deleteOnExit();
		} catch (IOException e) {
			mLogger.error(MN90.class, "Erreur lors du relachement du lock", e);
		}
	}
}
