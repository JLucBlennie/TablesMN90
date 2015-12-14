package com.jlb.plongee.ihm.panels.plongeur.exercices;

import java.util.ArrayList;
import java.util.List;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.datamodel.Plongeur;
import com.jlb.plongee.datamodel.exercices.Exercice;
import com.jlb.plongee.ihm.IController;
import com.jlb.tools.metamodel.Entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ExercicesCtrl implements IController<ExercicesView> {

	private ExercicesView mView;
	private Plongeur mPlongeur;

	public ExercicesCtrl(Plongeur plongeur) {
		MN90.getLogger().debug(this, "Ctor de PlongeesCtrl");
		this.mPlongeur = plongeur;
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

		List<Exercice> plongees = new ArrayList<Exercice>();
		for (Entity ent : mPlongeur.getChildrenOfType(Exercice.class.getName())) {
			plongees.add((Exercice) ent);
		}

		ObservableList<Exercice> plongeesObservable = FXCollections.observableList(plongees);

		mView.getPlongeesListe().setItems(plongeesObservable);
		// mView.setStyle("-fx-border-color: #FF35FB;-fx-border-width: 2px;");
	}

}
