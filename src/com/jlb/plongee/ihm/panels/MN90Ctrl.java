package com.jlb.plongee.ihm.panels;

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
		mView = new MN90View(mPlongeurCtrl.getView(), mCompartimentCtrl.getView());
		init();
	}

	@Override
	public MN90View getView() {
		return mView;
	}

	@Override
	public void init() {
		// mView.setStyle("-fx-border-color: #2e8b57;-fx-border-width: 2px;");
		mView.getExitButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
				System.exit(0);
			}

		});
	}

}
