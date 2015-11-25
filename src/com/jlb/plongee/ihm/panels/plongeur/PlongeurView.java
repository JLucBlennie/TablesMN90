package com.jlb.plongee.ihm.panels.plongeur;

import com.jlb.plongee.application.MN90;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class PlongeurView extends GridPane {

	private Label mPlongeurLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongeur.nom.label"));
	private TextField mPlongeurName = new TextField("Moi");
	private Label mTableLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongeur.table.label"));
	private TextField mTable = new TextField(MN90.class.getSimpleName());

	public PlongeurView(Pane exercicesView, Pane plongeesView) {
		MN90.getLogger().debug(this, "Contruction de la vue Plongeur");

		this.mPlongeurLabel.setPadding(new Insets(0, 5, 5, 2));
		this.add(this.mPlongeurLabel, 0, 0);
		this.mPlongeurName.setPadding(new Insets(0, 2, 5, 2));
		this.add(this.mPlongeurName, 1, 0);

		MN90.getLogger().debug(this, "Ajout des composants à la vue Plongeur");
		this.add(exercicesView, 0, 1, 2, 1);
		this.add(plongeesView, 2, 1);
		this.add(mTableLabel, 0, 2);
		this.mTable.setStyle("-fx-background-color: transparent;");
		this.add(mTable, 1, 2);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setGridLinesVisible(MN90.AFFICHAGE_GRILLE);

	}
}
