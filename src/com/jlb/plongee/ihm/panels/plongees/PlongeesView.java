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

	public PlongeesView() {
		initViews();
		this.setPadding(new Insets(50, 5, 5, 5));
		for (IPlongeeExerciceView plongeeView : mPlongeeExerciceViews) {
			this.add((Node) plongeeView, 0, 0);
		}
		this.setGridLinesVisible(MN90.AFFICHAGE_GRILLE);
	}

	private void initViews() {
		mPlongeeExerciceViews.add(new PlongeeSimpleView());
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
}
