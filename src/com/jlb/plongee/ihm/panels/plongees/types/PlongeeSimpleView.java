package com.jlb.plongee.ihm.panels.plongees.types;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.jlb.plongee.application.MN90;
import com.jlb.plongee.ihm.MN90Constants;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class PlongeeSimpleView extends Group implements IPlongeeExerciceView {

	protected Label mHeureDepartLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.heuredepart.label"));
	protected TextField mHeureDepartValue = new TextField("09:30");
	protected Line mSurface = new Line();
	protected Line mSurface2 = new Line();
	protected Line mSurface3 = new Line();
	protected Line mSurface4 = new Line();
	protected Line mSurface5 = new Line();
	protected Line mDescente = new Line();
	protected Line mFond = new Line();
	protected Label mProfMaxLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.profmax.label"));
	protected TextField mProfMaxValue = new TextField("30");
	protected Label mProfMaxUniteLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.profmax.unite.label"));
	protected Label mHeureSortieLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.heuresortie.label"));
	protected TextField mHeureSortieValue = new TextField("09:55");
	protected Label mDureePlongeeLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.dureeplongee.label"));
	protected TextField mDureePlongeeValue = new TextField("40");
	protected Label mDureePlongeeUniteLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.duree.unite.label"));
	protected Line mDebutRemontee = new Line();
	protected Line mPalier3m = new Line();
	protected Label mPalier3mLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.palier3m.label"));
	protected TextField mDureePalier3mValue = new TextField("50");
	protected Label mDureePalier3mUniteLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.duree.unite.label"));
	protected Line mRemonteeFin = new Line();
	protected Label mDTRLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.dtr.label"));
	protected TextField mDTRValue = new TextField("40");
	protected Label mDTRUniteLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.duree.unite.label"));
	protected Line mMarkDebut = new Line();
	protected Line mFlecheDureePlongee = new Line();
	protected Line mFlecheDureePlongee2 = new Line();
	protected Line mFlecheDureePlongee3 = new Line();
	protected Line mFlecheDureePlongee4 = new Line();
	protected Line mFlecheDureePlongee5 = new Line();
	protected Line mMarkDureePlongee = new Line();
	protected Line mMarkFinPlongee = new Line();
	protected Line mFlecheDTRPlongee = new Line();
	protected Line mFlecheDTRPlongee2 = new Line();
	protected Line mFlecheDTRPlongee3 = new Line();

	protected Label mGPSLabel = new Label(
			MN90.TABLES_MN90_PROPERTIES.getString("com.jlb.plongee.view.plongee.simple.gps.label"));
	protected TextField mGPSValue = new TextField("A");

	private SimpleDateFormat mDateFormat = new SimpleDateFormat("HH:mm");

	public PlongeeSimpleView() {
		MN90.getLogger().debug(this, "Construction de la vue PlongeeSimple");
		mHeureDepartLabel.setTranslateX(-30);
		mHeureDepartLabel.setTranslateY(0);
		this.getChildren().add(mHeureDepartLabel);

		mHeureDepartValue.setPrefWidth(100);
		mHeureDepartValue.setMaxWidth(100);
		mHeureDepartValue.setMinWidth(100);
		mHeureDepartValue.setTranslateX(5);
		mHeureDepartValue.setTranslateY(-5);
		this.getChildren().add(mHeureDepartValue);

		mSurface.setStartX(-30);
		mSurface.setStartY(30);
		mSurface.setEndX(800);
		mSurface.setEndY(30);
		mSurface.setStroke(Color.WHITE);
		mSurface.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_PLONGEE);
		this.getChildren().add(mSurface);

		mSurface2.setStartX(-25);
		mSurface2.setStartY(35);
		mSurface2.setEndX(-10);
		mSurface2.setEndY(35);
		mSurface2.setStroke(Color.WHITE);
		mSurface2.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_PLONGEE);
		this.getChildren().add(mSurface2);

		mSurface3.setStartX(-20);
		mSurface3.setStartY(40);
		mSurface3.setEndX(-15);
		mSurface3.setEndY(40);
		mSurface3.setStroke(Color.WHITE);
		mSurface3.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_PLONGEE);
		this.getChildren().add(mSurface3);

		mSurface4.setStartX(780);
		mSurface4.setStartY(35);
		mSurface4.setEndX(795);
		mSurface4.setEndY(35);
		mSurface4.setStroke(Color.WHITE);
		mSurface4.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_PLONGEE);
		this.getChildren().add(mSurface4);

		mSurface5.setStartX(785);
		mSurface5.setStartY(40);
		mSurface5.setEndX(790);
		mSurface5.setEndY(40);
		mSurface5.setStroke(Color.WHITE);
		mSurface5.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_PLONGEE);
		this.getChildren().add(mSurface5);

		mDescente.setStartX(0);
		mDescente.setStartY(30);
		mDescente.setEndX(10);
		mDescente.setEndY(400);
		mDescente.setStroke(Color.WHITE);
		mDescente.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_PLONGEE);
		this.getChildren().add(mDescente);

		mFond.setStartX(10);
		mFond.setStartY(400);
		mFond.setEndX(550);
		mFond.setEndY(400);
		mFond.setStroke(Color.WHITE);
		mFond.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_PLONGEE);
		this.getChildren().add(mFond);

		mProfMaxLabel.setTranslateX((550 - 10) / 2 - 100);
		mProfMaxLabel.setTranslateY(370);
		this.getChildren().add(mProfMaxLabel);

		mProfMaxValue.setPrefWidth(45);
		mProfMaxValue.setMaxWidth(45);
		mProfMaxValue.setMinWidth(45);
		mProfMaxValue.setTranslateX((550 - 10) / 2);
		mProfMaxValue.setTranslateY(365);
		this.getChildren().add(mProfMaxValue);

		mProfMaxUniteLabel.setTranslateX((550 - 10) / 2 + 50);
		mProfMaxUniteLabel.setTranslateY(370);
		this.getChildren().add(mProfMaxUniteLabel);

		mHeureSortieLabel.setTranslateX(715);
		mHeureSortieLabel.setTranslateY(0);
		this.getChildren().add(mHeureSortieLabel);

		mHeureSortieValue.setPrefWidth(100);
		mHeureSortieValue.setMaxWidth(100);
		mHeureSortieValue.setMinWidth(100);
		mHeureSortieValue.setTranslateX(750);
		mHeureSortieValue.setTranslateY(-5);
		this.getChildren().add(mHeureSortieValue);

		mDureePlongeeLabel.setTranslateX((550 - 10) / 2 - 100);
		mDureePlongeeLabel.setTranslateY(405);
		this.getChildren().add(mDureePlongeeLabel);

		mDureePlongeeValue.setPrefWidth(45);
		mDureePlongeeValue.setMaxWidth(45);
		mDureePlongeeValue.setMinWidth(45);
		mDureePlongeeValue.setTranslateX((550 - 10) / 2);
		mDureePlongeeValue.setTranslateY(400);
		this.getChildren().add(mDureePlongeeValue);

		mDureePlongeeUniteLabel.setTranslateX((550 - 10) / 2 + 50);
		mDureePlongeeUniteLabel.setTranslateY(405);
		this.getChildren().add(mDureePlongeeUniteLabel);

		mDebutRemontee.setStartX(550);
		mDebutRemontee.setStartY(400);
		mDebutRemontee.setEndX(650);
		mDebutRemontee.setEndY(80);
		mDebutRemontee.setStroke(Color.WHITE);
		mDebutRemontee.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_PLONGEE);
		this.getChildren().add(mDebutRemontee);

		mPalier3m.setStartX(650);
		mPalier3m.setStartY(80);
		mPalier3m.setEndX(750);
		mPalier3m.setEndY(80);
		mPalier3m.setStroke(Color.WHITE);
		mPalier3m.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_PLONGEE);
		this.getChildren().add(mPalier3m);

		mPalier3mLabel.setTranslateX(680);
		mPalier3mLabel.setTranslateY(50);
		this.getChildren().add(mPalier3mLabel);

		mDureePalier3mValue.setPrefWidth(50);
		mDureePalier3mValue.setMaxWidth(50);
		mDureePalier3mValue.setMinWidth(50);
		mDureePalier3mValue.setTranslateX(665);
		mDureePalier3mValue.setTranslateY(80);
		this.getChildren().add(mDureePalier3mValue);

		mDureePalier3mUniteLabel.setTranslateX(705);
		mDureePalier3mUniteLabel.setTranslateY(80);
		this.getChildren().add(mDureePalier3mUniteLabel);

		mRemonteeFin.setStartX(750);
		mRemonteeFin.setStartY(80);
		mRemonteeFin.setEndX(770);
		mRemonteeFin.setEndY(30);
		mRemonteeFin.setStroke(Color.WHITE);
		mRemonteeFin.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_PLONGEE);
		this.getChildren().add(mRemonteeFin);

		mDTRLabel.setTranslateX(640);
		mDTRLabel.setTranslateY(405);
		this.getChildren().add(mDTRLabel);

		mDTRValue.setPrefWidth(50);
		mDTRValue.setMaxWidth(50);
		mDTRValue.setMinWidth(50);
		mDTRValue.setTranslateX(680);
		mDTRValue.setTranslateY(400);
		this.getChildren().add(mDTRValue);

		mDTRUniteLabel.setTranslateX(725);
		mDTRUniteLabel.setTranslateY(405);
		this.getChildren().add(mDTRUniteLabel);

		MN90.getLogger().debug(this, "Création des marqueurs de durée dans la vue PlongeeSimple");

		mMarkDebut.setStartX(0);
		mMarkDebut.setStartY(30);
		mMarkDebut.setEndX(0);
		mMarkDebut.setEndY(450);
		mMarkDebut.setStroke(Color.WHITE);
		mMarkDebut.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_MARQUEUR);
		this.getChildren().add(mMarkDebut);

		mFlecheDureePlongee.setStartX(0);
		mFlecheDureePlongee.setStartY(440);
		mFlecheDureePlongee.setEndX(550);
		mFlecheDureePlongee.setEndY(440);
		mFlecheDureePlongee.setStroke(Color.WHITE);
		mFlecheDureePlongee.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_MARQUEUR);
		this.getChildren().add(mFlecheDureePlongee);

		mFlecheDureePlongee2.setStartX(0);
		mFlecheDureePlongee2.setStartY(440);
		mFlecheDureePlongee2.setEndX(5);
		mFlecheDureePlongee2.setEndY(445);
		mFlecheDureePlongee2.setStroke(Color.WHITE);
		mFlecheDureePlongee2.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_MARQUEUR);
		this.getChildren().add(mFlecheDureePlongee2);

		mFlecheDureePlongee3.setStartX(0);
		mFlecheDureePlongee3.setStartY(440);
		mFlecheDureePlongee3.setEndX(5);
		mFlecheDureePlongee3.setEndY(435);
		mFlecheDureePlongee3.setStroke(Color.WHITE);
		mFlecheDureePlongee3.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_MARQUEUR);
		this.getChildren().add(mFlecheDureePlongee3);

		mFlecheDureePlongee4.setStartX(555);
		mFlecheDureePlongee4.setStartY(435);
		mFlecheDureePlongee4.setEndX(545);
		mFlecheDureePlongee4.setEndY(445);
		mFlecheDureePlongee4.setStroke(Color.WHITE);
		mFlecheDureePlongee4.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_MARQUEUR);
		this.getChildren().add(mFlecheDureePlongee4);

		mFlecheDureePlongee5.setStartX(555);
		mFlecheDureePlongee5.setStartY(445);
		mFlecheDureePlongee5.setEndX(545);
		mFlecheDureePlongee5.setEndY(435);
		mFlecheDureePlongee5.setStroke(Color.WHITE);
		mFlecheDureePlongee5.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_MARQUEUR);
		this.getChildren().add(mFlecheDureePlongee5);

		mMarkDureePlongee.setStartX(550);
		mMarkDureePlongee.setStartY(30);
		mMarkDureePlongee.setEndX(550);
		mMarkDureePlongee.setEndY(450);
		mMarkDureePlongee.setStroke(Color.WHITE);
		mMarkDureePlongee.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_MARQUEUR);
		this.getChildren().add(mMarkDureePlongee);

		mMarkFinPlongee.setStartX(770);
		mMarkFinPlongee.setStartY(30);
		mMarkFinPlongee.setEndX(770);
		mMarkFinPlongee.setEndY(450);
		mMarkFinPlongee.setStroke(Color.WHITE);
		mMarkFinPlongee.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_MARQUEUR);
		this.getChildren().add(mMarkFinPlongee);

		mFlecheDTRPlongee.setStartX(550);
		mFlecheDTRPlongee.setStartY(440);
		mFlecheDTRPlongee.setEndX(770);
		mFlecheDTRPlongee.setEndY(440);
		mFlecheDTRPlongee.setStroke(Color.WHITE);
		mFlecheDTRPlongee.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_MARQUEUR);
		this.getChildren().add(mFlecheDTRPlongee);

		mFlecheDTRPlongee2.setStartX(770);
		mFlecheDTRPlongee2.setStartY(440);
		mFlecheDTRPlongee2.setEndX(765);
		mFlecheDTRPlongee2.setEndY(445);
		mFlecheDTRPlongee2.setStroke(Color.WHITE);
		mFlecheDTRPlongee2.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_MARQUEUR);
		this.getChildren().add(mFlecheDTRPlongee2);

		mFlecheDTRPlongee3.setStartX(770);
		mFlecheDTRPlongee3.setStartY(440);
		mFlecheDTRPlongee3.setEndX(765);
		mFlecheDTRPlongee3.setEndY(435);
		mFlecheDTRPlongee3.setStroke(Color.WHITE);
		mFlecheDTRPlongee3.setStrokeWidth(MN90Constants.EPAISSEUR_TRAIT_MARQUEUR);
		this.getChildren().add(mFlecheDTRPlongee3);

		mGPSLabel.setTranslateX(250);
		mGPSLabel.setTranslateY(250);
		this.getChildren().add(mGPSLabel);

		mGPSValue.setPrefWidth(50);
		mGPSValue.setMaxWidth(50);
		mGPSValue.setMinWidth(50);
		mGPSValue.setTranslateX(290);
		mGPSValue.setTranslateY(245);
		this.getChildren().add(mGPSValue);
	}

	@Override
	public void setHeureDepartValuePlongee1(long hdms) {
		mHeureDepartValue.setText(mDateFormat.format(new Date(hdms)));
	}

	@Override
	public void setHeureDepartValuePlongee2(long hdms) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void setHeureSortieValuePlongee1(long hdms) {
		mHeureSortieValue.setText(mDateFormat.format(new Date(hdms)));
	}

	@Override
	public void setHeureSortieValuePlongee2(long hdms) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void setDTRValuePlongee1(int dtr) {
		mDTRValue.setText(String.valueOf(dtr));
	}

	@Override
	public void setDTRValuePlongee2(int dtr) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void setProfondeurMaxValuePlongee1(int profMax) {
		mProfMaxValue.setText(String.valueOf(profMax));
	}

	@Override
	public void setProfondeurMaxValuePlongee2(int profMax) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void setTempsPlongeeValuePlongee1(int tpsPlongee) {
		mDureePlongeeValue.setText(String.valueOf(tpsPlongee));
	}

	@Override
	public void setTempsPlongeeValuePlongee2(int tpsPlongee) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void setTempsPalier3mValuePlongee1(int tpsPalier) {
		// TODO Auto-generated method stub
		mDureePalier3mValue.setText(String.valueOf(tpsPalier));
	}

	@Override
	public void setTempsPalier6mValuePlongee1(int tpsPalier) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTempsPalier9mValuePlongee1(int tpsPalier) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTempsPalier12mValuePlongee1(int tpsPalier) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTempsPalier15mValuePlongee1(int tpsPalier) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTempsPalier3mValuePlongee2(int tpsPalier) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void setTempsPalier6mValuePlongee2(int tpsPalier) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void setTempsPalier9mValuePlongee2(int tpsPalier) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void setTempsPalier12mValuePlongee2(int tpsPalier) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void setTempsPalier15mValuePlongee2(int tpsPalier) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void setIntervalleValue(int tpsIntervalle) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void setMajorationValue(int tpsMajo) {
		// Rien a faire => une seule plongee dans la vue
	}

	@Override
	public void setGPSValuePlongee1(String gps) {
		mGPSValue.setText(gps);
	}

	@Override
	public void setGPSValuePlongee2(String gps) {
		// Rien a faire => une seule plongee dans la vue
	}

}
