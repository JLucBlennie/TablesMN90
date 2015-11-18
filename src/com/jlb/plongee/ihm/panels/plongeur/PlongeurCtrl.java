package com.jlb.plongee.ihm.panels.plongeur;

import com.jlb.plongee.ihm.Controller;
import com.jlb.plongee.ihm.panels.plongeur.plongees.PlongeesCtrl;

public class PlongeurCtrl implements Controller<PlongeurView> {

	private PlongeesCtrl mPlongeesCtrl = new PlongeesCtrl();
	private PlongeurView mView;

	public PlongeurCtrl() {
		mView = new PlongeurView(mPlongeesCtrl.getView());
		init();
	}

	@Override
	public PlongeurView getView() {
		return mView;
	}

	@Override
	public void init() {
		// mView.setStyle("-fx-border-color: #3eFBFF;-fx-border-width: 2px;");
	}

}
