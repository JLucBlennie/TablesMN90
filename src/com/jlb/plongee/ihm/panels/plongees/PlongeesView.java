package com.jlb.plongee.ihm.panels.plongees;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.ihm.panels.plongees.types.PlongeeSimpleView;

import javafx.scene.layout.GridPane;

public class PlongeesView extends GridPane {

	private PlongeeSimpleView mPlongeeSimpleView = new PlongeeSimpleView();

	public PlongeesView() {
		this.add(mPlongeeSimpleView, 0, 0);
		this.setGridLinesVisible(MN90.AFFICHAGE_GRILLE);
	}
}
