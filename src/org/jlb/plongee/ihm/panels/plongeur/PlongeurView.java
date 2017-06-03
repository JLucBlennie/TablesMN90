package com.jlb.plongee.ihm.panels.plongeur;

import com.jlb.plongee.application.MN90;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

public class PlongeurView extends GridPane {

	private Label mPlongeurLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongeur.nom.label"));
	private TextField mPlongeurName = new TextField("Moi");

	public PlongeurView(Pane exercicesView) {
		MN90.getLogger().debug(this, "Contruction de la vue Plongeur");

		this.mPlongeurLabel.setPadding(new Insets(0, 5, 5, 2));
		this.add(this.mPlongeurLabel, 0, 0);
		this.mPlongeurName.setPadding(new Insets(0, 2, 5, 2));
		this.add(this.mPlongeurName, 1, 0);

		MN90.getLogger().debug(this, "Ajout des composants à la vue Plongeur");
		this.add(exercicesView, 0, 1, 2, 1);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setGridLinesVisible(MN90.AFFICHAGE_GRILLE);
		this.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
	}

	public TextField getPlongeurNameText() {
		return mPlongeurName;
	}
}
