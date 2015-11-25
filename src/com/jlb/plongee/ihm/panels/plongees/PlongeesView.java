package com.jlb.plongee.ihm.panels.plongees;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.ihm.panels.plongees.types.PlongeeSimpleView;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class PlongeesView extends GridPane {

	private PlongeeSimpleView mPlongeeSimpleView = new PlongeeSimpleView();

	public PlongeesView() {
		this.setPadding(new Insets(50, 5, 5, 5));
		this.add(mPlongeeSimpleView, 0, 0);
		this.setGridLinesVisible(MN90.AFFICHAGE_GRILLE);
	}
}
