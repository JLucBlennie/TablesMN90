package com.jlb.plongee.ihm.panels;

import com.jlb.plongee.ihm.Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;

public class MN90Ctrl implements Controller<MN90View> {

	private MN90View view;

	public MN90Ctrl(Controller<? extends Pane> plongeurCtrl, Controller<? extends Pane> compartimentCtrl) {
		view = new MN90View(plongeurCtrl.getView(), compartimentCtrl.getView());
		init();
	}

	@Override
	public MN90View getView() {
		return view;
	}

	@Override
	public void init() {
		// view.setStyle("-fx-border-color: #2e8b57;-fx-border-width: 2px;");
		view.exitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
				System.exit(0);
			}

		});
	}

}
