package com.jlb.plongee.ihm.panels.plongeur.exercices;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.datamodel.exercices.Exercice;
import com.jlb.plongee.ihm.MN90Constants;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

public class ExercicesView extends GridPane {

	private Label mExercicesLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.exercices.nom.label"));
	private ListView<Exercice> mExercicesListe = new ListView<Exercice>();
	private Button mAjoutButton = new Button();
	private Button mSupprButton = new Button();
	private Label mTableLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.exercices.table.label"));
	private TextField mTable = new TextField(MN90.class.getSimpleName());

	public ExercicesView(Pane exerciceView, Pane compartimentPane) {
		MN90.getLogger().debug(this, "Contruction de la vue Exercices");

		// this.setVgap(5);
		// this.setHgap(5);

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
		this.add(exerciceView, 1, 0, 1, 3);
		this.add(this.mExercicesListe, 0, 1);

		HBox buttonsContainer = new HBox(10);
		buttonsContainer.getChildren().add(this.mAjoutButton);
		buttonsContainer.getChildren().add(this.mSupprButton);
		buttonsContainer.setAlignment(Pos.CENTER);
		this.add(buttonsContainer, 0, 2);

		this.add(mTableLabel, 0, 3);
		this.mTable.setStyle("-fx-background-color: transparent;");
		this.add(mTable, 1, 3);
		this.add(compartimentPane, 0, 4, 2, 1);
		// this.setPadding(new Insets(10, 10, 10, 10));
		this.setGridLinesVisible(MN90.AFFICHAGE_GRILLE);
		this.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
	}

	public ListView<Exercice> getExercicesList() {
		return mExercicesListe;
	}

	public Button getAjoutButton() {
		return mAjoutButton;
	}

	public Button getSupprButton() {
		return mSupprButton;
	}
}
