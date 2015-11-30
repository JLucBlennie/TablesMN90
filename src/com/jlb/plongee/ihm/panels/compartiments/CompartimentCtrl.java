package com.jlb.plongee.ihm.panels.compartiments;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.ihm.IController;

public class CompartimentCtrl implements IController<CompartimentView> {

	CompartimentView mView;

	public CompartimentCtrl() {
		MN90.getLogger().debug(this, "Ctor de CompartimentCtrl");
		mView = new CompartimentView();
		init();
	}

	@Override
	public CompartimentView getView() {
		return mView;
	}

	@Override
	public void init() {
		MN90.getLogger().debug(this, "Initialisation de la vue Compartiment");
		mView.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
		// mView.setStyle("-fx-border-color: #FFFB3E;-fx-border-width: 2px;");
	}

}
