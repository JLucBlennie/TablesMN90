package com.jlb.plongee.ihm.impl;

import com.jlb.plongee.ihm.widget.UpwardProgress;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class MN90View extends GridPane {

	public GridPane plongeurPane = new GridPane();
	public Label plongeurlabel = new Label("Plongeur : ");
	public TextField plongeurName = new TextField();
	public Label plongeesLabel = new Label("Plongees : ");
	public ListView<String> plongeesListe = new ListView<String>();
	public GridPane compartimentPane = new GridPane();
	public UpwardProgress comp5min = new UpwardProgress(15, 100);
	public UpwardProgress comp120min = new UpwardProgress(15, 100);
	public Button exitButton = new Button("Quitter");

	public MN90View() {
		this.setPadding(new Insets(10, 10, 10, 10)); // top right bottom left
		this.setHgap(5);
		this.setVgap(5);
		this.setGridLinesVisible(true);

		ColumnConstraints columnConstraints = new ColumnConstraints();
		columnConstraints.setFillWidth(true);
		columnConstraints.setHgrow(Priority.ALWAYS);
		this.getColumnConstraints().add(columnConstraints);
		RowConstraints rowConstraints = new RowConstraints();
		rowConstraints.setFillHeight(true);
		rowConstraints.setVgrow(Priority.ALWAYS);
		this.getRowConstraints().add(rowConstraints);

		plongeurPane.add(this.plongeurlabel, 0, 0);
		plongeurPane.add(this.plongeurName, 1, 0);
		plongeurPane.add(this.plongeesLabel, 0, 1);
		plongeurPane.add(this.plongeesListe, 0, 2, 2, 1);
		plongeurPane.setPadding(new Insets(10, 10, 10, 10));
		plongeurPane.setGridLinesVisible(true);
		this.add(plongeurPane, 0, 0);
		compartimentPane.add(this.comp5min.getProgressHolder(), 0, 0);
		compartimentPane.add(this.comp120min.getProgressHolder(), 1, 0);
		compartimentPane.setPadding(new Insets(10, 10, 10, 10));
		compartimentPane.setGridLinesVisible(true);
		this.add(compartimentPane, 0, 1);
		this.exitButton.setAlignment(Pos.CENTER);
		this.add(this.exitButton, 6, 4);

	}
}
