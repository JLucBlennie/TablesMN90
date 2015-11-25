package com.jlb.plongee.ihm.panels.plongees.types;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.ihm.MN90Constants;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class PlongeeSimpleView extends Group {

	public PlongeeSimpleView() {
		MN90.getLogger().debug(this, "Construction de la vue PlongeeSimple");
		Label heureDepartLabel = new Label(
				MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.heuredepart.label"));
		heureDepartLabel.setTranslateX(0);
		heureDepartLabel.setTranslateY(0);
		this.getChildren().add(heureDepartLabel);

		Line surface = new Line();
		surface.setStartX(-30);
		surface.setStartY(30);
		surface.setEndX(800);
		surface.setEndY(30);
		surface.setStroke(Color.WHITE);
		surface.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_PLONGEE);
		this.getChildren().add(surface);

		Line surface2 = new Line();
		surface2.setStartX(-25);
		surface2.setStartY(35);
		surface2.setEndX(-10);
		surface2.setEndY(35);
		surface2.setStroke(Color.WHITE);
		surface2.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_PLONGEE);
		this.getChildren().add(surface2);

		Line surface3 = new Line();
		surface3.setStartX(-20);
		surface3.setStartY(40);
		surface3.setEndX(-15);
		surface3.setEndY(40);
		surface3.setStroke(Color.WHITE);
		surface3.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_PLONGEE);
		this.getChildren().add(surface3);

		Line surface4 = new Line();
		surface4.setStartX(780);
		surface4.setStartY(35);
		surface4.setEndX(795);
		surface4.setEndY(35);
		surface4.setStroke(Color.WHITE);
		surface4.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_PLONGEE);
		this.getChildren().add(surface4);

		Line surface5 = new Line();
		surface5.setStartX(785);
		surface5.setStartY(40);
		surface5.setEndX(790);
		surface5.setEndY(40);
		surface5.setStroke(Color.WHITE);
		surface5.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_PLONGEE);
		this.getChildren().add(surface5);

		Line descente = new Line();
		descente.setStartX(0);
		descente.setStartY(30);
		descente.setEndX(10);
		descente.setEndY(400);
		descente.setStroke(Color.WHITE);
		descente.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_PLONGEE);
		this.getChildren().add(descente);

		Line fond = new Line();
		fond.setStartX(10);
		fond.setStartY(400);
		fond.setEndX(550);
		fond.setEndY(400);
		fond.setStroke(Color.WHITE);
		fond.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_PLONGEE);
		this.getChildren().add(fond);

		Label profMaxLabel = new Label(
				MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.profmax.label"));
		profMaxLabel.setTranslateX((550 - 10) / 2 - 100);
		profMaxLabel.setTranslateY(370);
		this.getChildren().add(profMaxLabel);

		TextField profMaxValue = new TextField("30");
		profMaxValue.setPrefWidth(45);
		profMaxValue.setMaxWidth(45);
		profMaxValue.setMinWidth(45);
		profMaxValue.setTranslateX((550 - 10) / 2);
		profMaxValue.setTranslateY(365);
		this.getChildren().add(profMaxValue);

		Label profMaxUniteLabel = new Label(
				MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.profmax.unite.label"));
		profMaxUniteLabel.setTranslateX((550 - 10) / 2 + 50);
		profMaxUniteLabel.setTranslateY(370);
		this.getChildren().add(profMaxUniteLabel);

	}
}
