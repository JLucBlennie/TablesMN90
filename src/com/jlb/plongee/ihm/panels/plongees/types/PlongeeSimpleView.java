package com.jlb.plongee.ihm.panels.plongees.types;

import com.jlb.plongee.ihm.MN90Constants;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class PlongeeSimpleView extends Group {

	public PlongeeSimpleView() {

		Line descente = new Line();
		descente.setStartX(0);
		descente.setStartY(0);
		descente.setEndX(10);
		descente.setEndY(100);
		descente.setStroke(Color.WHITE);
		descente.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT);

		Line fond = new Line();
		fond.setStartX(10);
		fond.setStartY(100);
		fond.setEndX(150);
		fond.setEndY(100);
		fond.setStroke(Color.WHITE);
		fond.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT);

		this.getChildren().addAll(descente, fond);
	}
}
