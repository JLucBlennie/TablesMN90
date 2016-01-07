package com.jlb.plongee.ihm.panels;

import java.util.List;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.datamodel.Plongeur;
import com.jlb.plongee.ihm.IController;
import com.jlb.plongee.ihm.panels.compartiments.CompartimentCtrl;
import com.jlb.plongee.ihm.panels.plongeur.PlongeurCtrl;
import com.jlb.tools.metamodel.Entity;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MN90Ctrl implements IController<MN90View> {

	private PlongeurCtrl mPlongeurCtrl;
	private CompartimentCtrl mCompartimentCtrl = new CompartimentCtrl();
	private MN90View mView;

	public MN90Ctrl(List<Entity> plongeurs) {
		MN90.getLogger().debug(this, "Ctor MN90 IController");
		// TODO : voir comment choisir le plongeur et gerer l'absence de
		// plongeur.
		mPlongeurCtrl = new PlongeurCtrl((Plongeur) plongeurs.get(0));
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
		mView.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
		// mView.setStyle("-fx-border-color: #2e8b57;-fx-border-width: 2px;");
		// mView.setOpacity(20);
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
