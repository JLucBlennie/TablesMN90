package com.jlb.plongee.ihm.panels.plongeur.plongees;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.ihm.MN90Constants;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class PlongeesView extends GridPane {

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

		this.setVgap(5);
		this.setHgap(5);

		this.mAjoutButton.setMaxSize(MN90Constants.TAILLE_BOUTON_WIDTH_DEFAULT,
				MN90Constants.TAILLE_BOUTON_HEIGHT_DEFAULT);
		this.mAjoutButton.setMinSize(MN90Constants.TAILLE_BOUTON_WIDTH_DEFAULT,
				MN90Constants.TAILLE_BOUTON_HEIGHT_DEFAULT);
		this.mAjoutButton.setPrefSize(MN90Constants.TAILLE_BOUTON_WIDTH_DEFAULT,
				MN90Constants.TAILLE_BOUTON_HEIGHT_DEFAULT);
		this.mSupprButton.setMaxSize(MN90Constants.TAILLE_BOUTON_WIDTH_DEFAULT,
				MN90Constants.TAILLE_BOUTON_HEIGHT_DEFAULT);
		this.mSupprButton.setMinSize(MN90Constants.TAILLE_BOUTON_WIDTH_DEFAULT,
				MN90Constants.TAILLE_BOUTON_HEIGHT_DEFAULT);
		this.mSupprButton.setPrefSize(MN90Constants.TAILLE_BOUTON_WIDTH_DEFAULT,
				MN90Constants.TAILLE_BOUTON_HEIGHT_DEFAULT);
		this.mAjoutButton.setStyle("-fx-background-image: url('" + mAjoutImagePath
				+ "'); -fx-background-repeat: no-repeat; -fx-background-position: center;");
		this.mSupprButton.setStyle("-fx-background-image: url('" + mSupprImagePath
				+ "'); -fx-background-repeat: no-repeat; -fx-background-position: center;");

		MN90.getLogger().debug(this, "Ajout des composants à la vue Plongees");
		this.add(this.mPlongeesLabel, 0, 0);
		this.add(this.mPlongeesListe, 0, 1, 2, 1);

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
