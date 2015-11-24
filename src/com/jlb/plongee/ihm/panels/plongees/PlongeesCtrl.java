package com.jlb.plongee.ihm.panels.plongees;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.ihm.Controller;

public class PlongeesCtrl implements Controller<PlongeesView> {

	private PlongeesView mView = new PlongeesView();

	public PlongeesCtrl() {
		MN90.getLogger().debug(this, "Ctor de PlongeesCtrl");
		init();
	}

	@Override
	public PlongeesView getView() {
		return mView;
	}

	@Override
	public void init() {
		MN90.getLogger().debug(this, "Initialisation de la vue Plongees");
		mView.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
	}

}
