package com.jlb.plongee.ihm.panels.plongeur.exercices.exercice;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.datamodel.exercices.E_TYPE_EXERCICE;
import com.jlb.plongee.datamodel.exercices.E_TYPE_PLONGEE_EXERCICE;
import com.jlb.plongee.datamodel.exercices.Exercice;
import com.jlb.plongee.datamodel.plongees.Plongee;
import com.jlb.plongee.datamodel.plongees.PlongeeExercice;
import com.jlb.plongee.ihm.IController;
import com.jlb.plongee.ihm.panels.plongees.PlongeesCtrl;
import com.jlb.tools.metamodel.attributes.impl.IntegerAttribute;

public class ExerciceCtrl implements IController<ExerciceView> {

	private ExerciceView mView;
	private PlongeesCtrl mPlongeesCtrl;
	private Exercice mExercice;

	public ExerciceCtrl() {
		mPlongeesCtrl = new PlongeesCtrl();
		mView = new ExerciceView(mPlongeesCtrl.getView());
	}

	@Override
	public ExerciceView getView() {
		return mView;
	}

	@Override
	public void init() {
		MN90.getLogger().debug(this, "Initialisation de la vue Exercice");
		mView.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

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
					mView.setPlongee1Type(E_TYPE_PLONGEE_EXERCICE
							.values()[(int) plongee1.getAttribute(PlongeeExercice.ATTRIBUT_TYPE).getValue()]
									.getLabel());
				} else {
					mView.setPlongee1Name("No Dive");
					mView.setPlongee1Type(null);
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
		} else {
			MN90.getLogger().debug(this, "Pas d'exercice selectionne => affichage par defaut");
		}
	}
}
