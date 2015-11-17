package com.jlb.plongee.ihm.widget;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class UpwardProgress extends GridPane {

	private ProgressBar progressBar = new ProgressBar();
	private Label progressBarLabel = new Label();
	private Group progressContainer = new Group(progressBar);

	public UpwardProgress(String label, double width, double height) {
		progressBarLabel.setText(label);
		progressBarLabel.setTextAlignment(TextAlignment.CENTER);
		progressBar.setMinSize(StackPane.USE_PREF_SIZE, StackPane.USE_PREF_SIZE);
		progressBar.setPrefSize(height, width);
		progressBar.setMaxSize(StackPane.USE_PREF_SIZE, StackPane.USE_PREF_SIZE);
		progressBar.getTransforms().setAll(new Translate(0, height), new Rotate(-90, 0, 0));

		ColumnConstraints columnConstraints = new ColumnConstraints();
		columnConstraints.setFillWidth(true);
		columnConstraints.setHalignment(HPos.CENTER);
		columnConstraints.setHgrow(Priority.ALWAYS);
		this.getColumnConstraints().add(columnConstraints);

		RowConstraints rowConstraints = new RowConstraints();
		rowConstraints.setFillHeight(true);
		rowConstraints.setVgrow(Priority.ALWAYS);
		this.getRowConstraints().add(rowConstraints);

		this.setPadding(new Insets(2, 5, 2, 5));
		this.add(progressBarLabel, 0, 0);
		this.add(progressContainer, 0, 1);
	}

	public ProgressBar getProgressBar() {
		return progressBar;
	}
}
