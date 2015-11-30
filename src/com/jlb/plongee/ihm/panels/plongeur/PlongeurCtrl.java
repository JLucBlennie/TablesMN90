package com.jlb.plongee.ihm.panels.plongeur;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.ihm.IController;
import com.jlb.plongee.ihm.panels.plongees.PlongeesCtrl;
import com.jlb.plongee.ihm.panels.plongeur.exercices.ExercicesCtrl;

public class PlongeurCtrl implements IController<PlongeurView> {

	private ExercicesCtrl mExercicesCtrl = new ExercicesCtrl();
	private PlongeesCtrl mPlongeesCtrl = new PlongeesCtrl();

	private PlongeurView mView;

	public PlongeurCtrl() {
		MN90.getLogger().debug(this, "Ctor de PlongeurCtrl");

		mView = new PlongeurView(mExercicesCtrl.getView(), mPlongeesCtrl.getView());
		init();
	}

	@Override
	public PlongeurView getView() {
		return mView;
	}

	@Override
	public void init() {
		MN90.getLogger().debug(this, "Initialisation de la vue Plongeur");
		mView.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
		// mView.setStyle("-fx-border-color: #3eFBFF;-fx-border-width: 2px;");
	}

}
