package com.jlb.plongee.ihm.panels.plongees;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.datamodel.plongees.Plongee;
import com.jlb.plongee.datamodel.plongees.PlongeeExercice;
import com.jlb.plongee.ihm.IController;

public class PlongeesCtrl implements IController<PlongeesView> {

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

	public void emptyPlongee() {
		mView.setHeureDepartValuePlongee1(0);
		mView.setHeureSortieValuePlongee1(0);
		mView.setDTRValuePlongee1(0);
		mView.setProfondeurMaxValuePlongee1(0);
		mView.setTempsPlongeeValuePlongee1(0);
	}

	public void showPlongee(PlongeeExercice plongee) {
		showPlongee(plongee, null);
	}

	public void showPlongee(PlongeeExercice plongee1, PlongeeExercice plongee2) {
		long time = System.currentTimeMillis();
		mView.setHeureDepartValuePlongee1(time);
		mView.setHeureSortieValuePlongee1(
				time + (int) plongee1.getAttribute(Plongee.ATTRIBUTE_TEMPS_PLONGEES).getValue() * 1000 * 60
						+ plongee1.getDTR() * 1000 * 60);
		mView.setDTRValuePlongee1(plongee1.getDTR());
		mView.setProfondeurMaxValuePlongee1(plongee1.getProfondeur());
		mView.setTempsPlongeeValuePlongee1((int) plongee1.getAttribute(Plongee.ATTRIBUTE_TEMPS_PLONGEES).getValue());
		// Gestion des Temps de paliers

		if (plongee2 != null) {
			mView.setHeureDepartValuePlongee2(time);
			mView.setHeureSortieValuePlongee2(
					time + (int) plongee2.getAttribute(Plongee.ATTRIBUTE_TEMPS_PLONGEES).getValue() * 1000 * 60
							+ plongee2.getDTR() * 1000 * 60);
			mView.setDTRValuePlongee2(plongee1.getDTR());
			mView.setProfondeurMaxValuePlongee2(plongee1.getProfondeur());
			mView.setTempsPlongeeValuePlongee2(
					(int) plongee1.getAttribute(Plongee.ATTRIBUTE_TEMPS_PLONGEES).getValue());
			// Gestion des Temps de paliers

		}
	}

}
