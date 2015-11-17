package com.jlb.plongee.ihm.panels;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class MN90View extends GridPane {

	public Button exitButton = new Button("Quitter");

	public MN90View(Pane plongeurPane, Pane compartimentPane) {
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setHgap(5);
		this.setVgap(5);
		// this.setGridLinesVisible(true);

		ColumnConstraints columnConstraints = new ColumnConstraints();
		columnConstraints.setFillWidth(true);
		columnConstraints.setHgrow(Priority.ALWAYS);
		this.getColumnConstraints().add(columnConstraints);
		RowConstraints rowConstraints = new RowConstraints();
		rowConstraints.setFillHeight(true);
		rowConstraints.setVgrow(Priority.ALWAYS);
		this.getRowConstraints().add(rowConstraints);

		this.add(plongeurPane, 0, 0);
		this.add(compartimentPane, 0, 1);
		this.exitButton.setAlignment(Pos.CENTER);
		this.add(this.exitButton, 6, 4);
	}
}
