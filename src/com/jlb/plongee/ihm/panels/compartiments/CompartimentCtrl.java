package com.jlb.plongee.ihm.panels.compartiments;

import com.jlb.plongee.ihm.Controller;

public class CompartimentCtrl implements Controller<CompartimentView> {

	CompartimentView mView;

	public CompartimentCtrl() {
		mView = new CompartimentView();
		init();
	}

	@Override
	public CompartimentView getView() {
		return mView;
	}

	@Override
	public void init() {
		// mView.setStyle("-fx-border-color: #FFFB3E;-fx-border-width: 2px;");
	}

}
