package com.jlb.plongee.ihm.panels.plongees;

import java.util.ArrayList;
import java.util.List;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.ihm.panels.plongees.types.IPlongeeExerciceView;
import com.jlb.plongee.ihm.panels.plongees.types.PlongeeSimpleView;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class PlongeesView extends GridPane {

	List<IPlongeeExerciceView> mPlongeeExerciceViews = new ArrayList<IPlongeeExerciceView>();
	private int mNbPaliersPlongee1 = 0;
	private int mNbPaliersPlongee2 = 0;

	public PlongeesView() {
		initViews();
		this.setPadding(new Insets(50, 5, 5, 5));
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			this.add((Node) plongeeView, 0, 0);
		}
		this.setGridLinesVisible(MN90.AFFICHAGE_GRILLE);
		// this.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
	}

	private void initViews() {
		mPlongeeExerciceViews.add(new PlongeeSimpleView());
	}

	public void setNbPaliersPlongee1(int nbPaliers) {
		mNbPaliersPlongee1 = nbPaliers;
		// Faire un refresh de la vue en fonction de ce nb de paliers
	}

	public void setNbPaliersPlongee2(int nbPaliers) {
		mNbPaliersPlongee2 = nbPaliers;
		// Faire un refresh de la vue en fonction de ce nb de paliers
	}

	public void setHeureDepartValuePlongee1(long hdms) {
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.setHeureDepartValuePlongee1(hdms);
		}
	}

	public void setHeureDepartValuePlongee2(long hdms) {
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.setHeureDepartValuePlongee2(hdms);
		}
	}

	public void setHeureSortieValuePlongee1(long hdms) {
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.setHeureSortieValuePlongee1(hdms);
		}
	}

	public void setHeureSortieValuePlongee2(long hdms) {
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.setHeureSortieValuePlongee2(hdms);
		}
	}

	public void setDTRValuePlongee1(int dtr) {
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.setDTRValuePlongee1(dtr);
		}
	}

	public void setDTRValuePlongee2(int dtr) {
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.setDTRValuePlongee2(dtr);
		}
	}

	public void setProfondeurMaxValuePlongee1(int profMax) {
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.setProfondeurMaxValuePlongee1(profMax);
		}
	}

	public void setProfondeurMaxValuePlongee2(int profMax) {
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.setProfondeurMaxValuePlongee2(profMax);
		}
	}

	public void setTempsPlongeeValuePlongee1(int tpsPlongee) {
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.setTempsPlongeeValuePlongee1(tpsPlongee);
		}
	}

	public void setTempsPlongeeValuePlongee2(int tpsPlongee) {
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.setTempsPlongeeValuePlongee2(tpsPlongee);
		}
	}

	public void setTempsPalier3mValuePlongee1(int tpsPalier) {
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.setTempsPalier3mValuePlongee1(tpsPalier);
		}
	}

	public void setTempsPalier6mValuePlongee1(int tpsPalier) {
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.setTempsPalier6mValuePlongee1(tpsPalier);
		}
	}

	public void setTempsPalier9mValuePlongee1(int tpsPalier) {
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.setTempsPalier9mValuePlongee1(tpsPalier);
		}
	}

	public void setTempsPalier12mValuePlongee1(int tpsPalier) {
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.setTempsPalier12mValuePlongee1(tpsPalier);
		}
	}

	public void setTempsPalier15mValuePlongee1(int tpsPalier) {
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.setTempsPalier15mValuePlongee1(tpsPalier);
		}
	}

	public void setTempsPalier3mValuePlongee2(int tpsPalier) {
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.setTempsPalier3mValuePlongee2(tpsPalier);
		}
	}

	public void setTempsPalier6mValuePlongee2(int tpsPalier) {
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.setTempsPalier6mValuePlongee2(tpsPalier);
		}
	}

	public void setTempsPalier9mValuePlongee2(int tpsPalier) {
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.setTempsPalier9mValuePlongee2(tpsPalier);
		}
	}

	public void setTempsPalier12mValuePlongee2(int tpsPalier) {
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.setTempsPalier12mValuePlongee2(tpsPalier);
		}
	}

	public void setTempsPalier15mValuePlongee2(int tpsPalier) {
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.setTempsPalier15mValuePlongee2(tpsPalier);
		}
	}

	public void setGPSValuePlongee1(String gps) {
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.setGPSValuePlongee1(gps);
		}
	}

	public void setGPSValuePlongee2(String gps) {
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.setGPSValuePlongee2(gps);
		}
	}

	public void setIntervalleValue(int tpsIntervalle) {
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.setIntervalleValue(tpsIntervalle);
		}
	}

	public void setMajorationValue(int tpsMajo) {
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.setMajorationValue(tpsMajo);
		}
	}

	public void resizePlongeeViews(double width, double height) {
		MN90.getLogger().debug(this, "Changement de taille : " + width + " - " + height);
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			plongeeView.resizeNode(width, height);
		}
	}
}
