package com.jlb.plongee.ihm.panels;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.ihm.Controller;
import com.jlb.plongee.ihm.panels.compartiments.CompartimentCtrl;
import com.jlb.plongee.ihm.panels.plongeur.PlongeurCtrl;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MN90Ctrl implements Controller<MN90View> {

	private PlongeurCtrl mPlongeurCtrl = new PlongeurCtrl();
	private CompartimentCtrl mCompartimentCtrl = new CompartimentCtrl();
	private MN90View mView;

	public MN90Ctrl() {
		MN90.getLogger().debug(this, "Ctor MN90 Controller");
		mView = new MN90View(mPlongeurCtrl.getView(), mCompartimentCtrl.getView());
		init();
	}

	@Override
	public MN90View getView() {
		return mView;
	}

	@Override
	public void init() {
		MN90.getLogger().debug(this, "Initialisation de la vue MN90");
		// mView.setStyle("-fx-border-color: #2e8b57;-fx-border-width: 2px;");
		mView.getExitButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				MN90.getLogger().debug(this, "Fin de l'application");
				Platform.exit();
				System.exit(0);
			}

		});
	}

}
