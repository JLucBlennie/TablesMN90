package com.jlb.plongee.ihm.panels;

import java.util.List;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.datamodel.Plongeur;
import com.jlb.plongee.ihm.IController;
import com.jlb.plongee.ihm.panels.plongeur.PlongeurCtrl;
import com.jlb.tools.metamodel.Entity;
import com.jlb.tools.metamodel.IDataProcessorServices;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MN90Ctrl implements IController<MN90View> {

	private PlongeurCtrl mPlongeurCtrl;
	private MN90View mView;
	private IDataProcessorServices mDPServices;
	private List<Entity> mPlongeurs;

	public MN90Ctrl(IDataProcessorServices dpServices, List<Entity> plongeurs) {
		MN90.getLogger().debug(this, "Ctor MN90 IController");
		mDPServices = dpServices;
		mPlongeurs = plongeurs;
		// TODO : voir comment choisir le plongeur et gerer l'absence de
		// plongeur.
		mPlongeurCtrl = new PlongeurCtrl((Plongeur) plongeurs.get(0));
		mView = new MN90View(mPlongeurCtrl.getView());
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
				MN90.getLogger().info(this, "Suppression de la base de donnees pour sauvegarde");
				mDPServices.createDatabase();
				MN90.getLogger().info(this, "Sauvegarde des données");
				mDPServices.storeEntities(mPlongeurs);
				mDPServices.endDatabaseService();
				MN90.getLogger().debug(this, "Release du lock");
				MN90.releaseLock();
				Platform.exit();
				MN90.getLogger().debug(this, "Fin de l'application");
				System.exit(0);
			}
		});
	}

}
