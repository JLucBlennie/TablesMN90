package com.jlb.plongee.ihm.panels.plongeur.exercices.exercice;

import java.util.List;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.datamodel.exercices.E_TYPE_EXERCICE;
import com.jlb.plongee.datamodel.exercices.E_TYPE_PLONGEE_EXERCICE;
import com.jlb.plongee.datamodel.exercices.Exercice;
import com.jlb.plongee.datamodel.plongees.Plongee;
import com.jlb.plongee.datamodel.plongees.PlongeeExercice;
import com.jlb.plongee.datamodel.table.mn90.exception.PalierNonTrouveException;
import com.jlb.plongee.ihm.IController;
import com.jlb.plongee.ihm.panels.plongees.PlongeesCtrl;
import com.jlb.tools.metamodel.Entity;
import com.jlb.tools.metamodel.attributes.impl.IntegerAttribute;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class ExerciceCtrl implements IController<ExerciceView> {

	private ExerciceView mView;
	private PlongeesCtrl mPlongeesCtrl;
	private Exercice mExercice;

	public ExerciceCtrl() {
		mPlongeesCtrl = new PlongeesCtrl();
		mView = new ExerciceView(mPlongeesCtrl.getView());

		init();
	}

	@Override
	public ExerciceView getView() {
		return mView;
	}

	@Override
	public void init() {
		MN90.getLogger().debug(this, "Initialisation de la vue Exercice");
		mView.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

		mView.setPlongee1Name("No Dive");
		mView.setTypePlongee1(null);

		mView.getTypePlongee1().valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				MN90.getLogger().debug(this, "Changement du type de plongee de " + oldValue + " a " + newValue);
				// Calcul de la plongee et mise a jour de l'IHM
				refreshExercice();
			}
		});

		refreshExercice();
	}

	public void setExercice(Exercice exo) {
		mExercice = exo;
		refreshExercice();
	}

	private void refreshExercice() {
		// TODO : Faire la mise a jour des champ de l'exercice et la mise a jour
		// du dessin de l'exercice. C'est ici que l'on va choisir le dessin a
		// afficher en fonction du type de l'exercice. Il faut aussi gerer la
		// non presence d'exercice selectionne
		calculPlongees();
		if (mExercice != null) {
			E_TYPE_EXERCICE type = E_TYPE_EXERCICE
					.values()[((IntegerAttribute) mExercice.getAttribute(Exercice.ATTRIBUTE_TYPE)).getValue()
							.intValue()];
			switch (type) {
			case SIMPLE:
				MN90.getLogger().debug(this, "Type d'exercice Plongee Simple");
				if (!mExercice.getChildrenOfType(PlongeeExercice.class.getName()).isEmpty()) {
					PlongeeExercice plongee1 = (PlongeeExercice) mExercice
							.getChildrenOfType(PlongeeExercice.class.getName()).get(0);
					mView.setPlongee1Name((String) plongee1.getAttribute(Plongee.ATTRIBUTE_NAME).getValue());
					mView.setTypePlongee1(E_TYPE_PLONGEE_EXERCICE
							.values()[(int) plongee1.getAttribute(PlongeeExercice.ATTRIBUT_TYPE).getValue()]
									.getLabel());
					mPlongeesCtrl.showPlongee(plongee1);
				} else {
					mView.setPlongee1Name("No Dive");
					mView.setTypePlongee1(null);
					mPlongeesCtrl.emptyPlongee();
				}
				break;
			case CONSECUTIVE:
				MN90.getLogger().debug(this, "Type d'exercice Plongee Consecutive");
				break;
			case SUCCESSIVE:
				MN90.getLogger().debug(this, "Type d'exercice Plongee Successive");
				break;
			default:
				MN90.getLogger().debug(this, "Type d'exercice non trouve => affichage par defaut");
			}
			calculPlongees();
		} else {
			MN90.getLogger().debug(this, "Pas d'exercice selectionne => affichage par defaut");
			mPlongeesCtrl.emptyPlongee();
		}
	}

	private void calculPlongees() {
		if (mExercice != null) {
			List<Entity> plongees = mExercice.getChildrenOfType(PlongeeExercice.class.getName());
			for (Entity plongee : plongees) {
				try {
					MN90.getLogger().debug(this, "Calcul de la plongee " + plongee);
					((PlongeeExercice) plongee).plonge();
				} catch (PalierNonTrouveException e) {
					MN90.getLogger().error(this, "Palier non trouvé pour la plongee "
							+ mExercice.getChildOfType(PlongeeExercice.class.getName(), 0), e);
				}
			}
		}
	}
}
