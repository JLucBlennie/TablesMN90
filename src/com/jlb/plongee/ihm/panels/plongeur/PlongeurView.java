package com.jlb.plongee.ihm.panels.plongeur;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PlongeurView extends GridPane {

	public Label plongeurlabel = new Label("Plongeur : ");
	public TextField plongeurName = new TextField();
	public Label plongeesLabel = new Label("Plongees : ");
	public ListView<String> plongeesListe = new ListView<String>();

	public PlongeurView() {
		this.add(this.plongeurlabel, 0, 0);
		this.add(this.plongeurName, 1, 0);
		this.add(this.plongeesLabel, 0, 1);
		this.add(this.plongeesListe, 0, 2, 2, 1);
		this.setPadding(new Insets(10, 10, 10, 10));
		// this.setGridLinesVisible(true);

	}
}
