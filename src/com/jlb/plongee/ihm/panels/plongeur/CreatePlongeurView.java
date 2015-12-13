package com.jlb.plongee.ihm.panels.plongeur;

import com.jlb.plongee.application.MN90;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CreatePlongeurView extends GridPane {

	private Label mPlongeurLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongeur.nom.label"));
	private TextField mPlongeurName = new TextField("Moi");

	public CreatePlongeurView() {
		MN90.getLogger().debug(this, "Contruction de la vue CreatePlongeur");

		this.mPlongeurLabel.setPadding(new Insets(0, 5, 5, 2));
		this.add(this.mPlongeurLabel, 0, 0);
		this.mPlongeurName.setPadding(new Insets(0, 2, 5, 2));
		this.add(this.mPlongeurName, 1, 0);
		this.add(new Button("Ajouter"), 1, 1);

		MN90.getLogger().debug(this, "Ajout des composants à la vue CreatePlongeur");
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setGridLinesVisible(MN90.AFFICHAGE_GRILLE);

	}

	public TextField getPlongeurNameText() {
		return mPlongeurName;
	}
}
