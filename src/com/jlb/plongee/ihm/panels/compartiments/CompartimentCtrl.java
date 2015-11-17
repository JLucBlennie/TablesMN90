package com.jlb.plongee.ihm.panels.compartiments;

import com.jlb.plongee.ihm.Controller;

public class CompartimentCtrl implements Controller<CompartimentView> {

	CompartimentView view;

	public CompartimentCtrl() {
		view = new CompartimentView();
		init();
	}

	@Override
	public CompartimentView getView() {
		return view;
	}

	@Override
	public void init() {
		// view.setStyle("-fx-border-color: #FFFB3E;-fx-border-width: 2px;");
	}

}
