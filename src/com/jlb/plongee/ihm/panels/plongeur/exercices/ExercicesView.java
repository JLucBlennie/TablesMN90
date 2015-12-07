package com.jlb.plongee.ihm.panels.plongeur.exercices;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.datamodel.Plongee;
import com.jlb.plongee.ihm.MN90Constants;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class ExercicesView extends GridPane {

	private Label mExercicesLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.exercices.nom.label"));
	private ListView<Plongee> mExercicesListe = new ListView<Plongee>();
	private Button mAjoutButton = new Button();
	private Button mSupprButton = new Button();

	public ExercicesView() {
		MN90.getLogger().debug(this, "Contruction de la vue Exercices");

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
		this.mAjoutButton.setId("ajoutExerciceButton");
		this.mSupprButton.setId("supprExerciceButton");

		MN90.getLogger().debug(this, "Ajout des composants à la vue Exercices");
		this.add(this.mExercicesLabel, 0, 0);
		this.add(this.mExercicesListe, 0, 1, 2, 1);

		HBox buttonsContainer = new HBox(10);
		buttonsContainer.getChildren().add(this.mAjoutButton);
		buttonsContainer.getChildren().add(this.mSupprButton);
		buttonsContainer.setAlignment(Pos.CENTER);
		this.add(buttonsContainer, 0, 2, 2, 1);

		this.setPadding(new Insets(10, 10, 10, 10));
		this.setGridLinesVisible(MN90.AFFICHAGE_GRILLE);
	}

	public ListView<Plongee> getPlongeesListe() {
		return mExercicesListe;
	}
}
