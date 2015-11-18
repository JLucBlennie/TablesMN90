package com.jlb.plongee.ihm.panels;

import com.jlb.plongee.application.MN90;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class MN90View extends GridPane {

	private Button mExitButton = new Button(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.mn90.exit.button"));

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
		this.mExitButton.setAlignment(Pos.CENTER);
		this.add(this.mExitButton, 6, 4);
	}

	public Button getExitButton() {
		return mExitButton;
	}
}
