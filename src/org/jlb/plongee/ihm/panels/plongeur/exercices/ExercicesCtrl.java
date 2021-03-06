package com.jlb.plongee.ihm.panels.plongeur.exercices;

import java.util.ArrayList;
import java.util.List;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.datamodel.Plongeur;
import com.jlb.plongee.datamodel.exercices.E_TYPE_EXERCICE;
import com.jlb.plongee.datamodel.exercices.E_TYPE_PLONGEE_EXERCICE;
import com.jlb.plongee.datamodel.exercices.Exercice;
import com.jlb.plongee.datamodel.plongees.PlongeeExercice;
import com.jlb.plongee.ihm.IController;
import com.jlb.plongee.ihm.panels.compartiments.CompartimentCtrl;
import com.jlb.plongee.ihm.panels.plongeur.exercices.exercice.ExerciceCtrl;
import com.jlb.tools.metamodel.Entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ExercicesCtrl implements IController<ExercicesView> {

	private ExercicesView mView;
	private ExerciceCtrl mExerciceCtrl;
	private CompartimentCtrl mCompartimentCtrl = new CompartimentCtrl();
	private Plongeur mPlongeur;

	public ExercicesCtrl(Plongeur plongeur) {
		MN90.getLogger().debug(this, "Ctor de ExercicesCtrl");
		this.mPlongeur = plongeur;
		mExerciceCtrl = new ExerciceCtrl();
		mView = new ExercicesView(mExerciceCtrl.getView(), mCompartimentCtrl.getView());
		init();
	}

	@Override
	public ExercicesView getView() {
		return mView;
	}

	@Override
	public void init() {
		MN90.getLogger().debug(this, "Initialisation de la vue Exercices");
		mView.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

		mView.getExercicesList().setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// On doit afficher l'eercice selectionne
				MN90.getLogger().debug(this,
						"Selection de l'exercice : " + mView.getExercicesList().getSelectionModel().getSelectedItem());
				// Mise a jour de la vue exercice
				mExerciceCtrl.setExercice(mView.getExercicesList().getSelectionModel().getSelectedItem());
			}
		});

		refreshList();
		// mView.setStyle("-fx-border-color: #FF35FB;-fx-border-width: 2px;");

		// Ajout des actionListner sur les boutons + et -
		mView.getAjoutButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// Ajout d'une nouvelle exercice
				MN90.getLogger().debug(this, "--> Bouton +");
				// TODO : Mettre en place une IHM pour renseigner les elements
				// de l'exercice...
				Exercice exoToAdd = new Exercice(mPlongeur.getChildrenOfType(Exercice.class.getName()).size(),
						"Mon nouvel Exercice", E_TYPE_EXERCICE.SIMPLE);
				// Ajout d'une plongee
				PlongeeExercice plongee1 = new PlongeeExercice(0, "Plongee 1", 20, 40, E_TYPE_PLONGEE_EXERCICE.SIMPLE);
				exoToAdd.addPlongee(plongee1);
				PlongeeExercice plongee2 = new PlongeeExercice(1, "Plongee 2", 20, 40, E_TYPE_PLONGEE_EXERCICE.SIMPLE);
				exoToAdd.addPlongee(plongee2);
				mPlongeur.addExercice(exoToAdd);
				refreshList();
			}

		});

		mView.getSupprButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// Suppression de l'exercice selectionne
				Exercice exoToDelete = mView.getExercicesList().getSelectionModel().getSelectedItem();
				if (exoToDelete != null) {
					MN90.getLogger().debug(this, "--> Bouton - : Suppression de l'exrecice : " + exoToDelete);
					mPlongeur.removeExercice(exoToDelete);
					refreshList();
				} else {
					MN90.getLogger().debug(this,
							"--> Bouton - : Suppression de l'exrecice : Pas d'exercice selectionne...");
				}
			}

		});
	}

	private void refreshList() {
		List<Exercice> exercices = new ArrayList<Exercice>();
		for (Entity ent : mPlongeur.getChildrenOfType(Exercice.class.getName())) {
			exercices.add((Exercice) ent);
		}

		ObservableList<Exercice> exercicesObservable = FXCollections.observableList(exercices);

		mView.getExercicesList().setItems(exercicesObservable);
	}

}
