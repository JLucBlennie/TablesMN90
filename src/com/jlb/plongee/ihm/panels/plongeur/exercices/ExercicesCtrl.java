package com.jlb.plongee.ihm.panels.plongeur.exercices;

import java.util.ArrayList;
import java.util.List;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.ihm.IController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ExercicesCtrl implements IController<ExercicesView> {

	private ExercicesView mView;

	public ExercicesCtrl() {
		MN90.getLogger().debug(this, "Ctor de PlongeesCtrl");
		mView = new ExercicesView();
		init();
	}

	@Override
	public ExercicesView getView() {
		return mView;
	}

	@Override
	public void init() {
		MN90.getLogger().debug(this, "Initialisation de la vue Plongees");
		mView.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
		List<String> list = new ArrayList<String>();
		list.add("Plongee 1");
		list.add("Plongee 2");
		list.add("Plongee 3");
		list.add("Plongee 4");
		list.add("Plongee 5");

		ObservableList<String> plongees = FXCollections.observableList(list);

		mView.getPlongeesListe().setItems(plongees);
		// mView.setStyle("-fx-border-color: #FF35FB;-fx-border-width: 2px;");
	}

}
