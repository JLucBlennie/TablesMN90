package com.jlb.plongee.ihm.panels;

import com.jlb.plongee.application.MN90;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.TextAlignment;

public class MN90View extends GridPane {

	private Button mExitButton = new Button(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.mn90.exit.button"));

	private Label mVersion = new Label("Version : " + MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.version"));
	private ImageView imvTitre = new ImageView();
	private Image imgTitre = new Image(MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.titre.img"));
	private ImageView imvFond = new ImageView();
	private Image imgFond = new Image(MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.fond.img"));

	public MN90View(Pane plongeurPane, Pane compartimentPane) {
		MN90.getLogger().debug(this, "Contruction de la vue MN90");
		this.setPadding(new Insets(10, 10, 10, 10));
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

		// this.add(imvFond, 0, 0, 6, 2);
		// imvFond.setImage(imgFond);
		// imvFond.setFitWidth(100);
		// imvFond.setPreserveRatio(true);
		// imvFond.setSmooth(true);
		// imvFond.setCache(true);

		this.add(imvTitre, 0, 0, 6, 2);
		imvTitre.setImage(imgTitre);
		imvTitre.setFitHeight(100);
		imvTitre.setPreserveRatio(true);
		imvTitre.setSmooth(true);
		imvTitre.setCache(true);

		this.add(plongeurPane, 0, 0);
		this.add(compartimentPane, 0, 1);
		this.mVersion.setTextAlignment(TextAlignment.CENTER);
		this.add(mVersion, 0, 2);
		GridPane.setHalignment(this.mExitButton, HPos.CENTER);
		this.add(this.mExitButton, 6, 2);
	}

	public Button getExitButton() {
		return mExitButton;
	}
}
