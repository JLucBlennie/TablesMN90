package com.jlb.plongee.ihm.panels.plongeur.plongees;

import com.jlb.plongee.application.MN90;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class PlongeesView extends GridPane {

	private static int TAILLE_BOUTON_WIDTH = 30;
	private static int TAILLE_BOUTON_HEIGHT = 30;
	private static String mAjoutImagePath = MN90.TABLES_MN90_PROPERTIES
			.getString("com.jlb.plongee.view.plongees.ajout.image");
	private static String mSupprImagePath = MN90.TABLES_MN90_PROPERTIES
			.getString("com.jlb.plongee.view.plongees.suppr.image");
	private Label mPlongeesLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongees.nom.label"));
	private ListView<String> mPlongeesListe = new ListView<String>();
	private Button mAjoutButton = new Button();
	private Button mSupprButton = new Button();

	public PlongeesView() {
		MN90.getLogger().debug(this, "Contruction de la vue Plongees");

		this.add(this.mPlongeesLabel, 0, 0);
		this.add(this.mPlongeesListe, 0, 1, 2, 1);

		this.mAjoutButton.setMaxSize(TAILLE_BOUTON_WIDTH, TAILLE_BOUTON_HEIGHT);
		this.mAjoutButton.setMinSize(TAILLE_BOUTON_WIDTH, TAILLE_BOUTON_HEIGHT);
		this.mAjoutButton.setPrefSize(TAILLE_BOUTON_WIDTH, TAILLE_BOUTON_HEIGHT);
		this.mSupprButton.setMaxSize(TAILLE_BOUTON_WIDTH, TAILLE_BOUTON_HEIGHT);
		this.mSupprButton.setMinSize(TAILLE_BOUTON_WIDTH, TAILLE_BOUTON_HEIGHT);
		this.mSupprButton.setPrefSize(TAILLE_BOUTON_WIDTH, TAILLE_BOUTON_HEIGHT);
		this.mAjoutButton.setStyle("-fx-background-image: url('" + mAjoutImagePath
				+ "'); -fx-background-repeat: no-repeat; -fx-background-position: center;");
		this.mSupprButton.setStyle("-fx-background-image: url('" + mSupprImagePath
				+ "'); -fx-background-repeat: no-repeat; -fx-background-position: center;");

		MN90.getLogger().debug(this, "Ajout des composants à la vue Plongees");
		HBox buttonsContainer = new HBox(10);
		buttonsContainer.getChildren().add(this.mAjoutButton);
		buttonsContainer.getChildren().add(this.mSupprButton);
		buttonsContainer.setAlignment(Pos.CENTER);
		this.add(buttonsContainer, 0, 2, 2, 1);

		this.setPadding(new Insets(10, 10, 10, 10));
		this.setGridLinesVisible(MN90.AFFICHAGE_GRILLE);
	}

	public ListView<String> getPlongeesListe() {
		return mPlongeesListe;
	}
}
