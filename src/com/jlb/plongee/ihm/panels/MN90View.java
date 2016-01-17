package com.jlb.plongee.ihm.panels;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.ihm.MN90Constants;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.TextAlignment;

public class MN90View extends GridPane {

	private Button mExitButton = new Button();

	private Label mVersion = new Label(MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.titre") + " v"
			+ MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.version"));
	private Label mApplicationName = new Label(MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.titre") + "\n"
			+ MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.sous-titre"));

	public MN90View(Pane plongeurPane) {
		MN90.getLogger().debug(this, "Contruction de la vue MN90");
		this.setPadding(new Insets(30, 30, 30, 30));
		this.setHgap(5);
		this.setVgap(5);
		this.setGridLinesVisible(MN90.AFFICHAGE_GRILLE);

		ColumnConstraints columnConstraints = new ColumnConstraints();
		columnConstraints.setFillWidth(true);
		columnConstraints.setHgrow(Priority.ALWAYS);
		columnConstraints.setHalignment(HPos.CENTER);
		this.getColumnConstraints().add(columnConstraints);
		RowConstraints rowConstraints = new RowConstraints();
		rowConstraints.setFillHeight(true);
		rowConstraints.setVgrow(Priority.ALWAYS);
		rowConstraints.setValignment(VPos.TOP);
		this.getRowConstraints().add(rowConstraints);

		MN90.getLogger().debug(this, "Ajout des composants à la vue MN90");

		this.mApplicationName.setId("applicationName");
		this.mApplicationName.setTextAlignment(TextAlignment.CENTER);
		this.add(mApplicationName, 0, 0, 2, 1);

		this.mExitButton.setMaxSize(MN90Constants.TAILLE_BOUTON_WIDTH_EXIT, MN90Constants.TAILLE_BOUTON_HEIGHT_EXIT);
		this.mExitButton.setMinSize(MN90Constants.TAILLE_BOUTON_WIDTH_EXIT, MN90Constants.TAILLE_BOUTON_HEIGHT_EXIT);
		this.mExitButton.setPrefSize(MN90Constants.TAILLE_BOUTON_WIDTH_EXIT, MN90Constants.TAILLE_BOUTON_HEIGHT_EXIT);
		this.mExitButton.setId("exitButton");
		GridPane.setHalignment(this.mExitButton, HPos.LEFT);
		this.add(this.mExitButton, 1, 0);
		this.add(plongeurPane, 0, 0);
		this.mVersion.setId("version");
		this.mVersion.setTextAlignment(TextAlignment.CENTER);
		this.add(mVersion, 0, 2);
	}

	public Button getExitButton() {
		return mExitButton;
	}
}
